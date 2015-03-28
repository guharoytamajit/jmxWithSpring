package com.mbean;

public interface IDog {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jmxExample.AnimalMBean#getAge()
	 */
	public abstract int age();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jmxExample.AnimalMBean#setAge(int)
	 */
	public abstract void setAge(int age);

}