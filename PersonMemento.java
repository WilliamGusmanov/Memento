package mementoPackage;

import java.io.Serializable;

import mementoPackage.Person.HairColor;

public class PersonMemento implements Serializable {
	/**
	 * Memento: the object that is going to maintain the state of originator/person.
	 * @author williamgusmanov
	 *
	 */
	private int heightInches;
	/** The weight of the person in pounds.  Ounces not significant. */
	private int weightPounds;
	/** Last Name of the person. */
	private String lName;
	/** First Name of the person.*/
	private String fName;
	/** The person's hair color */
	private HairColor hairColor;
	/** Ratio of inches to feet. */
	public static final int inchesPerFoot = 12;
	/** Maximum believable height in inches.*/
	private static final int maxHeight = 7 * inchesPerFoot;
	/** Minimum believable height in inches. */
	private static final int minHeight = 1 * inchesPerFoot;
	/** Maximum believable weight in pounds.*/
	public static final int maxWeight = 400;
	/** Minimum believable weight in pounds.*/
	private static final int minWeight = 20;
	//could be cal
	PersonMemento(Person p){
		heightInches = p.getHeightInches();
		weightPounds = p.getWeightPounds();
		lName = p.getlName();
		fName = p.getfName();
		hairColor = p.getHairColor();
	}
	/**
	 * Give the height of the person in inches.
	 * @return Height in inches.
	 */
	public int getHeightInches () {
		return this.heightInches;
	}
	
	/**
	 * Return the feet (floor) of the person.
	 * @return
	 */
	public int getHeightFeet () {
		return this.getHeightInches()/inchesPerFoot;
	}
	
	/**
	 * Return the number of lbs the person weighs.
	 * @return	The number of pounds that the person weighs.
	 */
	public int getWeightPounds () {
		return this.weightPounds;
	}
	
	public HairColor getHairColor () {
		return this.hairColor;
		}
	
	/**
	 * Calculate height from feet & inches.
	 * @param feet	The feet in height.
	 * @param inches	The inches above the last foot that need to be added to get height in inches.
	 * @return	Total height in inches.
	 */
	/*
	private static int netHeight (int feet, int inches) {
		return feet * inchesPerFoot + inches;
	}
	*/
	public Person getSavedPerson(){
		return new Person(lName, fName, hairColor, getHeightFeet(), getHeightInches(), getWeightPounds());
	}
	
	@Override
	public String toString() {
		return "heightInches=" + heightInches + ", weightPounds=" + weightPounds + ", lName=" + lName
				+ ", fName=" + fName + ", hairColor=" + hairColor;
	}
	
}
