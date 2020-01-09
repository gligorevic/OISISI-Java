package dialogs;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.StudentController;
import view.MainFrame;
import view.PredmetTab;

public class DodajStudentaNaPredmetDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5605791297728587814L;

	public DodajStudentaNaPredmetDijalog() {
		super(MainFrame.getInstance(), "Dodaj studenta na predmet", true);
		
		this.setLayout(new GridBagLayout());
		
		JLabel index = new JLabel("Index: ");
		JTextField indexInput = new JTextField();
		
		JButton potvrdi = new JButton("Potvrdi");
		potvrdi.setEnabled(false);
		JButton odustani = new JButton("Odustani");
		
		Insets insets = new Insets(10, 10, 10, 10);
		
		addComponent(this, index, 0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, indexInput, 1, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, potvrdi, 2, 2, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, odustani, 1, 2, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetController.getInstance().dodajStudenta(PredmetTab.getInstance().getSelectedRow(), indexInput.getText());
				dispose();
			}
		});
		
		indexInput.addKeyListener(new KeyListener() {	
			@Override
			public void keyTyped(KeyEvent e) {
				
			}			
			@Override
			public void keyReleased(KeyEvent e) {
				if(StudentController.getInstance().checkIfStudentExist(indexInput.getText())) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		
		setSize(400,350);
		setLocationRelativeTo(MainFrame.getInstance());
	}
	
	private void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill, Insets insets, Double weightx, Double weighty) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty,
	    anchor, fill, insets, 0, 0);
	    container.add(component, gbc);
	}
}
