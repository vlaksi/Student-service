package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesoriController;
import model.Predmet;
import model.Profesor;
import view.GlavniProzor;
import view.Tabovi;

/**
 * Klasa koja predstavlja dialog koji iskace kada pritisnemo dugme za izmenu
 * profesora
 * 
 * @author Pufke
 *
 */
public class DodavanjeProfesoraDIalog extends JDialog {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		        return matcher.find();
		}
	
	private static final long serialVersionUID = 1173816528517766648L;

	public DodavanjeProfesoraDIalog() {
		super();

		setTitle("Dodavanje profesora");
		setSize(500, 500);
		// setBackground();
		setLocationRelativeTo(GlavniProzor.getInstance());
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
		JTextField txtDatumRodjenja = new JTextField();
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
		JTextField txtBrojTelefona = new JTextField();
		txtBrojTelefona.setPreferredSize(dim);
		panBrojTelefona.add(lblBrojTelefona);
		panBrojTelefona.add(txtBrojTelefona);

		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblpanEmail = new JLabel("Email* ");
		lblpanEmail.setPreferredSize(dim);
		JTextField txtPanEmail = new JTextField();
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
		setLocationRelativeTo(GlavniProzor.getInstance());
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
				for (Profesor p : ProfesoriController.getInstance().getListaSvihProfesora()) {
					if (p.getBrojLicneKarte().equals(brojLicneKarteFieldValue)) {
						JOptionPane.showMessageDialog(null, "ERROR: Vec postoji profesor sa tim brojem licne karte.",
								"Greska", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				String titulaFieldValue = txtTitula.getText();
				String zvanjeFiledValue = txtTitula.getText();


				
				if (imeFieldValue.isBlank() || prezimeFieldValue.isBlank() || datumRodjenjaFieldValue.isBlank()
						|| adresaStanovanjaFieldValue.isBlank() || datumRodjenjaFieldValue.isBlank()
						|| emailValue.isBlank() || adresaKancelarijeFieldValue.isBlank()
						|| brojLicneKarteFieldValue.isBlank() || titulaFieldValue.isBlank()
						|| zvanjeFiledValue.isBlank()) {
					JOptionPane.showMessageDialog(null, "ERROR: Niste uneli sva polja", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;

				} 

				if (!imeFieldValue.matches("[\\p{L}\\s]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za ime profesora( Ispravan format imena je Nemanja )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!prezimeFieldValue.matches("[\\p{L}\\s]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za prezime profesora( Ispravan format prezimena je Peric )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!datumRodjenjaFieldValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za datum rodjenja( Ispravan format datuma rodjenja je YYYY-MM-DD )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!adresaStanovanjaFieldValue.matches("[\\p{L}\\s]+[0-9]+,[\\p{L}\\s]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za adresu stanovanja( Ispravan format datuma rodjenja je Karadjordjeva 83, Novi Sad )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!brojtelefonaFieldValue.matches("[0-9]{3}/[0-9]{3,5}-[0-9]{3,5}")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za broj telefona( Ispravan format za broj telefona je 065/555-555 )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!validate(emailValue)) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za e-mail(Ispravan primer maila je foobar@gmail.com)",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!adresaKancelarijeFieldValue.matches("[\\p{L}\\s]+[0-9]+,[\\p{L}\\s]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za adresu kancelarije( Ispravan format adrese je Karadjordjeva 83, Novi Sad )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!brojLicneKarteFieldValue.matches("[0-9]{9}")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za broj licne karte( Ispravan format je 555555 )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!titulaFieldValue.matches("[\\p{L}\\s]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost titulu( Ispravan format je profesor )", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!zvanjeFiledValue.matches("[\\p{L}\\s]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za zvanje( Ispravan format je dekan )", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				List<Predmet> listaPredmeta = new ArrayList<Predmet>();
				Profesor profesor = new Profesor(imeFieldValue, prezimeFieldValue, datumRodjenjaFieldValue,
						adresaStanovanjaFieldValue, brojtelefonaFieldValue, emailValue, adresaKancelarijeFieldValue,
						brojLicneKarteFieldValue, titulaFieldValue, zvanjeFiledValue, listaPredmeta);
				ProfesoriController.getInstance().dodavanjeProfesora(profesor);

				Tabovi.getModelProfesori().fireTableDataChanged();
				dispose();

			}
		});
	}

}
