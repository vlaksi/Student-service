package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa u kojoj cuvamo podatke o profesorima.
 * 
 * @author Vaxi
 *
 */
public class BazaProfesor {
//TODO Dodati spisak predmeta za svakog profesora
//TODO Resiti sta cemo sa ostalim podacima koji se ne popune [podaci koji nisu na prikazu]
	private static BazaProfesor instance = null;
	private List<Profesor> profesori;
	private List<String> kolone;
	
	public static BazaProfesor getInstance() {
		if (instance == null) {
			instance = new BazaProfesor();
		}
		return instance;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	private BazaProfesor() {
		initProfesore();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rodjenja");
		this.kolone.add("Adresa stanovanja");
		this.kolone.add("Telefon");
		this.kolone.add("Email");
		this.kolone.add("Adresa kancelarije");
		this.kolone.add("Broj licne");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");

	}

	/**
	 * Metoda za pocetni init prilikom kreiranja BazeProfesora
	 */
	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		profesori.add(new Profesor("Valentin", "Djimic","1975.03.09","Pupinova 10","06625222","valedimi@gmail.com", "Gogoljeva 3", "395189","Dr.","Dipl.ing.el"));
		profesori.add(new Profesor("Goja", "Malinovski","1970.12.09","Pupinova 13","06135222", "gojafudbal@gmail.com", "Pupinova 21", "042289","Dr.","Dipl.ing.el"));
		profesori.add(new Profesor("Ivana", "Kolutoski","1990.11.04","Pupinova 1","06435200", "ikans@gmail.com", "Jovina 5", "015389","Dr.","Dipl.ing.el"));

	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profe) {
		this.profesori = profe;
	}

	public int getBrojKolona() {
		return kolone.size();
	}

	public String getImeKolone(int index) {
		return this.kolone.get(index);
	}

	/**
	 * @param indexReda
	 * @return Profesora iz reda prosledjenog parametra.
	 */
	public Profesor getRed(int indexReda) {
		return this.profesori.get(indexReda);
	}

	/**
	 * 
	 * @param red
	 * @param kolona
	 * @return Vrednost u tabeli za prosledjeni red i kolonu
	 */
	public String getVrednost(int red, int kolona) {
		Profesor profesor = this.profesori.get(red);
		switch (kolona) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getDatumRodjenja();
		case 3:
			return profesor.getAdresaStanovanja();
		case 4:
			return profesor.getTelefon();
		case 5:
			return profesor.getEmail();
		case 6:
			return profesor.getAdresaKancelarije();
		case 7:
			return profesor.getBrojLicneKarte();
		case 8:
			return profesor.getTitula();
		case 9:
			return profesor.getZvanje();
		default:
			return null;

		}
	}

	/**
	 * Metoda koja za prosledjene parametre dodaje novog profesora u bazu profesora.
	 * 
	 * @param ime
	 * @param prezime
	 * @param email
	 * @param adresaKancelarije
	 * @param brojLicneKarte
	 */
	public void dodajProfesora(String ime, String prezime, String email, String adresaKancelarije,
			String brojLicneKarte) {
		this.profesori.add(new Profesor(ime, prezime, email, adresaKancelarije, brojLicneKarte));
	}

	/**
	 * Metoda koja brise profesora sa prosledjenim brojem licne karte.
	 * 
	 * @param brojLicne
	 */
	public void izbrisiProfesora(String brojLicne) {
		for (Profesor profesor : profesori) {
			if (profesor.getBrojLicneKarte().equals(brojLicne)) {
				profesori.remove(profesor);
				break;
			}
		}
	}

	/**
	 * Metoda koja za prosledjenje parametre menja profesora sa tim brojem licne
	 * karte.
	 * 
	 * @param ime
	 * @param prezime
	 * @param email
	 * @param adresaKancelarije
	 * @param brojLicneKarte
	 */
	public void izmeniProfesora(String ime, String prezime, String email, String adresaKancelarije,
			String brojLicneKarte) {
		for (Profesor profesor : profesori) {
			if (profesor.getBrojLicneKarte().equals(brojLicneKarte)) {
				profesor.setIme(ime);
				profesor.setPrezime(prezime);
				profesor.setEmail(email);
				profesor.setAdresaKancelarije(adresaKancelarije);
				profesor.setBrojLicneKarte(brojLicneKarte);
			}
		}
	}

}
