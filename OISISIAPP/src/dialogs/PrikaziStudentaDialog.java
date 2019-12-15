package dialogs;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import model.BazaStudent;
import model.Student;
import view.MainFrame;

public class PrikaziStudentaDialog extends JDialog{
	
	public PrikaziStudentaDialog(int row) {
		super(MainFrame.getInstance(), "Student",true);
		
		Student student = BazaStudent.getInstance().getRow(row);
		
		this.setLayout(new GridBagLayout());
		Insets insets = new Insets(10,10,10,10);
		
		JLabel ime = new JLabel("Ime: " + student.getIme());
		JLabel prezime = new JLabel("Prezime: " + student.getPrezime());
		
		JLabel adresa = new JLabel("Adresa: " + student.getAdresaStanovanja());
		JLabel email = new JLabel("Email: " + student.getEmailAdresa());
		JLabel telefon = new JLabel("Telefon: " + student.getBrojTelefona());
		JLabel godStud = new JLabel("Godina studija: " + student.getGodinaStudija());
		JLabel brIndeksa = new JLabel("Broj indeksa: " + student.getBrojIndeksa());
		
		DateFormat formatDatuma = new SimpleDateFormat("dd-mm-yyyy");
		
		String datumRodjenjaFormat = formatDatuma.format(student.getDatumRodjenja());
		String datumUpisaFormat = formatDatuma.format(student.getDatumUpisa());
		
		JLabel datumRodjenja = new JLabel("Datum rodjenja: " + datumRodjenjaFormat);
		JLabel datumUpisa = new JLabel("Datum upisa: " + datumUpisaFormat);
		
		String status = new String();
		
		if(student.getBudzet()) {
			status = "Bud�et";
		}else {
			status = "Samofinansiranje";
		}
		
		JLabel statusSt = new JLabel("Status: " +  status);
		
		addComponent(this, ime, 0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, prezime, 0, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, datumRodjenja, 0, 2, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, adresa, 0, 3, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, email, 0, 4, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, telefon, 0, 5, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, datumUpisa, 0, 6, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, godStud, 0, 7, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, brIndeksa, 0, 8, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		addComponent(this, statusSt, 0, 9, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.1, 1.0);
		
		
		setSize(400,450);
		setLocationRelativeTo(MainFrame.getInstance());
		
	}
	
	
	private void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill, Insets insets, Double weightx, Double weighty) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty,
	    anchor, fill, insets, 0, 0);
	    container.add(component, gbc);
	}
}
