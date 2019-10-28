package mementoPackage;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class MementoRunner {
	public static void main(String[] args) {
		//uses jfilechooser to choose file path 
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setDialogTitle("Select file to save records of person");
		String outName = null;
		if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			outName = jFileChooser.getSelectedFile().getAbsolutePath();
		}
		
		//Person Originator = new Person ("Vu","Bryan",Person.HairColor.BLACK,5,11,230);
		Person Originator = null; 
		PersonCareTaker careTaker = new PersonCareTaker(outName);
		try {
		System.out.println("Opening File Directory.");
		//lname, fname, haircolor, feet, inches, weight 
		
		char continueProgram = 'y';
		boolean fNameEntered = false;
		boolean lNameEntered = false; 
		boolean personCreated = false; 
		Scanner in = new Scanner(System.in);
		for (int i = 0; continueProgram == 'y'; i++) {
			System.out.printf("Enter data for instance %f" , i);
			String lname = "", fname = "";
			if (!lNameEntered) {
				System.out.println("Enter last name: ");
				lname = in.next();
				lNameEntered = true;
			}
			if(!fNameEntered) {
				System.out.printf("Enter first name: ");
				fname = in.next();
				fNameEntered = true; 
			}
			System.out.println("Enter hair color: ");
			String haircolor = in.next();
			System.out.println("Enter height in feet: ");
			int feet = in.nextInt();
			System.out.println("Enter height in inches: ");
			int inches = in.nextInt(); 
			System.out.println("Enter weight in pounds: ");
			int weight = in.nextInt();
			if (!personCreated) {
				Originator = new Person(lname,fname,Person.HairColor.valueOf(haircolor),feet,inches,weight); 
				personCreated = true; 
			}
			else {
				Originator.setHairColor(Person.HairColor.valueOf(haircolor));
				Originator.setHeight(feet, inches);
				Originator.setWeight(weight);
			}
			PersonMemento personInstance= new PersonMemento(Originator);
			careTaker.addMemento(personInstance);
			System.out.println("Would you like to continue? (Y)es or (N)o");
			continueProgram = in.nextLine().toLowerCase().charAt(0); //might want to throw an exception if not y or n
			}
		System.out.println("Printing skinnest instance: " + careTaker.getMemento());
		System.out.println("Enter weight: ");
		System.out.println(careTaker.getMemento(in.nextInt()));
		System.out.println("Program completed satisfactory");
		in.close();
		
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	} 
	public static void addPerson() {
		char continueProgram = 'y';
		boolean fNameEntered = false;
		boolean lNameEntered = false; 
		boolean personCreated = false; 
		Scanner in = new Scanner(System.in);
		for (int i = 0; continueProgram == 'y'; i++) {
			System.out.printf("Enter data for instance %f" , i);
			String lname = "", fname = "";
			if (!lNameEntered) {
				System.out.println("Enter last name: ");
				lname = in.next();
				lNameEntered = true;
			}
			if(!fNameEntered) {
				System.out.printf("Enter first name: ");
				fname = in.next();
				fNameEntered = true; 
			}
			System.out.println("Enter hair color: ");
			String haircolor = in.next();
			System.out.println("Enter height in feet: ");
			int feet = in.nextInt();
			System.out.println("Enter height in inches: ");
			int inches = in.nextInt(); 
			System.out.println("Enter weight in pounds: ");
			int weight = in.nextInt();
			Person Originator;
			if (!personCreated) {
				Originator = new Person(lname,fname,Person.HairColor.valueOf(haircolor),feet,inches,weight); 
				personCreated = true; 
			}
			else {
				Originator.setHairColor(Person.HairColor.valueOf(haircolor));
				Originator.setHeight(feet, inches);
				Originator.setWeight(weight);
			}
			PersonMemento personInstance= new PersonMemento(Originator);
			careTaker.addMemento(personInstance);
			System.out.println("Would you like to continue? (Y)es or (N)o");
			continueProgram = in.nextLine().toLowerCase().charAt(0); //might want to throw an exception if not y or n
			}
	}

	/**
	 * a.) prompts the user for the name and path of the file that they will use for storing their PersonMemento objects
	 * Done
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

