package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudent;

/**
 * Klasa AbstractTableModelStudenti je klasa koja nasledjuje AbstractTableModel
 * i sluzi nam za prikaz tabele studenata.
 * 
 * @author Vaxi i Pufke
 *
 */
public class ATMStudenti extends AbstractTableModel {

	private static final long serialVersionUID = -3033571354019443426L;

	public static String kolonaListaStudenata = "Spisak predmeta";
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO izmeniti ovo false autogenerisano, i uvesti logiku za proveru da li je
		// celiji dozvoljena izmena ili ne
		return false;
	}

	@Override
	public int getRowCount() {
		return BazaStudent.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		// TODO proveriti da li je uredu + 1, mislim da jeste jer treba jos jedna kolona
		// za listu predmeta koje slusa student
		return BazaStudent.getInstance().getColumnCount() + 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex <= BazaStudent.getInstance().getColumnCount()) {
			return BazaStudent.getInstance().getVrednost(rowIndex, columnIndex);
		} else if (columnIndex == BazaStudent.getInstance().getColumnCount() + 1) {
			// TODO treba da vrati listu predmeta za tog studenta
			
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == BazaStudent.getInstance().getKolone().size()) {
			return kolonaListaStudenata;
		}
		return BazaStudent.getInstance().getImeKolone(column);
	}

}
