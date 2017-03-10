package com.tactfactory.dofus.entities;

import java.util.ArrayList;

public class Stuff extends UsableItem {
	ArrayList<BonusPrimaire> bonus;

	/**
	 * @return the bonus
	 */
	public ArrayList<BonusPrimaire> getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(ArrayList<BonusPrimaire> bonus) {
		this.bonus = bonus;
	}

	public Stuff(){
		this.bonus = new ArrayList<BonusPrimaire>();
	}
}
