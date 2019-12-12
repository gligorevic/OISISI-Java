package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaStudent;

public class AbstractTableModelStudenti extends AbstractTableModel {

	
	private static final long serialVersionUID = -7349770694737017202L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return (BazaStudent.getInstance().getKolone().size() + 1);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaStudent.getInstance().getStudenti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex < 7) {
			return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
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
		case 5:
		case 6:
			return String.class;
		case 7:
			return JButton.class;
		default:
			return null;
		}
	}
	
	
	
	@Override
	public String getColumnName(int column) {
		if (column >= BazaStudent.getInstance().getKolone().size()) {
			return "Detaljnije";
		}
		return BazaStudent.getInstance().getColumnName(column);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 8;
	}
	
	
}
