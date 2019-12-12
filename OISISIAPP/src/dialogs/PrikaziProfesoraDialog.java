package dialogs;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import model.BazaProfesor;
import model.Profesor;
import view.MainFrame;

public class PrikaziProfesoraDialog extends JDialog {

	
	public PrikaziProfesoraDialog(int row) {
		super(MainFrame.getInstance(), "Profesor", true);
	
		Profesor profesor = BazaProfesor.getInstance().getRow(row);
		
		this.setLayout(new GridBagLayout());
		Insets insets = new Insets(10,10,10,10);
		
		JLabel ime = new JLabel("Ime: " + profesor.getIme());
		JLabel prezime = new JLabel("Prezime: " + profesor.getPrezime());
		JLabel datumRodjenja = new JLabel("Datum rodjenja: " + profesor.getDatumRodjenja());
		JLabel adresa = new JLabel("Adresa: " + profesor.getAdresa());
		JLabel email = new JLabel("Email: " + profesor.getEmail());
		JLabel telefon = new JLabel("Telefon: " + profesor.getTelefon());
		JLabel adresaKanc = new JLabel("Adresa Kancelarije: " + profesor.getAdresaKancelarije());
		JLabel brLicne = new JLabel("Broj licne karte: " + profesor.getBrLicne());
		JLabel titula = new JLabel("Titula: " + profesor.getTitula());
		JLabel zvanje = new JLabel("Zvanje: " + profesor.getZvanje());
		
		addComponent(this, ime, 0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, prezime, 1, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, adresa, 0, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, brLicne, 1, 1, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, email, 0, 2, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, telefon, 1, 2, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, titula, 0, 4, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, zvanje, 1, 4, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, datumRodjenja, 0, 5, 3, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, adresaKanc, 0, 6, 3, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		profesor.getPredmeti().forEach(p -> {
			model.addElement(p.getSifra() + " - " + p.getNaziv());
		});
		JList<String> lista = new JList<>();
		lista.setModel(model);
		
		addComponent(this, new JScrollPane(lista), 0, 7, 3, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		
		
		setSize(400,450);
		setLocationRelativeTo(MainFrame.getInstance());
	}
	
	private void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill, Insets insets, Double weightx, Double weighty) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty,
	    anchor, fill, insets, 0, 0);
	    container.add(component, gbc);
	}
}
