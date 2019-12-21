package controller;

import java.util.Date;

import model.BazaPredmet;
import model.BazaProfesor;
import model.Profesor;
import view.ProfesorTab;

public class ProfesorController {
	private static ProfesorController instance = null;

	public static ProfesorController getInstance() {
		if(instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	public boolean checkIfProfesorExist(String licna) {
		try {
			return BazaProfesor.getInstance().checkIfProfesorExistByLicna(Integer.parseInt(licna));
		} catch(Exception e) {
			return false;
		}
	}
	
	public void obrisiProfesora(int selectedRow) {
		Profesor profesor = BazaProfesor.getInstance().getRow(selectedRow);
		System.out.println(profesor.getIme());
		BazaProfesor.getInstance().obrisiProfesora(profesor);
		
		BazaPredmet.getInstance().obrisiProfesoraSaSvihPredmeta(profesor);
		
		ProfesorTab.getInstance().azurirajPrikaz();
	}

	public void dodajProfesora( String ime , String prezime,Date datumRodjenja,
			String adresa, String brojTelefona,String email, String adresaKancelarije,
			Integer brLicne, String titula, String zvanje) {
		
		BazaProfesor.getInstance().dodajProfesora(ime , prezime , datumRodjenja, adresa, brojTelefona,
						email , adresaKancelarije,brLicne,titula,zvanje);
		
		ProfesorTab.getInstance().azurirajPrikaz();
		
		
		
	}

	public void izmeniProfesora(int row, String ime, String prezime, Date datumRodjenjaDate, String adresa, String telefon,
			String email, String adresaKancelarije, int brojLicneKarteInt, String titula, String zvanje) {
		// TODO Auto-generated method stub
		BazaProfesor.getInstance().izmeniProfesora(row , ime , prezime , datumRodjenjaDate,adresa,
				telefon , email , adresaKancelarije ,  brojLicneKarteInt , titula,zvanje);
		
		ProfesorTab.getInstance().azurirajPrikaz();
		
	}
}
