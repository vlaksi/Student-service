package controller;



import java.util.ArrayList;
import java.util.List;

import model.BazaStudent;
import model.Predmet;
import model.Student;


/**
 * Klasa koja rukuje reakcijama na dogadjaje entiteta/modela: Student.
 * 
 * @author Vaxi i Pufke
 *
 */

public class StudentiController {
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	

	private static StudentiController instance = null;
	List<Student> listaStudenataZaSerijalizaciju = Serijalizacija.getInstance().deserijalizacijaObjekta();//Lista studenata za serijalizaciju
	

	private StudentiController() {
			
	}
	
	//Metoda koja vraca studenta za prosledjeni index reda
	public Student getListaStudenata(int i) {
		return BazaStudent.getInstance().getStudenti().get(i);
	}
	
	//Metoda koja vraca sve studente
	public List<Student> getListaSvihStudenata() {
		return BazaStudent.getInstance().getStudenti();
	}
	
	//Metoda koja vraca studenta za prosledjen index, u suprotnom vraca null
	public Student getStudentByIndex(String index) {
		List<Student> listaSvihStudenata = getListaSvihStudenata();
		
		for(Student student : listaSvihStudenata) {
			if(student.getBrIndexa().equals(index)) {
				return student;
			}
		}
		return null;
	}
	
	/**
	 * Metoda koja za prosledjenog studenta brise sa predmet, tj u listi predmeta
	 * 
	 * @param entitet studenta i premdet

	 */
	public void izbrisiPredmetProsledjenomStudentu(Student student, Predmet predmet) {
		BazaStudent.getInstance().izbrisiPredmetProsledjenomStudentu(student, predmet);
	}
	
	/**
	 * Metoda koja za prosledjenog studenta dodaje predmet, tj u listi predmeta
	 * 
	 * @param entitet studenta i premdet

	 */
	public void dodajStudentaNaPredmet(Student student, Predmet predmet) {
		BazaStudent.getInstance().addStudentNaPredmet(student, predmet);
	}

	public List<Student> getStudenti() {
		return BazaStudent.getInstance().getStudenti();
	}
	
	/**
	 * Metoda koja za prosledjenog studenta dodaje studenta
	 * 
	 * @param entitet studenta 
	 */
	public void dodajStudenta(Student student) {
		BazaStudent.getInstance().dodajStudentaString(student.getIme(), student.getPrezime(), student.getDatumRodjenja(), student.getAdresaStanovanja(), student.getTelefon(), 
				student.getEmail(), student.getBrIndexa(), student.getDatumUpisa(), student.getGodinaStudija(), student.getProsecnaOcena(),
				student.getStatusStudenta(), student.getPredmeti());
		//Dodajemo studenta u listu za serijalizaciju
		listaStudenataZaSerijalizaciju.add(student);

	}

	public List<Student> getListaStudenataZaSerijalizaciju() {
		return listaStudenataZaSerijalizaciju;
	}

	public void setListaStudenataZaSerijalizaciju(List<Student> listaStudenataZaSerijalizaciju) {
		this.listaStudenataZaSerijalizaciju = listaStudenataZaSerijalizaciju;
	}
	
	
	
}
