package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BazaProfesor {
	
	private static BazaProfesor instance = null;
	
	public static BazaProfesor getInstance() {
		if(instance == null) {
			instance = new BazaProfesor();
		}
		return instance;
	}
	
	private List<Profesor> profesori;
	private List<String> kolone;
	
	private long generator;
	
	private BazaProfesor() {
		generator = 0;
		initProfesore();
		this.kolone = new ArrayList<String>();
		this.kolone.add("ID");
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina Studija");
		this.kolone.add("Profesor");
	}
	
	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		this.profesori.add(new Profesor(1l, "Ivan", "Lukovic", new Date(), "Micurinova 3", "555-333", "luki@gmail.com", "kucna", 123, "profesor", "profa"));
	}

	public Profesor findByLicna(String licna) {
		try {
			for(Profesor p : profesori) {
				if(p.getBrLicne().equals(Integer.parseInt(licna))) {
					return p;
				}
			}
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public boolean checkIfProfesorExistByLicna(Integer licna) {
		for(Profesor p : profesori) {
			if(p.getBrLicne().equals(licna)) {
				return true;
			}
		}
		return false;
	}
}
