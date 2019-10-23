package mementoPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MementoRunner {
	public static void main(String[] args) {
		Person Bryan = new Person ("Vu","Bryan",Person.HairColor.BLACK,5,11,230);
		Person Bryan2 = new Person ("Vu","Bryan",Person.HairColor.BLACK,5,8,160);
		PersonMemento MBryan = new PersonMemento(Bryan);
		PersonMemento MWilliam = new PersonMemento(Bryan2);
		PersonCareTaker careTaker = new PersonCareTaker();
		careTaker.addMemento(MBryan);
		careTaker.addMemento(MWilliam);
		careTaker.readFile();
		System.out.println("Program completed satisfactory");
	}
	/**
	 * a.) prompts the user for the name and path of the file that they will use for storing their PersonMemento objects
	 * 
	 */

	/**
	 * b.) Go into a loop, prompt user for the Person Characteristics (height, weight, ...) at various times
	 */
	
	/**
	 * c.) Uses getMemento to find the skinniest of the Personmementos that have been written to disk
	 */
	
	/**
	 * d.) Uses getMemento to find the first PersonMemento that matches the weight that you give it. 
	 */
}

