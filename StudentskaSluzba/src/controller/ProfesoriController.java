package controller;

import model.BazaProfesor;
import model.Profesor;

/**
 * Klasa koja rukuje reakcijama na dogadjaje entiteta/modela: Profesor.
 * 
 * @author Vaxi i Pufke
 *
 */
public class ProfesoriController {
	private static ProfesoriController instance = null;

	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}

	private ProfesoriController() {
	}
	
//Metoda kojoj prosledjujemo entite profesora
//i ona je dodaje u bazu podataka, tj u listu 
	public void dodavanjeProfesora(Profesor profesor) {
		BazaProfesor.getInstance().dodajProfesora(profesor.getIme(), profesor.getPrezime(),
				profesor.getDatumRodjenja(), profesor.getAdresaStanovanja(), profesor.getTelefon(), profesor.getEmail(),
				profesor.getAdresaKancelarije(), profesor.getBrojLicneKarte(), profesor.getTitula(), profesor.getZvanje());
	}

	public Profesor getListaProfesora(int selectedRowIndex) {
		return BazaProfesor.getInstance().getProfesori().get(selectedRowIndex);
	}
}
