package com.buzzyog.snippets.utils;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;

public class Logger {
	public static void info(String s) {
		Bukkit.getLogger().info("[Logger] " + s);
	}

	public static void severe(String content) {
		Bukkit.getLogger().severe("[Logger] " + content);
	}

	public static void console(String content) {
		Bukkit.getServer().getConsoleSender().sendMessage(content);
	}
	
}