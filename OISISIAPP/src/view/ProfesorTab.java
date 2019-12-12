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
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

public class ProfesorTab extends JPanel {

	private static final long serialVersionUID = 4734568815745319308L;

	private static ProfesorTab instance = null;
	
	public static ProfesorTab getInstance() {
		if(instance == null) {
			instance = new ProfesorTab();
		}
		return instance;
	}
	
	private ProfesoriTable profesoriTable;
	private TableRowSorter<AbstractTableModelProfesori> sorter;
	
	public ProfesorTab() {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(70, 100, 100, 100));
		profesoriTable = new ProfesoriTable();

		profesoriTable.setPreferredSize( new Dimension( 1000, 480 ) );
		JScrollPane scrollPane = new JScrollPane(profesoriTable);
		add(scrollPane, BorderLayout.CENTER);
		initSorter();
	}
	
	public int getSelectedRow() {
		return profesoriTable.getSelectedRow();
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) profesoriTable.getModel();	
		model.fireTableDataChanged();
		validate();
	}
	
	private void initSorter() {
		this.sorter = new TableRowSorter<>((AbstractTableModelProfesori)profesoriTable.getModel());
		this.sorter.setSortable(4, false);
		profesoriTable.setRowSorter(this.sorter);
	}
	
	public void setFilter(String searchString) {
		String[] parts = searchString.split(";");
		Map<String,String> map = new HashMap<>();
		
		map.put("ime", "");
		map.put("prezime", "");
		map.put("email", "");
		map.put("broj licne", "");
		map.put("telefon", "");
		
		for(int i = 0; i < parts.length; i++) {
			String[] splited = parts[i].split(":");
			if(splited.length > 1) {
			map.put(splited[0].toLowerCase(), splited[1]);
			}
		}
		
		List<RowFilter<Object,Object>> rfs = new ArrayList<RowFilter<Object,Object>>();
		
		rfs.add(RowFilter.regexFilter(".*" + map.get("ime") + ".*", 0));
		rfs.add(RowFilter.regexFilter(".*" + map.get("prezime") + ".*", 0));
		rfs.add(RowFilter.regexFilter(".*" + map.get("email") + ".*", 1));
		rfs.add(RowFilter.regexFilter(".*" + map.get("broj licne") + ".*", 2));
		rfs.add(RowFilter.regexFilter(".*" + map.get("telefon") + ".*", 3));
		
		this.sorter.setRowFilter(RowFilter.andFilter(rfs));
	}
}
