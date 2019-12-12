package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaProfesor;

public class AbstractTableModelProfesori extends AbstractTableModel {

	private static final long serialVersionUID = -3261024513031285602L;

	@Override
	public int getRowCount() {
		return BazaProfesor.getInstance().getProfesori().size();
	}

	@Override
	public int getColumnCount() {
		return 6;
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex < 5) {
			return BazaProfesor.getInstance().getValueAt(rowIndex, columnIndex);
		} else {
			return new JButton("" + rowIndex);
		}
	}
	
	@Override
	public String getColumnName(int column) {
		if (column >= 5) {
			return "Prikazi vise";
		}
		return BazaProfesor.getInstance().getColumnName(column);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 5;
	}

}
