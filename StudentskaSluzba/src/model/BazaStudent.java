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

		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rodjenja");
		this.kolone.add("Adresa stanovanja");
		this.kolone.add("Telefon");
		this.kolone.add("Email");
		this.kolone.add("Indeks");
		this.kolone.add("Datum upisa");
		this.kolone.add("Godina studija");
		this.kolone.add("Prosek");
		this.kolone.add("Status");

	}

	private void initStudent() {
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student("Marko", "Markovic", "01.01.1998", "Nikinacka 81", "06030012", "marem@gmail.com",
				"RA1-2017", "02.07.2017", "3", 9.50, Status.B));
		studenti.add(new Student("Nikola", "Nikolic", "11.09.1998", "Topolosk 18", "06130012", "dzonisetac@gmail.com",
				"RA2-2017", "02.07.2017", "3", 9.61, Status.B));
		studenti.add(new Student("Pero", "Meric", "08.01.1998", "Sremska 1", "06430012", "marope@gmail.com", "RA3-2017",
				"02.07.2017", "3", 8.50, Status.B));

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
			return student.getIme();
		case 1:
			return student.getPrezime();
		case 2:
			return student.getDatumRodjenja();
		case 3:
			return student.getAdresaStanovanja();
		case 4:
			return student.getTelefon();
		case 5:
			return student.getEmail();
		case 6:
			return student.getBrIndexa();
		case 7:
			return student.getDatumUpisa();
		case 8:
			return student.getGodinaStudija();
		case 9:
			return (student.getProsecnaOcena()).toString();
		case 10:
			return (student.getStatusStudenta()).toString();

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
	public void izmeniProfesora(String brIndexa, String ime, String prezime, String godinaStudija,
			Status statusStudenta, Double prosecnaOcena) {
		for (Student student : studenti) {
			if (student.getBrIndexa().equals(brIndexa)) {
				student.setIme(ime);
				student.setPrezime(prezime);
				student.setGodinaStudija(godinaStudija);
				student.setStatusStudenta(statusStudenta);
				;
				student.setProsecnaOcena(prosecnaOcena);
			}
		}
	}

}
