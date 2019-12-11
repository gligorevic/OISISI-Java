package controller;

import java.util.Date;

import model.BazaStudent;
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
			Integer godinaStudija, Boolean budzet) {
		
		BazaStudent.getInstance().dodajStudenta( brojIndeksa,ime,prezime,
				datumRodjenja,adresa,brojTelefona,email,datumUpisa,godinaStudija,budzet);
		
		StudentTab.getInstance().azurirajPrikaz();
	}

	public boolean checkIfStudentExist(String index) {
		return BazaStudent.getInstance().checkExistance(index);
	}
}
