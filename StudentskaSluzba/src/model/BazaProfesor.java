package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa u kojoj cuvamo podatke o profesorima.
 * @author Vaxi
 *
 */
public class BazaProfesor {

	private static BazaProfesor instance = null;
	
	public static BazaProfesor getInstance() {
		if(instance == null) {
			instance = new BazaProfesor();
		}
		return instance;
	}
	
	
	private List<Profesor> profesori;
	private List<String> kolone;
	
	private BazaProfesor() {
		initProfesore();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("EMAIL");
		this.kolone.add("ADRESA KACELARIJE");
		this.kolone.add("BROJ LICNE KARTE");
		
	}
	
	/**
	 * Metoda za pocetni init prilikom kreiranja BazeProfesora
	 */
	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		profesori.add(new Profesor("Valentin", "Djimic", "valedimi@gmail.com", "Gogoljeva 3", "030889880221"));
		profesori.add(new Profesor("Goja", "Malinovski", "gojafudbal@gmail.com", "Pupinova 21", "210888880291"));
		profesori.add(new Profesor("Ivana", "Kolutoski", "ikans@gmail.com", "Jovina 5", "010898880292"));
		
	}
	
	public List<Profesor> getProfesori(){
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
		switch(kolona) {
		case 0: return profesor.getIme();
		case 1: return profesor.getPrezime();
		case 2: return profesor.getEmail();
		case 3: return profesor.getAdresaKancelarije();
		case 4: return profesor.getBrojLicneKarte();
		default: return null;
			
		}
	}
	
	/**
	 * Metoda koja za prosledjene parametre dodaje novog profesora u bazu profesora.
	 * @param ime
	 * @param prezime
	 * @param email
	 * @param adresaKancelarije
	 * @param brojLicneKarte
	 */
	public void dodajProfesora(String ime, String prezime,String email, String adresaKancelarije, String brojLicneKarte) {
		this.profesori.add(new Profesor(ime,prezime,email,adresaKancelarije,brojLicneKarte));
	}
	
	/**
	 * Metoda koja brise profesora sa prosledjenim brojem licne karte.
	 * @param brojLicne
	 */
	public void izbrisiProfesora(String brojLicne) {
		for(Profesor profesor : profesori) {
			if(profesor.getBrojLicneKarte().equals(brojLicne)) {
				profesori.remove(profesor);
				break;
			}
		}
	}
	
	/**
	 * Metoda koja za prosledjenje parametre menja profesora sa tim brojem licne karte.
	 * @param ime
	 * @param prezime
	 * @param email
	 * @param adresaKancelarije
	 * @param brojLicneKarte
	 */
	public void izmeniProfesora(String ime, String prezime,String email, String adresaKancelarije, String brojLicneKarte) {
		for(Profesor profesor : profesori) {
			if(profesor.getBrojLicneKarte().equals(brojLicneKarte)) {
				profesor.setIme(ime);
				profesor.setPrezime(prezime);
				profesor.setEmail(email);
				profesor.setAdresaKancelarije(adresaKancelarije);
				profesor.setBrojLicneKarte(brojLicneKarte);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
