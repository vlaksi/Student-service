package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ProfesoriController;
import model.Profesor;
import view.GlavniProzor;

/**
 * Klasa koja predstavlja dialog koji iskace kada pritisnemo dugme za izmenu
 * profesora
 * 
 * @author Pufke
 *
 */
public class DodavanjeProfesoraDIalog extends JDialog {

	private static final long serialVersionUID = 1173816528517766648L;

	public DodavanjeProfesoraDIalog() {
		super();

		setTitle("Dodavanje profesora");
		setSize(500, 500);
		// setBackground();
		setLocationRelativeTo(null);
		this.setModal(true);
		
		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);

		// dimenzije labela i tekstualnih komponenti
		Dimension dim = new Dimension(150, 20);

		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrezime = new JLabel("Prezime*");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);

		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		panIme.add(lblIme);
		panIme.add(txtIme);

		JPanel panDatumRodj = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDAtumRodj = new JLabel("Datum rodjenja*");
		lblDAtumRodj.setPreferredSize(dim);
		// JTextField txtDatumRodjenja = new JTextField();
		MaskFormatter maskDatumRodj = null;
		try {
			maskDatumRodj = new MaskFormatter("####.##.##");
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "ERROR: Greska u datumu rodjenja", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		maskDatumRodj.setPlaceholderCharacter('_');
		maskDatumRodj.setValidCharacters("0123456789");
		JFormattedTextField txtDatumRodjenja = new JFormattedTextField(maskDatumRodj);
		txtDatumRodjenja.setPreferredSize(dim);
		panDatumRodj.add(lblDAtumRodj);
		panDatumRodj.add(txtDatumRodjenja);

		JPanel panAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja*");
		lblAdresaStanovanja.setPreferredSize(dim);
		JTextField txtAdresaStanovanja = new JTextField();
		txtAdresaStanovanja.setPreferredSize(dim);
		panAdresaStanovanja.add(lblAdresaStanovanja);
		panAdresaStanovanja.add(txtAdresaStanovanja);

		JPanel panBrojTelefona = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojTelefona = new JLabel("Broj telefona*");
		lblBrojTelefona.setPreferredSize(dim);
		// JTextField txtBrojTelefona = new JTextField();
		MaskFormatter maskBrojTelefona = null;
		try {
			maskBrojTelefona = new MaskFormatter("##########");
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "ERROR: Greska u unosu broja telefona", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
		maskBrojTelefona.setPlaceholderCharacter('_');
		maskBrojTelefona.setValidCharacters("0123456789");
		JFormattedTextField txtBrojTelefona = new JFormattedTextField(maskBrojTelefona);
		txtBrojTelefona.setPreferredSize(dim);
		panBrojTelefona.add(lblBrojTelefona);
		panBrojTelefona.add(txtBrojTelefona);

		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblpanEmail = new JLabel("Email* ");
		lblpanEmail.setPreferredSize(dim);
		// JTextField txtPanEmail = new JTextField();
		MaskFormatter maskEmail = null;
		try {
			maskEmail = new MaskFormatter("*****@******");
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "ERROR: Greska u mailu", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		maskEmail.setPlaceholderCharacter('_');
		JFormattedTextField txtPanEmail = new JFormattedTextField(maskEmail);
		txtPanEmail.setPreferredSize(dim);
		panEmail.add(lblpanEmail);
		panEmail.add(txtPanEmail);

		JPanel panAdresaKancelarije = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaKancelarije = new JLabel("Adresa kancelarije*");
		lblAdresaKancelarije.setPreferredSize(dim);
		JTextField txtAdresaKancelarije = new JTextField();
		txtAdresaKancelarije.setPreferredSize(dim);
		panAdresaKancelarije.add(lblAdresaKancelarije);
		panAdresaKancelarije.add(txtAdresaKancelarije);

		JPanel panBrojLicneKarte = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojLicneKarte = new JLabel("Broj licne*");
		lblBrojLicneKarte.setPreferredSize(dim);
		JTextField txtBrojLicneKarte = new JTextField();
		txtBrojLicneKarte.setPreferredSize(dim);
		panBrojLicneKarte.add(lblBrojLicneKarte);
		panBrojLicneKarte.add(txtBrojLicneKarte);

		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitula = new JLabel("Titula*");
		lblTitula.setPreferredSize(dim);
		JTextField txtTitula = new JTextField();
		txtTitula.setPreferredSize(dim);
		panTitula.add(lblTitula);
		panTitula.add(txtTitula);

		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblZvanje = new JLabel("Zvanje*");
		lblZvanje.setPreferredSize(dim);
		JTextField txtZvanje = new JTextField();
		txtZvanje.setPreferredSize(dim);
		panZvanje.add(lblZvanje);
		panZvanje.add(txtZvanje);

		panCenter.add(panPrezime);
		panCenter.add(panIme);
		panCenter.add(panDatumRodj);
		panCenter.add(panAdresaStanovanja);
		panCenter.add(panBrojTelefona);
		panCenter.add(panEmail);
		panCenter.add(panAdresaKancelarije);
		panCenter.add(panBrojLicneKarte);
		panCenter.add(panTitula);
		panCenter.add(panZvanje);

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

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// Listeneri koji skupljaju text iz polja
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String imeFieldValue = txtIme.getText();
				String prezimeFieldValue = txtPrezime.getText();
				String datumRodjenjaFieldValue = txtDatumRodjenja.getText();
				String adresaStanovanjaFieldValue = txtAdresaStanovanja.getText();
				String brojtelefonaFieldValue = txtBrojTelefona.getText();
				String emailValue = txtPanEmail.getText();
				String adresaKancelarijeFieldValue = txtAdresaKancelarije.getText();
				String brojLicneKarteFieldValue = txtBrojLicneKarte.getText();
				String titulaFieldValue = txtTitula.getText();
				String zvanjeFiledValue = txtTitula.getText();

				if (imeFieldValue.isBlank() || prezimeFieldValue.isBlank() || datumRodjenjaFieldValue.isBlank()
						|| adresaStanovanjaFieldValue.isBlank() || datumRodjenjaFieldValue.trim().equals(".  .")
						|| brojtelefonaFieldValue.trim().equals("__________")
						|| emailValue.trim().equals("_____@______") || adresaKancelarijeFieldValue.isBlank()
						|| brojLicneKarteFieldValue.isBlank() || titulaFieldValue.isBlank()
						|| zvanjeFiledValue.isBlank()) {
					JOptionPane.showMessageDialog(null, "ERROR: Niste uneli sva polja", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					Profesor profesor = new Profesor(imeFieldValue, prezimeFieldValue, datumRodjenjaFieldValue,
							adresaStanovanjaFieldValue, brojtelefonaFieldValue, emailValue, adresaKancelarijeFieldValue,
							brojLicneKarteFieldValue, titulaFieldValue, zvanjeFiledValue);
					ProfesoriController.getInstance().dodavanjeProfesora(profesor);
				}

				Integer width = (int) GlavniProzor.getInstance().getSize().getWidth();
				Integer height = (int) GlavniProzor.getInstance().getSize().getHeight();

				GlavniProzor.getInstance().setSize(width, height + 1);
				dispose();

			}
		});
	}

}
