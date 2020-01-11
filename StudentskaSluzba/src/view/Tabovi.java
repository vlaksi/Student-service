package view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import controller.PredmetiController;
import controller.ProfesoriController;
import controller.StudentiController;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.Dialogs.ListDialog;
import view.Dialogs.ListDialog2;
import view.Dialogs.ListDialog3;

/**
 * Klasa koja predstavlja tabove,i u kojoj se kreiraju tabovi.
 * 
 * @author Vaxi i Pufke
 *
 */

public class Tabovi {

	public static Tabovi getInstance() {
		if (instance == null) {
			instance = new Tabovi();
		}
		return instance;
	}

	private StudentiJTable tabelaStudenata = null; // Treba nam za brisanje studenata
	private static ATMStudenti modelStudenti = null; // Treba nam za brisanje studenata

	private ProfesoriJTable tabelaProfesora = null; // za brisanje profesora
	private static ATMProfesori modelProfesori = null; // za brisanje profesora

	private PredmetiJTable tabelaPredmeta = null;
	private static ATMPredmeti modelPredmeti = null;

	private static int selectedRowTabelaPredmeta;// Treba nam za Dodavanje studenata na predmet, tj ispitujemo u klasi
													// MojToolbar da li je ista selektovano, ako je 0 0 znaci nije
	private static int selectedRowTabelaProfesor;

	private static int selectedColTabelaPredmeta;
	private static int selectedColTabelaProfesora;

	private JScrollPane scrollPane = null;
	private JTabbedPane tabbedPane = null;
	private JComponent panel1;
	private JComponent panel2;
	private JComponent panel3;
	public static Tabovi instance = null;

	public Tabovi() {
		super();
		tabbedPane = new JTabbedPane();

		panel1 = napraviTab("Panel 1", true, 0);
		tabbedPane.addTab("Studenti", null, panel1, "Studenti");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_S);

