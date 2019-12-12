package controller;

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
		ProfesorTab.getInstance().azurirajPrikaz();
	}
}
