package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

/**
 * Klasa AbstractTableModelPredmeti je klasa koja nam sluzi za implementaciju
 * prikaza tabele predmeta
 * 
 * @author Vaxi
 *
 */
public class ATMPredmeti extends AbstractTableModel {

	private static final long serialVersionUID = -1833610915091754649L;

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getBrojaKolona() + 1; // +1 zbog dodatne kolone za listu studenata na tom
																// predmetu
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex <= BazaPredmeta.getInstance().getBrojaKolona()) {
			return BazaPredmeta.getInstance().getVrednost(rowIndex, columnIndex);
		} else if (columnIndex == BazaPredmeta.getInstance().getBrojaKolona() + 1) {

		}
		return null;
	}

}
