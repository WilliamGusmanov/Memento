package mementoPackage;

import java.io.Serializable;

import mementoPackage.Person.HairColor;

public class PersonMemento implements Serializable {
	/**
	 * Memento: the object that is going to maintain the state of originator/person.
	 * @author William Gusmanov, Bryan Vu
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
	/** Maximum believable weight in pounds.*/
	public static final int maxWeight = 400;
	
	/**
	 * constructor
	 * @param p
	 */
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
	}//end function definition
	
	/**
	 * Return the feet (floor) of the person.
	 * @return
	 */
	public int getHeightFeet () {
		return this.getHeightInches()/inchesPerFoot;
	}//end function definition
	
	/**
	 * Return the number of lbs the person weighs.
	 * @return	The number of pounds that the person weighs.
	 */
	public int getWeightPounds () {
		return this.weightPounds;
	}//end function definition
	
	/**
	 * 
	 * @return
	 */
	public HairColor getHairColor () {
		return this.hairColor;
	}//end function definition
	
	/**
	 * 
	 * @return
	 */
	public Person getSavedPerson(){
		return new Person(lName, fName, hairColor, getHeightFeet(), getHeightInches(), getWeightPounds());
	}//end function definition
	
	/**
	 * toString method
	 */
	@Override
	public String toString () {
		return String.format("Name: %s, %s, Hair Color: %s, Height:%d'%d, Weight #: %d",
				this.lName, this.fName, "" + this.hairColor, this.getHeightFeet(), 
				this.getHeightInches()%inchesPerFoot,
				this.weightPounds);//So we can print the Person.
	}//end function definition
}//end class definition