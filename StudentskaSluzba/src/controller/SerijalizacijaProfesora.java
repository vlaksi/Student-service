package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import model.Profesor;

public class SerijalizacijaProfesora {
	private static SerijalizacijaProfesora instance = null;

	public static SerijalizacijaProfesora getInstance() {
		if (instance == null) {
			instance = new SerijalizacijaProfesora();
		}
		return instance;
	}

	private SerijalizacijaProfesora() {

	}

	String filename = "objectstreamProfesori.txt";

	public void serijalizacijaObjekta(List<Profesor> profesori) {

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(profesori);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println("Greska pri upisu");
		}
	}

	 
	public List<Profesor> deserijalizacijaObjekta() {
		List<Profesor> profesori;
		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			profesori = (List<Profesor>)in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized ");
			return profesori;
			//System.out.println("Ime prvog studenta = " + .getIme());
		}

		catch (IOException ex) {
			System.out.println("Greska pri ispisu");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		return null;
		
	}

}
