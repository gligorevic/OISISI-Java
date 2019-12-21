package controller;

import model.BazaPredmet;
import model.BazaProfesor;
import model.BazaStudent;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.PredmetTab;

public class PredmetController {

	private static PredmetController instance = null;

	public static PredmetController getInstance() {
		if(instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public void dodajPredmet(String sifra, String naziv, Integer semestar, Integer godinaStudija) {
		BazaPredmet.getInstance().dodajPredmet(sifra,naziv,semestar,godinaStudija);
		PredmetTab.getInstance().azurirajPrikaz();
	}
	
	public void izmeniPredmet(int selectedRow, String sifra, String naziv, Integer semestar, Integer godinaStudija) {
		Predmet predmet = BazaPredmet.getInstance().getRow(selectedRow);		
		BazaPredmet.getInstance().izmeniPredmet(predmet.getId(), sifra, naziv, semestar, godinaStudija);
		PredmetTab.getInstance().azurirajPrikaz();
	}
	
	public void obrisiPredmet(int selectedRow) {
		Predmet predmet = BazaPredmet.getInstance().getRow(selectedRow);
		BazaPredmet.getInstance().obrisiPredmet(predmet);

		BazaStudent.getInstance().deletePredmetFromEveryStudent(predmet);
		PredmetTab.getInstance().azurirajPrikaz();
		
	}
	
	public void ukloniProfu(int selectedRow) {
		Predmet predmet = BazaPredmet.getInstance().getRow(selectedRow);
		Profesor prof = predmet.getProfesor();
		
		BazaPredmet.getInstance().ukloniProfu(predmet);
		BazaProfesor.getInstance().ukloniPredmetProfesoru(prof,predmet);
		
		PredmetTab.getInstance().azurirajPrikaz();
	}
	
	public void dodajStudenta(int selectedRow, String index) {
		Predmet predmet = BazaPredmet.getInstance().getRow(selectedRow);	
		BazaPredmet.getInstance().dodajStudenta(predmet, index);
		
		Student student = BazaStudent.getInstance().getStudentByIndex(index);
		student.addPredmetToList(predmet);
		PredmetTab.getInstance().azurirajPrikaz();
	}
	
	
	public void dodajProfesora(int selectedRow, String licna) {
		Predmet predmet = BazaPredmet.getInstance().getRow(selectedRow);
		BazaPredmet.getInstance().dodajProfesora(predmet, licna);
		PredmetTab.getInstance().azurirajPrikaz();
	}
	
	public void ukloniStudenta(String index) {
		Predmet predmet = BazaPredmet.getInstance().getRow(PredmetTab.getInstance().getSelectedRow());
		BazaPredmet.getInstance().ukloniStudenta(predmet, index);
		
		Student student = BazaStudent.getInstance().getStudentByIndex(index);
		student.removePredmetFromList(predmet);
	}
} 
