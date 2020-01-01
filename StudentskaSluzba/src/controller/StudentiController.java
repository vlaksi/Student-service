package controller;

/**
 * Klasa koja rukuje reakcijama na dogadjaje entiteta/modela: Student.
 * 
 * @author Vaxi
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
}
