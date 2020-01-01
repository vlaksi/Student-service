package model;

import java.util.ArrayList;
import java.util.List;

import model.Student.Status;

public class BazaStudent {
//TODO proveriti jos jednom sve metode umoran sam kucao...
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
		studenti.add(new Student("RA-1-2017", "Marko", "Markovic", "3", Status.B, 9.50));
		studenti.add(new Student("RA-2-2017", "Nikola", "Nikolic", "2", Status.S, 7.41));
		studenti.add(new Student("RA-3-2017", "Pero", "Peric", "4", Status.B, 8.54));
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return kolone.size();
	}

	public String getImeKolone(int index) {
		return this.kolone.get(index);
	}

	/**
	 * @param indexReda
	 * @return Student iz reda prosledjenog parametra.
	 */
	public Student getRed(int indexReda) {
		return this.studenti.get(indexReda);
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	/**
	 * 
	 * @param red
	 * @param kolona
	 * @return Vrednost u tabeli za prosledjeni red i kolonu
	 */
	public String getVrednost(int red, int kolona) {
		Student student = this.studenti.get(red);

		switch (kolona) {
		case 0:
			return student.getBrIndexa();
		case 1:
			return student.getIme();
		case 2:
			return student.getBrIndexa();
		case 3:
			return student.getGodinaStudija();
		case 4:
			return (student.getStatusStudenta()).toString();
		case 5:
			return (student.getProsecnaOcena()).toString();
		default:
			return null;

		}
	}

	/**
	 * Metoda koja za prosledjene parametre dodaje novog studenta u bazu profesora.
	 * 
	 * @param ime
	 * @param prezime
	 * @param brindexa
	 * @param godina   studija
	 * @param status   studenta
	 * @param prosecna ocena
	 */
	public void dodajStudenta(String brIndexa, String ime, String prezime, String godinaStudija, Status statusStudenta,
			Double prosecnaOcena) {
		this.studenti.add(new Student(brIndexa, ime, prezime, godinaStudija, statusStudenta, prosecnaOcena));
	}

	/**
	 * Metoda koja brise studenta sa brojem indexa.
	 * 
	 * @param broj indexa
	 */
	public void izbrisiStudenta(String brIndexa) {
		for (Student student : studenti) {
			if (student.getBrIndexa().equals(brIndexa)) {
				studenti.remove(student);
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
	public void izmeniProfesora(String brIndexa, String ime, String prezime, String godinaStudija, Status statusStudenta,
			Double prosecnaOcena) {
		for (Student student : studenti) {
			if (student.getBrIndexa().equals(brIndexa)) {
				student.setIme(ime);
				student.setPrezime(prezime);
				student.setGodinaStudija(godinaStudija);
				student.setStatusStudenta(statusStudenta);;
				student.setProsecnaOcena(prosecnaOcena);
			}
		}
	}

}
