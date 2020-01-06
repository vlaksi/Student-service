package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.Student;

public class SerijalizacijaStudenta {
	private static SerijalizacijaStudenta instance = null;

	public static SerijalizacijaStudenta getInstance() {
		if (instance == null) {
			instance = new SerijalizacijaStudenta();
		}
		return instance;
	}

	private SerijalizacijaStudenta() {

	}

	String filename = "objectstreamStudenti.txt";

	public void serijalizacijaObjekta(List<Student> studenti) {

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(studenti);

			out.close();
			file.close();

			//System.out.println("StudentSerializable:Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println("StudentSerializable:Greska pri upisu");
		}
	}

	 
	public List<Student> deserijalizacijaObjekta() {
		List<Student> student1;
		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			student1 = (List<Student>)in.readObject();

			in.close();
			file.close();

			//System.out.println("StudentSerializable:Object has been deserialized ");
			return student1;
			//System.out.println("Ime prvog studenta = " + .getIme());
		}

		catch (IOException ex) {
			System.out.println("StudentSerializable:Greska pri ispisu");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		return null;
		
	}

}
