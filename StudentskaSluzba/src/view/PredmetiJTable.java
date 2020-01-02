package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 * Klasa koje reprezentuje konfigurisanje prikaza tabele predmeti.
 * 
 * @author Vaxi
 *
 */
public class PredmetiJTable extends JTable {

	private static final long serialVersionUID = -1404313258591137307L;
	
	private TableRowSorter<ATMPredmeti> sortiranje;
	
	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ATMPredmeti model =new ATMPredmeti();
		this.setModel(model);
		
		sortiranje = new TableRowSorter<ATMPredmeti>(model);
		sortiranje.setSortable(4, false); // iskljucujem kolonu za spisak studenata
		this.setRowSorter(sortiranje);
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
