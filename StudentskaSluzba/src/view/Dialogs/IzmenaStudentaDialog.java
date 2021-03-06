package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.StudentiController;
import model.Predmet;
import model.Student;
import model.Student.Status;
import view.ATMStudenti;
import view.GlavniProzor;
import view.Tabovi;

/**
 * Klasa koja predstavalja dijalog za Izmenu studenta
 * 
 * @author Pufke
 *
 */

public class IzmenaStudentaDialog extends JDialog {

	private static final long serialVersionUID = -3924920391540440967L;
	private static JTextField txtPrezime = null;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public IzmenaStudentaDialog() {
		super();

		setTitle("Izmena studenta");
		setSize(500, 500);
		// setBackground();

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
		txtPrezime.setText(
				StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getPrezime());
		txtPrezime.setPreferredSize(dim);
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);

		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setText(StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getIme());
		txtIme.setPreferredSize(dim);
		panIme.add(lblIme);
		panIme.add(txtIme);

		JPanel panDatumRodj = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDAtumRodj = new JLabel("Datum rodjenja*");
		lblDAtumRodj.setPreferredSize(dim);
		JTextField txtDatumRodjenja = new JTextField();
		txtDatumRodjenja.setText(StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex())
				.getDatumRodjenja());
		txtDatumRodjenja.setPreferredSize(dim);
		panDatumRodj.add(lblDAtumRodj);
		panDatumRodj.add(txtDatumRodjenja);

		JPanel panAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja*");
		lblAdresaStanovanja.setPreferredSize(dim);
		JTextField txtAdresaStanovanja = new JTextField();
		txtAdresaStanovanja.setText(StudentiController.getInstance()
				.getListaStudenata(ATMStudenti.getSelectedRowIndex()).getAdresaStanovanja());
		txtAdresaStanovanja.setPreferredSize(dim);
		panAdresaStanovanja.add(lblAdresaStanovanja);
		panAdresaStanovanja.add(txtAdresaStanovanja);

		JPanel panBrojTelefona = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojTelefona = new JLabel("Broj telefona*");
		lblBrojTelefona.setPreferredSize(dim);
		JTextField txtBrojTelefona = new JTextField();
		txtBrojTelefona.setText(
				StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getTelefon());
		txtBrojTelefona.setPreferredSize(dim);
		panBrojTelefona.add(lblBrojTelefona);
		panBrojTelefona.add(txtBrojTelefona);

		JPanel panBrojIndexa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojIndexa = new JLabel("Broj indexa* ");
		lblBrojIndexa.setPreferredSize(dim);
		JTextField txtBrojIndexa = new JTextField();
		txtBrojIndexa.setText(
				StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getBrIndexa());
		txtBrojIndexa.setPreferredSize(dim);
		panBrojIndexa.add(lblBrojIndexa);
		panBrojIndexa.add(txtBrojIndexa);

		JPanel panGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodinaStudija = new JLabel("Trenutna godina studija*");
		lblGodinaStudija.setPreferredSize(dim);
		String[] godineStudija = { "1", "2", "3", "4" };
		JComboBox<String> godineComboBox = new JComboBox<String>(godineStudija);
		godineComboBox.setPreferredSize(dim);
		godineComboBox.setSelectedItem(StudentiController.getInstance()
				.getListaStudenata(ATMStudenti.getSelectedRowIndex()).getGodinaStudija());
		panGodinaStudija.add(lblGodinaStudija);
		panGodinaStudija.add(godineComboBox);

		JPanel panProsecnaOcena = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblpanProsecnaOcena = new JLabel("Prosecna ocena* ");
		lblpanProsecnaOcena.setPreferredSize(dim);
		JTextField txtProsecnaOcena = new JTextField();
		txtProsecnaOcena.setText((StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex())
				.getProsecnaOcena()).toString());
		txtProsecnaOcena.setPreferredSize(dim);
		panProsecnaOcena.add(lblpanProsecnaOcena);
		panProsecnaOcena.add(txtProsecnaOcena);

		JPanel panDatumUpiusa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblpanDatumUpiusa = new JLabel("Datum upisa* ");
		lblpanDatumUpiusa.setPreferredSize(dim);
		JTextField txtPanDatumUpiusa = new JTextField();
		txtPanDatumUpiusa.setText((StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex())
				.getDatumUpisa()));
		txtPanDatumUpiusa.setPreferredSize(dim);
		panDatumUpiusa.add(lblpanDatumUpiusa);
		panDatumUpiusa.add(txtPanDatumUpiusa);

		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblpanEmail = new JLabel("Email* ");
		lblpanEmail.setPreferredSize(dim);
		JTextField txtPanEmail = new JTextField();

		txtPanEmail.setText(
				(StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getEmail()));
		txtPanEmail.setPreferredSize(dim);
		panEmail.add(lblpanEmail);
		panEmail.add(txtPanEmail);

		JPanel panBudzetButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton budzetButton = new JRadioButton("Budzet");
		panBudzetButton.add(budzetButton);
		budzetButton.setSelected(true);

		JPanel panSamofinansiranjeButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton samofinansiranjeButton = new JRadioButton("Samofinansiranje");
		panSamofinansiranjeButton.add(samofinansiranjeButton);

		// radio batne moramo da dodamo u grupu da bi imali funkcionalnost da je samo
		// jedan radio button selektovan, tj da se medjusobno iskljucuju
		ButtonGroup group = new ButtonGroup();
		group.add(budzetButton);
		group.add(samofinansiranjeButton);

		panCenter.add(panPrezime);
		panCenter.add(panIme);
		panCenter.add(panDatumRodj);
		panCenter.add(panAdresaStanovanja);
		panCenter.add(panBrojTelefona);
		panCenter.add(panBrojIndexa);
		panCenter.add(panProsecnaOcena);
		panCenter.add(panGodinaStudija);
		panCenter.add(panDatumUpiusa);
		panCenter.add(panEmail);
		panCenter.add(panBudzetButton);
		panCenter.add(panSamofinansiranjeButton);

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
				String brojIndexaFieldValue = txtBrojIndexa.getText();
				String brojtelefonaFieldValue = txtBrojTelefona.getText();
				String godinaStudijaValue = godineComboBox.getSelectedItem().toString();
				Double prosecnaOcenaValue = null;
				String datumUpisaValue = txtPanDatumUpiusa.getText();
				String emailValue = txtPanEmail.getText();

				if (!prezimeFieldValue.matches("[\\p{L}\\s]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za prezime studenta( Ispravan format prezimena je Peric )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!imeFieldValue.matches("[\\p{L}\\s]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za ime studenta( Ispravan format imena je Nemanja )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!datumRodjenjaFieldValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za datum rodjenja( Ispravan format datuma rodjenja je YYYY-MM-DD )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!adresaStanovanjaFieldValue.matches("[0-9]*{1,7}[\\p{L}\\s]+[0-9]*{1,7},[\\p{L}\\s]+")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za adresu stanovanja( Ispravan format datuma rodjenja je Karadjordjeva 83, Novi Sad )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!datumUpisaValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za datum upisa( Ispravan format datuma upisa je YYYY-MM-DD )",
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

				if (!brojIndexaFieldValue.matches("[A-Z]{1,2}[0-9]{1,3}-[12][0-9]{3}")) {
					JOptionPane.showMessageDialog(null,
							"ERROR: Uneli ste pogresnu vrednost za index studenta( Ispravan format indexa studenta je RA123-2017 )",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// Datum upisa, da nije veci od trenutnog, a ne sme biti manji od njegovog
				// datuma rodjena(ili rodjena +18)
				String[] tokensDatumUpisa = datumUpisaValue.split("-");
				String[] tokensDatumRodjenja = datumRodjenjaFieldValue.split("-");

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now();
				String[] tokensDatumTrenutni = dtf.format(now).split("-");

				try {
					int godinaUpisa = Integer.parseInt(tokensDatumUpisa[0]);
					int mesecUpisa = Integer.parseInt(tokensDatumUpisa[1]);
					int danUpisa = Integer.parseInt(tokensDatumUpisa[2]);
					int godinaRodjenja = Integer.parseInt(tokensDatumRodjenja[0]);
					@SuppressWarnings("unused")
					int mesecRodjenja = Integer.parseInt(tokensDatumRodjenja[1]);
					@SuppressWarnings("unused")
					int danRodjenja = Integer.parseInt(tokensDatumRodjenja[2]);
					int godinaTrenutna = Integer.parseInt(tokensDatumTrenutni[0]);
					int mesecTrenutni = Integer.parseInt(tokensDatumTrenutni[1]);
					int danTrenutni = Integer.parseInt(tokensDatumTrenutni[2]);

					// datum upisa, da nije veci od trenutnog
					if (godinaUpisa > godinaTrenutna) {
						JOptionPane.showMessageDialog(null,
								"ERROR: Datum upisa mora da bude manji od trenutnog datuma!", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (godinaUpisa == godinaTrenutna) {
						if (mesecUpisa > mesecTrenutni) {
							JOptionPane.showMessageDialog(null,
									"ERROR:Datum upisa mora da bude manji od trenutnog datuma!", "Greska",
									JOptionPane.ERROR_MESSAGE);
							return;
						} else if (mesecUpisa == mesecTrenutni) {
							if (danUpisa > danTrenutni) {
								JOptionPane.showMessageDialog(null,
										"ERROR:Datum upisa mora da bude manji od trenutnog datuma!", "Greska",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}

					// datum upisa sme biti manji od njegovog datuma rodjena(ili rodjena +18)
					if (godinaUpisa - 18 < godinaRodjenja) {
						JOptionPane.showMessageDialog(null, "ERROR: Student mora da ima minimum 18 godina!", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

				} catch (Exception e) {
					System.out.println("Greska pri parsiranju datuma");
				}

				if (!txtProsecnaOcena.getText().equals("")) {
					try {
						prosecnaOcenaValue = Double.parseDouble(txtProsecnaOcena.getText());

						if (prosecnaOcenaValue < 6 || prosecnaOcenaValue > 10) {
							JOptionPane.showMessageDialog(null,
									"ERROR: Uneli ste pogresnu vrednost za prosecnu ocenu(prosecna ocena je u intervalu od 6 do 10 ili ostavite prazno polje ako je student prva godina i nema prosek)",
									"Greska", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "ERROR: Uneli ste slovo u polje za prosecnu ocenu",
								"Greska", JOptionPane.ERROR_MESSAGE);
						return;

					}
				} else {
					if (godinaStudijaValue.equals("1")) {
						prosecnaOcenaValue = 0.0;
					} else {
						JOptionPane.showMessageDialog(null, "ERROR: Niste uneli sva polja", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				budzetButton.setActionCommand(budzetButton.getText());// Ove metode su nam potrebne da bi radio button
																		// prikupio informacije
				samofinansiranjeButton.setActionCommand(samofinansiranjeButton.getText());

				// Ako je budzet button pritisnut vratice string Budzet ako nije vratice string
				// null
				String budzetRadioButtonValue = budzetButton.isSelected() ? "Budzet" : "null";
				String samofinansiranjeRadioButtonValue = samofinansiranjeButton.isSelected() ? "Samofinansiranje"
						: "null";

				Status budzetIliSamofinansiranje = null;

				if (budzetRadioButtonValue.equals("Budzet")) {
					budzetIliSamofinansiranje = Status.B;
				} else if (samofinansiranjeRadioButtonValue.equals("Samofinansiranje")) {
					budzetIliSamofinansiranje = Status.S;
				}

				if (imeFieldValue.equals("") || prezimeFieldValue.equals("")|| datumRodjenjaFieldValue.equals("")
						|| adresaStanovanjaFieldValue.equals("") || brojIndexaFieldValue.equals("")
						|| brojIndexaFieldValue.equals("")|| brojtelefonaFieldValue.equals("")
						|| godinaStudijaValue.equals("") || datumUpisaValue.equals("") || emailValue.equals("")) {
					JOptionPane.showMessageDialog(null, "ERROR: Niste uneli sva polja", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					/*
					 * Ako je izmena godine studenta, da vrsi brisanje i u predmetima tog studenta
					 */
					if (!StudentiController.getInstance().getListaSvihStudenata().get(ATMStudenti.getSelectedRowIndex())
							.getGodinaStudija().equals(godinaStudijaValue)) {
						List<Predmet> listaPredmeta = new ArrayList<Predmet>();
						StudentiController.getInstance()
								.dodajStudenta(new Student(imeFieldValue, prezimeFieldValue, datumRodjenjaFieldValue,
										adresaStanovanjaFieldValue, brojtelefonaFieldValue, emailValue,
										brojIndexaFieldValue, datumUpisaValue, godinaStudijaValue, prosecnaOcenaValue,
										budzetIliSamofinansiranje, listaPredmeta));
						StudentiController.getInstance().izbrisiStudenta(ATMStudenti.getSelectedRowIndex());

					} else {/*
							 * Ako je izmena nekog drugog polja studenta, da ne vrsi brisanje u predmetima
							 * tog studenta
							 */

						List<Predmet> listaPredmeta = new ArrayList<Predmet>();
						listaPredmeta = StudentiController.getInstance().getListaSvihStudenata()
								.get(ATMStudenti.getSelectedRowIndex()).getPredmeti();
						StudentiController.getInstance()
								.dodajStudenta(new Student(imeFieldValue, prezimeFieldValue, datumRodjenjaFieldValue,
										adresaStanovanjaFieldValue, brojtelefonaFieldValue, emailValue,
										brojIndexaFieldValue, datumUpisaValue, godinaStudijaValue, prosecnaOcenaValue,
										budzetIliSamofinansiranje, listaPredmeta));
						StudentiController.getInstance()
								.izbrisiStudentaAliNeIPredmete(ATMStudenti.getSelectedRowIndex());
					}

				}

				Tabovi.getModelStudenti().fireTableDataChanged();

			}
		});

	}

	public static JTextField getTxtPrezime() {
		return txtPrezime;
	}

	public static void setTxtPrezime(JTextField txtPrezime) {
		IzmenaStudentaDialog.txtPrezime = txtPrezime;
	}

}
