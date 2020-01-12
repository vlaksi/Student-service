package model;

import java.io.Serializable;
import java.util.List;

/**
 * Model Predmeta
 * 
 * @author Pufke
 *
 */
public class Student implements Serializable{

	private static final long serialVersionUID = -4899548870833415227L;

	private String ime;
	private String prezime;
	private String datumRodjenja; 
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String brIndexa;
	private String datumUpisa;
	private String godinaStudija;
	private Double prosecnaOcena;
	private Status statusStudenta;
	private List<Predmet> predmeti;
	
	public enum Status {
		B,S;
	}

	public Student(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String telefon,
			String email, String brIndexa, String datumUpisa, String godinaStudija, Double prosecnaOcena, Status statusStudenta, List<Predmet> predmeti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.brIndexa = brIndexa;
		this.datumUpisa = datumUpisa;
		this.godinaStudija = godinaStudija;
		this.prosecnaOcena = prosecnaOcena;
		this.setStatusStudenta(statusStudenta);
		this.predmeti = predmeti;
	}
	
	public Student() {
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String profesor() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getPrezime() {
		return prezime;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrIndexa() {
		return brIndexa;
	}
	public void setBrIndexa(String brIndexa) {
		this.brIndexa = brIndexa;
	}
	public String getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public String getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public Double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(Double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public Status getStatusStudenta() {
		return statusStudenta;
	}

	public void setStatusStudenta(Status statusStudenta) {
		this.statusStudenta = statusStudenta;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	
}
