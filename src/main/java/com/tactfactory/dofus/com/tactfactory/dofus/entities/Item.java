package com.tactfactory.dofus.entities;

public abstract class Item extends Element {
	private Integer level;

	/**
	 * @return the type
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param type the type to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
}