		panel2 = napraviTab("Panel 2", false, 1);
		tabbedPane.addTab("Profesori", null, panel2, "Profesori");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_P);

		panel3 = napraviTab("Panel 3", true, 2);
		tabbedPane.addTab("Predmeti", null, panel3, "Predmeti");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_R);

		this.scrollPane = new JScrollPane(tabbedPane);
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * Metoda koja pravi tabove u zavisnosti od indikatoraTaba[0-StudentTab,
	 * 1-ProefesorTab, 2-PredmetTab].
	 * 
	 * @param text
	 * @param f
	 * @param indikatorTaba
	 * @return
	 */
	private JComponent napraviTab(String text, boolean f, int indikatorTaba) {
		// TODO Ako nadjemo pametniji nacin,implementirati da bolje pozicioniranje
		// tabela, a ne ovako hc.
		JPanel panel = new JPanel(false);
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(200, 100));

		// Dodam labelu gore,dole,levo,desno a u sredinu tabelu
		JLabel l = new JLabel("");
		l.setPreferredSize(new Dimension(100, 100));
		l.setBackground(Color.lightGray);
		panel.add(l, BorderLayout.WEST);

		JLabel r = new JLabel("");
		r.setPreferredSize(new Dimension(100, 100));
		r.setBackground(Color.lightGray);
		panel.add(r, BorderLayout.EAST);

		JLabel s = new JLabel("");
		s.setPreferredSize(new Dimension(100, 50));
		s.setBackground(Color.lightGray);
		panel.add(s, BorderLayout.SOUTH);

		JLabel n = new JLabel("");
		n.setPreferredSize(new Dimension(100, 50));
		n.setBackground(Color.lightGray);
		n.setForeground(Color.WHITE);
		panel.add(n, BorderLayout.NORTH);
		// KRAJ DODAVANJA "BORDERA" OKO TABELA

		switch (indikatorTaba) {
		case 0:
			tabelaStudenata = new StudentiJTable();
			JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
			tabelaStudenata.getColumn("Spisak predmeta").setCellRenderer(new ButtonRenderer());
			panel.add(scrollPane, BorderLayout.CENTER);

			tabelaStudenata.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int row = tabelaStudenata.rowAtPoint(evt.getPoint());
					int col = tabelaStudenata.columnAtPoint(evt.getPoint());

					// OVO JE RADILO !!
					/*
					 * if (row >= 0 && col == 11) { ATMStudenti atmStudent = new ATMStudenti();
					 * 
					 * System.out.println(atmStudent.getValueAt(row, 11));
					 * JOptionPane.showMessageDialog(null, atmStudent.getValueAt(row, 11),
					 * "Lista predmeta selektovanog studenta", JOptionPane.INFORMATION_MESSAGE); }
					 */

					if (row >= 0 && col == 11) {
						//ATMStudenti atmStudent = modelStudenti;
						//String predmeti = (String) atmStudent.getValueAt(row, 11);
						String predmeti = (String) tabelaStudenata.getValueAt(row, 11);
						String[] tokens = predmeti.split("\n");

						JList<Object> list = new JList<Object>(tokens);
						ListDialog2 dialog2 = new ListDialog2("Spisak predmeta izabranog studenta", list);

						dialog2.show();
					}

				}
			});

			modelStudenti = (ATMStudenti) tabelaStudenata.getModel();
			modelStudenti.fireTableDataChanged(); // osvezavanje promena
			break;
		case 1:
			tabelaProfesora = new ProfesoriJTable();
			JScrollPane scrollPane3 = new JScrollPane(tabelaProfesora);
			tabelaProfesora.getColumn("Spisak predmeta").setCellRenderer(new ButtonRenderer());
			panel.add(scrollPane3, BorderLayout.CENTER);

			tabelaProfesora.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int row = tabelaProfesora.rowAtPoint(evt.getPoint());
					int col = tabelaProfesora.columnAtPoint(evt.getPoint());

					setSelectedColTabelaProfesora(col);
					setSelectedRowTabelaProfesor(row);

					if (row >= 0 && col == 10) {
						//String predmeti = (String) Tabovi.modelProfesori.getValueAt(row, 10);
						String predmeti = (String) tabelaProfesora.getValueAt(row, 10);
						String[] tokens = predmeti.split("\n");

						JList<Object> list = new JList<Object>(tokens);
						ListDialog3 dialog3 = new ListDialog3("Spisak predmeta izabranog profesora", list);
						dialog3.setOnOk(e -> {
							if (dialog3.getSelectedItem() == null
									|| dialog3.getSelectedItem().toString().length() == 0) {
								JOptionPane.showMessageDialog(null,
										"ERROR: Morate da selektujete predmet ako zelite da ga obriste.", "Greska",
										JOptionPane.ERROR_MESSAGE);
								return;
							} else {
								// TODO obrisati taj predmet iz liste predmeta tog profesora
								// TODO obrisati tog profesora iz liste profesora u predmetu
								Profesor profesorKomeBrisemoPredmet = ProfesoriController.getInstance()
										.getListaProfesora(tabelaProfesora.convertRowIndexToModel(row));
								Predmet predmetKogBrisemo = PredmetiController.getInstance()
										.getPredmetByNaziv(dialog3.getSelectedItem().toString());

								ProfesoriController.getInstance().izbrisiPredmetProfesora(profesorKomeBrisemoPredmet,
										predmetKogBrisemo);
								PredmetiController.getInstance().izbrisiProfesoraSaPredmeta(profesorKomeBrisemoPredmet,
										predmetKogBrisemo);
								Tabovi.getModelProfesori().fireTableDataChanged();
							}
						});

						dialog3.show();
					}

				}
			});

			modelProfesori = (ATMProfesori) tabelaProfesora.getModel();
			modelProfesori.fireTableDataChanged();
			break;
		case 2:
			this.tabelaPredmeta = new PredmetiJTable();
			JScrollPane scrollPane2 = new JScrollPane(this.tabelaPredmeta);
			//tabelaPredmeta.getColumn("Spisak studenata").setCellRenderer(new ButtonRenderer());
			panel.add(scrollPane2, BorderLayout.CENTER);

			tabelaPredmeta.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 2) {
						int row = tabelaPredmeta.rowAtPoint(evt.getPoint());
						int col = tabelaPredmeta.columnAtPoint(evt.getPoint());

						setSelectedColTabelaPredmeta(col);
						setSelectedRowTabelaPredmeta(row);

						if (row >= 0 && col == 5) {
							//String predmeti = (String) Tabovi.modelPredmeti.getValueAt(row, 5);
							//TODO proveriti ovo za ostale entitete
							String predmeti = (String) tabelaPredmeta.getValueAt(row, 5);
							String[] tokens = predmeti.split("\n");

							JList<Object> list = new JList<Object>(tokens);
							ListDialog dialog = new ListDialog(
									"Izaberite studenta kog zelite da obrisete sa predmeta: ", list);

							dialog.setOnOk(e -> {

								if (dialog.getSelectedItem() == null
										|| dialog.getSelectedItem().toString().length() == 0) {
									JOptionPane.showMessageDialog(null,
											"ERROR: Morate da selektujete studenta, ako nema ni jednog prvo ga dodajte na predmet",
											"Greska", JOptionPane.ERROR_MESSAGE);
									return;
								} else {
									System.out.println(row);
									Predmet PredmetSaKogBrisemo = PredmetiController.getInstance()
											.getListaPredmeta(tabelaPredmeta.convertRowIndexToModel(row));
									Student StudentKogBrisemo = StudentiController.getInstance()
											.getStudentByIndex(dialog.getSelectedItem().toString());

									// PredmetiController.getInstance().removeStudentaSaPredmet(StudentKogBrisemo,
									// PredmetSaKogBrisemo);
									StudentiController.getInstance()
											.izbrisiPredmetProsledjenomStudentu(StudentKogBrisemo, PredmetSaKogBrisemo);
									PredmetiController.getInstance().izbrisiStudentaProsledjenomPredmetu(
											StudentKogBrisemo, PredmetSaKogBrisemo);
									Tabovi.modelPredmeti.fireTableDataChanged();
								}
							});
							dialog.show();
						}
					} else {
						System.out.println("Nisam u tabu 3");
					}

				}
			});
			modelPredmeti = (ATMPredmeti) this.tabelaPredmeta.getModel();

			modelPredmeti.fireTableDataChanged();

			break;
		default:
			System.out.println("Das ist ein Problem mein Freund!");
		}

		return panel;
	}

	public StudentiJTable getTabelaStudenata() {
		return this.tabelaStudenata;
	}

	public static ATMStudenti getModelStudenti() {
		return modelStudenti;
	}

	public ProfesoriJTable getTabelaProfesora() {
		return this.tabelaProfesora;
	}

	public static ATMProfesori getModelProfesori() {
		return modelProfesori;
	}

	public PredmetiJTable getTabelaPredmeta() {
		return this.tabelaPredmeta;
	}

	public static ATMPredmeti getModelPredmeti() {
		return modelPredmeti;
	}

	public static int getSelectedRowTabelaPredmeta() {
		return Tabovi.selectedRowTabelaPredmeta;
	}

	public void setSelectedRowTabelaPredmeta(int selectedRowTabelaPredmeta) {
		Tabovi.selectedRowTabelaPredmeta = selectedRowTabelaPredmeta;
	}

	public static int getSelectedRowTabelaProfesor() {
		return Tabovi.selectedRowTabelaProfesor;
	}

	public static void setSelectedRowTabelaProfesor(int selectedRowTabelaProfesor) {
		Tabovi.selectedRowTabelaProfesor = selectedRowTabelaProfesor;
	}

	public static int getSelectedColTabelaPredmeta() {
		if (Tabovi.selectedColTabelaPredmeta == 0) {
		}
		return Tabovi.selectedColTabelaPredmeta;
	}

	public static int getSelectedColTabelaProfesora() {
		if (Tabovi.selectedColTabelaProfesora == 0) {

		}
		return Tabovi.selectedColTabelaProfesora;
	}

	public void setSelectedColTabelaPredmeta(int selectedColTabelaPredmeta) {
		Tabovi.selectedColTabelaPredmeta = selectedColTabelaPredmeta;
	}

	public void setSelectedColTabelaProfesora(int selectedColTabelaProfesora) {
		Tabovi.selectedColTabelaProfesora = selectedColTabelaProfesora;
	}

}
