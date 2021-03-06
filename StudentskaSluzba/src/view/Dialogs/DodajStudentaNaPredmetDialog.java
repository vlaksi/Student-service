package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetiController;
import controller.StudentiController;
import model.Predmet;
import model.Student;
import view.ATMPredmeti;
import view.GlavniProzor;
import view.Tabovi;

public class DodajStudentaNaPredmetDialog extends JDialog {

	private static final long serialVersionUID = -6472283890478597069L;

	public DodajStudentaNaPredmetDialog() {
		super();

		setTitle("Predmet - Dodavanje studenta");
		setSize(500, 500);
		this.setModal(true);

		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);

		/* Dimenzije labela i tekstualnih komponenti */
		Dimension dim = new Dimension(150, 20);

		JPanel panIndxStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIndxStudenta = new JLabel("Index studenta*");
		lblIndxStudenta.setPreferredSize(dim);
		JTextField txtIndxStudenta = new JTextField();
		txtIndxStudenta.setPreferredSize(dim);
		panIndxStudenta.add(lblIndxStudenta);
		panIndxStudenta.add(txtIndxStudenta);

		panCenter.add(panIndxStudenta);

		panCenter.add(Box.createVerticalStrut(25));
		add(panCenter, BorderLayout.CENTER);

		JPanel panBottom = new JPanel();
		BoxLayout box = new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);

		JButton btnOk = new JButton("Potvrda");
		btnOk.setPreferredSize(new Dimension(90, 25));

		JButton btnCancel = new JButton("Odustanak");
		btnCancel.setPreferredSize(new Dimension(97, 25));
		panBottom.add(Box.createGlue());
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));

		add(panBottom, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(GlavniProzor.getInstance());

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		int red = ATMPredmeti.getSelectedRowIndex();

		btnOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				String indexFieldValue = txtIndxStudenta.getText();
				int isti = -1;
				List<Student> listaSvihStudenata = StudentiController.getInstance().getListaSvihStudenata();
				Student studentKogDodajemo = new Student();
				Predmet predmetNaKojiDodajemo = new Predmet();

				if (indexFieldValue.isEmpty()) {
					JOptionPane.showMessageDialog(null, "ERROR: Niste uneli index", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				for (Student student : listaSvihStudenata) {

					if (indexFieldValue.equals(student.getBrIndexa())) {

						// Provera da li su student i selektovani predmet na istoj godini studija
						if (!student.getGodinaStudija().equals(
								PredmetiController.getInstance().getPredmetByRowIndex(red).getGodinaStudija())) {
							JOptionPane.showMessageDialog(null,
									"ERROR: Predmet koji ste izabrali i student nisu na istoj godini studija", "Greska",
									JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							studentKogDodajemo = student;
							predmetNaKojiDodajemo = PredmetiController.getInstance().getPredmetByRowIndex(red);
							isti = 1;
						}
					}
				}

				if (isti == -1) {
					JOptionPane.showMessageDialog(null, "ERROR: Ne postoji student sa tim indexom", "Greska",
							JOptionPane.ERROR_MESSAGE);
				} else { // U suprotnom zanci da smo pronasli odgovarajuceg studenta za predmet i treba
							// ga dodati

					// provera da li taj predmet vec postoji u listiPredmeta u studentu
					List<Predmet> listaPredmetaa = studentKogDodajemo.getPredmeti();
					for (Predmet predmett : listaPredmetaa) {
						if (predmett.getSifraPredmeta().equals(predmetNaKojiDodajemo.getSifraPredmeta())) {
							JOptionPane.showMessageDialog(null,
									"ERROR: Nije moguce dodeliti dva puta isti predmet studentu!", "Greska",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					}

					PredmetiController.getInstance().dodajStudentaPredmetu(studentKogDodajemo, predmetNaKojiDodajemo);
					StudentiController.getInstance().dodajPredmetStudentu(studentKogDodajemo, predmetNaKojiDodajemo);

				}
				Tabovi.getModelPredmeti().fireTableDataChanged();
				dispose();
			}
		});
	}
}
