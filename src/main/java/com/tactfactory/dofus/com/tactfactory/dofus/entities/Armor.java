package com.tactfactory.dofus.entities;

import java.util.ArrayList;

public class Armor extends Stuff{
	ArrayList<Effet> effets;
	ArrayList<Condition> conditions;
	ArrayList<Stat> stats;

	/**
	 * @return the effets
	 */
	public ArrayList<Effet> getEffets() {
		return effets;
	}
	/**
	 * @param effets the effets to set
	 */
	public void setEffets(ArrayList<Effet> effets) {
		this.effets = effets;
	}
	/**
	 * @return the conditions
	 */
	public ArrayList<Condition> getConditions() {
		return conditions;
	}
	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(ArrayList<Condition> conditions) {
		this.conditions = conditions;
	}
	/**
	 * @return the stats
	 */
	public ArrayList<Stat> getStats() {
		return stats;
	}
	/**
	 * @param stats the stats to set
	 */
	public void setStats(ArrayList<Stat> stats) {
		this.stats = stats;
	}

	public Armor(){
		this.conditions = new ArrayList<Condition>();
		this.effets = new ArrayList<Effet>();
		this.stats = new ArrayList<Stat>();
	}
}
