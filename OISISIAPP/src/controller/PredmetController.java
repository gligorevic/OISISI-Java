package controller;

import model.BazaPredmet;
import model.Predmet;
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
		PredmetTab.getInstance().azurirajPrikaz();
	}
	
	public void ukloniProfu(int selectedRow) {
		Predmet predmet = BazaPredmet.getInstance().getRow(selectedRow);
		BazaPredmet.getInstance().ukloniProfu(predmet);
		PredmetTab.getInstance().azurirajPrikaz();
	}
	
	public void dodajStudenta(int selectedRow, String index) {
		Predmet predmet = BazaPredmet.getInstance().getRow(selectedRow);	
		BazaPredmet.getInstance().dodajStudenta(predmet, index);
		PredmetTab.getInstance().azurirajPrikaz();
	}
}
