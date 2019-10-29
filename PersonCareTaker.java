
/**
 * Caretaker class: The object that keeps track of multiple Memento.
 * does all I/O with Memento File that has all memento instances
 * @author Bryan Vu
 * @author William Gusmanov
 */

package mementoPackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class PersonCareTaker {
	
	/**
	 * file path that is used to enter into Scanners to write and read binary values
	 */
	private String filePath;
	
	/**
	 * value used to writing to file. false to overwrite file. True to append to file. 
	 */
	private boolean append;
	
	private FileOutputStream out;
	
	private FileInputStream in;
	
	/**
	 * keeps track of how many mementos have been added. Used to
	 */
	int personsAdded = 0; 

	/**
	 * Overloaded constructor that takes in the filepath as a parameter
	 * @param filePath the path of the file to write to 
	 */
	public PersonCareTaker(String filePath) {
		this.filePath = filePath;
		append = false;
	}//end of overloaded constructor definition
	
	/**
	 * A method to take a memento of a person and adds it to the file 
	 * being written to
	 * @param personToWrite, writes instance of personMemento into file 
	 * @throws IOException, if file not found
	 */
	public void addMemento(PersonMemento personToWrite) throws IOException {
		out = new FileOutputStream(filePath,append);
		DataOutputStream addToFile = new DataOutputStream(new BufferedOutputStream(out));
		append = true;
		addToFile.writeUTF(personToWrite.toString());
		personsAdded++;
		addToFile.close();
	}//end function definition
	
	/**
	 * A method to read a file and grab the instance of a memento
	 * with the lowest weight 
	 * @return, the personMemento instance with the lowest weight 
	 * @throws IOException, if file not found. 
	 */
	public PersonMemento getMemento() throws IOException{
		in = new FileInputStream(filePath); 
		DataInputStream readFromFile = new DataInputStream(new BufferedInputStream(in));
		PersonMemento lowestWeight = null; 
		for (int i = 0; i < personsAdded; i++) {
			String FullString = readFromFile.readUTF();
			String [] personInfo = FullString.split(",");
			String lName = personInfo[0].substring(6); 
			String fName = personInfo[1].substring(1); 
			String personHairColor = personInfo[2].substring(13);
			String heightFeetInches = personInfo[3].substring(8); //must convert this to inches
			String []splitheightFeetInches = heightFeetInches.split("'");
			int heightFeet = Integer.parseInt(splitheightFeetInches[0]);
			int heightInches = Integer.parseInt(splitheightFeetInches[1]);
			int weightPounds = Integer.parseInt(personInfo[4].substring(11));
			if (lowestWeight == null || weightPounds < lowestWeight.getWeightPounds()) {
				lowestWeight = new PersonMemento(new Person(lName, fName, Person.HairColor.valueOf(personHairColor), heightFeet, heightInches, weightPounds));
			}//end if
		}//end for loop
		readFromFile.close();
		return lowestWeight; 	
	}//end function definition
	
	/**
	 * A method to search for an instance of a memento with the weight
	 * that is specified in the parameter
	 * @param weight, used to find the memento in the file that matches the weight
	 * @return null if weight not found, otherwise return memento with the same weight
	 * @throws IOException, if file not found
	 */
	public PersonMemento getMemento(int weight) throws IOException{
		in = new FileInputStream(filePath);
		DataInputStream readFromFile = new DataInputStream(new BufferedInputStream(in));
		PersonMemento sameWeight = null; 
		for (int i = 0; i < personsAdded; i++) {
			String [] personInfo = readFromFile.readUTF().split(",");
			String lName = personInfo[0].substring(6);
			String fName = personInfo[1].substring(1);
			String personHairColor = personInfo[2].substring(13);
			String heightFeetInches = personInfo[3].substring(8); //must convert this to inches
			String []splitheightFeetInches = heightFeetInches.split("'");
			int heightFeet = Integer.parseInt(splitheightFeetInches[0]);
			int heightInches = Integer.parseInt(splitheightFeetInches[1]);
			int weightPounds = Integer.parseInt(personInfo[4].substring(11));
			if (weight == weightPounds) {
				readFromFile.close();
				return new PersonMemento(new Person(lName, fName, Person.HairColor.valueOf(personHairColor), heightFeet, heightInches, weightPounds));
			}//end if statement
		}//end for loop
		readFromFile.close();
		return sameWeight; 
	}//end function definition
}//end class defintion
