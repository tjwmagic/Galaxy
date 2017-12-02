/**
 * 
 */
package com.whitemandesigns.travis.galaxy;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author Travis Whiteman
 * @creationDate 2017-11-29
 * @projectName ProjectGalaxy_SWT
 * @packageName com.whitemandesigns.travis.galaxy
 * @fileName Moon.java
 */
public class Moon {
	Random dice = new Random();
	
	private double orbitDistance;
	private int type;
	private String name;
	private int habit;
	private int mineral;
	
	public Moon(int n, Planet parent) {
		name = parent.getName() + String.valueOf((char)(n+96));
		type = generateType();
		orbitDistance = 0;
		habit = 0;
		mineral = 0;
		//This gives a nice bell-curve distribution of distance from planet,
		//habitability and minerals.
		for(int i = 0; i < 3; i++) {
			orbitDistance += dice.nextDouble() * 350000;
			habit += dice.nextInt(33);
			mineral += dice.nextInt(33);
		}
	}
	
	public int generateType() {
		int roll = dice.nextInt(100);
		
		if (roll < 4)
			return Planet.EARTH_LIKE;
		else if (roll < 75)
			return Planet.ROCKY;
		else if (roll < 97)
			return Planet.ICY;
		else 
			return Planet.WATER;
	}
	
	private String lookupType(int theType) {
		String type = "";
		switch (theType) 
		{
		case Planet.EARTH_LIKE: type = "Earth-like"; break;
		case Planet.WATER: type = "Aquatic"; break;
		case Planet.GAS: type = "Gaseous"; break;
		case Planet.ROCKY: type = "Barren"; break;
		case Planet.ICY: type = "Frozen"; break;
		}
		return type;
	}
	public void printAll() {
		System.out.print("        " + name + ": ");
		System.out.print("Type: " + lookupType(type) + " ");
		
		DecimalFormat df = new DecimalFormat("#,##0.0");
		System.out.print("DIST=" + df.format(orbitDistance) + " miles ");
		System.out.print("HABIT=" + habit + "% ");
		System.out.println("MINERAL=" + mineral + "%");
	}
	
}
