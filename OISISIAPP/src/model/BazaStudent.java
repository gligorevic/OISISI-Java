package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BazaStudent {
private static BazaStudent instance = null;
	
	public static BazaStudent getInstance() {
		if(instance == null) {
			instance = new BazaStudent();
		}
		return instance;
	}
	
	private List<Student> studenti;
	private List<String> kolone;
	
	private long generator;
	
	private BazaStudent() {
		generator = 0;
		initStudente();
		this.kolone = new ArrayList<String>();
		this.kolone.add("ID");
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina Studija");
		this.kolone.add("Profesor");
	}
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		this.studenti.add(new Student(generateId(), "RA-99-2016", "Igor", "Gligorevic", new Date(), "Vojvodjanskih brigada 4", "123-456", "igor.gligorevic@hotmail.com", new Date(), 4, false, StatusStudenta.S, 8.0));
	}
	
	private long generateId() {
		return ++generator;
	}
	
	public boolean checkExistance(String index) {
		System.out.println(studenti.size());
		for(int i = 0; i < studenti.size(); i++) {
			System.out.println(studenti.get(i).getBrojIndeksa().toUpperCase());
			System.out.println(index.toUpperCase());
			if(studenti.get(i).getBrojIndeksa().toUpperCase().equals(index.toUpperCase())) {
				return true;
			}	
		}
		
		return false;
	}
	
	public Student getStudentByIndex(String index) {
		for(int i = 0; i < studenti.size(); i++) {
			if(studenti.get(i).getBrojIndeksa().toUpperCase().equals(index.toUpperCase())) {
				return studenti.get(i);
			}	
		}
		return null;
	}
}
