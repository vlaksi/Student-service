package controller;

import java.util.List;

import model.BazaProfesor;
import model.Predmet;
import model.Profesor;

/**
 * Klasa koja rukuje reakcijama na dogadjaje entiteta/modela: Profesor.
 * 
 * @author Vaxi i Pufke
 *
 */
public class ProfesoriController {
	private static ProfesoriController instance = null;

	List<Profesor> listaProfesoraZaSerijalizaciju = SerijalizacijaProfesora.getInstance().deserijalizacijaObjekta();

	// List<Profesor> listaProfesoraZaSerijalizaciju = new ArrayList<Profesor>();
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
		BazaProfesor.getInstance().dodajProfesora(profesor.getIme(), profesor.getPrezime(), profesor.getDatumRodjenja(),
				profesor.getAdresaStanovanja(), profesor.getTelefon(), profesor.getEmail(),
				profesor.getAdresaKancelarije(), profesor.getBrojLicneKarte(), profesor.getTitula(),
				profesor.getZvanje(), profesor.getPredmeti());
		// Dodajemo profesora u listu za serijalizaciju
		listaProfesoraZaSerijalizaciju.add(profesor);
	}

	public Profesor getListaProfesora(int selectedRowIndex) {
		return BazaProfesor.getInstance().getProfesori().get(selectedRowIndex);
	}

	public List<Profesor> getListaSvihProfesora() {
		return BazaProfesor.getInstance().getProfesori();
	}

	public void dodajPredmetProfesoru(Profesor profesor, Predmet predmet) {
		BazaProfesor.getInstance().dodajPredmetProfesoru(profesor, predmet);
	}

	// metoda koja brise taj predmet iz liste predmeta tog profesora
	public void izbrisiPredmetProfesora(Profesor profesor, Predmet predmet) {
		BazaProfesor.getInstance().izbrisiPredmetProfesora(profesor, predmet);
	}

	public List<Profesor> getListaProfesoraZaSerijalizaciju() {
		return listaProfesoraZaSerijalizaciju;
	}

	public void setListaProfesoraZaSerijalizaciju(List<Profesor> listaProfesoraZaSerijalizaciju) {
		this.listaProfesoraZaSerijalizaciju = listaProfesoraZaSerijalizaciju;
	}

	// Metoda koja brise profesora za proslednje index reda
	public void izbrisiProfesora(int selectedRowIndex) {
		Profesor profesor = new Profesor();
		profesor = BazaProfesor.getInstance().getProfesori().get(selectedRowIndex);

		for (Predmet p : PredmetiController.getInstance().getListaSvihPredmeta()) {
			// prodjem kroz sve predmete i ako imaju tog profesora,uklonimo ga
			if(p.getPredmetniProfesor().equals(profesor)) {
				Profesor profa = new Profesor(); profa.setPrezime("nema "); profa.setBrojLicneKarte("profesor");
				p.setPredmetniProfesor(profa);
			}
		}
		
		BazaProfesor.getInstance().getProfesori().remove(selectedRowIndex);
		listaProfesoraZaSerijalizaciju.remove(selectedRowIndex);
	}

}
