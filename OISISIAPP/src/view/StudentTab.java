package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class StudentTab extends JPanel {
	
private static StudentTab instance = null;
	
	public static StudentTab getInstance() {
		if(instance == null) {
			instance = new StudentTab();
		}
		return instance;
	}
	
	private StudentiTable studentiTable;
	
	public StudentTab() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(70, 100, 100, 100));
		studentiTable = new StudentiTable();
		
		studentiTable.setPreferredSize( new Dimension( 1000, 480 ) );
		JScrollPane scrollPane = new JScrollPane(studentiTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public int getSelectedRow() {
		return studentiTable.getSelectedRow();
	}
	
	public void azurirajPrikaz() {
		
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) studentiTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}
}
