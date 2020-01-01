package controller;

/**
 * Klasa koja rukuje reakcijama na dogadjaje entiteta/modela: Predmet.
 * 
 * @author Vaxi
 *
 */
public class PredmetiController {
	
	private static PredmetiController instance = null;
	
	public static PredmetiController getInstance() {
		if(instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	private PredmetiController() {
		
	}
}
