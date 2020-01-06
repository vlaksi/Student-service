package view;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.PredmetiController;
import controller.ProfesoriController;
import controller.StudentiController;
import view.Dialogs.AboutDialog;
import view.Dialogs.DodajPredmetDialog;
import view.Dialogs.DodajStudentaDialog;
import view.Dialogs.DodavanjeProfesoraDIalog;
import view.Dialogs.HelpDialog;
import view.Dialogs.IzmenaPredmetaDialog;
import view.Dialogs.IzmenaProfesoraDialog;
import view.Dialogs.IzmenaStudentaDialog;
import view.Dialogs.PotvrdaBrisanjaDialog;

/*
 * klasa nasledjuje JMenuBar i predstavlja kontejner
 * za komponente JMenu. Instanca ove klase ce se 
 * smestati u glavni prozor aplikacije
 * 
 * @author Pufke
 * 
 */
public class MojMenyBar extends JMenuBar {
//TODO proveriti metode setMnemonic gde se kasnije koriste, trebalo bi kod eventlistenera, PAZI na to neki se isto zovu kod 
//TODO JMenu komponente i JMenuItem komponente, ako ih ne budemo nigde koristili treba ih obrisati !!! 
	private static final long serialVersionUID = -8544372218994433942L;

	public MojMenyBar() {

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		JMenuItem closeMenuItem = new JMenuItem("Close              ", new ImageIcon("./img/exit.png"));
		closeMenuItem.setMnemonic(KeyEvent.VK_W);
		closeMenuItem.setToolTipText("Zatvaranje aplikacije");
		closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, // zatvaranje na ctrl c
				InputEvent.CTRL_DOWN_MASK));
		closeMenuItem.addActionListener((event) -> System.exit(0));

		JMenuItem newMenuItem = new JMenuItem("New", new ImageIcon("./img/new.png"));
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setToolTipText("Dodavanje novog entiteta u sistem");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		newMenuItem.addActionListener((event) -> dodavanjeEntiteta());
		
		file.add(newMenuItem);
		file.addSeparator();
		file.add(closeMenuItem);

		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);

		JMenuItem miEdit = new JMenuItem("Edit", new ImageIcon("./img/edit_menu.png"));
		miEdit.setMnemonic(KeyEvent.VK_E);
		miEdit.setToolTipText("Editovanje entiteta u sistemu");
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		miEdit.addActionListener((event) -> izmenaEntiteta());
		
		JMenuItem miDelete = new JMenuItem("Delete", new ImageIcon("./img/delete.png"));
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setToolTipText("Brisanje postojeceg entiteta u sistemu");
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		miDelete.addActionListener((event) -> brisanjeEntiteta());
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);

		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem helpMenuItem = new JMenuItem("Help", new ImageIcon("./img/help.png"));
		helpMenuItem.setMnemonic(KeyEvent.VK_H);
		helpMenuItem.setToolTipText("Pomoc pri radu sa aplikacijom");
		helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		helpMenuItem.addActionListener((event) -> helpp());
		
		JMenuItem aboutMenuItem = new JMenuItem("About", new ImageIcon("./img/about.png"));
		aboutMenuItem.setMnemonic(KeyEvent.VK_I);
		aboutMenuItem.setToolTipText("Informacije o autorima aplikacije");
		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		aboutMenuItem.addActionListener((event) -> about());

		help.add(helpMenuItem);
		help.addSeparator();
		help.add(aboutMenuItem);

		add(file);
		add(edit);
		add(help);
	}

	private Object dodavanjeEntiteta() {
		if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 0) {
			DodajStudentaDialog dialog = new DodajStudentaDialog();
			dialog.setVisible(true);
		}
		if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 1) {
			DodavanjeProfesoraDIalog dialog = new DodavanjeProfesoraDIalog();
			dialog.setVisible(true);
		}

		if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 2) {
			DodajPredmetDialog dialog = new DodajPredmetDialog();
			dialog.setVisible(true);
		}
		return listenerList;
	}
	
	 private void izmenaEntiteta() {
		if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 0) {
			if (StudentiController.getInstance().getListaSvihStudenata().isEmpty()) {
				JOptionPane.showMessageDialog(null, "ERROR: Tabela je prazna, i nema studenta za izmenu.",
						"Greska", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				IzmenaStudentaDialog dialog = new IzmenaStudentaDialog();
				dialog.setVisible(true);
			}

		}
		if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 1) {
			if (ProfesoriController.getInstance().getListaSvihProfesora().isEmpty()) {
				JOptionPane.showMessageDialog(null, "ERROR: Tabela je prazna, i nema profesora za izmenu.",
						"Greska", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				IzmenaProfesoraDialog dialog = new IzmenaProfesoraDialog();
				dialog.setVisible(true);
			}

		}

		if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 2) {
			if (PredmetiController.getInstance().getListaSvihPredmeta().isEmpty()) {
				JOptionPane.showMessageDialog(null, "ERROR: Tabela je prazna, i nema predmeta za izmenu.",
						"Greska", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				IzmenaPredmetaDialog dialog = new IzmenaPredmetaDialog();
				dialog.setVisible(true);
			}

		}
	}
	 
	 private void brisanjeEntiteta() {
		 
		 PotvrdaBrisanjaDialog dialog = new PotvrdaBrisanjaDialog();
			dialog.setVisible(true);
	 }
	 
	 private void about() {
		 AboutDialog aboutDialog = new AboutDialog();
	 }
	 private void helpp() {
		 HelpDialog helpDialog = new HelpDialog();
		 helpDialog.setVisible(true);
	 }
}
