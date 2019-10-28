package mementoPackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;


/**
 * Caretaker class: The object that keeps track of multiple Memento.
 * does all I/O with Memento File that has all memento instances
 * @author williamgusmanov
 *
 */
public class PersonCareTaker {
	
	/**
	 * file path that is used to enter into Scanners to write and read binary values
	 */
	private String filePath;
	
	/**
	 * value used to writing to file. false to overwrite file. True to append to file. 
	 */
	private boolean append = false; 
	
	/**
	 * keeps track of how many mementos have been added. Used to
	 */
	int personsAdded = 0; 
	public static void main(String[] args) {
		new PersonCareTaker(); 
	}
	
	/**
	 * default constructor 
	 */
	public PersonCareTaker(){
		filePath = "out.txt";
	}
	
	/**
	 * Asks user for what file to write Person Mementos into and sets the filePath to the file selected. 
	 */
	public void input() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setDialogTitle("Select file to save records of person");
		if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			String outname = jFileChooser.getSelectedFile().getAbsolutePath();
			this.filePath = outname;
			append = false; 
		} 
	}
	
	/**
	 * 
	 * @param personToWrite, writes instance of personMemento into file 
	 * @throws IOException, if file not found
	 */
	public void addMemento(PersonMemento personToWrite) throws IOException {
		DataOutputStream addToFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filePath,append)));
		append = true;
		addToFile.writeUTF(personToWrite.toString());
		personsAdded++;
		addToFile.close();
	}//end function definition
	
	/**
	 * @return, the personMemento instance with the lowest weight 
	 * @throws IOException, if file not found. 
	 */
	public PersonMemento getMemento() throws IOException{
		DataInputStream readFromFile = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
		PersonMemento lowestWeight = null; 
		for (int i = 0; i < personsAdded; i++) {
			String [] personInfo = readFromFile.readUTF().split(";");
			String lName = personInfo[0].substring(6);
			String fName																																																																	 = personInfo[1].substring(1);
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
	 * @param weight, used to find the memento in the file that matches the weight
	 * @return null if weight not found, otherwise return memento with the same weight
	 * @throws IOException, if file not found
	 */
	public PersonMemento getMemento(int weight) throws IOException{
		DataInputStream readFromFile = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
		PersonMemento sameWeight = null; 
		for (int i = 0; i < personsAdded; i++) {
			String [] personInfo = readFromFile.readUTF().split(";");
			String lName = personInfo[0].substring(6);
			String fName																																																																	 = personInfo[1].substring(1);
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
