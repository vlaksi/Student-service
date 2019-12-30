package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa u kojoj cuvamo podatke o predmetima.
 * 
 * @author Vaxi
 *
 */
public class BazaPredmeta {
//TODO Ishendlovati kako cemo za predmet dodavati predmetnog profesora
//TODO Ishendlovati kako cemo na predmet dodavati studente
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaPredmeta() {
		initPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("SEMESTAR");
		this.kolone.add("GODINA STUDIJA");

	}

	private void initPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
		
		predmeti.add(new Predmet("ANZ1-17", "Analiza 1",1, 1));
		predmeti.add(new Predmet("ANZ1-17", "Analiza 1", 1, 1));
		predmeti.add(new Predmet("ANZ2-17", "Analiza 2", 3, 2));
		predmeti.add(new Predmet("ALGB-17", "Algebra", 1, 1));
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
			return (predmet.getSemestar()).toString();

		case 3:
			return (predmet.getGodinaStudija()).toString();

		default:
			return null;
		}
	}

	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, Integer semestar, Integer godinaStudija) {
		this.predmeti.add(new Predmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija));
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
	public void izmeniPredmet(String sifraPredmeta, String nazivPredmeta, Integer semestar, Integer godinaStudija) {
		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				predmet.setNazivPredmeta(nazivPredmeta);
				predmet.setSemestar(semestar);
				predmet.setGodinaStudija(godinaStudija);
			}
		}
	}

}
