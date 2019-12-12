package controller;

import model.BazaProfesor;

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
}
