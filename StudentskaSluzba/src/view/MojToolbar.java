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

import model.BazaPredmeta;
import model.BazaProfesor;
import model.BazaStudent;
import view.Dialogs.DodajPredmetDialog;
import view.Dialogs.DodajStudentaDialog;
import view.Dialogs.DodavanjeProfesoraDIalog;
import view.Dialogs.IzmenaPredmetaDialog;
import view.Dialogs.IzmenaProfesoraDialog;
import view.Dialogs.IzmenaStudentaDialog;

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
		this.novoDugme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 0) {
					DodajStudentaDialog dialog = new DodajStudentaDialog(new StudentiJTable(), "Dodavanje studenta",
							true);
					dialog.setVisible(true);
				}

				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 1) {
					DodavanjeProfesoraDIalog dialog = new DodavanjeProfesoraDIalog(new ProfesoriJTable(),
							"Dodavanje profesora", true);
					dialog.setVisible(true);
				}

				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 2) {
					DodajPredmetDialog dialog = new DodajPredmetDialog(new PredmetiJTable(), "Dodavanje predmeta",
							true);
					dialog.setVisible(true);
				}
			}

		});

		ImageIcon iconNew = new ImageIcon("./img/add.png");
		novoDugme.setIcon(iconNew);
		add(novoDugme);
		postaviVidljivost(true, novoDugme);
		addSeparator();

		izmeniDugme = new JButton();
		izmeniDugme.setToolTipText("Izmeni");
		izmeniDugme.addActionListener(new ActionListener() {
			/*
			 * Lisener koji u zavisnosti u kom smo tabu i kliknemo izmeni da vrsi
			 * odgovarajucu izmenu selektovanog reda
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 0) {
					IzmenaStudentaDialog dialog = new IzmenaStudentaDialog(new StudentiJTable(), "Izmena studenta",
							true);
					dialog.setVisible(true);
				}
				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 1) {
					IzmenaProfesoraDialog dialog = new IzmenaProfesoraDialog(new ProfesoriJTable(), "Izmena profesora",
							true);
					dialog.setVisible(true);
				}

				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 2) {
					IzmenaPredmetaDialog dialog = new IzmenaPredmetaDialog(new PredmetiJTable(), "Izmena predmeta",
							true);
					dialog.setVisible(true);
				}
			}

		});

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
				/*
				 * Lisener koji u zavisnosti u kom smo tabu a kliknemo na izbrisi, izbrise
				 * odredjeni red
				 */
				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 0) {
					int i = ATMStudenti.getSelectedRowIndex();
					// System.out.println(i);
					BazaStudent.getInstance().getStudenti().remove(i);// TODO uraditi preko kontrolera
					Tabovi.getModelStudenti().fireTableDataChanged();
				}
				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 1) {
					int i = ATMProfesori.getSelectedRowIndex();
					// System.out.println(i);
					BazaProfesor.getInstance().getProfesori().remove(i);// TODO uraditi preko kontrolera
					Tabovi.getModelProfesori().fireTableDataChanged();

				}
				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 2) {
					int i = ATMPredmeti.getSelectedRowIndex();
					// System.out.println(i);
					BazaPredmeta.getInstance().getPredmeti().remove(i);// TODO uraditi preko kontrolera
					Tabovi.getModelPredmeti().fireTableDataChanged();
				}

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

		ImageIcon canselSearch = new ImageIcon("./img/canselSearch.png");
		JButton cancelSearchB = new JButton("Cancel", canselSearch);
		cancelSearchB.setVisible(false);

		searchB.addActionListener(new ActionListener() {
			/*
			 * Lisener koji na klik dugmica searchB, filtrira po zeljenim parametrima
			 * prosledjenim u searchable text fildu.
			 * 
			 * Implementacija: Razbijamo uneti string iz search-a po ';'. A onda njih
			 * rastavim na levi i desni.I kasnije ako imam neki koji odgovara nazivima
			 * kolone[ili slicnim].Pozivam metodu newFilter() koja vraca filtrirani izgled
			 * tabele.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				searchB.setVisible(false);
				cancelSearchB.setVisible(true);

				String[] nizUnetihParova = searchable.getText().split(";");
				String[] nizLevih = { " ", " ", " ", " ", " " };
				String[] nizDesnih = new String[5];
				for (int i = 0; i < nizUnetihParova.length; i++) {
					String[] pomocni;
					pomocni = nizUnetihParova[i].split(":");
					nizLevih[i] = pomocni[0];
					nizDesnih[i] = pomocni[1];

				}

				for (int i = 0; i < nizLevih.length; i++) {
					if (nizLevih[i].equals("sifra") || nizLevih[i].equals("Sifra") || nizLevih[i].equals("SIFRA")) {
						PredmetiJTable.newFilter(nizDesnih[i], 0);
					}
					if (nizLevih[i].equals("naziv") || nizLevih[i].equals("Naziv") || nizLevih[i].equals("NAZIV")) {
						PredmetiJTable.newFilter(nizDesnih[i], 1);
					}
					if (nizLevih[i].equals("semestar") || nizLevih[i].equals("Semestar")
							|| nizLevih[i].equals("SEMESTAR")) {
						PredmetiJTable.newFilter(nizDesnih[i], 2);
					}
					if (nizLevih[i].equals("godina") || nizLevih[i].equals("Godina") || nizLevih[i].equals("GODINA")) {
						PredmetiJTable.newFilter(nizDesnih[i], 3);
					}
					if (nizLevih[i].equals("profesor") || nizLevih[i].equals("Profesor")
							|| nizLevih[i].equals("Profesor")) {
						PredmetiJTable.newFilter(nizDesnih[i], 4);
					}
				}

			}
		});

		cancelSearchB.addActionListener(new ActionListener() {
			/* Lisener koji na pritisak cancel dugmeta,vraca prikaz nefiltrirane tabele */
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelSearchB.setVisible(false);
				searchB.setVisible(true);
				PredmetiJTable.newFilter("", 0);
			}
		});

		add(Box.createHorizontalGlue()); // Posle ovoga su svi elementi zalepljeni za desnu stranu
		add(searchable);
		add(searchB);
		add(cancelSearchB);
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
