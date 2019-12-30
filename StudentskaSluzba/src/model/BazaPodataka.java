package model;


/**
 * Klasa u kojoj se nalaze podaci i metode o entitetima aplikacije.
 * @author Pufke i Vaxi
 *
 */
public class BazaPodataka {

	private static BazaPodataka instance = null;
	
	public static BazaPodataka getInstance() {
		if(instance == null) {
			instance = new BazaPodataka();
		}
		return instance;
	}
	
}
