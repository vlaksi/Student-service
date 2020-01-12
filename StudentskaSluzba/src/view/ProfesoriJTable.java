package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 * Klasa koja sluzi za reprezentativni nacin prikaza tabele profesora i
 * sortiranje profesora.
 * 
 * @author Vaxi i Pufke
 *
 */
public class ProfesoriJTable extends JTable {

	private static final long serialVersionUID = -3442801886235942895L;

	private ATMProfesori model;
	private static TableRowSorter<ATMProfesori> sortiranje;

	public ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false); // kako bi iskljucili mogucnost pomeranja kolona levo-desno
		this.setModel(new ATMProfesori());
		this.model = new ATMProfesori();
		this.setModel(model);

		sortiranje = new TableRowSorter<ATMProfesori>(model);

		for (int i = 3; i <= 10; i++) {
			sortiranje.setSortable(i, false); // u ovoj for petlji smo iskljucili mogucnost sortiranja tabele profesora po specifikaciji projekta
		}
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
		RowFilter<? super ATMProfesori, ? super Integer> rf = null;

		try {
			rf = RowFilter.regexFilter("^" + trazeno, brojKolone);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}

		getSortiranje().setRowFilter(rf);
	}
	
	
	
	public ATMProfesori getModel() {
		return model;
	}

	public static TableRowSorter<ATMProfesori> getSortiranje() {
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
