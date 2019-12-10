package dialogs;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import model.BazaPredmet;
import model.Predmet;
import view.MainFrame;

public class DodajStudentaNaPredmetDijalog extends JDialog {

	public DodajStudentaNaPredmetDijalog(int row) {
		super(MainFrame.getInstance(), "Dodaj studenta na predmet", true);
		
		Predmet predmet = BazaPredmet.getInstance().getRow(row);
		
		this.setLayout(new GridBagLayout());
		
		JLabel index = new JLabel("Index: ");
		JTextField indexInput = new JTextField();
		
		JButton potvrdi = new JButton("Potvrdi");
		potvrdi.setEnabled(false);
		
		Insets insets = new Insets(10, 10, 10, 10);
		
		addComponent(this, index, 0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, indexInput, 1, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, potvrdi, 2, 2, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		
		
		indexInput.addKeyListener(new KeyListener() {	
			@Override
			public void keyTyped(KeyEvent e) {
			}			
			@Override
			public void keyReleased(KeyEvent e) {	
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(StudentController.getInstance().checkIfStudentExist(indexInput.getText())) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
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
