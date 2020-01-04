package model;

import java.util.ArrayList;
import java.util.List;

import model.Student.Status;

/**
 * Klasa u kojoj cuvamo podatke o predmetima.
 * 
 * @author Vaxi i Pufke
 *
 */
public class BazaPredmeta {
//TODO Ishendlovati kako cemo za predmet dodavati predmetnog profesora
//TODO Ishendlovati kako cemo na predmet dodavati studente
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
		this.predmeti = new ArrayList<Predmet>();
		
		List<Profesor> listaProfesora = BazaProfesor.getInstance().getProfesori();
		Profesor profa = listaProfesora.get(0);
		Profesor profa1 = listaProfesora.get(1);
		Profesor profa2 = listaProfesora.get(2);

		predmeti.add(new Predmet("ANZ1-17", "Analiza 1", "1", "1", profa));
		predmeti.add(new Predmet("ANZ1-17", "Analiza 1", "1", "1", profa));
		predmeti.add(new Predmet("ANZ2-17", "Analiza 2", "3", "2", profa1));
		predmeti.add(new Predmet("ALGB-17", "Algebra", "1", "1", profa2));
		
		for(Predmet predmet : predmeti) {
			predmet.getListaStudenata().add(new Student("Marko", "Markovic", "1998.01.01", "Nikinacka 81", "06030012", "marem@gmail.com",
					"RA1-2017", "2017.02.07", "2", 9.50, Status.B, predmeti));
			predmet.getListaStudenata().add(new Student("Pero", "Meric", "1998.08.01.", "Sremska 1", "06430012", "marope@gmail.com",
					"RA3-2017", "2017.02.07", "3", 8.50, Status.B, predmeti));
		}
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
			Profesor profa) {
		this.predmeti.add(new Predmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, profa));
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
	 * Metoda koja prosledjenog studenta  dodaje na predmet, tj u listu studenata predmeta
	 * 
	 * @param entitet studenta

	 */
	public void dodajStudentaNaPredmet(Student student, Predmet predmet) {
		predmet.getListaStudenata().add(student);
	}
	

	/**
	 * Metoda koja prosledjenog studenta brise sa predmeta, tj u listu studenata predmeta
	 * 
	 * @param entitet studenta

	 */
	public void removeStudentaSaPredmet(Student student, Predmet predmet) {
		predmet.getListaStudenata().remove(student);
	}
	
	

}
