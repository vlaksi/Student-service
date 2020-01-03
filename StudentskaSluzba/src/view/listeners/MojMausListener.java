package view.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GlavniProzor;
import view.StudentiJTable;
import view.Dialogs.DodajStudentaDialog;

/**
 * Klasa koja je zaduzena za reakciju na akciju misa
 * @author Pufke
 *
 */

public class MojMausListener  implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex()== 0) {
			DodajStudentaDialog dialog = new DodajStudentaDialog(new StudentiJTable(), "Dodavanje studenta", true);
			dialog.setVisible(true);
		}
		
			
	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

