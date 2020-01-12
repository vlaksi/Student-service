package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
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

	private ATMPredmeti model;
	private static TableRowSorter<ATMPredmeti> sortiranje;

	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false); // kako bi iskljucili mogucnost pomeranja kolona levo-desno
		this.model = new ATMPredmeti();
		this.setModel(getModel());

		sortiranje = new TableRowSorter<ATMPredmeti>(model);
		sortiranje.setSortable(4, false); // iskljucujem poslednje 2 kolone za mogucnost sortiranja
		sortiranje.setSortable(5, false);
		this.setRowSorter(sortiranje);
	}

	/**
	 * Metoda koja vraca novi izgled tabele, filtriran po zeljenim parametrima.Npr:
	 * ako zelimo da za nultu[prvu] kolonu proverimo da li ima neko ko pocinje sa
	 * 'AN',prosledimo string "AN" kao prvi parametar a kao drugi parametar
	 * prosledimo 0 [nulta kolona]
	 * 
	 * @param trazeno
	 * @param brojKolone
	 */
	public static void newFilter(String trazeno, int brojKolone) {
		RowFilter<? super ATMPredmeti, ? super Integer> rf = null;

		try {
			rf = RowFilter.regexFilter("^" + trazeno, brojKolone);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}

		getSortiranje().setRowFilter(rf);
	}

	public static TableRowSorter<ATMPredmeti> getSortiranje() {
		return sortiranje;
	}

	public static void setSortiranje(TableRowSorter<ATMPredmeti> sortiranje) {
		PredmetiJTable.sortiranje = sortiranje;
	}

	public ATMPredmeti getModel() {
		return this.model;
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
