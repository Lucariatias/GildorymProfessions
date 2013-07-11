package com.gildorymrp.professions;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.professions.Profession;

public class ProfessionManager {
	
	private Map<Character, Profession> professions = new HashMap<Character, Profession>();
	
	public Profession getProfession(Player player) {
		return this.getProfession(Gildorym.getCorePlugin().getActiveCharacter(player));
	}
	
	public Profession getProfession(Character character) {
		return professions.get(character);
	}
	
	public void setProfession(Player player, Profession profession) {
		this.setProfession(Gildorym.getCorePlugin().getActiveCharacter(player), profession);
	}
	
	public void setProfession(Character character, Profession profession) {
		professions.put(character, profession);
	}

}
