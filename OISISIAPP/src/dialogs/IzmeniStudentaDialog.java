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
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import controller.StudentController;
import model.BazaStudent;
import model.Student;
import view.MainFrame;

public class IzmeniStudentaDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1114210953535082274L;
	
	public IzmeniStudentaDialog(int row) {
		
		super(MainFrame.getInstance(), "Izmeni studenta" , true);
		
		Student student = BazaStudent.getInstance().getRow(row);
		
		this.setLayout(new GridBagLayout());
		
		setSize(400,500);
		
		Integer godinaStudijaOld = new Integer(student.getGodinaStudija());
		SpinnerModel godinaStudijaModel = new SpinnerNumberModel(godinaStudijaOld ,(Integer) 1 
																,(Integer) 5 ,(Integer) 1);
		
		JLabel ime = new JLabel("Ime: ");
		JLabel prezime = new JLabel("Prezime: ");
		JLabel datumRodjenja= new JLabel("Datum Rodjenja:");
		JLabel adresa= new JLabel("Adresa stanovanja:");
		JLabel telefon= new JLabel("Kontakt telefon");
		JLabel email= new JLabel("Email adresa");
		JLabel brIndexa= new JLabel("Broj indexa");
		JLabel datumUpisa= new JLabel("Datum Upisa");
		JLabel godinaStudija = new JLabel("Godina studija");
		JLabel status = new JLabel("Status:");

		Insets insets = new Insets(10,0,0,0);
		
		
		addComponent(this, ime ,0,0,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, prezime ,0,1,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, datumRodjenja ,0,2,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, adresa ,0,3,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, telefon ,0,4,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, email ,0,5,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, brIndexa ,0,6,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, datumUpisa ,0,7,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, godinaStudija ,0,8,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		addComponent(this, status ,0,9,1,1,GridBagConstraints.NORTH , GridBagConstraints.HORIZONTAL, insets, 0.1,1.0);
		
		JTextField imeInput = new JTextField(student.getIme()); //0
		JTextField prezimeInput = new JTextField(student.getPrezime());//1
		JTextField adresaInput = new JTextField(student.getAdresaStanovanja()); //3
		JTextField telefonInput = new JTextField(student.getBrojTelefona()); //4
		JTextField emailInput = new JTextField(student.getEmailAdresa());//5
		JTextField indeksInput = new JTextField(student.getBrojIndeksa());//6
		JSpinner godinaStudijaInput = new JSpinner(godinaStudijaModel);//8
		
		DateFormat formatDatuma = new SimpleDateFormat("dd-mm-yyyy");
		JFormattedTextField datumRodjenjaInput = new JFormattedTextField(formatDatuma);
		JFormattedTextField datumUpisaInput = new JFormattedTextField(formatDatuma );
		
	
		datumRodjenjaInput.setValue(student.getDatumRodjenja());
		datumUpisaInput.setValue(student.getDatumUpisa());
		
		JCheckBox statusStudentaInput = new JCheckBox("Budzet" , student.getBudzet());
		
		addComponent(this, imeInput, 1, 0, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, prezimeInput, 1, 1, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, datumRodjenjaInput, 1, 2, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, adresaInput, 1, 3, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, telefonInput, 1, 4, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, emailInput, 1, 5, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, indeksInput, 1, 6, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, datumUpisaInput, 1, 7, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, godinaStudijaInput, 1, 8, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		addComponent(this, statusStudentaInput, 1, 9, 2, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, insets, 100.0, 1.0);
		
		
		
		
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
				Date datumUpisaDate= new Date();
				try {
					datumUpisaDate = formatter.parse(datumUpisaInput.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				StudentController.getInstance().izmeniStudenta(row,indeksInput.getText(), 
						imeInput.getText(), prezimeInput.getText(),datumRodjenjaDate,adresaInput.getText(),telefonInput.getText(),
						emailInput.getText(),datumUpisaDate,(Integer)godinaStudijaInput.getValue(),
						statusStudentaInput.isSelected());
				
				dispose();
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

}
