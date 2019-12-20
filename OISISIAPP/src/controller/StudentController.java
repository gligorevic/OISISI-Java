package controller;

import java.util.Date;

import model.BazaPredmet;
import model.BazaStudent;
import model.Student;
import view.StudentTab;

public class StudentController {
	private static StudentController instance = null;

	public static StudentController getInstance() {
		if(instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public void dodajStudenta(String brojIndeksa, String ime , String prezime,Date datumRodjenja,
			String adresa, String brojTelefona,String email, Date datumUpisa,
			Integer godinaStudija, Boolean budzet , Double prosjecnaOcjena) {
		
		BazaStudent.getInstance().dodajStudenta( brojIndeksa,ime,prezime,
				datumRodjenja,adresa,brojTelefona,email,datumUpisa,godinaStudija,budzet , prosjecnaOcjena);
		
		StudentTab.getInstance().azurirajPrikaz();
	}

	public boolean checkIfStudentExist(String index) {
		return BazaStudent.getInstance().checkExistance(index);
	}

	public void izmeniStudenta(int row,String brojIndeksa, String ime , String prezime,Date datumRodjenja,
			String adresa, String brojTelefona,String email, Date datumUpisa,
			Integer godinaStudija, Boolean budzet , Double prosjecnaOcjena) {
		// TODO Auto-generated method stub
		
		
		BazaStudent.getInstance().izmeniStudenta(row ,brojIndeksa,  ime ,  prezime, datumRodjenja,
				 adresa,  brojTelefona, email,  datumUpisa,
				 godinaStudija,  budzet , prosjecnaOcjena);
		
		StudentTab.getInstance().azurirajPrikaz();
		
	}


	public void obrisiStudenta(int selectedRow) {
		Student student = BazaStudent.getInstance().getRow(selectedRow);
		BazaStudent.getInstance().obrisiStudenta(student);
		
		BazaPredmet.getInstance().obrisiStudentaSaSvihPredmeta(student);
		
		StudentTab.getInstance().azurirajPrikaz();
		
	}
}
