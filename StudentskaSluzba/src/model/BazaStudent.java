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
		this.kolone.add("Godina studija");
	}
	
	private void initStudent() {
		this.igraci = new ArrayList<Igrac>();
		igraci.add(new Igrac(generateId(), "Mika", "Mikic", "Crvena Zvezda"));
		igraci.add(new Igrac(generateId(), "Zika", "Zikic", "FMP"));
		igraci.add(new Igrac(generateId(), "Pera", "Peric", "OKK Sabac"));
	}
}
