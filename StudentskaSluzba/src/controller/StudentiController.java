package controller;

import model.BazaStudent;
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
}
