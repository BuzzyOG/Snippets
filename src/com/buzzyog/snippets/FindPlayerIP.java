package com.buzzyog.snippets;
 
import java.util.logging.Level;
 

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;
 
public class FindPlayerIP implements Listener {
	
private final Plugin plugin;
	
	public FindPlayerIP( Plugin plugin )
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this , plugin);
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		String ip = null;
		
		try {
			ip = event.getAddress().getHostAddress();
		} catch(NullPointerException e) {
			plugin.getLogger().log(Level.WARNING, "Could not find Player IP");
		}
		
		if(ip != null) {
			ip = ip.replace("/", "");
			
			// Do something with the IP
		}
	}
}