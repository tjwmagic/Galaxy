/**
 * 
 */
package com.whitemandesigns.travis.galaxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.ibm.icu.text.DecimalFormat;

/**
 * @author Travis Whiteman
 * @creationDate 2017-11-29
 * @projectName ProjectGalaxy_SWT
 * @packageName com.whitemandesigns.travis.galaxy
 * @fileName Star.java
 */
public class Star {

	public static final int BLACK_HOLE = 0;
	public static final int DWARF = 1;
	public static final int SMALL = 2;
	public static final int MEDIUM = 3;
	public static final int LARGE = 4;
	public static final int GIANT = 5;
	public static final int SUPER_GIANT = 6;
	
	
	private String name;
	private int size;
	private int x, y, z;
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private Random dice = new Random();
	
	public Star(int n) {
		DecimalFormat df = new DecimalFormat("0000");
		name = "S" + df.format(n);
		int count = 0;
		size = generateSize();
		
		x = dice.nextInt(201) - 100;
		y = dice.nextInt(201) - 100;
		z = dice.nextInt(21) - 10;
		
		//Planet Generation
		int numberplanets = dice.nextInt(11);
		
		if (size == Star.BLACK_HOLE) {
			numberplanets = 0;
		}
		
		//Create Planets		
		for (int i = 1; i <= numberplanets; i++) {
			Planet planet = new Planet(size);
			planets.add(planet);
		}
		
		//Organized by distance
		Collections.sort(planets);
		
		//Name planets
		for (Planet planet : planets) {
			planet.setName(count++, this);
		}
	}
	
	private int generateSize() {
		int roll = dice.nextInt(100);
		
		if (roll < 1) {
			return Star.BLACK_HOLE;
		}
		else if (roll < 10) {
			return Star.DWARF;
		}
		else if (roll < 35) {
			return Star.SMALL;
		}
		else if (roll < 55) {
			return Star.MEDIUM;
		}
		else if (roll < 75) {
			return Star.LARGE;
		}
		else if (roll < 85) {
			return Star.GIANT;
		}
		else return Star.SUPER_GIANT;
		
	}
	
	public void printAll() {
		System.out.print(name + ": ");
		System.out.print("X=" + x + " ");
		System.out.print("Y=" + y + " ");
		System.out.print("Z=" + z + " ");
		System.out.print("TYPE: ");
		System.out.println(lookupType(size));
		
		for (Planet planet : planets) {
			planet.printAll();
		}
	}
	
	private String lookupType(int size) {
		
		switch (size) {
		case Star.BLACK_HOLE: return "Black Hole";
		case Star.DWARF: return "Dwarf";
		case Star.SMALL: return "Small";
		case Star.MEDIUM: return "Medium";
		case Star.LARGE: return "Large";
		case Star.GIANT: return "Giant";
		case Star.SUPER_GIANT: return "Super Giant";
		}
		return "Hello";
	}

	/**
	 * @return
	 */
	public String getName() {
		return null;
	}
}
	
