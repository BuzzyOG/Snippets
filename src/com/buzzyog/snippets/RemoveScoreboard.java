package com.buzzyog.snippets;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;


public class RemoveScoreboard {
	
	public void removeScoreboard(Player p) {
		Scoreboard sc = Bukkit.getScoreboardManager().getNewScoreboard();
		sc.clearSlot(DisplaySlot.SIDEBAR);
		p.setScoreboard(sc);
	}

}
