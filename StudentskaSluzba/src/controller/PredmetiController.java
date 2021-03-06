package controller;

import java.util.ArrayList;
import java.util.List;

import model.BazaPredmeta;
import model.BazaStudent;
import model.Predmet;
import model.Profesor;
import model.Student;

/**
 * Klasa koja rukuje reakcijama na dogadjaje entiteta/modela: Predmet.
 * 
 * @author Vaxi
 *
 */
public class PredmetiController {

	private static PredmetiController instance = null;
	// List<Predmet> listaPredmetaZaSerijalizaciju = new ArrayList<Predmet>();
	List<Predmet> listaPredmetaZaSerijalizaciju = BazaPredmeta.getInstance().getPredmeti();

	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}

	private PredmetiController() {

	}

	/**
	 * Metoda koja prosledjeni Predmet stavlja u BazuPredmeta.
	 * 
	 * @param predmet
	 */
	public void dodavanjePredmeta(Predmet predmet) {
		BazaPredmeta.getInstance().dodajPredmet(predmet.getSifraPredmeta(), predmet.getNazivPredmeta(),
				predmet.getSemestar(), predmet.getGodinaStudija(), predmet.getPredmetniProfesor(),
				predmet.getListaStudenata());
		// Dodajemo predmeta u listu za serijalizaciju
		// listaPredmetaZaSerijalizaciju.add(predmet);
	}

	/**
	 * Metoda koja za prosledjeni red, vrati iz baze taj Predmet.
	 * 
	 * @param selectedRowIndex
	 * @return
	 */
	public Predmet getListaPredmeta(int selectedRowIndex) {
		return BazaPredmeta.getInstance().getPredmeti().get(selectedRowIndex);
	}

	// Metoda koja vraca studenta za prosledjeni index reda public Predmet
	public Predmet getPredmetByRowIndex(int rowIndex) {
		return BazaPredmeta.getInstance().getPredmeti().get(rowIndex);
	}

	// Metoda koja vraca studenta za prosledjenu sifru
	public Predmet getPredmetByID(String sifra) {
		List<Predmet> listaPredmeta = new ArrayList<Predmet>();
		listaPredmeta = BazaPredmeta.getInstance().getPredmeti();

		for (Predmet predmet : listaPredmeta) {
			if (predmet.getSifraPredmeta().equals(sifra)) {
				return predmet;
			} else {
				System.out.println("Nije isto");
			}
		}
		return null;

	}

	public Predmet getPredmetByNaziv(String naziv) {
		List<Predmet> listaPredmeta = new ArrayList<Predmet>();
		listaPredmeta = BazaPredmeta.getInstance().getPredmeti();
		for (Predmet predmet : listaPredmeta) {
			if (predmet.getNazivPredmeta().equals(naziv)) {
				return predmet;
			}
		}
		return null;
	}

	// Metoda koja dodaje studenta na predmet
	public void dodajStudentaPredmetu(Student student, Predmet predmet) {

		for (Predmet predmetZaSerijalizaciju : listaPredmetaZaSerijalizaciju) {
			if (predmetZaSerijalizaciju.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
				BazaPredmeta.getInstance().dodajStudentaNaPredmet(student, predmet);
				return;
			}
		}
	}

	/* Metoda koja dodaje profesora na predmet */
	public void dodajProfesoraNaPredmet(Profesor profesor, Predmet predmet) {
		BazaPredmeta.getInstance().dodajProfesoraNaPredmet(profesor, predmet);
	}

	public void izbrisiStudentaProsledjenomPredmetu(Student student, Predmet predmet) {
		BazaPredmeta.getInstance().izbrisiStudentaProsledjenomPredmetu(student, predmet);
	}

	/* Metoda koja brise tog profesora iz liste profesora u predmetu */
	public void izbrisiProfesoraSaPredmeta(Profesor profesor, Predmet predmet) {
		BazaPredmeta.getInstance().izbrisiProfesoraSaPredmeta(profesor, predmet);
	}

	public List<Predmet> getListaSvihPredmeta() {
		return BazaPredmeta.getInstance().getPredmeti();
	}

	// Metoda koja brise predmet za prosledjeni index reda
	public void izbrisiPredmet(int selectedRowIndex) {
		/*
		 * Ali pored toga mora i da se obrise taj predmet kod profesora koji imaju ovaj
		 * predmet ( tj sa njihove liste predmeta da ga skinemo ) takodje svim
		 * studentima koji imaju ovaj predmet, moraju da ga izgube( tj sa njihove liste
		 * predmeta da ga skinemo)
		 */

		/* Skidanje predmeta sa profesorove liste predmeta */

		Predmet predmetKogBrisemo = BazaPredmeta.getInstance().getPredmeti().get(selectedRowIndex);
		/*
		 * Obrisati taj predmet u tabeli profesora za odredjenog profesora koji ima taj
		 * predmet
		 */
		if (predmetKogBrisemo.getPredmetniProfesor().getBrojLicneKarte().equals("profesora")
				|| predmetKogBrisemo.getPredmetniProfesor().getBrojLicneKarte().equals(" profesora")) {
			// System.out.println("Predmet: " + predmetKogBrisemo.getNazivPredmeta() + "
			// nema profesora!");
			/* slucaj kada nemam profesora -> nema nikakvog brisanja tog profesora */
		} else {
			/*
			 * slucaj kada predmet ima profesora -> u tabeli profesori,za odredjenog
			 * profesora, obrisati iz njegove liste predmeta nas predmet
			 */
			int brojacBreak = -1;
			Profesor profesorKomUklanjamo = predmetKogBrisemo.getPredmetniProfesor();
			System.out.println("Profesora kog uklanjamo ima jmbg: " + profesorKomUklanjamo.getBrojLicneKarte());
			for (Profesor prof : ProfesoriController.getInstance().getListaSvihProfesora()) {
				if (profesorKomUklanjamo.getBrojLicneKarte().equals(prof.getBrojLicneKarte())) {
					for (Predmet p : prof.getPredmeti()) {
						if (p.getSifraPredmeta().equals(predmetKogBrisemo.getSifraPredmeta())) {
							if (prof.getPredmeti().remove(p)) {
							} else {
							}
							brojacBreak = 1;
							break;

						}
					}
					if (brojacBreak == 1) {
						break;
					}
				}

			}
		}

		/* Skidanje predmeta sa studentove liste predmeta */
		for (Student s : BazaStudent.getInstance().getStudenti()) {
			for (Predmet p : s.getPredmeti()) {
				if (p.getSifraPredmeta().equals(predmetKogBrisemo.getSifraPredmeta())) {
					if (s.getPredmeti().remove(p)) {
						break;
					}
				}
			}

		}

		BazaPredmeta.getInstance().getPredmeti().remove(selectedRowIndex);

	}

	public List<Predmet> getListaPredmetaZaSerijalizaciju() {
		return listaPredmetaZaSerijalizaciju;
	}

	public void setListaPredmetaZaSerijalizaciju(List<Predmet> listaPredmetaZaSerijalizaciju) {
		this.listaPredmetaZaSerijalizaciju = listaPredmetaZaSerijalizaciju;

	}

}
