package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

public class StudentTab extends JPanel {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 5298032789657176485L;
	
	private static StudentTab instance = null;
	
	public static StudentTab getInstance() {
		if(instance == null) {
			instance = new StudentTab();
		}
		return instance;
	}
	
	private StudentiTable studentiTable;
	private TableRowSorter<AbstractTableModelStudenti> sorter;
	
	public StudentTab() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(70, 100, 100, 100));
		studentiTable = new StudentiTable();
		
		studentiTable.setPreferredSize( new Dimension( 1000, 480 ) );
		JScrollPane scrollPane = new JScrollPane(studentiTable);
		add(scrollPane, BorderLayout.CENTER);
		initSorter();
	}
	
	private void initSorter() {
		// TODO Auto-generated method stub
		this.sorter = new TableRowSorter<>((AbstractTableModelStudenti)studentiTable.getModel());
		this.sorter.setSortable(7,false);
		studentiTable.setRowSorter(this.sorter);
	}

	public int getSelectedRow() {
		return studentiTable.getSelectedRow();
	}
	
	public void azurirajPrikaz() {
		
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) studentiTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}

	public void setFilter(String searchString) {
		// TODO Auto-generated method stub
		String[] parts = searchString.split(";");
		Map<String,String> map = new HashMap<>();
		
		map.put("ime", "");
		map.put("prezime", "");
		map.put("broj indeksa", "");
	
		for(int i = 0; i < parts.length; i++) {
			String[] splited = parts[i].split(":");
			if(splited.length > 1) {
			map.put(splited[0].toLowerCase(), splited[1]);
			}
		}
		
		List<RowFilter<Object,Object>> rfs = new ArrayList<RowFilter<Object,Object>>();
		
		rfs.add(RowFilter.regexFilter(".*" + map.get("broj indeksa") + ".*", 0));
		rfs.add(RowFilter.regexFilter(".*" + map.get("ime") + ".*", 1));
		rfs.add(RowFilter.regexFilter(".*" + map.get("prezime") + ".*", 2));
		this.sorter.setRowFilter(RowFilter.andFilter(rfs));
		
	}
}
