/**
 * 
 */
package com.whitemandesigns.travis.galaxy;

import java.util.ArrayList;

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
	
	public double getAu() {
		return au;
	}

	public void setName(int n) {
		
	}
	
	public Planet(int size) {
		
	}
	
	public void printAll() {
		
	}
}
