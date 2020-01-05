package model;

import java.util.ArrayList;
import java.util.List;

import controller.SerijalizacijaProfesora;

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

		this.profesori = SerijalizacijaProfesora.getInstance().deserijalizacijaObjekta();
		 	 

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
		case 10:
			List<Predmet> listaPredmeta = profesor.getPredmeti();
			String listaPredmetaString = "";

			for (Predmet predmet : listaPredmeta) {
				listaPredmetaString += predmet.nazivPredmeta;
				listaPredmetaString += "\n";
			}
			return listaPredmetaString;
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
	 * @param zvanjeFiledValue
	 * @param titulaFieldValue
	 * @param brojLicneKarteFieldValue
	 * @param adresaKancelarijeFieldValue
	 * @param emailValue
	 */
	public void dodajProfesora(String ime, String prezime, String email, String adresaKancelarije,
			String brojLicneKarte, String emailValue, String adresaKancelarijeFieldValue,
			String brojLicneKarteFieldValue, String titulaFieldValue, String zvanjeFiledValue,
			List<Predmet> listaPredmeta) {
		this.profesori.add(new Profesor(ime, prezime, email, adresaKancelarije, brojLicneKarte, emailValue,
				adresaKancelarijeFieldValue, brojLicneKarteFieldValue, titulaFieldValue, zvanjeFiledValue,
				listaPredmeta));
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

	/**
	 * Metoda koja prosledjenom profesoru, dodaje prosledjeni predmet.
	 * 
	 * @param profesor
	 * @param predmet
	 */
	public void dodajPredmetProfesoru(Profesor profesor, Predmet predmet) {
		profesor.getPredmeti().add(predmet);
	}

	/**
	 * Metoda koja brise predmet prosledjenom profesoru.
	 * 
	 * @param profesor
	 * @param predmet
	 */
//	public void izbrisiPredmetProfesora(Profesor profesor, Predmet predmet) {
//		System.out.println("Predmeti profesora "+profesor.getIme() +" su: ");
//		for(Predmet p : profesor.getPredmeti()) {
//			System.out.println(p.getNazivPredmeta());
//			if(p.equals(predmet)) {
//				System.out.println("Objekti su isti");
//				profesor.getPredmeti().remove(predmet);
//			}else {
//				System.out.println("Objekti nisu isti");
//				// naci indeks
//				int indeks=0;
//				//for(Pred)
//				
//				profesor.getPredmeti().remove(indeks);
//			}
//		}
//		System.out.println("A zelimo obrisati predmet: " + predmet.getNazivPredmeta());
//		profesor.getPredmeti().remove(predmet);
//
//	}
	
	
	/**
	 * Metoda koja brise predmet prosledjenom profesoru.
	 * 
	 * @param profesor
	 * @param predmet
	 */
	public void izbrisiPredmetProfesora(Profesor profesor, Predmet predmet) {
		int indeks=0;
		for(Predmet p : profesor.getPredmeti()) {
			if(p.getSifraPredmeta().equals(predmet.getSifraPredmeta())){
				System.out.println("sifre su ime iste, a indeks na kom se nalazi je: "+indeks);
				break;
			}
			
			indeks++;
		}
		
		
		profesor.getPredmeti().remove(indeks);
	}

}
