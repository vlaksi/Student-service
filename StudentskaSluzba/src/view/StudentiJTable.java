package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * Klasa koja reprezentuje tabelu studenata.
 * 
 * @author Vaxi
 *
 */
public class StudentiJTable extends JTable {

	private static final long serialVersionUID = 3870532450326465610L;

	public StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new ATMStudenti());
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		/*
		 * Metoda koja omogucava da selektovani red ima drugaciju boju od ostalih
		 * redova.
		 */
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
