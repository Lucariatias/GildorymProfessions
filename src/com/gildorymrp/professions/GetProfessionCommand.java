package com.gildorymrp.professions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetProfessionCommand implements CommandExecutor {
	
	private GildorymProfessions plugin;
	
	public GetProfessionCommand(GildorymProfessions plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (args.length >= 1) {
			if (plugin.getServer().getPlayer(args[0]) != null) {
				player = plugin.getServer().getPlayer(args[0]);
			}
		}
		sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.GREEN + player.getDisplayName() + "'s profession is " + plugin.getProfession(player));
		return true;
	}

}
