package view.listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controller.PredmetiController;
import controller.ProfesoriController;
import controller.SerijalizacijaPredmeta;
import controller.SerijalizacijaProfesora;
import controller.SerijalizacijaStudenta;
import controller.StudentiController;

/**
 * Klasa koja implementira WindowListener.
 * 
 * @author Vaxi i Pufke
 *
 */
public class MyWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Uraditi ako bude potrebe.

	}

	@Override
	public void windowClosing(WindowEvent e) {
		//Upisivanje u fajl tj serijalizacija pri zatvaranju prozora
		SerijalizacijaStudenta.getInstance().serijalizacijaObjekta(StudentiController.getInstance().getListaStudenataZaSerijalizaciju());
		SerijalizacijaProfesora.getInstance().serijalizacijaObjekta(ProfesoriController.getInstance().getListaProfesoraZaSerijalizaciju());		
		SerijalizacijaPredmeta.getInstance().serijalizacijaObjekta(PredmetiController.getInstance().getListaPredmetaZaSerijalizaciju());
		
		JFrame frame = (JFrame) e.getComponent();
		int code = JOptionPane.showConfirmDialog(frame, "Da li ste sigurni da �elite da zatvorite aplikaciju?",
				"Zatvaranje aplikacije?", JOptionPane.YES_NO_OPTION);
		if (code != JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Uraditi ako bude potrebe.

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Uraditi ako bude potrebe.

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Uraditi ako bude potrebe.

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Uraditi ako bude potrebe.

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Uraditi ako bude potrebe.

	}

}
