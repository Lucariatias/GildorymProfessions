package com.gildorymrp.professions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.equipment.DnDMaterial;
import com.gildorymrp.api.plugin.professions.GildorymProfessionsPlugin;
import com.gildorymrp.api.plugin.professions.Profession;

public class GildorymProfessions extends JavaPlugin implements GildorymProfessionsPlugin {
	
	public static final String PREFIX = "" + ChatColor.DARK_RED + ChatColor.MAGIC + "|" + ChatColor.RESET + ChatColor.DARK_GRAY + "GildorymProfessions" + ChatColor.DARK_RED + ChatColor.MAGIC + "| " + ChatColor.RESET;
	private ProfessionManager professionManager = new ProfessionManager();
	
	@Override
	public void onEnable() {
		this.getCommand("setprofession").setExecutor(new SetProfessionCommand(this));
		this.getCommand("getprofession").setExecutor(new GetProfessionCommand(this));
		for (Profession profession : Profession.values()) {
			for (DnDMaterial material : DnDMaterial.values()) {
				if (!this.getConfig().contains("professions." + profession.toString() + ".craft." + material.toString())) {
					this.getConfig().set("professions." + profession.toString() + ".craft." + material.toString(), false);
				}
				if (!this.getConfig().contains("professions." + profession.toString() + ".smelt." + material.toString())) {
					this.getConfig().set("professions." + profession.toString() + ".smelt." + material.toString(), false);
				}
				if (!this.getConfig().contains("professions." + profession.toString() + ".use." + material.toString())) {
					this.getConfig().set("professions." + profession.toString() + ".use." + material.toString(), false);
				}
				if (!this.getConfig().contains("professions." + profession.toString() + ".interact." + material.toString())) {
					this.getConfig().set("professions." + profession.toString() + ".interact." + material.toString(), false);
				}
			}
		}
		this.saveConfig();
	}

	@Override
	public Profession getProfession(Player player) {
		return professionManager.getProfession(player);
	}

	@Override
	public Profession getProfession(Character character) {
		return professionManager.getProfession(character);
	}

	@Override
	public void setProfession(Player player, Profession profession) {
		professionManager.setProfession(player, profession);
	}

	@Override
	public void setProfession(Character character, Profession profession) {
		professionManager.setProfession(character, profession);
	}

	@Override
	public boolean canCraft(Player player, DnDMaterial material) {
		return canCraft(getProfession(player), material);
	}

	@Override
	public boolean canSmelt(Player player, DnDMaterial material) {
		return canSmelt(getProfession(player), material);
	}

	@Override
	public boolean canUse(Player player, DnDMaterial material) {
		return canUse(getProfession(player), material);
	}

	@Override
	public boolean canInteract(Player player, DnDMaterial material) {
		return canInteract(getProfession(player), material);
	}

	@Override
	public boolean canCraft(Character character, DnDMaterial material) {
		return canCraft(getProfession(character), material);
	}

	@Override
	public boolean canSmelt(Character character, DnDMaterial material) {
		return canSmelt(getProfession(character), material);
	}

	@Override
	public boolean canUse(Character character, DnDMaterial material) {
		return canUse(getProfession(character), material);
	}

	@Override
	public boolean canInteract(Character character, DnDMaterial material) {
		return canInteract(getProfession(character), material);
	}

	@Override
	public boolean canCraft(Profession profession, DnDMaterial material) {
		return this.getConfig().getBoolean("professions." + profession.toString() + ".craft." + material.toString());
	}

	@Override
	public boolean canSmelt(Profession profession, DnDMaterial material) {
		return this.getConfig().getBoolean("professions." + profession.toString() + ".smelt." + material.toString());
	}

	@Override
	public boolean canUse(Profession profession, DnDMaterial material) {
		return this.getConfig().getBoolean("professions." + profession.toString() + ".use." + material.toString());
	}

	@Override
	public boolean canInteract(Profession profession, DnDMaterial material) {
		return this.getConfig().getBoolean("professions." + profession.toString() + ".interact." + material.toString());
	}

}
