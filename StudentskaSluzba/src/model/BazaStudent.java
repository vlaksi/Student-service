package model;

import java.util.ArrayList;
import java.util.List;



public class BazaStudent {
	
	private static BazaStudent instance = null;
	
	public static BazaStudent getInstance() {
		if (instance == null) {
			instance = new BazaStudent();
		}
		return instance;
	}
	
	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudent() {
		initStudent();
		this.kolone = new ArrayList<String>();
		
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}
	
	private void initStudent() {
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student(brIndexa, ime, prezime, godinaStudija, st, prosecnaOcena));
		studenti.add(new Student(brIndexa, ime, prezime, godinaStudija, st, prosecnaOcena));
		studenti.add(new Student(brIndexa, ime, prezime, godinaStudija, st, prosecnaOcena));
	}
}
