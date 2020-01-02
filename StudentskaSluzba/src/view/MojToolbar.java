package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import view.listeners.MojMausListener;

/**
 * Klasa koja sluzi za implementaciju toolbara-a u glavnom prozoru.
 * 
 * @author Vaxi
 *
 */
public class MojToolbar extends JToolBar {
	private static final long serialVersionUID = 4684825905522190943L;

	private JButton novoDugme;
	private JButton izmeniDugme;

	public static MojToolbar instance = null;

	public static MojToolbar getInstance() {
		if (instance == null) {
			instance = new MojToolbar();
		}
		return instance;
	}

	public MojToolbar() {
		super(SwingConstants.HORIZONTAL); // podesavanje orijentacije toolbar-a

		addSeparator();
		this.novoDugme = new JButton();
		this.novoDugme.setToolTipText("Dodaj");
		this.novoDugme.addMouseListener(new MojMausListener());
		ImageIcon iconNew = new ImageIcon("./img/add.png");
		this.novoDugme.setIcon(iconNew);
		add(this.novoDugme);
		this.novoDugme.setVisible(true);

		addSeparator();

		izmeniDugme = new JButton();
		izmeniDugme.setToolTipText("Izmeni");
		ImageIcon iconNew2 = new ImageIcon("./img/edit.png");
		izmeniDugme.setIcon(iconNew2);
		add(izmeniDugme);
		izmeniDugme.setVisible(true);
		addSeparator();

		JToggleButton izbrisiDugme = new JToggleButton();
		izbrisiDugme.setToolTipText("Izbrisi");
		ImageIcon iconNew3 = new ImageIcon("./img/delete.png");
		izbrisiDugme.setIcon(iconNew3);
		add(izbrisiDugme);
		izbrisiDugme.setVisible(true);

		addSeparator();
		JButton dodajStudenta = new JButton();
		dodajStudenta.setToolTipText("Dodaj studenta");
		ImageIcon iconNew4 = new ImageIcon("./img/student.png");
		dodajStudenta.setIcon(iconNew4);
		add(dodajStudenta);
		dodajStudenta.setVisible(true);
		addSeparator();

		JButton dodajProfesora = new JButton();
		dodajProfesora.setToolTipText("Dodaj profesora");
		ImageIcon iconNew5 = new ImageIcon("./img/profesor3.png");
		dodajProfesora.setIcon(iconNew5);
		add(dodajProfesora);
		dodajProfesora.setVisible(true);
		addSeparator();

		JTextField searchable = new JTextField(30); // search polje
		ImageIcon search = new ImageIcon("./img/search.png");
		JButton searchB = new JButton("Search", search); // search dugme

		add(Box.createHorizontalGlue()); // Posle ovoga su svi elementi zalepljeni za desnu stranu
		add(searchable);
		add(searchB);
		searchable.setMaximumSize(new Dimension(100, 40));

		setFloatable(false);// toolbar je pokretljiv, probati i sa staticnim toolbarom
		setBackground(new Color(255, 255, 254));
	}

}
