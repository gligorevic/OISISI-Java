package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
	
	private Long id;
	
	private String brojIndeksa;
	
	private String ime;
	
	private String prezime;
	
	private Date datumRodjenja;
	
	private String adresaStanovanja;
	
	private String brojTelefona;
	
	private String emailAdresa;
	
	private Date datumUpisa;
	
	private Integer godinaStudija;
	
	private Boolean budzet;
	
	private StatusStudenta status;
	
	private Long prosjecnaOcjena;
	
	private List<Predmet> predmeti = new ArrayList<>();
	
	public Student() {
		
	}
	
	

	public Student(Long id, String brojIndeksa, String ime, String prezime, Date datumRodjenja, String adresaStanovanja,
			String brojTelefona, String emailAdresa, Date datumUpisa, Integer godinaStudija, Boolean budzet,
			StatusStudenta status, Long prosjecnaOcjena, List<Predmet> predmeti) {
		super();
		this.id = id;
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.brojTelefona = brojTelefona;
		this.emailAdresa = emailAdresa;
		this.datumUpisa = datumUpisa;
		this.godinaStudija = godinaStudija;
		this.budzet = budzet;
		this.status = status;
		this.prosjecnaOcjena = prosjecnaOcjena;
		this.predmeti = predmeti;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
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

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public Integer getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Integer godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Boolean getBudzet() {
		return budzet;
	}

	public void setBudzet(Boolean budzet) {
		this.budzet = budzet;
	}

	public StatusStudenta getStatus() {
		return status;
	}

	public void setStatus(StatusStudenta status) {
		this.status = status;
	}

	public Long getProsjecnaOcjena() {
		return prosjecnaOcjena;
	}

	public void setProsjecnaOcjena(Long prosjecnaOcjena) {
		this.prosjecnaOcjena = prosjecnaOcjena;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
}
