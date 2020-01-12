package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.PredmetiController;
import controller.ProfesoriController;
import controller.StudentiController;
import view.Dialogs.DodajPredmetDialog;
import view.Dialogs.DodajProfesoraNaPredmetDialog;
import view.Dialogs.DodajStudentaDialog;
import view.Dialogs.DodajStudentaNaPredmetDialog;
import view.Dialogs.DodavanjeProfesoraDIalog;
import view.Dialogs.IzmenaPredmetaDialog;
import view.Dialogs.IzmenaProfesoraDialog;
import view.Dialogs.IzmenaStudentaDialog;
import view.Dialogs.PotvrdaBrisanjaDialog;

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
				PotvrdaBrisanjaDialog dialog = new PotvrdaBrisanjaDialog();
				dialog.setVisible(true);

			}
		});
		ImageIcon iconNew3 = new ImageIcon("./img/delete.png");
		izbrisiDugme.setIcon(iconNew3);
		add(izbrisiDugme);
		postaviVidljivost(true, izbrisiDugme);
		addSeparator();
		dodajStudenta = new JButton();
		dodajStudenta.setToolTipText("Dodaj studenta");
		dodajStudenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Listener koji sluzi za priakzivanje dialoga za dodavanje studenta na predmet

				if ((Tabovi.getSelectedColTabelaPredmeta() == 0) && (Tabovi.getSelectedRowTabelaPredmeta() == 0)) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Morate prvo da selektujete neki predmet u tabeli, u koloni naziv, selektujte zeljeni predmet",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					DodajStudentaNaPredmetDialog dialog = new DodajStudentaNaPredmetDialog();
					dialog.setVisible(true);
				}

				Tabovi.getModelPredmeti().fireTableDataChanged();

			}
		});

		ImageIcon iconNew4 = new ImageIcon("./img/student.png");
		dodajStudenta.setIcon(iconNew4);
		add(dodajStudenta);
		postaviVidljivost(false, dodajStudenta);
		addSeparator();

		dodajProfesora = new JButton();
		dodajProfesora.setToolTipText("Dodaj profesora");
		dodajProfesora.addActionListener(new ActionListener() {
			/*
			 * Lisener koji sluzi za prikazivanje dialoga za dodavanje profesora na predmet
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((Tabovi.getSelectedColTabelaPredmeta() == 0) && (Tabovi.getSelectedRowTabelaPredmeta() == 0)) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Morate prvo da selektujete neki predmet u tabeli, u koloni naziv, selektujte zeljeni predmet",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					DodajProfesoraNaPredmetDialog dialog = new DodajProfesoraNaPredmetDialog();
					dialog.setVisible(true);
				}

				Tabovi.getModelPredmeti().fireTableDataChanged();

			}
		});
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

		add(Box.createHorizontalGlue()); // Posle ovoga su svi elementi zalepljeni za desnu stranu
		add(searchable);
		add(searchB);
		add(cancelSearchB);
		searchable.setMaximumSize(new Dimension(100, 40));

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
				if (searchable.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Morate da uneste neku pretragu, kako bi se ona izvrsila.", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					searchB.setVisible(false);
					cancelSearchB.setVisible(true);

					String[] nizUnetihParova = searchable.getText().split(";");
					for (int i = 0; i < nizUnetihParova.length; i++) {
						if (!nizUnetihParova[i].contains(":") || nizUnetihParova[i].equals(":")) {
							JOptionPane.showMessageDialog(null,
									"ERROR: Niste validno pokusali pretragu. Primer validnog nacina: nazivKolone:trazenaVrednost .",
									"Greska", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					/* Search pretraga u tabu studenata */
					if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 0) {
						String[] nizLevih = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
						String[] nizDesnih = new String[11];
						for (int i = 0; i < nizUnetihParova.length; i++) {
							String[] pomocni;
							pomocni = nizUnetihParova[i].split(":");
							nizLevih[i] = pomocni[0];
							nizDesnih[i] = pomocni[1];
						}
						for (int i = 0; i < nizLevih.length; i++) {
							if (nizLevih[i].equals("ime") || nizLevih[i].equals("Ime") || nizLevih[i].equals("IME")) {
								StudentiJTable.newFilter(nizDesnih[i], 0);
							}
							if (nizLevih[i].equals("prezime") || nizLevih[i].equals("Prezime")
									|| nizLevih[i].equals("PREZIME")) {
								StudentiJTable.newFilter(nizDesnih[i], 1);
							}
							if (nizLevih[i].equals("datum rodjenja") || nizLevih[i].equals("Datum Rodjenja")
									|| nizLevih[i].equals("Datum rodjenja") || nizLevih[i].equals("DATUM RODJENJA")) {
								StudentiJTable.newFilter(nizDesnih[i], 2);
							}
							if (nizLevih[i].equals("adresa stanovanja") || nizLevih[i].equals("Adresa Stanovanja")
									|| nizLevih[i].equals("Adresa stanovanja")
									|| nizLevih[i].equals("ADRESA STANOVANJA")) {
								StudentiJTable.newFilter(nizDesnih[i], 3);
							}
							if (nizLevih[i].equals("telefon") || nizLevih[i].equals("Telefon")
									|| nizLevih[i].equals("TELEFON")) {
								StudentiJTable.newFilter(nizDesnih[i], 4);
							}
							if (nizLevih[i].equals("email") || nizLevih[i].equals("Email")
									|| nizLevih[i].equals("EMAIL")) {
								StudentiJTable.newFilter(nizDesnih[i], 5);
							}
							if (nizLevih[i].equals("indeks") || nizLevih[i].equals("Indeks")
									|| nizLevih[i].equals("Indeks")) {
								StudentiJTable.newFilter(nizDesnih[i], 6);
							}
							if (nizLevih[i].equals("Datum Upisa") || nizLevih[i].equals("datum upisa")
									|| nizLevih[i].equals("Datum upisa") || nizLevih[i].equals("DATUM UPISA")) {
								StudentiJTable.newFilter(nizDesnih[i], 7);
							}
							if (nizLevih[i].equals("Godina") || nizLevih[i].equals("Godina studija")
									|| nizLevih[i].equals("godina") || nizLevih[i].equals("GODINA")
									|| nizLevih[i].equals("godina studija") || nizLevih[i].equals("GODINA STUDIJA")) {
								StudentiJTable.newFilter(nizDesnih[i], 8);
							}
							if (nizLevih[i].equals("Prosek") || nizLevih[i].equals("prosek")
									|| nizLevih[i].equals("PROSEK")) {
								StudentiJTable.newFilter(nizDesnih[i], 9);
							}
							if (nizLevih[i].equals("Status") || nizLevih[i].equals("status")
									|| nizLevih[i].equals("STATUS")) {
								StudentiJTable.newFilter(nizDesnih[i], 10);
							}

						}
						searchable.setText(null);
					}

					/* Search pretraga u tabu profesora */
					if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 1) {
						String[] nizLevih = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
						String[] nizDesnih = new String[10];
						for (int i = 0; i < nizUnetihParova.length; i++) {
							String[] pomocni;
							pomocni = nizUnetihParova[i].split(":");
							nizLevih[i] = pomocni[0];
							nizDesnih[i] = pomocni[1];
						}
						for (int i = 0; i < nizLevih.length; i++) {
							if (nizLevih[i].equals("ime") || nizLevih[i].equals("Ime") || nizLevih[i].equals("IME")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 0);
							}
							if (nizLevih[i].equals("prezime") || nizLevih[i].equals("Prezime")
									|| nizLevih[i].equals("PREZIME")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 1);
							}
							if (nizLevih[i].equals("datum rodjenja") || nizLevih[i].equals("Datum Rodjenja")
									|| nizLevih[i].equals("Datum rodjenja") || nizLevih[i].equals("DATUM RODJENJA")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 2);
							}
							if (nizLevih[i].equals("adresa stanovanja") || nizLevih[i].equals("Adresa Stanovanja")
									|| nizLevih[i].equals("Adresa stanovanja")
									|| nizLevih[i].equals("ADRESA STANOVANJA")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 3);
							}
							if (nizLevih[i].equals("telefon") || nizLevih[i].equals("Telefon")
									|| nizLevih[i].equals("TELEFON")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 4);
							}
							if (nizLevih[i].equals("email") || nizLevih[i].equals("Email")
									|| nizLevih[i].equals("EMAIL")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 5);
							}
							if (nizLevih[i].equals("adresa kancelarije") || nizLevih[i].equals("Adresa Kancelarije")
									|| nizLevih[i].equals("Adresa kancelarije")
									|| nizLevih[i].equals("ADRESA KANCELARIJE")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 6);
							}
							if (nizLevih[i].equals("broj licne") || nizLevih[i].equals("Broj Licne")
									|| nizLevih[i].equals("Broj licne") || nizLevih[i].equals("BROJ LICNE")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 7);
							}
							if (nizLevih[i].equals("titula") || nizLevih[i].equals("Titula")
									|| nizLevih[i].equals("TITULA")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 8);
							}
							if (nizLevih[i].equals("zvanje") || nizLevih[i].equals("Zvanje")
									|| nizLevih[i].equals("ZVANJE")) {
								ProfesoriJTable.newFilter(nizDesnih[i], 9);
							}

						}

						searchable.setText(null);
					}
					/* Search pretraga u tabu predmeta */
					if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 2) {
						String[] nizLevih = { " ", " ", " ", " ", " " };
						String[] nizDesnih = new String[5];
						for (int i = 0; i < nizUnetihParova.length; i++) {
							String[] pomocni;
							pomocni = nizUnetihParova[i].split(":");
							nizLevih[i] = pomocni[0];
							nizDesnih[i] = pomocni[1];
						}

						for (int i = 0; i < nizLevih.length; i++) {
							if (nizLevih[i].equals("sifra") || nizLevih[i].equals("Sifra")
									|| nizLevih[i].equals("SIFRA")) {
								PredmetiJTable.newFilter(nizDesnih[i], 0);
							}
							if (nizLevih[i].equals("naziv") || nizLevih[i].equals("Naziv")
									|| nizLevih[i].equals("NAZIV")) {
								PredmetiJTable.newFilter(nizDesnih[i], 1);
							}
							if (nizLevih[i].equals("semestar") || nizLevih[i].equals("Semestar")
									|| nizLevih[i].equals("SEMESTAR")) {
								PredmetiJTable.newFilter(nizDesnih[i], 2);
							}
							if (nizLevih[i].equals("godina") || nizLevih[i].equals("Godina")
									|| nizLevih[i].equals("GODINA") || nizLevih[i].equals("godina studija")
									|| nizLevih[i].equals("Godina studija") || nizLevih[i].equals("Godina Studija")
									|| nizLevih[i].equals("GODINA STUDIJA")) {
								PredmetiJTable.newFilter(nizDesnih[i], 3);
							}
							if (nizLevih[i].equals("profesor") || nizLevih[i].equals("Profesor")
									|| nizLevih[i].equals("Profesor")) {
								PredmetiJTable.newFilter(nizDesnih[i], 4);
							}
						}
						searchable.setText(null);
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
				ProfesoriJTable.newFilter("", 0);
				StudentiJTable.newFilter("", 0);

			}
		});

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
