package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import view.StudentiJTable;

public class DodajStudentaDialog extends JDialog {

	private static final long serialVersionUID = -3924920391540440967L;

	public DodajStudentaDialog(StudentiJTable studentiJTable, String title, boolean modal) {
		super();

		setTitle("Dodavanje studenta");
		setSize(500, 500);
		// setBackground();
		setLocationRelativeTo(studentiJTable);

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
		
		JPanel panBrojIndexa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojIndexa = new JLabel("Broj indexa* ");
		lblBrojIndexa.setPreferredSize(dim);
		JTextField txtBrojIndexa = new JTextField();
		txtBrojIndexa.setPreferredSize(dim);
		panBrojIndexa.add(lblBrojIndexa);
		panBrojIndexa.add(txtBrojIndexa);
		
		
		JPanel panGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodinaStudija = new JLabel("Trenutna godina studija*");
		lblGodinaStudija.setPreferredSize(dim);
		String[] godineStudija = { "I (prva)" , "II (druga)" ,  "III (treca)",  "IV (cetvrta)"};
		JComboBox<String> godineComboBox = new JComboBox<String>(godineStudija);
		godineComboBox.setPreferredSize(dim);
		panGodinaStudija.add(lblGodinaStudija);
		panGodinaStudija.add(godineComboBox);
	
		JPanel panBudzetButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton budzetButton = new JRadioButton("Budzet");
		panBudzetButton.add(budzetButton);
		budzetButton.setSelected(true);
		
		JPanel panSamofinansiranjeButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton samofinansiranjeButton = new JRadioButton("Samofinansiranje");
		panSamofinansiranjeButton.add(samofinansiranjeButton);
		
		
		
	
		
		panCenter.add(panPrezime);
		panCenter.add(panIme);
		panCenter.add(panDatumRodj);
		panCenter.add(panAdresaStanovanja);
		panCenter.add(panBrojTelefona);
		panCenter.add(panBrojIndexa);
		panCenter.add(panGodinaStudija);
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
	}

}
