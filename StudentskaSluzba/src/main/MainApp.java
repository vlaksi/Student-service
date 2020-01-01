package main;

import controller.GlavniController;
import model.BazaPredmeta;
import model.BazaProfesor;
import view.GlavniProzor;
import model.BazaStudent;

/**
 * Glavna klasa iz koje se vrsi inicijalno pokretanje aplikacije.
 * 
 * @author Pufke i Vaxi
 *
 */
public class MainApp {

	public static void main(String[] args) {
		BazaProfesor.getInstance();
		BazaPredmeta.getInstance();
		BazaStudent.getInstance();
		GlavniController.getInstance();
		GlavniProzor.getInstance();

	}

}
