package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    
		this.kolone.add("Broj Indeksa");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum Rodjenja");
		this.kolone.add("Godina Studija");
		this.kolone.add("Budzet");
		this.kolone.add("Prosjecna Ocjena");
	}
	
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
	}
	
	private long generateId() {
		return ++generator;
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch(column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
			String strDate = dateFormat.format(student.getDatumRodjenja());
			return strDate;
		case 4:
			return Integer.toString(student.getGodinaStudija());
		case 5:
			if(student.getBudzet()) {
				return "Budzet";
			}else {
				return "Samofinansiranje";
			}
			
		case 6:
			return Double.toString(student.getProsjecnaOcjena());
		default: 
			return null;
		}
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
	
	public void dodajStudenta(String brojIndeksa, String ime , String prezime,Date datumRodjenja,
					String adresa, String brojTelefona,String email, Date datumUpisa,
					Integer godinaStudija, Boolean budzet, Double prosjecnaOcjena) {
		
		this.studenti.add(new Student( generateId() , brojIndeksa,ime,prezime,
				datumRodjenja,adresa,brojTelefona,email,datumUpisa,godinaStudija,budzet, prosjecnaOcjena));
		
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	
	public List<String> getKolone() {
		return kolone;
	}


	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}


	public List<Student> getStudenti() {
		return studenti;
	}
	
	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}


	public Student getRow(int row) {
		// TODO Auto-generated method stub
		return this.studenti.get(row);
	}


	public void izmeniStudenta(int row,String brojIndeksa, String ime , String prezime,Date datumRodjenja,
			String adresa, String brojTelefona,String email, Date datumUpisa,
			Integer godinaStudija, Boolean budzet , Double prosjecnaOcjena) {
		// TODO Auto-generated method stub
		
		Student student = BazaStudent.getInstance().getRow(row);
		
		student.setBrojIndeksa(brojIndeksa);
		student.setIme(ime);
		student.setPrezime(prezime);
		student.setDatumRodjenja(datumRodjenja);
		student.setAdresaStanovanja(adresa);
		student.setBrojTelefona(brojTelefona);
		student.setEmailAdresa(email);
		student.setDatumUpisa(datumUpisa);
		student.setGodinaStudija(godinaStudija);
		student.setBudzet(budzet);
		student.setProsjecnaOcjena(prosjecnaOcjena);
		
		
	}


	public void obrisiStudenta(Student student) {
		
		
		Iterator<Student> iter = this.studenti.listIterator();
		
		while(iter.hasNext()) {
			Student s = iter.next();
			if(s == student) {
				iter.remove();
			}
		}
		
	}


	public void deletePredmetFromEveryStudent(Predmet predmet) {
		
		for(int i = 0; i < studenti.size(); i++) {
			for(int j = 0; i < studenti.get(i).getPredmeti().size(); j++) {
				if(studenti.get(i).getPredmeti().get(j).getId().equals(predmet.getId())) {
					studenti.get(i).getPredmeti().remove(j);
					break;
				}
			}
		}
		
		Iterator<Student> iter = this.studenti.listIterator();
		
		while(iter.hasNext()) {
			Student s = iter.next();
			
			Iterator<Predmet> iterPredmet = s.getPredmeti().listIterator();
			
			while(iterPredmet.hasNext()) {
				Predmet p = iterPredmet.next();
				if(p.getId() == predmet.getId()) {
					iterPredmet.remove();
				}
			}
		}
		
	}
}
