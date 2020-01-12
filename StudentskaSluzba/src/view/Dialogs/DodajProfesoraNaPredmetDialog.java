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
import controller.ProfesoriController;
import model.Predmet;
import model.Profesor;
import view.ATMPredmeti;
import view.GlavniProzor;
import view.Tabovi;

/**
 * Klasa koja predstavlja dijalog koji iskace prilikom dodavanja profesora na
 * predmet.
 * 
 * @author Vaxi
 *
 */
public class DodajProfesoraNaPredmetDialog extends JDialog {
	private static final long serialVersionUID = 8486429064630711627L;

	public DodajProfesoraNaPredmetDialog() {
		setTitle("Predmet - Dodavanje profesora");
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
		Dimension dim = new Dimension(200, 20);

		/* Dodavanje broj licne karte profesora */
		JPanel panBrojLicne = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrojLicne = new JLabel("Broj licne karte*");
		lblBrojLicne.setPreferredSize(dim);
		JTextField txtBrojLicne = new JTextField();
		txtBrojLicne.setPreferredSize(dim);
		panBrojLicne.add(lblBrojLicne);
		panBrojLicne.add(txtBrojLicne);

		panCenter.add(panBrojLicne);

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

			@Override
			public void actionPerformed(ActionEvent e) {
				String brojLicneFieldValue = txtBrojLicne.getText();
				int vecPostoji = 0;
				List<Profesor> listaSvihProfesora = ProfesoriController.getInstance().getListaSvihProfesora();
				Profesor profesorKogDodajemo = new Profesor();
				Predmet predmetNaKojiDodajemo = new Predmet();

				if (brojLicneFieldValue.isEmpty()) {
					JOptionPane.showMessageDialog(null, "ERROR: Niste uneli broj licne karte profesora", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				for (Profesor profesor : listaSvihProfesora) {
					if (brojLicneFieldValue.equals(profesor.getBrojLicneKarte())) {
						profesorKogDodajemo = profesor;
						predmetNaKojiDodajemo = PredmetiController.getInstance().getPredmetByRowIndex(red);
						vecPostoji = 1;
					}
				}
				if (vecPostoji == 0) {
					JOptionPane.showMessageDialog(null, "ERROR: Ne postoji profesor sa tim brojem licne karte",
							"Greska", JOptionPane.ERROR_MESSAGE);
				} else {
					/* Ako postoji, onda ga dodajemo tog profesora na predmet */
					PredmetiController.getInstance().dodajProfesoraNaPredmet(profesorKogDodajemo,
							predmetNaKojiDodajemo);
					ProfesoriController.getInstance().dodajPredmetProfesoru(profesorKogDodajemo, predmetNaKojiDodajemo);
				}

				Tabovi.getModelPredmeti().fireTableDataChanged();
				dispose();

			}

		});

	}

}
