package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.Border;

import listeners.DodajPredmetListener;
import listeners.DodajProfesoraNaPredmetListener;
import listeners.DodajStudentaListener;
import listeners.DodajStudentaNaPredmetListener;
import listeners.IzmeniPredmetListener;
import listeners.IzmeniStudentaListener;
import listeners.ObrisiPredmetListener;
import listeners.ObrisiStudentaListener;

public class Toolbar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 598066133790021983L;

	public Toolbar(Integer currentTab) {	
		Border emptyBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		
		JButton btnNew = new JButton();
		
		btnNew.setToolTipText("Dodaj");
		if(currentTab == 2) {
			btnNew.setIcon(new ImageIcon("images/add_predmet.png"));
		} else {
			btnNew.setIcon(new ImageIcon("images/add.png"));
		}
		btnNew.setBorder(emptyBorder);
		add(btnNew);

		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmeni");
		btnEdit.setIcon(new ImageIcon("images/edit.png"));
		btnEdit.setBorder(emptyBorder);
		add(btnEdit);

		addSeparator();

		JToggleButton btnDelete = new JToggleButton();
		btnDelete.setToolTipText("Obrisi");
		btnDelete.setIcon(new ImageIcon("images/delete.png"));
		btnDelete.setBorder(emptyBorder);
		add(btnDelete);
		
		if(currentTab == 2) {
			addSeparator();
			
			JButton btnDodaj = new JButton();
			btnDodaj.setToolTipText("Dodaj studenta");
			btnDodaj.setIcon(new ImageIcon("images/add.png"));
			btnDodaj.setBorder(emptyBorder);
			add(btnDodaj);
			btnDodaj.addActionListener(new DodajStudentaNaPredmetListener());
			
			addSeparator();
			
			JButton btnDodajProfu = new JButton();
			btnDodajProfu.setToolTipText("Dodaj profesora");
			btnDodajProfu.setIcon(new ImageIcon("images/add.png"));
			btnDodajProfu.setBorder(emptyBorder);
			btnDodajProfu.addActionListener(new DodajProfesoraNaPredmetListener());
			
			add(btnDodajProfu);
		}
		
		add(Box.createHorizontalGlue());
		
		JTextField searchInput = new JTextField(16);
		searchInput.setMaximumSize(searchInput.getPreferredSize());
		add(searchInput);
		
		JButton search = new JButton();
		search.setToolTipText("Pretrazi");
		search.setIcon(new ImageIcon("images/search.png"));
		search.setBorder(emptyBorder);
		add(search);
		
		setFloatable(false);
	
		
		if(currentTab == 2) {
			btnNew.addActionListener(new DodajPredmetListener());
			btnEdit.addActionListener(new IzmeniPredmetListener());
			btnDelete.addActionListener(new ObrisiPredmetListener());
			search.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					PredmetTab.getInstance().setFilter(searchInput.getText());
				}
			});
		}else if(currentTab == 0) {
			btnNew.addActionListener(new DodajStudentaListener());
			btnEdit.addActionListener(new IzmeniStudentaListener());
			btnDelete.addActionListener(new ObrisiStudentaListener());
		}
	}
}
