package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.StudentiController;
import model.Predmet;
import model.Student;
import model.Student.Status;
import view.ATMStudenti;
import view.Tabovi;

/**
 * Klasa koja predstavalja dijalog za Izmenu studenta
 * @author Pufke
 *
 */
public class IzmenaStudentaDialog  extends JDialog {
//TODO Dodati masku tj neki vid provere za index studenta
	private static final long serialVersionUID = -3924920391540440967L;
	private static JTextField txtPrezime = null;
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		        return matcher.find();
		}
	
	
	public IzmenaStudentaDialog() {
		super();

		setTitle("Izmena studenta");
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
		txtPrezime.setText(StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getPrezime()); 
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
		txtDatumRodjenja.setText(StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getDatumRodjenja());
		txtDatumRodjenja.setPreferredSize(dim);
		panDatumRodj.add(lblDAtumRodj);
		panDatumRodj.add(txtDatumRodjenja);
		
		

		JPanel panAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja*");
		lblAdresaStanovanja.setPreferredSize(dim);
		JTextField txtAdresaStanovanja = new JTextField();
		txtAdresaStanovanja.setText(StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getAdresaStanovanja());
		txtAdresaStanovanja.setPreferredSize(dim);
		panAdresaStanovanja.add(lblAdresaStanovanja);
		panAdresaStanovanja.add(txtAdresaStanovanja);

		JPanel panBrojTelefona = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojTelefona = new JLabel("Broj telefona*");
		lblBrojTelefona.setPreferredSize(dim);
		//JTextField txtBrojTelefona = new JTextField();
		MaskFormatter maskBrojTelefona = null;
		try {
			maskBrojTelefona = new MaskFormatter("##########");
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "ERROR: Greska u unosu broja telefona" , "Greska" , JOptionPane.ERROR_MESSAGE);
		}
		maskBrojTelefona.setPlaceholderCharacter('_'); 
		maskBrojTelefona.setValidCharacters("0123456789"); 
		JFormattedTextField txtBrojTelefona = new JFormattedTextField(maskBrojTelefona);
		txtBrojTelefona.setText(StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getTelefon());
		txtBrojTelefona.setPreferredSize(dim);
		panBrojTelefona.add(lblBrojTelefona);
		panBrojTelefona.add(txtBrojTelefona);

		JPanel panBrojIndexa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojIndexa = new JLabel("Broj indexa* ");
		lblBrojIndexa.setPreferredSize(dim);
		JTextField txtBrojIndexa = new JTextField();
		/*
		 * MaskFormatter maskBrojIndexa = null; try { maskBrojIndexa = new
		 * MaskFormatter("UU###-####"); } catch (ParseException e1) {
		 * JOptionPane.showMessageDialog(null, "ERROR: Greska u unosu Indexa" , "Greska"
		 * , JOptionPane.ERROR_MESSAGE); }
		 */
		/*
		 * maskBrojTelefona.setPlaceholderCharacter('_');
		 * maskBrojTelefona.setValidCharacters("0123456789");
		 */
		 /*FormattedTextField txtBrojIndexa = new JFormattedTextField(maskBrojIndexa);*/
		txtBrojIndexa.setText(StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getBrIndexa());
		txtBrojIndexa.setPreferredSize(dim);
		panBrojIndexa.add(lblBrojIndexa);
		panBrojIndexa.add(txtBrojIndexa);
		

		JPanel panGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodinaStudija = new JLabel("Trenutna godina studija*");
		lblGodinaStudija.setPreferredSize(dim);
		String[] godineStudija = { "1", "2", "3", "4" };
		JComboBox<String> godineComboBox = new JComboBox<String>(godineStudija);
		godineComboBox.setPreferredSize(dim);
		panGodinaStudija.add(lblGodinaStudija);
		panGodinaStudija.add(godineComboBox);
		
		JPanel panProsecnaOcena = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblpanProsecnaOcena = new JLabel("Prosecna ocena* ");
		lblpanProsecnaOcena.setPreferredSize(dim);
		JTextField txtProsecnaOcena = new JTextField();
		txtProsecnaOcena.setText((StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getProsecnaOcena()).toString());
		txtProsecnaOcena.setPreferredSize(dim);
		panProsecnaOcena.add(lblpanProsecnaOcena);
		panProsecnaOcena.add(txtProsecnaOcena);
		
		JPanel panDatumUpiusa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblpanDatumUpiusa = new JLabel("Datum upisa* ");
		lblpanDatumUpiusa.setPreferredSize(dim);
		JTextField txtPanDatumUpiusa = new JTextField();
		txtPanDatumUpiusa.setText((StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getDatumUpisa()));
		txtPanDatumUpiusa.setPreferredSize(dim);
		panDatumUpiusa.add(lblpanDatumUpiusa);
		panDatumUpiusa.add(txtPanDatumUpiusa);
		
		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblpanEmail = new JLabel("Email* ");
		lblpanEmail.setPreferredSize(dim);
		JTextField txtPanEmail = new JTextField();
	
		txtPanEmail.setText((StudentiController.getInstance().getListaStudenata(ATMStudenti.getSelectedRowIndex()).getEmail()));
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

		//radio batne moramo da dodamo u grupu da bi imali funkcionalnost da je samo jedan radio button selektovan, tj da se medjusobno iskljucuju
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
		
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		
		
		//Listeneri koji skupljaju text iz polja
		btnOk.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
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
			
			      if (!datumRodjenjaFieldValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
			    	  JOptionPane.showMessageDialog(null,
								"ERROR: Uneli ste pogresnu vrednost za datum rodjenja( Ispravan format datuma rodjenja je YYYY-MM-DD )",
								"Greska", JOptionPane.ERROR_MESSAGE);
			    	  return;
			    	}
			      
			      if (!datumUpisaValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
			    	  JOptionPane.showMessageDialog(null,
								"ERROR: Uneli ste pogresnu vrednost za datum upisa( Ispravan format datuma upisa je YYYY-MM-DD )",
								"Greska", JOptionPane.ERROR_MESSAGE);
			    	  return;
			    	}
			      
			      
			      if(!validate(emailValue)) {
						JOptionPane.showMessageDialog(null,
								"ERROR: Uneli ste pogresnu vrednost za e-mail(Ispravan primer maila je foobar@gmail.com)",
								"Greska", JOptionPane.ERROR_MESSAGE);
						return;
					}
				
				  if(!txtProsecnaOcena.getText().equals("")) {
					  try {
						  prosecnaOcenaValue = Double.parseDouble(txtProsecnaOcena.getText()); 
						  
						  if(prosecnaOcenaValue < 6 || prosecnaOcenaValue > 10) {
							  JOptionPane.showMessageDialog(null, "ERROR: Uneli ste pogresnu vrednost za prosecnu ocenu(prosecna ocena je u intervalu od 6 do 10)" , "Greska" , JOptionPane.ERROR_MESSAGE); 
						  }
						}
						catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "ERROR: Uneli ste slovo u polje za prosecnu ocenu" , "Greska" , JOptionPane.ERROR_MESSAGE);
							return;
						}
				  }else {
					  JOptionPane.showMessageDialog(null, "ERROR: Niste uneli sva polja" , "Greska" , JOptionPane.ERROR_MESSAGE);
					  return;
				  }
				
			
			      
			      budzetButton.setActionCommand(budzetButton.getText());//Ove metode su nam potrebne da bi radio button prikupio informacije
			      samofinansiranjeButton.setActionCommand(samofinansiranjeButton.getText());
			      
			      //Ako je budzet button pritisnut vratice string Budzet ako nije vratice string null
			      String budzetRadioButtonValue = budzetButton.isSelected()? "Budzet" : "null";
			      String samofinansiranjeRadioButtonValue = samofinansiranjeButton.isSelected()? "Samofinansiranje" : "null";
			      
			      Status budzetIliSamofinansiranje = null ;
			      
			      if(budzetRadioButtonValue.equals("Budzet")) {
			    	  budzetIliSamofinansiranje = Status.B;
			      }else if (samofinansiranjeRadioButtonValue.equals("Samofinansiranje")) {
			    	  budzetIliSamofinansiranje = Status.S;
			      }
			    	
			      if(imeFieldValue.isBlank() || prezimeFieldValue.isBlank() || datumRodjenjaFieldValue.isBlank() || adresaStanovanjaFieldValue.isBlank() ||
			    		  brojIndexaFieldValue.isBlank() || brojIndexaFieldValue.trim().equals("-")|| brojtelefonaFieldValue.isBlank() || godinaStudijaValue.isBlank() ||
			    		  prosecnaOcenaValue.isNaN() ||datumUpisaValue.trim().equals(".  .") || emailValue.trim().equals("_____@______") ) {
			    	  JOptionPane.showMessageDialog(null, "ERROR: Niste uneli sva polja" , "Greska" , JOptionPane.ERROR_MESSAGE);
			    	  return;
			      }else {
					  List<Predmet> listaPredmeta = new ArrayList<Predmet>();
			    	  StudentiController.getInstance().dodajStudenta(new Student(imeFieldValue, prezimeFieldValue, datumRodjenjaFieldValue, adresaStanovanjaFieldValue, 
			    			  brojtelefonaFieldValue, emailValue, brojIndexaFieldValue, datumUpisaValue, godinaStudijaValue, prosecnaOcenaValue, budzetIliSamofinansiranje, listaPredmeta));
			      }
			
			    //Ako su prosle sve izmene onda izbrisemo
			      StudentiController.getInstance().izbrisiStudenta(ATMStudenti.getSelectedRowIndex());
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
