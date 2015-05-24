package com.buzzyog.snippets;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class NearstPlayer {
	
	@EventHandler
	public void onNearPlayer(Player e) {
	double closest = Double.MAX_VALUE;
	Player closestp = null;
	for(Player i : Bukkit.getOnlinePlayers()){
		double dist = i.getLocation().distance(e.getPlayer().getLocation());
		if (closest == Double.MAX_VALUE || dist < closest){
			closest = dist;
			closestp = i;
  	}
	}
	if (closestp == null){
	  //No players found
	}
	else{
	  //the closest player is closestp
	}
	}
}
