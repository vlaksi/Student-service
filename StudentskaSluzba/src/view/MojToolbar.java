package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import model.BazaStudent;
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
	private JButton izbrisiDugme;
	private JButton dodajStudenta;
	private JButton dodajProfesora;

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

		novoDugme = new JButton();
		novoDugme.setToolTipText("Dodaj");

		this.novoDugme = new JButton();
		this.novoDugme.setToolTipText("Dodaj");
		this.novoDugme.addMouseListener(new MojMausListener());
		
		ImageIcon iconNew = new ImageIcon("./img/add.png");
		novoDugme.setIcon(iconNew);
		add(novoDugme);
		postaviVidljivost(true, novoDugme);
		addSeparator();

		izmeniDugme = new JButton();
		izmeniDugme.setToolTipText("Izmeni");
		ImageIcon iconNew2 = new ImageIcon("./img/edit.png");
		izmeniDugme.setIcon(iconNew2);
		add(izmeniDugme);
		postaviVidljivost(true, izmeniDugme);
		addSeparator();

		izbrisiDugme = new JButton();
		izbrisiDugme.setToolTipText("Izbrisi");
		izbrisiDugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = ATMStudenti.getSelectedRowIndex();
				System.out.println(i);
				BazaStudent.getInstance().getStudenti().remove(i);
				Tabovi.getModelStudenti().fireTableDataChanged();
				
			}
		});
		ImageIcon iconNew3 = new ImageIcon("./img/delete.png");
		izbrisiDugme.setIcon(iconNew3);
		add(izbrisiDugme);
		postaviVidljivost(true, izbrisiDugme);
		addSeparator();
		
		dodajStudenta = new JButton();
		dodajStudenta.setToolTipText("Dodaj studenta");
		ImageIcon iconNew4 = new ImageIcon("./img/student.png");
		dodajStudenta.setIcon(iconNew4);
		add(dodajStudenta);
		postaviVidljivost(false, dodajStudenta);
		addSeparator();

		dodajProfesora = new JButton();
		dodajProfesora.setToolTipText("Dodaj profesora");
		ImageIcon iconNew5 = new ImageIcon("./img/profesor3.png");
		dodajProfesora.setIcon(iconNew5);
		add(dodajProfesora);
		postaviVidljivost(false, dodajProfesora);
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

	/**
	 * Metoda koja za odredjeno dugme u toolbaru, postavi vidljivost na true ili
	 * false, u zavisnosti od parametra tf.
	 * 
	 * @param tf
	 * @param jb
	 */
	public void postaviVidljivost(boolean tf, JButton jb) {
		jb.setEnabled(tf);
		jb.setVisible(tf);
	}

	public JButton getNovoDugme() {
		return this.novoDugme;
	}

	public void setNovoDugme(JButton novoDugme) {
		this.novoDugme = novoDugme;
	}

	public JButton getIzmeniDugme() {
		return izmeniDugme;
	}

	public void setIzmeniDugme(JButton izmeniDugme) {
		this.izmeniDugme = izmeniDugme;
	}

	public JButton getIzbrisiDugme() {
		return izbrisiDugme;
	}

	public void setIzbrisiDugme(JButton izbrisiDugme) {
		this.izbrisiDugme = izbrisiDugme;
	}

	public JButton getDodajStudenta() {
		return dodajStudenta;
	}

	public void setDodajStudenta(JButton dodajStudenta) {
		this.dodajStudenta = dodajStudenta;
	}

	public JButton getDodajProfesora() {
		return dodajProfesora;
	}

	public void setDodajProfesora(JButton dodajProfesora) {
		this.dodajProfesora = dodajProfesora;
	}

}
