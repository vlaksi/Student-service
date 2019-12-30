package model;

import java.util.Date;

public class Student {
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String brIndexa;
	private Date datumUpisa;
	private String godinaStudija;
	private double prosecnaOcena;
	
	private enum Status {
		B(0), //Budzet
		S(1); //Samofinansiranje
		
		private Status(int status) {this.status = status;}
		
		private final int status;
		
		public int getStatus() {
			return status;
		}
	}
	
	private Status st;
	
	public Student(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String brIndexa, Date datumUpisa, String godinaStudija, double prosecnaOcena, Status st) {
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
		this.st = st;
	}
	
	public Student(String brIndexa,String ime, String prezime, String godinaStudija, Status st, double prosecnaOcena) {
		this.brIndexa = brIndexa;
		this.ime = ime;
		this.prezime = prezime;
		this.godinaStudija = godinaStudija;
		this.prosecnaOcena = prosecnaOcena;
		this.st = st;
	}
	
	public Student() {
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
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
	public Date getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public String getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	public Status getSt() {
		return st;
	}
	public void setSt(Status st) {
		this.st = st;
	}

}
