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
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		Player player = null;
		if (args.length < 1) {
			sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.RED
					+ "You must specify a profession!");
			return true;
		} else if (args.length == 1) {
			if (sender instanceof Player) {
				player = (Player) sender;
			} else {
				sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.RED
						+ "Only a player can perform this command!");
				return true;
			}
		} else {
			if (!sender.hasPermission("gildorym.setprofessionother")) {
				sender.sendMessage(GildorymProfessions.PREFIX
						+ ChatColor.RED
						+ "You do not have permission to change another player's profession!");
			}
			player = sender.getServer().getPlayer(args[1]);
			if (player == null) {
				sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.RED
						+ "That player does not exist!");
			}
		}

		Profession profession = Profession.valueOf(args[0].toUpperCase());
		if (plugin.getProfession(player) != null
				&& !sender.hasPermission("gildorym.setprofessionother")) {
			sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.RED
					+ "You already have a profession!");
		}

		try {
			plugin.setProfession(player, profession);
			sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.GREEN
					+ "Set profession to " + profession.toString());
		} catch (IllegalArgumentException exception) {
			sender.sendMessage(GildorymProfessions.PREFIX + ChatColor.RED
					+ "That profession does not exist!");
		}

		return true;
	}

}
