package model;

import java.util.ArrayList;
import java.util.List;

import controller.SerijalizacijaPredmeta;

/**
 * Klasa u kojoj cuvamo podatke o predmetima.
 * 
 * @author Vaxi i Pufke
 *
 */
public class BazaPredmeta {
	private static BazaPredmeta instance = null;
	private List<Predmet> predmeti;
	private List<String> kolone;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private BazaPredmeta() {
		initPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina studija");
		this.kolone.add("Profesor");

	}

	private void initPredmeta() {

		this.predmeti = SerijalizacijaPredmeta.getInstance().deserijalizacijaObjekta();

	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getBrojaKolona() {
		return kolone.size();
	}

	public String getImeKolone(int index) {
		return this.kolone.get(index);
	}

	/**
	 * Metoda koja za prosledjeni index reda vrati citav entitet Predmet (tj. citav
	 * red)
	 * 
	 * @param indexReda
	 * @return red sa prosledjenim indexom reda
	 */
	public Predmet getRed(int indexReda) {
		return this.predmeti.get(indexReda);
	}

	/**
	 * Metoda koja za prosledjene kordinate vrati vrednost iz te celije.
	 * 
	 * @param red
	 * @param kolona
	 * @return vrednost celije
	 */
	public String getVrednost(int red, int kolona) {
		Predmet predmet = this.predmeti.get(red);
		switch (kolona) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return predmet.getSemestar();

		case 3:
			return predmet.getGodinaStudija();
		case 4:
			String stringCelije = predmet.getPredmetniProfesor().getPrezime() + " "
					+ predmet.getPredmetniProfesor().getBrojLicneKarte();
			return stringCelije;
		case 5:
			List<Student> listaStudenataNaPredemtu = predmet.getListaStudenata();
			String listaPredmetaString = "";
			for (Student student : listaStudenataNaPredemtu) {
				listaPredmetaString += student.getBrIndexa();
				listaPredmetaString += "\n";
			}
			return listaPredmetaString;
		default:
			return null;
		}
	}

	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, String semestar, String godinaStudija,
			Profesor profa, List<Student> listaStudenata) {
		this.predmeti.add(new Predmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, profa, listaStudenata));
	}

	/**
	 * Metoda koja brise predmet po prosledjenoj sifri predmeta.
	 * 
	 * @param sifraPredmeta
	 */
	public void izbrisiPredmet(String sifraPredmeta) {
		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				predmeti.remove(predmet);
				break;
			}
		}
	}

	/**
	 * Metoda koja za prosledjene parametre menja predmet sa tom sifrom predmeta.
	 * 
	 * @param sifraPredmeta
	 * @param nazivPredmeta
	 * @param semestar
	 * @param godinaStudija
	 */
	public void izmeniPredmet(String sifraPredmeta, String nazivPredmeta, String semestar, String godinaStudija) {
		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				predmet.setNazivPredmeta(nazivPredmeta);
				predmet.setSemestar(semestar);
				predmet.setGodinaStudija(godinaStudija);
			}
		}
	}

	/**
	 * Metoda koja prosledjenog studenta dodaje na predmet, tj u listu studenata
	 * predmeta
	 * 
	 * @param entitet studenta
	 * 
	 */
	public void dodajStudentaNaPredmet(Student student, Predmet predmet) {
		predmet.getListaStudenata().add(student);
	}

	/**
	 * Metoda koja prosledjenom predmetu, dodaje predmetnog profesora.
	 * 
	 * @param profesor
	 * @param predmet
	 */
	public void dodajProfesoraNaPredmet(Profesor profesor, Predmet predmet) {
		predmet.setPredmetniProfesor(profesor);
	}

	/**
	 * Metoda koja prosledjenog studenta brise sa predmeta, tj u listu studenata
	 * predmeta
	 * 
	 * @param entitet studenta
	 * 
	 */
	public void izbrisiStudentaProsledjenomPredmetu(Student student, Predmet predmet) {

		for (Student s : predmet.getListaStudenata()) {
			if (s.getBrIndexa().equals(student.getBrIndexa())) {
				predmet.getListaStudenata().remove(s);
				break;
			}
		}

		System.out.println("POZVAOOOOOOOOOO");
		predmet.getListaStudenata().remove(student);
	}

	/**
	 * Metoda koja na prosledjenom predmetu skida prosledjenog profesora.
	 * 
	 * @param profesor
	 * @param predmet
	 */
	public void izbrisiProfesoraSaPredmeta(Profesor profesor, Predmet predmet) {

		Profesor profa = new Profesor();
		profa.setPrezime("nema");
		profa.setBrojLicneKarte(" profesora");
		predmet.setPredmetniProfesor(profa);

	}

}
