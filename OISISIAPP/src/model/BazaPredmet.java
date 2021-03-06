package model;

import java.util.ArrayList;
import java.util.List;

public class BazaPredmet {
	
	private static BazaPredmet instance = null;
	
	public static BazaPredmet getInstance() {
		if(instance == null) {
			instance = new BazaPredmet();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	
	private long generator;
	
	private BazaPredmet() {
		generator = 0;
		initPredmete();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina Studija");
		this.kolone.add("Profesor");
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	private void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		this.predmeti.add(new Predmet(generateId(), "BP1", "Baze Podataka 1", 5, 3));
	}
	
	private long generateId() {
		return ++generator;
	}
	
	public Predmet getRow(int index) {
		return this.predmeti.get(index);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch(column) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return Integer.toString(predmet.getSemestar());
		case 3:
			return Integer.toString(predmet.getGodinaStudija());
		case 4:
			Profesor profa = predmet.getProfesor();
			if(profa == null) {
				return "----Nije dodat----";
			}
			return profa.getIme() + " " + profa.getPrezime();
		default: 
			return null; 
		}
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public List<Student> getStudentiFromPredmet(int id) {
		return predmeti.get(id).getStudenti();
	}
	
	public Profesor getProfesorFromPredmet(int id) {
		return predmeti.get(id).getProfesor();
	}
	
	public void izmeniPredmet(Long id, String sifra, String naziv, Integer semestar, Integer godinaStudija) {
		predmeti.forEach(p -> {
			if(p.getId() == id) {
				p.setNaziv(naziv);
				p.setSifra(sifra);
				p.setGodinaStudija(godinaStudija);
				p.setSemestar(semestar);
			}
		});
	}
	
	public void dodajPredmet(String sifra, String naziv, Integer semestar, Integer godinaStudija) {
		this.predmeti.add(new Predmet(generateId(), sifra, naziv, semestar, godinaStudija));
	}
	
	public void obrisiPredmet(Predmet predmet) {
		for(int i = 0; i < predmeti.size(); i++) {
			if(predmeti.get(i).getId().equals(predmet.getId())) {
				predmeti.remove(i);
				break;
			}
		}
		BazaProfesor.getInstance().obrisiPredmetProfesora(predmet.getProfesor(), predmet);
		
	}
	
	public void ukloniProfu(Predmet predmet) {
		BazaProfesor.getInstance().obrisiPredmetProfesora(predmet.getProfesor(), predmet);
		predmet.setProfesor(null);
	}
	
	public void dodajStudenta(Predmet predmet, String index) {
		Student student = BazaStudent.getInstance().getStudentByIndex(index);
		if(student != null && !predmet.getStudenti().contains(student) && student.getGodinaStudija() >= predmet.getGodinaStudija()) {
		predmet.getStudenti().add(student);
		}
	}
	
	public void dodajProfesora(Predmet predmet, String licna) {
		Profesor profesor = BazaProfesor.getInstance().findByLicna(licna);
		if(profesor != null && predmet.getProfesor() == null) {
			predmet.setProfesor(profesor);
			BazaProfesor.getInstance().dodajPredmetProfesoru(predmet, licna);
		}
	}
	
	public void ukloniStudenta(Predmet predmet, String index) {
		for(Student s : predmet.getStudenti()) {
			if(s.getBrojIndeksa().toUpperCase().equals(index.toUpperCase())) {
				predmet.getStudenti().remove(s);
				return;
			}
		}
	}

	public void obrisiStudentaSaSvihPredmeta(Student student) {

		for(int i = 0; i < predmeti.size(); i++) {
			for(int j = 0; j < predmeti.get(i).getStudenti().size(); j++) {
				if(predmeti.get(i).getStudenti().get(j).getId()
						.equals(student.getId())) {
					predmeti.get(i).getStudenti().remove(j);
					break;
				}
			}
			
		}	
	}

	public void obrisiProfesoraSaSvihPredmeta(Profesor profesor) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < predmeti.size() ; i++) {
			if(predmeti.get(i).getProfesor().getId().equals(profesor.getId())){
				predmeti.get(i).setProfesor(null);
			}
		}
	}
	
}
