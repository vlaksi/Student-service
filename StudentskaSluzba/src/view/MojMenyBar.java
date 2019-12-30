package view;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenuItem.setToolTipText("Zatvaranje aplikacije");
		closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, // zatvaranje na ctrl c
				InputEvent.CTRL_DOWN_MASK));
		closeMenuItem.addActionListener((event) -> System.exit(0));

		JMenuItem newMenuItem = new JMenuItem("New", new ImageIcon("./img/new.png"));
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setToolTipText("Dodavanje novog entiteta u sistem");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

		file.add(newMenuItem);
		file.addSeparator();
		file.add(closeMenuItem);

		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);

		JMenuItem miEdit = new JMenuItem("Edit", new ImageIcon("./img/edit_menu.png"));
		miEdit.setMnemonic(KeyEvent.VK_E);
		miEdit.setToolTipText("Editovanje entiteta u sistemu");
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

		JMenuItem miDelete = new JMenuItem("Delete", new ImageIcon("./img/delete.png"));
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setToolTipText("Brisanje postojeceg entiteta u sistemu");
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);

		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);

		JMenuItem helpMenuItem = new JMenuItem("Help", new ImageIcon("./img/help.png"));
		helpMenuItem.setMnemonic(KeyEvent.VK_H);
		helpMenuItem.setToolTipText("Pomoc pri radu sa aplikacijom");
		helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));

		JMenuItem aboutMenuItem = new JMenuItem("About", new ImageIcon("./img/about.png"));
		aboutMenuItem.setMnemonic(KeyEvent.VK_A);
		aboutMenuItem.setToolTipText("Informacije o autorima aplikacije");
		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));

		help.add(helpMenuItem);
		help.addSeparator();
		help.add(aboutMenuItem);

		add(file);
		add(edit);
		add(help);
	}
}
