package controller;

/**
 * Glavni kontroler u kome se resavaju dogadjaji koji povezuju razne kontrolere.
 * @author Vaxi
 *
 */
public class GlavniController {

	private static GlavniController instance = null;
	
	public static GlavniController getInstance() {
		if(instance == null) {
			instance = new GlavniController();
		}
		return instance;
	}
	
	private GlavniController() {
		
	}
}
