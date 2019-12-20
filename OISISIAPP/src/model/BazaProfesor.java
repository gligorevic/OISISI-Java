package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
		
		Iterator<Profesor> iter = this.profesori.listIterator();
		
		while(iter.hasNext()) {
			Profesor p = iter.next();
			if(p == profesor) {
				iter.remove();
			}
		}
	}
	
	public void obrisiPredmetProfesora(Profesor profesor, Predmet predmet) {
		profesor.getPredmeti().remove(predmet);
	}

	public void dodajProfesora(String ime, String prezime, Date datumRodjenja, String adresa, String brojTelefona,
			String email, String adresaKancelarije, Integer brLicne, String titula, String zvanje) {
		// TODO Auto-generated method stub
		this.profesori.add(new Profesor(generateId(), ime , prezime , datumRodjenja, adresa, brojTelefona,
				email , adresaKancelarije,brLicne,titula,zvanje));
	}

	public void izmeniProfesora(int row, String ime, String prezime, Date datumRodjenjaDate, String adresa,
			String telefon, String email, String adresaKancelarije, int brojLicneKarteInt, String titula,
			String zvanje) {
		// TODO Auto-generated method stub
		Profesor profesor = BazaProfesor.getInstance().getRow(row);
		
		profesor.setIme(ime);
		profesor.setPrezime(prezime);
		profesor.setDatumRodjenja(datumRodjenjaDate);
		profesor.setAdresa(adresa);
		profesor.setTelefon(telefon);
		profesor.setEmail(email);
		profesor.setAdresaKancelarije(adresaKancelarije);
		profesor.setBrLicne(brojLicneKarteInt);
		profesor.setTitula(titula);
		profesor.setZvanje(zvanje);
		
		
		
		
		
	}

	public void deletePredmetFromEveryProfesor(Predmet predmet) {
		// TODO Auto-generated method stub
		
		Iterator<Profesor> iter = this.profesori.listIterator();
		
		while(iter.hasNext()) {
			Profesor p = iter.next();
			
			Iterator<Predmet> iterPredmet = p.getPredmeti().listIterator();
			
			while(iterPredmet.hasNext()) {
				Predmet pr = iterPredmet.next();
				if(pr == predmet) {
					iterPredmet.remove();
				}
			}
		}
	}

	public void ukloniPredmetProfesoru(Profesor prof, Predmet predmet) {
		// TODO Auto-generated method stub
		Iterator<Predmet> iter = prof.getPredmeti().listIterator();
		
		while(iter.hasNext()) {
			Predmet p = iter.next();
			
			if(p == predmet) {
				iter.remove();
			}
		}
	}
}
