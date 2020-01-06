package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PredmetiController;
import controller.ProfesoriController;
import controller.StudentiController;
import view.ATMPredmeti;
import view.ATMProfesori;
import view.ATMStudenti;
import view.GlavniProzor;
import view.Tabovi;

/**
 * Klasa koja reprezentuje dijalog koji iskace kada neko pokusa da obrise neki
 * entitet iz tabele studenata.
 * 
 * @author Vaxi
 *
 */
public class PotvrdaBrisanjaStudentaDialog extends JDialog {

	private static final long serialVersionUID = 408727338813645251L;

	public PotvrdaBrisanjaStudentaDialog() {
		super();
		setTitle("Brisanje ?");
		setSize(485, 180);
		setLocationRelativeTo(this.getParent());
		setModal(true);

		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		panCenter.add(Box.createVerticalStrut(25));

		/* Dimenzije labela i tekstualnih komponenti */
		Dimension dim = new Dimension(400, 20);

		JPanel panPoruka = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblPoruka = new JLabel("Da li ste sigurni da zelite da izbrisete selektovani entitet ?");
		lblPoruka.setPreferredSize(dim);
		panPoruka.add(lblPoruka);

		panCenter.add(panPoruka);

		/*
		 * Na JDialog dodajemo panCentar i to u sredinu JDialog-a
		 */
		panCenter.add(Box.createVerticalStrut(25));
		add(panCenter, BorderLayout.NORTH);

		/* Na dnu JDialoga deo gde ce biti dugme Potvrda i Odustanak */
		JPanel panBottom = new JPanel();
		BoxLayout box = new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);

		/* Dodavanje Potvrde i Odustanak na dno */
		JButton btnOk = new JButton("Da");
		btnOk.setPreferredSize(new Dimension(90, 25));
		JButton btnCancel = new JButton("Ne");
		btnCancel.setPreferredSize(new Dimension(97, 25));
		panBottom.add(Box.createGlue());
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(25));

		add(panBottom, BorderLayout.CENTER);

		/*
		 * Omogucujemo da se dialog lepo resizuje tj da se uklopi u odnosu na sve nase
		 * male panele u JDialogu
		 */
		// pack();

		/* Lisener da na klik Ne ugasili dijalog */
		setLocationRelativeTo(GlavniProzor.getInstance());
		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 0) {
					int i = ATMStudenti.getSelectedRowIndex();
					StudentiController.getInstance().izbrisiStudenta(i);
					Tabovi.getModelStudenti().fireTableDataChanged();
					dispose();
				}
				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 1) {
					int i = ATMProfesori.getSelectedRowIndex();
					ProfesoriController.getInstance().izbrisiProfesora(i);
					Tabovi.getModelProfesori().fireTableDataChanged();
					dispose();
				}
				if (GlavniProzor.getInstance().getTabovi().getTabbedPane().getSelectedIndex() == 2) {
					int i = ATMPredmeti.getSelectedRowIndex();
					PredmetiController.getInstance().izbrisiPredmet(i);
					Tabovi.getModelPredmeti().fireTableDataChanged();
					dispose();
				}

			}
		});
	}

}
