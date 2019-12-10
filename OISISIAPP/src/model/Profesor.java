package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profesor {

	private Long id;
	
	private String ime;
	private String prezime;
	
	private Date datumRodjenja;
	
	private String adresa;
	
	private String telefon;
	
	private String email;
	
	private String adresaKancelarije;
	
	private Integer brLicne;
	
	private String titula;
	
	private String zvanje;
	
	private List<Predmet> predmeti = new ArrayList<>();

	public Profesor() {
	}
	
	public Profesor(Long id, String ime, String prezime, Date datumRodjenja, String adresa, String telefon, String email,
			String adresaKancelarije, Integer brLicne, String titula, String zvanje) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brLicne = brLicne;
		this.titula = titula;
		this.zvanje = zvanje;
	}
	
	public Profesor(Long id, String ime, String prezime, Date datumRodjenja, String adresa, String telefon, String email,
			String adresaKancelarije, Integer brLicne, String titula, String zvanje, List<Predmet> predmeti) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brLicne = brLicne;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = predmeti;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public Integer getBrLicne() {
		return brLicne;
	}

	public void setBrLicne(Integer brLicne) {
		this.brLicne = brLicne;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
	
}
