package com.tactfactory.dofus.entities;

public class Stat extends Element{
	private String statName;
	private String value;

	/**
	 * @return the statName
	 */
	public String getStatName() {
		return statName;
	}
	/**
	 * @param statName the statName to set
	 */
	public void setStatName(String statName) {
		this.statName = statName;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
