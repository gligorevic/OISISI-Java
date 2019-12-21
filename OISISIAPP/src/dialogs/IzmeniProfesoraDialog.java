package dialogs;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

import controller.ProfesorController;
import controller.StudentController;
import model.BazaProfesor;
import model.BazaStudent;
import model.Profesor;
import model.Student;
import view.MainFrame;

public class IzmeniProfesoraDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3047424752372152212L;
		
	public IzmeniProfesoraDialog(int row) {
		
		super(MainFrame.getInstance(), "Izmeni Profesora" , true);
		this.setLayout(new GridBagLayout());
		Profesor profesor= BazaProfesor.getInstance().getRow(row);
		setSize(400,500);
		
		JLabel ime = new JLabel("Ime: ");
		JLabel prezime = new JLabel("Prezime: ");
		JLabel datumRodjenja= new JLabel("Datum Rodjenja: ");
		JLabel adresa= new JLabel("Adresa stanovanja: ");
		JLabel telefon= new JLabel("Kontakt telefon: ");
		JLabel email= new JLabel("Email adresa: ");
		JLabel adresaKancelarije= new JLabel("Adresa kancelarije: ");
		JLabel brLicne= new JLabel("Broj licne karte:");
		JLabel titula = new JLabel("Titula: ");
		JLabel zvanje = new JLabel("Zvanje: ");
		
		Insets insets = new Insets(10,0,0,0);
		
		addComponent(this, ime ,0,0,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, prezime ,0,1,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, datumRodjenja ,0,2,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, adresa ,0,3,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, telefon ,0,4,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, email ,0,5,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, adresaKancelarije ,0,6,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, brLicne ,0,7,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, titula ,0,8,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, zvanje ,0,9,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		
		JTextField imeInput = new JTextField(profesor.getIme()); //0
		JTextField prezimeInput = new JTextField(profesor.getPrezime());//1
		JTextField adresaInput = new JTextField(profesor.getAdresa()); //3
		JTextField telefonInput = new JTextField(profesor.getTelefon()); //4
		JTextField emailInput = new JTextField(profesor.getEmail());//5
		JTextField adresaKancelarijeInput = new JTextField(profesor.getAdresaKancelarije()); //0
		JTextField brLicneKarteInput = new JTextField(profesor.getBrLicne().toString());//7
		JTextField titulaInput = new JTextField(profesor.getTitula());//1
		JTextField zvanjeInput = new JTextField(profesor.getZvanje()); //3
		
		DateFormat formatDatuma = new SimpleDateFormat("dd-mm-yyyy");
		JFormattedTextField datumRodjenjaInput = new JFormattedTextField(getMaskFormatterDate("##-##-####"));
		
		datumRodjenjaInput.setValue(profesor.getDatumRodjenja());
		
		addComponent(this, imeInput, 1, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, prezimeInput, 1, 1, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, datumRodjenjaInput, 1, 2, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, adresaInput, 1, 3, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, telefonInput, 1, 4, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, emailInput, 1, 5, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, adresaKancelarijeInput, 1, 6, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, brLicneKarteInput, 1, 7, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, titulaInput, 1, 8, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, zvanjeInput, 1, 9, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		
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
				SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
				
				Date datumRodjenjaDate = new Date();
				try {
					datumRodjenjaDate = formatter.parse(datumRodjenjaInput.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				int  brojLicneKarteInt = Integer.parseInt(brLicneKarteInput.getText());
				if(imeInput.getText().isEmpty() || prezimeInput.getText().isEmpty() ||
						adresaInput.getText().isEmpty() || telefonInput.getText().isEmpty() || emailInput.getText().isEmpty() || adresaKancelarijeInput.getText().isEmpty() ||
						((Integer)brojLicneKarteInt == null)  || titulaInput.getText().isEmpty() || zvanjeInput.getText().isEmpty() || (datumRodjenjaDate == null)) {

					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Popunite sva polja!");
				}else {
				
				ProfesorController.getInstance().izmeniProfesora(row ,imeInput.getText(), prezimeInput.getText(),datumRodjenjaDate,
						adresaInput.getText(),telefonInput.getText(),emailInput.getText(), adresaKancelarijeInput.getText(),
						brojLicneKarteInt,titulaInput.getText(), zvanjeInput.getText());
				
				dispose();
				}
			}
		});
		
		
		jp.add(nazad);
		jp.add(potvrdi);
		
		addComponent(this, jp, 2, 10, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 0.0, 1.0);
		
		
		
		
		setLocationRelativeTo(MainFrame.getInstance());
		
	}
	
	private void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill, Insets insets, Double weightx, Double weighty) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty,
	    anchor, fill, insets, 0, 0);
	    container.add(component, gbc);
	}
	
	private MaskFormatter getMaskFormatterDate(String format) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(format);
			mask.setPlaceholderCharacter('0');
		}catch(ParseException ex){
			ex.printStackTrace();
		}
		return mask;
	}

}