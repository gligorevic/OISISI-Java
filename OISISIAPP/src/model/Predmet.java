package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Predmet implements Serializable {

	private static final long serialVersionUID = 3506122255564832091L;
	
	private Long id;
	private String sifra;
	private String naziv;
	private Integer semestar;
	private Integer godinaStudija;
	private Profesor profesor;
	private List<Student> studenti = new ArrayList<>();
	
	public Predmet() {
	}
	
	public Predmet(Long id, String sifra, String naziv, Integer semestar, Integer godinaStudija) {
		this.id = id;
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
	}
	
	public Predmet(Long id, String sifra, String naziv, Integer semestar, Integer godinaStudija,Profesor profesor) {
		this.id = id;
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
	}
	
	public Predmet(Long id, String sifra, String naziv, Integer semestar, Integer godinaStudija, Profesor profesor,
			List<Student> studenti) {
		this.id = id;
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.studenti = studenti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getSemestar() {
		return semestar;
	}

	public void setSemestar(Integer semestar) {
		this.semestar = semestar;
	}

	public Integer getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Integer godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	
	
	
}
