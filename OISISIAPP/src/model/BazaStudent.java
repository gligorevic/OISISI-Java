package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		this.studenti.add(new Student(generateId(), "RA-99-2016", "Igor", "Gligorevic", new Date(), "Vojvodjanskih brigada 4", "123-456", "igor.gligorevic@hotmail.com", new Date(), 4, false, StatusStudenta.S, 8.0));
		this.studenti.add(new Student(generateId(), "RA-98-2018", "Pera", "Peric", new Date(), "Novosadskog sajma 4", "654-321", "peraperic@hotmail.com", new Date(), 2, true, StatusStudenta.B, 9.0));
		this.studenti.add(new Student(generateId(), "RA-97-2017", "Miki", "Veliki", new Date(), "Masarikova 2", "654-123", "mikiveliki@hotmail.com", new Date(), 3, true, StatusStudenta.B, 6.0));
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
					Integer godinaStudija, Boolean budzet) {
		
		this.studenti.add(new Student( generateId() , brojIndeksa,ime,prezime,
				datumRodjenja,adresa,brojTelefona,email,datumUpisa,godinaStudija,budzet	));
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
}
