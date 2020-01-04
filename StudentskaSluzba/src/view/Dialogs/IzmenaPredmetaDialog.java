package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import model.BazaPredmeta;
import model.Predmet;
import view.ATMPredmeti;
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
		setLocationRelativeTo(null);

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
		panSemestar.add(lblSemestar);
		panSemestar.add(semestarComboBox);

		/* Dodavanje godine studija */
		JPanel panGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodinaStudija = new JLabel("Godina studija*");
		lblGodinaStudija.setPreferredSize(dim);
		String[] godineStudija = { "1", "2", "3", "4" };
		JComboBox<String> godineComboBox = new JComboBox<String>(godineStudija);
		godineComboBox.setPreferredSize(dim);
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

		/* Lisener da na klik Odustanka ugasimo dijalog */
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
				setVisible(false);
			}

		});

		/* Lisener da na klik Potvrda pokupi podatke iz dialoga i doda ih u tabelu */

		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sifraFieldValue = txtSifra.getText();
				String nazivFieldValue = txtNaziv.getText();
				String semestarFieldValue = semestarComboBox.getSelectedItem().toString();
				String godinaStudijaFieldValue = godineComboBox.getSelectedItem().toString();

				if (sifraFieldValue.isBlank() || nazivFieldValue.isBlank()) {
					JOptionPane.showMessageDialog(null, "ERROR: Niste uneli sva polja", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {		
					Predmet predmet = new Predmet(sifraFieldValue, nazivFieldValue, semestarFieldValue,
							godinaStudijaFieldValue, PredmetiController.getInstance().getListaPredmeta(ATMPredmeti.getSelectedRowIndex())
							.getPredmetniProfesor());
					PredmetiController.getInstance().dodavanjePredmeta(predmet);
				}

				// Ako su prosle sve izmene onda izbrisemo tu koju smo izmenili
				int i = ATMPredmeti.getSelectedRowIndex();
				BazaPredmeta.getInstance().getPredmeti().remove(i);// TODO prebaciti u kontroler
				Tabovi.getModelPredmeti().fireTableDataChanged();

			}
		});

	}
}