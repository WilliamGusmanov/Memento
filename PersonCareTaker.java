package mementoPackage;

import java.util.ArrayList;

import momentoPackage.PersonCaretaker;

/**
 * Caretaker class: The object that keeps track of multiple Memento.
 * does all I/O with Memento File that has all memento instances
 * @author williamgusmanov
 *
 */
public class PersonCareTaker {
	
	public static void main(String[] args) {
		new PersonCaretaker(); 
	}
	/**
	 * constructor that runs all the I/O
	 * there is only one file that is being written to and read from 
	 */
	public PersonCareTaker(){
		
		
		
	}
	ArrayList<PersonMemento> savedPersonInstances = new ArrayList<PersonMemento>();
	public void addMomento(PersonMemento personInstance) {
		savedPersonInstances.add(personInstance);
	}
	/**
	 * returns instance of personmemento with lowest weight 
	 * @return
	 */
	public PersonMemento getPersonMemento() {
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
	}	
}

