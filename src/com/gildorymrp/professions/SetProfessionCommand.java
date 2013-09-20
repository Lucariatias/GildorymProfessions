package com.gildorymrp.professions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gildorymrp.api.plugin.professions.Profession;

public class SetProfessionCommand implements CommandExecutor {

	private GildorymProfessions plugin;

	public SetProfessionCommand(GildorymProfessions plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		Profession profession = Profession.valueOf(args[0].toUpperCase());
		if (profession == null){
			if (args.length >= 1) {
				try {
					plugin.setProfession(player, profession);
					sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.GREEN + "Set profession to " + profession.toString());
				} catch (IllegalArgumentException exception) {
					sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.RED + "That profession does not exist!");
				}
			} else {
				sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.RED + "You must specify a profession!");
			}
			
		}else{
			sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.RED + "You may not change profession!");
		}
	return true;
	}
	
}
