package com.buzzyog.snippets.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class BossBarAPI {

	private static Method a;
	private static Field d;
	private static Constructor<?> entityEnderdragon;

	private static Method getDatawatcher;
	private static Method getPlayerHandle;
	private static Method getWorldHandle;
	private static Constructor<?> packetPlayOutSpawnEntityLiving;

	private static Field playerConnection;
	private static Method sendPacket;
	private static Method setLocation;

	static {
		try {
			packetPlayOutSpawnEntityLiving = getMCClass(
					"PacketPlayOutSpawnEntityLiving").getConstructor(
					getMCClass("EntityLiving"));
			entityEnderdragon = getMCClass("EntityEnderDragon").getConstructor(
					getMCClass("World"));
			setLocation = getMCClass("EntityEnderDragon").getMethod(
					"setLocation", double.class, double.class, double.class,
					float.class, float.class);

			getWorldHandle = getCraftClass("CraftWorld").getMethod("getHandle");
			getPlayerHandle = getCraftClass("entity.CraftPlayer").getMethod(
					"getHandle");
			playerConnection = getMCClass("EntityPlayer").getDeclaredField(
					"playerConnection");
			sendPacket = getMCClass("PlayerConnection").getMethod("sendPacket",
					getMCClass("Packet"));

			getDatawatcher = getMCClass("EntityEnderDragon").getMethod(
					"getDataWatcher");
			a = getMCClass("DataWatcher").getMethod("a", int.class,
					Object.class);
			d = getMCClass("DataWatcher").getDeclaredField("d");
			d.setAccessible(true);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private static void changeWatcher(Object nms_entity, String text)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		final Object nms_watcher = getDatawatcher.invoke(nms_entity);
		final Map<?, ?> map = (Map<?, ?>) d.get(nms_watcher);
		map.remove(10);
		a.invoke(nms_watcher, 10, text);
	}

	private static Class<?> getCraftClass(String name)
			throws ClassNotFoundException {
		final String version = Bukkit.getServer().getClass().getPackage()
				.getName().replace(".", ",").split(",")[3]
				+ ".";
		final String className = "org.bukkit.craftbukkit." + version + name;
		return Class.forName(className);
	}

	private static Class<?> getMCClass(String name)
			throws ClassNotFoundException {
		final String version = Bukkit.getServer().getClass().getPackage()
				.getName().replace(".", ",").split(",")[3]
				+ ".";
		final String className = "net.minecraft.server." + version + name;
		return Class.forName(className);
	}

	private final Map<String, Object> playerDragons = new HashMap<String, Object>();

	private final Map<String, String> playerText = new HashMap<String, String>();

	private final Plugin plugin;

	public BossBarAPI(final Plugin plugin) {
		this.plugin = plugin;

		new BukkitRunnable() {

			@Override
			public void run() {
				for (final Player p : plugin.getServer().getOnlinePlayers()) {
					BossBarAPI.this.setBossBar(p,
							BossBarAPI.this.playerText.get(p.getName()));
				}
			}
		}.runTaskTimer(this.plugin, 100, 100);
	}

	public Object getEnderDragon(Player p) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		if (this.playerDragons.containsKey(p.getName())) {
			return this.playerDragons.get(p.getName());
		} else {
			final Object nms_world = getWorldHandle.invoke(p.getWorld());
			this.playerDragons.put(p.getName(),
					entityEnderdragon.newInstance(nms_world));
			return this.getEnderDragon(p);
		}
	}

	public void setBossBar(Player p, String text) {
		this.playerText.put(p.getName(), text);
		try {
			final Object nms_dragon = this.getEnderDragon(p);
			setLocation.invoke(nms_dragon, p.getLocation().getX(), -200, p
					.getLocation().getZ(), 0F, 0F);
			changeWatcher(nms_dragon, text);
			final Object nms_packet = packetPlayOutSpawnEntityLiving
					.newInstance(nms_dragon);
			final Object nms_player = getPlayerHandle.invoke(p);
			final Object nms_connection = playerConnection.get(nms_player);
			sendPacket.invoke(nms_connection, nms_packet);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}