package mementoPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import momentoPackage.MomentoRunner;

public class MementoRunner {
	public static void main(String[] args) {
		MementoRunner runner = new MementoRunner(); 
		runner.input();
		runner.input();
		runner.readFile();
		System.out.println("Program completed satisfactory");
	}
	/**
	 * a.) prompts the user for the name and path of the file that they will use for storing their PersonMemento objects
	 * 
	 */
	public void input() {
		//Use JFileReader
		String fileName = "out.bin";
		try {
			FileOutputStream fileOs = new FileOutputStream(fileName);
			ObjectOutputStream os = new ObjectOutputStream(fileOs);
			os.writeInt(2048);
			os.writeBytes("writing to out.bin");
			os.close();
		}
		catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} 
		catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public void readFile() {
		String fileName = "out.bin";
		try {
			FileInputStream fileIs = new FileInputStream(fileName);
			ObjectInputStream is = new ObjectInputStream(fileIs);
			int x = is.readInt();
			String y = is.readLine();
			int z = is.readInt();
			String a = is.readLine();
			System.out.println(x + "\n" + y + "\n" + z + "\n" + a);
			is.close();
		} 
		catch (FileNotFoundException exception) {
			
			exception.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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

