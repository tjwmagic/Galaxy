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
 * @fileName Galaxy.java
 */
public class Galaxy {

	Random dice = new Random();
	ArrayList<Star> stars = new ArrayList<Star>();
	
	
	public Galaxy() {
		int numberStars = dice.nextInt(100) + 1;
		
		for (int i = 1; i <= numberStars; i++) {
			Star star = new Star(i);
			stars.add(star);
		}
	}
	
	public void printAll() {
		for (Star star : stars) {
			star.printAll();
		}
	}
	
}
