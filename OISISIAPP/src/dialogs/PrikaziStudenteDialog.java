package dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.PredmetController;
import model.BazaPredmet;
import model.Predmet;
import view.MainFrame;

public class PrikaziStudenteDialog extends JDialog {
	
	private static final long serialVersionUID = -3450726041014947809L;

	public PrikaziStudenteDialog(int id) {
		super(MainFrame.getInstance(), "Spisak studenata", true);
		Predmet predmet = BazaPredmet.getInstance().getRow(id);
		
		this.setLayout(new GridBagLayout());
		Insets insets = new Insets(10,10,10,10);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		predmet.getStudenti().forEach(s -> {
			model.addElement(s.getBrojIndeksa());
		});

        JList<String> lista = new JList<>();

        JPanel jp = new JPanel(new BorderLayout());
        JButton potvrdi = new JButton("Obrisi");
        potvrdi.setEnabled(false);
        JButton nazad = new JButton("Odustani");
        
        nazad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        
        potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetController.getInstance().ukloniStudenta(lista.getSelectedValue());
				model.removeElement(lista.getSelectedValue());
			}
		});
        lista.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(lista.isSelectionEmpty()) {
					potvrdi.setEnabled(false);
				} else {
					potvrdi.setEnabled(true);
				}
			}
		});
        
        
        lista.setModel(model);  
        
        if(model.size() == 0) {
        	this.add(new JLabel("Nema studenata na predmetu"));
        } else {
        	jp.add(new JScrollPane(lista));
        	addComponent(this, nazad, 1, 4, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
        	addComponent(this, potvrdi, 2, 4, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
        	addComponent(this, jp, 0, 0, 3, 3, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
        }
        
        
        setSize(350,350);
		setLocationRelativeTo(MainFrame.getInstance());
	}
	
	private void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill, Insets insets, Double weightx, Double weighty) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty,
	    anchor, fill, insets, 0, 0);
	    container.add(component, gbc);
	}
}
