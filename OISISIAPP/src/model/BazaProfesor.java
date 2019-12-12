package model;

import java.text.SimpleDateFormat;
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
		this.kolone.add("Ime i prezime");
		this.kolone.add("Email");
		this.kolone.add("Broj licne karte");
		this.kolone.add("Telefon");
		this.kolone.add("Datum Rodjenja");
	}
	
	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		this.profesori.add(new Profesor(generateId(), "Ivan", "Lukovic", new Date(), "Micurinova 3", "555-333", "luki@gmail.com", "kucna", 123, "profesor", "profa"));
		this.profesori.add(new Profesor(generateId(), "Mile", "Milic", new Date(), "Njegoseva 23", "222-221", "miki@gmail.com", "adresa 13", 321, "profesor", "profa"));
		this.profesori.add(new Profesor(generateId(), "Radivoj", "Lukovic", new Date(), "Postanska 32", "232-221", "lux@gmail.com", "adresa 22", 323, "profesor", "profa"));	
	}

	public Profesor getRow(int index) {
		return this.profesori.get(index);
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch(column) {
		case 0:
			return profesor.getIme() + " " + profesor.getPrezime();
		case 1:
			return profesor.getEmail();
		case 2:
			return Integer.toString(profesor.getBrLicne());
		case 3:
			return profesor.getTelefon();
		case 4:
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		    String strDate = formatter.format(profesor.getDatumRodjenja());  
			return strDate;
		default: 
			return null; 
		}
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

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	private long generateId() {
		return ++generator;
	}
	
	public void dodajPredmetProfesoru(Predmet predmet, String licna) {
		for(int i = 0; i < profesori.size(); i++) {
			if(profesori.get(i).getBrLicne() == Integer.parseInt(licna)) {
				profesori.get(i).getPredmeti().add(predmet);
				System.out.println("dodao");
			}
		}
	}
	
	public void obrisiProfesora(Profesor profesor) {
		profesori.remove(profesor);
		System.out.println(profesori.size());
	}
	
	public void obrisiPredmetProfesora(Profesor profesor, Predmet predmet) {
		profesor.getPredmeti().remove(predmet);
	}
}
