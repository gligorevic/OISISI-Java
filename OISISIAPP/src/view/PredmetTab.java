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

public class PredmetTab extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1523380528366386958L;
	private static PredmetTab instance = null;
	
	public static PredmetTab getInstance() {
		if(instance == null) {
			instance = new PredmetTab();
		}
		return instance;
	}
	
	private PredmetiTable predmetiTable;
	private TableRowSorter<AbstractTableModelPredmeti> sorter;
	
	private PredmetTab() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(70, 100, 100, 100));
		predmetiTable = new PredmetiTable();
		
		predmetiTable.setPreferredSize( new Dimension( 1000, 480 ) );
		JScrollPane scrollPane = new JScrollPane(predmetiTable);
		add(scrollPane, BorderLayout.CENTER);
		initSorter();
	}
	
	public int getSelectedRow() {
		return predmetiTable.getSelectedRow();
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) predmetiTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}
	
	private void initSorter() {
		this.sorter = new TableRowSorter<>((AbstractTableModelPredmeti)predmetiTable.getModel());
		this.sorter.setSortable(5, false);
		predmetiTable.setRowSorter(this.sorter);
	}
	
	public void setFilter(String searchString) {
		String[] parts = searchString.split(";");
		Map<String,String> map = new HashMap<>();
		
		map.put("sifra", "");
		map.put("naziv", "");
		map.put("semestar", "");
		map.put("godina", "");
		map.put("profesor", "");
		
		for(int i = 0; i < parts.length; i++) {
			String[] splited = parts[i].split(":");
			if(splited.length > 1) {
			map.put(splited[0].toLowerCase(), splited[1]);
			}
		}
		
		List<RowFilter<Object,Object>> rfs = new ArrayList<RowFilter<Object,Object>>();
		
		rfs.add(RowFilter.regexFilter(".*" + map.get("sifra") + ".*", 0));
		rfs.add(RowFilter.regexFilter(".*" + map.get("naziv") + ".*", 1));
		rfs.add(RowFilter.regexFilter(".*" + map.get("semestar") + ".*", 2));
		rfs.add(RowFilter.regexFilter(".*" + map.get("godina") + ".*", 3));
		rfs.add(RowFilter.regexFilter(".*" + map.get("profesor") + ".*", 4));
		
		this.sorter.setRowFilter(RowFilter.andFilter(rfs));
	}
	
	
}
