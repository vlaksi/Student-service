package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 * Klasa koja reprezentuje tabelu studenata.
 * 
 * @author Vaxi
 *
 */
public class StudentiJTable extends JTable {

	private static final long serialVersionUID = 3870532450326465610L;

	private ATMStudenti model;
	private static TableRowSorter<ATMStudenti> sortiranje;
	
	public StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new ATMStudenti());
		this.getTableHeader().setReorderingAllowed(false); // kako bi iskljucili mogucnost pomeranja kolona levo-desno
		this.setModel(new ATMStudenti());
		this.model = new ATMStudenti();
		this.setModel(model);
		
		sortiranje = new TableRowSorter<ATMStudenti>(model);
		sortiranje.setSortable(11, false); // iskljucujem poslednju kolonu za mogucnost sortiranja
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
		//TODO mozda ovo prebaciti u kontroler kasnije
		RowFilter<? super ATMStudenti, ? super Integer> rf = null;

		try {
			rf = RowFilter.regexFilter("^" + trazeno, brojKolone);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}

		getSortiranje().setRowFilter(rf);
	}

	public ATMStudenti getModel() {
		return model;
	}

	public static TableRowSorter<ATMStudenti> getSortiranje() {
		return sortiranje;
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
