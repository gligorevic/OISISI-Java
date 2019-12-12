package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaPredmet;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	private static final long serialVersionUID = 8454002200965331257L;
	
	@Override
	public int getRowCount() {
		return BazaPredmet.getInstance().getPredmeti().size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex < 6) {
			return BazaPredmet.getInstance().getValueAt(rowIndex, columnIndex);
		} else {
			return new JButton("" + rowIndex);
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return String.class;
		case 5:
			return JButton.class;
		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		if (column >= 5) {
			return "Lista studenata";
		}
		return BazaPredmet.getInstance().getColumnName(column);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 5;
	}
}
