package mementoPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import momentoPackage.PersonCaretaker;

/**
 * Caretaker class: The object that keeps track of multiple Memento.
 * does all I/O with Memento File that has all memento instances
 * @author williamgusmanov
 *
 */
public class PersonCareTaker {
	
	//file
	private String filePath = "out.txt";
	private boolean append = false; 
	
	public static void main(String[] args) {
		new PersonCareTaker(); 
	}
	/**
	 * constructor that runs all the I/O
	 * there is only one file that is being written to and read from 
	 */
	public PersonCareTaker(){
		
	}
	//ArrayList<PersonMemento> savedPersonInstances = new ArrayList<PersonMemento>();
/*	public void addMomento(PersonMemento personInstance) {
		savedPersonInstances.add(personInstance);
	}*/
	/**
	 * returns instance of personmemento with lowest weight 
	 * @return
	 */
	
	public void input() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setDialogTitle("Select File");
		if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			String outname = jFileChooser.getSelectedFile().getAbsolutePath();
			this.filePath = outname;
		} 
	}
	
	public void addMemento(PersonMemento personToWrite) {
		try {
			FileOutputStream fileOs = new FileOutputStream(this.filePath,append);
			append = true; 
			ObjectOutputStream os = new ObjectOutputStream(fileOs);
			os.writeBytes(personToWrite.toString()+"\n");
			os.close();
		} 
		catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readFile() {
		try {
			FileInputStream fileIs = new FileInputStream(this.filePath);
			ObjectInputStream is = new ObjectInputStream(fileIs);
			String personLine = is.readLine();
			String [] personInfo = personLine.split(",");
			int heightInches = Integer.parseInt(personInfo[0].substring(13));
			int weightPounds = Integer.parseInt(personInfo[1].substring(14));
			String lName = personInfo[2].substring(7);
			String fName = personInfo[3].substring(7);
			String personHairColor = personInfo[4].substring(11);
			System.out.println(personLine);
			System.out.println(personHairColor);
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
/*	
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
	}*/

/*	public PersonMemento getPersonMemento() {
		PersonMemento lowest = savedPersonInstances.get(0); 
		for (PersonMemento x : savedPersonInstances) {
			if (x.getWeightPounds() < lowest.getWeightPounds()) {
				lowest = x;
				}
			}
		return lowest; 
	}
	public PersonMemento getPersonMemento(int weight) {
		for (PersonMemento x : savedPersonInstances) {
			if (x.getWeightPounds() == weight) {
				return x; 
				}
			}
		return null; 
	}*/	
	
}

