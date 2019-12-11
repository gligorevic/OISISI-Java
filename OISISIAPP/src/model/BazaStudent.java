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
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina Studija");
		this.kolone.add("Profesor");
	}
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		this.studenti.add(new Student(generateId(), "RA-99-2016", "Igor", "Gligorevic", new Date(), "Vojvodjanskih brigada 4", "123-456", "igor.gligorevic@hotmail.com", new Date(), 4, false, StatusStudenta.S, 8.0));
		this.studenti.add(new Student(generateId(), "RA-98-2018", "Pera", "Peric", new Date(), "Novosadskog sajma 4", "654-321", "peraperic@hotmail.com", new Date(), 2, true, StatusStudenta.B, 9.0));
		this.studenti.add(new Student(generateId(), "RA-97-2017", "Miki", "Veliki", new Date(), "Masarikova 2", "654-123", "mikiveliki@hotmail.com", new Date(), 3, true, StatusStudenta.B, 6.0));
	}
	
	private long generateId() {
		return ++generator;
	}
	
	public boolean checkExistance(String index) {
		for(int i = 0; i < studenti.size(); i++) {
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
