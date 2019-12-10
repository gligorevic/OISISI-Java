package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class PredmetTab extends JPanel {
	
	private static PredmetTab instance = null;
	
	public static PredmetTab getInstance() {
		if(instance == null) {
			instance = new PredmetTab();
		}
		return instance;
	}
	
	private PredmetiTable predmetiTable;
	
	private PredmetTab() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(70, 100, 100, 100));
		predmetiTable = new PredmetiTable();
		
		predmetiTable.setPreferredSize( new Dimension( 1000, 480 ) );
		JScrollPane scrollPane = new JScrollPane(predmetiTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public int getSelectedRow() {
		return predmetiTable.getSelectedRow();
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) predmetiTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}
}
