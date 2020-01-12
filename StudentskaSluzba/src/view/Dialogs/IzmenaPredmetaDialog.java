package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetiController;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.ATMPredmeti;
import view.GlavniProzor;
import view.Tabovi;

/**
 * Klasa koje predstavlja dijalog za izmenu predmeta.
 * 
 * @author Vaxi
 *
 */
public class IzmenaPredmetaDialog extends JDialog {

	private static final long serialVersionUID = 3359794769472151342L;

	public IzmenaPredmetaDialog() {
		super();
		setTitle("Izmena predmeta");
		setSize(500, 500);
		this.setModal(true);

		/*
		 * Koristimo centralni da bi isli od gore prema dole kad dodajemo neke
		 * komponente.A na njega cemo posle lepiti male panele, gde svaki panel
		 * predstavlja jedan label i jedan text field [ stavljacemo flow layout za te
		 * panele, preporucljivo ].
		 * 
		 */
		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);

		/* Dimenzije labela i tekstualnih komponenti */
		Dimension dim = new Dimension(150, 20);

		/* Dodavanje sifre */
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSifra = new JLabel("Sifra*");
		lblSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setText(PredmetiController.getInstance().getListaPredmeta(ATMPredmeti.getSelectedRowIndex())
				.getSifraPredmeta());
		txtSifra.setPreferredSize(dim);
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);

		/* Dodavanje naziva */
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNaziv = new JLabel("Naziv*");
		lblNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setText(PredmetiController.getInstance().getListaPredmeta(ATMPredmeti.getSelectedRowIndex())
				.getNazivPredmeta());
		txtNaziv.setPreferredSize(dim);
		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);

		/* Dodavanje JComboBox-a za semestra na kom se odrzava predmet */
		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSemestar = new JLabel("Semestar*");
		lblSemestar.setPreferredSize(dim);
		String[] semestar = { "1", "2", "3", "4", "5", "6", "7", "8" };
		JComboBox<String> semestarComboBox = new JComboBox<String>(semestar);
		semestarComboBox.setPreferredSize(dim);
		semestarComboBox.setSelectedItem(
				PredmetiController.getInstance().getListaPredmeta(ATMPredmeti.getSelectedRowIndex()).getSemestar());
		panSemestar.add(lblSemestar);
		panSemestar.add(semestarComboBox);

		/* Dodavanje godine studija */
		JPanel panGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodinaStudija = new JLabel("Godina studija*");
		lblGodinaStudija.setPreferredSize(dim);
		String[] godineStudija = { "1", "2", "3", "4" };
		JComboBox<String> godineComboBox = new JComboBox<String>(godineStudija);
		godineComboBox.setPreferredSize(dim);
		godineComboBox.setSelectedItem(PredmetiController.getInstance()
				.getListaPredmeta(ATMPredmeti.getSelectedRowIndex()).getGodinaStudija());
		panGodinaStudija.add(lblGodinaStudija);
		panGodinaStudija.add(godineComboBox);

		/*
		 * Dodavanje na centralni panCenter nase male panele.
		 */
		panCenter.add(panSifra);
		panCenter.add(panNaziv);
		panCenter.add(panSemestar);
		panCenter.add(panGodinaStudija);

		/*
		 * Na JDialog dodajemo panCentar i to u sredinu JDialog-a
		 */
		panCenter.add(Box.createVerticalStrut(25));
		add(panCenter, BorderLayout.CENTER);

		/* Na dnu JDialoga deo gde ce biti dugme Potvrda i Odustanak */
		JPanel panBottom = new JPanel();
		BoxLayout box = new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);

		/* Dodavanje Potvrde i Odustanak na dno */
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

		/*
		 * Omogucujemo da se dialog lepo resizuje tj da se uklopi u odnosu na sve nase
		 * male panele u JDialogu
		 */
		pack();
		setLocationRelativeTo(GlavniProzor.getInstance());

		/* Lisener da na klik Odustanka ugasimo dijalog */
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// dispose();
				setVisible(false);
			}

		});

		/* Lisener da na klik Potvrda pokupi podatke iz dialoga i doda ih u tabelu */

		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sifraFieldValue = txtSifra.getText();
				Predmet kliknutPredmet = PredmetiController.getInstance()
						.getListaPredmeta(ATMPredmeti.getSelectedRowIndex());

				for (Predmet p : PredmetiController.getInstance().getListaSvihPredmeta()) {
					if (p.getSifraPredmeta().equals(sifraFieldValue)
							&& !p.getSifraPredmeta().equals(kliknutPredmet.getSifraPredmeta())) {
						JOptionPane.showMessageDialog(null, "ERROR: Vec postoji predmet sa tom sifrom.", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				String nazivFieldValue = txtNaziv.getText();
				String semestarFieldValue = semestarComboBox.getSelectedItem().toString();
				String godinaStudijaFieldValue = godineComboBox.getSelectedItem().toString();

				/* Provera da li su godina studija i semestar odgovarajuci */
				if (godinaStudijaFieldValue.equals("1")) {
					if (semestarFieldValue.equals("1") || semestarFieldValue.equals("2")) {

					} else {
						JOptionPane.showMessageDialog(null,
								"ERROR: Na prvoj godini je moguce biti samo na prvom ili drugom semestru.", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if (godinaStudijaFieldValue.equals("2")) {
					if (semestarFieldValue.equals("3") || semestarFieldValue.equals("4")) {

					} else {
						JOptionPane.showMessageDialog(null,
								"ERROR: Na drugoj godini je moguce biti samo na trecem ili cetvrtom semestru.",
								"Greska", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if (godinaStudijaFieldValue.equals("3")) {
					if (semestarFieldValue.equals("5") || semestarFieldValue.equals("6")) {

					} else {
						JOptionPane.showMessageDialog(null,
								"ERROR: Na trecoj godini je moguce biti samo na petom ili sestom semestru.", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if (godinaStudijaFieldValue.equals("4")) {
					if (semestarFieldValue.equals("7") || semestarFieldValue.equals("8")) {

					} else {
						JOptionPane.showMessageDialog(null,
								"ERROR: Na cetvrtoj godini je moguce biti samo na sedmom ili osmom semestru.", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				if (!nazivFieldValue.matches("[\\p{L}\\s]+[0-9]*")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za naziv predmeta ( Ispravan format naziva je npr: Analiza 1 )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!sifraFieldValue.matches("[A-Z]{2,3}[0-9]{2,3}")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za sifru predmeta ( Ispravan format sifre je npr: DM881 )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (sifraFieldValue.isBlank() || nazivFieldValue.isBlank()) {
					JOptionPane.showMessageDialog(null, "ERROR: Niste uneli sva polja", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {

					List<Student> listaStudenata = new ArrayList<Student>();
					Profesor profa = new Profesor();
					profa.setPrezime("Nema");
					profa.setBrojLicneKarte(" profesora");
					Predmet predmet = new Predmet(sifraFieldValue, nazivFieldValue, semestarFieldValue,
							godinaStudijaFieldValue, profa, listaStudenata);
					PredmetiController.getInstance().izbrisiPredmet(ATMPredmeti.getSelectedRowIndex());
					PredmetiController.getInstance().dodavanjePredmeta(predmet);
				}
				Tabovi.getModelPredmeti().fireTableDataChanged();

			}
		});

	}
}
