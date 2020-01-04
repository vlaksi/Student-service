package controller;



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
	private static StudentiController instance = null;

	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}

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
	public void removeStudentaSaPredmet(Student student, Predmet predmet) {
		BazaStudent.getInstance().removeStudentaSaPredmet(student, predmet);
	}
}
