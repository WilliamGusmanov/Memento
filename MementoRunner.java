/**
 * Driver class to demonstrate the Memento Design Pattern
 * with a person CareTaker and a personMemento
 * @author Bryan Vu
 * @author William Gusmanov
 */

package mementoPackage;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class MementoRunner {
	public static void main(String[] args) {
		
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setDialogTitle("Select file to save records of person");
		String outName = null;
		if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			outName = jFileChooser.getSelectedFile().getAbsolutePath();
		}//end if statement for file selection 
		Person Originator = null; 
		PersonCareTaker careTaker = new PersonCareTaker(outName);
		
		try {
		System.out.println("Opening File Directory.");

		char continueProgram = 'n';
		boolean fNameEntered = false;
		boolean lNameEntered = false; 
		boolean personCreated = false;
		
		Scanner in = new Scanner(System.in);
		while (continueProgram == 'n') {
			String lname = "", fname = "";
			if (!lNameEntered) {
				System.out.print("Enter last name: ");
				lname = in.next();
				lNameEntered = true;
			}//end if (last name)
			if(!fNameEntered) {
				System.out.print("Enter first name: ");
				fname = in.next();
				fNameEntered = true; 
			}//end if (first name)
			System.out.println(
					"0:\tBLACK\n" + "1:\tBLONDE\n" + "2:\tRED\n" + "3:\tAUBURN\n" + "4:\tSALT_AND_PEPPER\n"
					+ "5:\tGREY\n" + "6:\tWHITE\n" + "7:\tBALD\n");
			System.out.println("Please enter the # corresponding to the hair color: ");
			int value = in.nextInt();
			System.out.println("You entered " + Person.HairColor.getColor(value));
			System.out.println("Person's height in feet: ");
			int feet = in.nextInt();
			System.out.println("And the inches? For instance, 5'10\" would be 10: ");
			int inches = in.nextInt(); 
			System.out.println("Their weight in pounds: ");
			int weight = in.nextInt();
			if (!personCreated) {
				//Person.HairColor.valueOf(haircolor)
				Originator = new Person(lname,fname,Person.HairColor.getColor(value),feet,inches,weight); 
				personCreated = true; 
			}//end if for person not created
			else {
				Originator.setHairColor(Person.HairColor.getColor(value));
				Originator.setHeight(feet, inches);
				Originator.setWeight(weight);
			}//end else (person is created)
			System.out.println(Originator); //printing details of Originator
			PersonMemento personInstance= new PersonMemento(Originator); //make an instance of memento
			careTaker.addMemento(personInstance); //add the memento to the file
			System.out.println("Are we done here (Y/N)?: ");
			in.nextLine();
			continueProgram = in.nextLine().toLowerCase().charAt(0); //might want to throw an exception if not y or n
		}//end while loop
		
		System.out.println("Skinnest version: " + careTaker.getMemento());
		System.out.println("What weight do you want to search for? ");
		int weight = in.nextInt(); 
		PersonMemento foundWeight = careTaker.getMemento(weight);
		if (foundWeight != null) {
			System.out.println("Sought after version:" + foundWeight);
		}//end if (person with desired weight found)
		else {
			System.out.println("weight not found.");
		}//end else (person with weight is not found)
		System.out.println("Program completed satisfactory");
		in.close();
		}//end try block
		catch (IOException e) {
			e.printStackTrace();
		}//end catch statement
	}//end main 
}//end of MementoRunner 

