package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import model.Predmet;

public class SerijalizacijaPredmeta {
	private static SerijalizacijaPredmeta instance = null;

	public static SerijalizacijaPredmeta getInstance() {
		if (instance == null) {
			instance = new SerijalizacijaPredmeta();
		}
		return instance;
	}

	private SerijalizacijaPredmeta() {

	}

	String filename = "objectstreamPredmeti.txt";

	public void serijalizacijaObjekta(List<Predmet> predmeti) {

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(predmeti);

			out.close();
			file.close();

			System.out.println("PredmetSerializable: Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println("PredmetSerializable: Greska pri upisu");
		}
	}

	 
	public List<Predmet> deserijalizacijaObjekta() {
		List<Predmet> predmeti;
		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			predmeti = (List<Predmet>)in.readObject();

			in.close();
			file.close();

			System.out.println("StudentSerializable:Object has been deserialized ");
			return predmeti;
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
