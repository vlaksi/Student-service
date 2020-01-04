package view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

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

	private static int selectedRowTabelaPredmeta;//Treba nam za Dodavanje studenata na predmet, tj ispitujemo u klasi MojToolbar da li je ista selektovano, ako je 0 0 znaci nije
	private static  int selectedColTabelaPredmeta;
	
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
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		panel2 = napraviTab("Panel 2", false, 1);
		tabbedPane.addTab("Profesori", null, panel2, "Profesori");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		panel3 = napraviTab("Panel 3", true, 2);
		tabbedPane.addTab("Predmeti", null, panel3, "Predmeti");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

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
					if (row >= 0 && col == 11) {
						ATMStudenti atmStudent = new ATMStudenti();

						System.out.println(atmStudent.getValueAt(row, 11));
						JOptionPane.showMessageDialog(null, atmStudent.getValueAt(row, 11),
								"Lista predmeta selektovanog studenta", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});

			modelStudenti = (ATMStudenti) tabelaStudenata.getModel();
			modelStudenti.fireTableDataChanged(); // osvezavanje promena
			break;
		case 1:
			tabelaProfesora = new ProfesoriJTable();
			JScrollPane scrollPane3 = new JScrollPane(tabelaProfesora);
			panel.add(scrollPane3, BorderLayout.CENTER);
			modelProfesori = (ATMProfesori) tabelaProfesora.getModel();
			modelProfesori.fireTableDataChanged();
			break;
		case 2:
			this.tabelaPredmeta = new PredmetiJTable();
			JScrollPane scrollPane2 = new JScrollPane(this.tabelaPredmeta);
			panel.add(scrollPane2, BorderLayout.CENTER);

			modelPredmeti = (ATMPredmeti) this.tabelaPredmeta.getModel();

			tabelaPredmeta.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					int row = tabelaPredmeta.rowAtPoint(evt.getPoint());
					int col = tabelaPredmeta.columnAtPoint(evt.getPoint());
					
					setSelectedColTabelaPredmeta(col);
					setSelectedRowTabelaPredmeta(row);
	
				}
			});
			modelPredmeti = (ATMPredmeti) tabelaPredmeta.getModel();

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

	public int getSelectedRowTabelaPredmeta() {
		return Tabovi.selectedRowTabelaPredmeta;
	}

	public void setSelectedRowTabelaPredmeta(int selectedRowTabelaPredmeta) {
		Tabovi.selectedRowTabelaPredmeta = selectedRowTabelaPredmeta;
	}

	public int getSelectedColTabelaPredmeta() {
		if(Tabovi.selectedColTabelaPredmeta == 0) {
			System.out.println("NULAA JE");
		}
		return Tabovi.selectedColTabelaPredmeta;
	}

	public void setSelectedColTabelaPredmeta(int selectedColTabelaPredmeta) {
		Tabovi.selectedColTabelaPredmeta = selectedColTabelaPredmeta;
	}

}
