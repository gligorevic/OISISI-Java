package dialogs;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import controller.PredmetController;
import model.BazaPredmet;
import model.Predmet;
import view.MainFrame;

public class DodajPredmetDialog extends JDialog {
	public DodajPredmetDialog() {
		super(MainFrame.getInstance(), "Dodaj predmet", true);
				
		this.setLayout(new GridBagLayout());
		
		Integer value1 = new Integer(1);
		Integer value2 = new Integer(1);
		Integer mins = new Integer(1);
		Integer maxs = new Integer(10);
		Integer min = new Integer(1);
		Integer max = new Integer(5);
		Integer step = new Integer(1);
		SpinnerModel model1 = new SpinnerNumberModel(value1, mins, maxs, step);
		SpinnerModel model2 = new SpinnerNumberModel(value2, min, max, step);
		
		JLabel sifra = new JLabel("Šifra: ");
		JLabel naziv = new JLabel("Naziv: ");
		JLabel semestar = new JLabel("Semestar: ");
		JLabel godinaStud = new JLabel("Godina studija: ");
		Insets insets = new Insets(10, 0, 0, 0);
		
		addComponent(this, sifra, 0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, naziv, 0, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, semestar, 0, 2, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, godinaStud, 0, 3, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		
		JTextField sifraInput = new JTextField();
		JTextField nazivInput = new JTextField();
		JSpinner semestarInput = new JSpinner(model1);
		JSpinner godinaStudInput = new JSpinner(model2);
		
		addComponent(this, sifraInput, 1, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, nazivInput, 1, 1, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, semestarInput, 1, 2, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, godinaStudInput, 1, 3, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);	

		JPanel jp = new JPanel();
		
		JButton nazad = new JButton("Nazad");
		JButton potvrdi = new JButton("Potvrdi");
		
		nazad.setPreferredSize(new Dimension(75, 30));
		potvrdi.setPreferredSize(new Dimension(75, 30));
		
		nazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PredmetController.getInstance().dodajPredmet(sifraInput.getText(), nazivInput.getText(), (Integer)semestarInput.getValue(), (Integer)godinaStudInput.getValue());
				dispose();
			}
		});
		
		jp.add(nazad);
		jp.add(potvrdi);
		
		addComponent(this, jp, 2, 4, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.0, 1.0);
		
		setSize(400,350);
		setLocationRelativeTo(MainFrame.getInstance());
	}

	private void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill, Insets insets, Double weightx, Double weighty) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty,
	    anchor, fill, insets, 0, 0);
	    container.add(component, gbc);
	}
}
