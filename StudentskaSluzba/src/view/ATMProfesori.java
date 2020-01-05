package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesor;

/**
 * Klasa AbstractTableModelProfesori je klasa koja nam sluzi za prikaz tabele
 * profesora.
 * 
 * @author Vaxi i Pufke
 *
 */
public class ATMProfesori extends AbstractTableModel {

	private static final long serialVersionUID = -4422057131202788042L;

	public static int selectedRowIndex = 0; // polje koje nam sluzi da u svakom trenutku znamo koji je selektovan red
	public static int selectedCoulumnIndex = 0;

	public static String spisakPredmeta = "Spisak predmeta";

	@Override
	public int getRowCount() {
		return BazaProfesor.getInstance().getProfesori().size();
	}

	@Override
	public int getColumnCount() {
		return BazaProfesor.getInstance().getBrojKolona() + 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		setSelectedRowIndex(rowIndex);
		setSelectedCoulumnIndex(columnIndex);
		if (columnIndex <= BazaProfesor.getInstance().getBrojKolona()) {
			return BazaProfesor.getInstance().getVrednost(rowIndex, columnIndex);
		} else if (columnIndex == BazaProfesor.getInstance().getBrojKolona() + 1) {
			// TODO implementirati da vrati listu predmeta za tog profesora
			return BazaProfesor.getInstance().getVrednost(rowIndex, columnIndex);
		}
		return null;
	}

	public static int getSelectedCoulumnIndex() {
		return selectedCoulumnIndex;
	}

	public static void setSelectedCoulumnIndex(int selectedCoulumnIndex) {
		ATMProfesori.selectedCoulumnIndex = selectedCoulumnIndex;
	}

	public static int getSelectedRowIndex() {
		return selectedRowIndex;
	}

	public static void setSelectedRowIndex(int selectedRowIndex) {
		ATMProfesori.selectedRowIndex = selectedRowIndex;
	}

	@Override
	public String getColumnName(int column) {
		if (column == BazaProfesor.getInstance().getKolone().size()) {
			return spisakPredmeta;
		}
		return BazaProfesor.getInstance().getImeKolone(column);
	}

}
