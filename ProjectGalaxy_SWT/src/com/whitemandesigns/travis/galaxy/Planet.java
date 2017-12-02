/**
 * 
 */
package com.whitemandesigns.travis.galaxy;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Travis Whiteman
 * @creationDate 2017-11-29
 * @projectName ProjectGalaxy_SWT
 * @packageName com.whitemandesigns.travis.galaxy
 * @fileName Planet.java
 */	
public class Planet implements Comparable<Planet>{

	public static final int ROCKY = 1;
	public static final int ICY = 2;
	public static final int EARTH_LIKE = 3;
	public static final int GAS = 4;
	public static final int WATER = 5;
	
	ArrayList<Moon> moons = new ArrayList<Moon>();
	Random dice = new Random();	
	
	private double au;
	private int type;
	private String name;
	private int habit;
	private int mineral;
	
	
	
	@Override
	public int compareTo(Planet other) {
		if (au < other.getAu()) {
			return -1;
		}
		else {
			return 1;
		}
		
	}
	
	public int generateType() {
		int roll = dice.nextInt(100);
		
		if (roll < 10) {
			return Planet.EARTH_LIKE;
		}
		else if (roll < 60) {
			return Planet.ROCKY;
		}
		else if (roll < 80) {
			return Planet.GAS;
		}
		else if (roll < 95) {
			return Planet.ICY;
		}
		else return Planet.WATER;
	}
	
	public double getAu() {
		return au;
	}

	public void setName(int n, Star parent) {
		name = parent.getName() + "-" + String.valueOf(n);
	}
	
	public Planet(int size) {
		au = (dice.nextDouble() * 20 + .1) * size;
		type = generateType();
		habit = dice.nextInt(101);
		mineral = dice.nextInt(101);
	}
	
	public void printAll() {
		System.out.print("    " + name + " ");
		System.out.print("AU=" + au + " ");
		System.out.print("TYPE:" + type + " "); //add type lookup as in star
		System.out.print("HABIT=" + habit + " ");
		System.out.println("MINERAL=" + mineral);
	}
	
	public String getName() {
		return name;
	}
}
