package com.buzzyog.snippets.api;

import java.lang.reflect.Field;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class HeadFooterApi {
	
	/*
	 * How to send header and footers 
	 * 
	 * @EventHandler
	public void onJoin(PlayerJoinEvent e){
		HeadFooterApi.sendHeaderAndFooter(e.getPlayer(), "", "§7Welcome To BuzzyTest");
	}
	 */

	public static void sendHeaderAndFooter(Player p, String head, String foot){
		CraftPlayer craftplayer = (CraftPlayer)p;
		PlayerConnection connection = craftplayer.getHandle().playerConnection;
		IChatBaseComponent header = ChatSerializer.a("{'color': '" + "', 'text': '" + head + "'}");
		IChatBaseComponent footer = ChatSerializer.a("{'color': '" + "', 'text': '" + foot + "'}");
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();

		try {
			Field headerField = packet.getClass().getDeclaredField("a");
			headerField.setAccessible(true);
			headerField.set(packet, header);
			headerField.setAccessible(!headerField.isAccessible());

			Field footerField = packet.getClass().getDeclaredField("b");
			footerField.setAccessible(true);
			footerField.set(packet, footer);
			footerField.setAccessible(!footerField.isAccessible());
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.sendPacket(packet);
	}
}