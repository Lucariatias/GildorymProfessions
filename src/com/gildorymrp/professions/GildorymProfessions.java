package com.gildorymrp.professions;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.professions.GildorymProfessionsPlugin;
import com.gildorymrp.api.plugin.professions.Profession;

public class GildorymProfessions extends JavaPlugin implements GildorymProfessionsPlugin {

	@Override
	public Profession getProfession(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profession getProfession(Character character) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canCraft(Player player, Material material) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSmelt(Player player, Material material) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canUse(Player player, Material material) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canInteract(Player player, Material material) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canCraft(Profession profession, Material material) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSmelt(Profession profession, Material material) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canUse(Profession profession, Material material) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canInteract(Profession profession, Material material) {
		// TODO Auto-generated method stub
		return false;
	}

}
