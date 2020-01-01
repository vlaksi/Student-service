package controller;

/**
 * Klasa koja rukuje reakcijama na dogadjaje entiteta/modela: Profesor.
 * 
 * @author Vaxi
 *
 */
public class ProfesoriController {
	private static ProfesoriController instance = null;

	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}

	private ProfesoriController() {
	}
}
