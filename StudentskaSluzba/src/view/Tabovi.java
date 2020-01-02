package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 * Klasa koja predstavlja tabove,i u kojoj se kreiraju tabovi.
 * 
 * @author Vaxi
 *
 */
public class Tabovi {

	private JScrollPane scrollPane = null;
	private JTabbedPane tabbedPane = null;
	private JComponent panel1;
	private JComponent panel2;
	private JComponent panel3;
	public static Tabovi instance = null;

	public static Tabovi getInstance() {
		if (instance == null) {
			instance = new Tabovi();
		}
		return instance;
	}

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

	public JComponent getPanel1() {
		return this.panel1;
	}

	public JComponent getPanel2() {
		return this.panel2;
	}

	public JComponent getPanel3() {
		return this.panel3;
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

		// Dodam labelu gore,dole,levo,desno a u sredinu tabelu studenata
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
		// KRAJ DODAVANJA "BORDERA" OKO TABELE STUDENATA

		switch (indikatorTaba) {
		case 0:
			StudentiJTable tabelaStudenata = new StudentiJTable();
			JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
			panel.add(scrollPane, BorderLayout.CENTER);
			ATMStudenti model = (ATMStudenti) tabelaStudenata.getModel();
			model.fireTableDataChanged(); // osvezavanje promena
			break;
		case 1:
			ProfesoriJTable tabelaProfesora = new ProfesoriJTable();
			JScrollPane scrollPane3 = new JScrollPane(tabelaProfesora);
			panel.add(scrollPane3, BorderLayout.CENTER);
			ATMProfesori model3 = (ATMProfesori) tabelaProfesora.getModel();
			model3.fireTableDataChanged();
			break;
		case 2:
			PredmetiJTable tabelaPredmeta = new PredmetiJTable();
			JScrollPane scrollPane2 = new JScrollPane(tabelaPredmeta);
			panel.add(scrollPane2, BorderLayout.CENTER);
			ATMPredmeti model2 = (ATMPredmeti) tabelaPredmeta.getModel();
			model2.fireTableDataChanged();
			break;
		default:
			System.out.println("Das ist ein Problem mein Freund!");
		}

		return panel;
	}

}
