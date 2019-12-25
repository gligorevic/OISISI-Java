package dialogs;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import view.MainFrame;

public class HelpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4432376499239129815L;

	public HelpDialog(){

		super(MainFrame.getInstance(), "Help", true);

		setSize(520,520);
		setLocationRelativeTo(MainFrame.getInstance());
		
		this.setLayout(new BorderLayout());
		
		String text = new String("<html>"
				+ "<h2> Help dokumentacija </h2>"
				+ "<p>"
				+ "Ova aplikacija namjenjena je za upravljanjem entitetima u okviru Studentse sluzbe."
				+ "<br> Entiteti"
				+ " kojima se upravlja su: Studenti , Predmeti i Profesori."
				+ "</p>"
				+ "<h3> Studenti </h3>"
				+ "<p>"
				+ "Studeni su prikazani u tabeli pod tabom 'Studenti' i nad njima se mogu vrsiti <br>"
				+ "neke operacije. Operacije koje omogucava aplikacija su: dodavanje novog studenta <br>"
				+ "brisanje studenta iz liste i izmjena postojeceg studenta.Takodje postoji dugme <br>"
				+ "u listi koje omogucava prikaz detaljnijih informacija o studentu."
				+ "</p>"
				+ "<h4> Dodavanje studenta </h4>"
				+ "<p>"
				+ "Kako bi dodali novog studenta moramo se pozicionirati na tab 'Studenti' i u <br>"
				+ "toolbar-u izabrati ikonicu 'Dodaj' ili u meni baru pod stavkom 'File' -> 'New' <br>"
				+ "Precica za dodavanje novog studenta je kada smo pozicionirani na tab 'Studenti' <br>"
				+ "pritisnemo precicu 'Ctrl+N'. <br>"
				+ "Ukoliko smo izvrsili neku od prethodnih akicja otvara se dijalog koji treba do <br"
				+ "kraja popuniti, i tek nakon sto su svi podaci unijeti bice omoguceno dugme za <br>"
				+ "potvrdu kreiranja novog studenta."
				+ "</p>"
				+ "<h4> Brisanje studenta </h4>"
				+ "<p>"
				+ "Za brisanje studenta potrebno je prvo izabrati studenta u listi kojeg zelimo <br>"
				+ "da obrisemo i nakon toga u toolbar-u izabrati opciju obrisi ili u meni bar-u <br>"
				+ "'Edit' -> 'Delete' , takodje brisanje je moguce izvrsiti precicom 'Ctrl+D'."
				+ "</p>"
				+ "<h4> Izmjena studenta </h4>"
				+ "<p>"
				+ "Izmjena studenta se vrsi tako sto se selektuje student kojeg zelimo da <br>"
				+ "izmjenimo iz liste i u toolbar-u izaberemo 'Izmeni' ili iz meni bara-a <br>"
				+ "'Edit' -> 'Edit' , takodje izmjenu je moguce izvrsiti precicom 'Ctrl+E' <br>"
				+ "Nakon sto smo pokrenuli izmjenu otvorice se dijalog sa svim podacima <br>"
				+ "studenta koje je moguce mijenjati i bice dozvoljena izmjena samo ukoliko <br>"
				+ "su sva polja popunjena."
				+ "</p>"
				+ "<h3>Profesori</h3>"
				+ "<p>"
				+ "Profesori su prikazani u tabeli pod tabom 'profesori' i nad njima se mogu vrsiti <br>"
				+ "neke operacije. Operacije koje omogucava aplikacija su: dodavanje novog profesora <br>"
				+ "brisanje profesora iz liste i izmjena postojeceg profesora.Takodje postoji dugme <br>" 
				+ "u listi koje omogucava prikaz detaljnijih informacija o profesoru."
				+ "</p>"
				+ "<h4> Dodavanje profesora </h4>"
				+ "<p>"
				+ "Kako bi dodali novog profesora moramo se pozicionirati na tab 'Profesori' i u <br>"
				+ "toolbar-u izabrati ikonicu 'Dodaj' ili u meni baru pod stavkom 'File' -> 'New' <br>"
				+ "Precica za dodavanje novog profesora je kada smo pozicionirani na tab 'Profesori' <br>"
				+ "pritisnemo precicu 'Ctrl+N'. <br>"
				+ "Ukoliko smo izvrsili neku od prethodnih akicja otvara se dijalog koji treba do <br"
				+ "kraja popuniti, i tek nakon sto su svi podaci unijeti bice omoguceno dugme za <br>"
				+ "potvrdu kreiranja novog profesora."
				+ "</p>"
				+ "<h4> Brisanje profesora </h4>"
				+ "<p>"
				+ "Za brisanje profesora potrebno je prvo izabrati profesora u listi kojeg zelimo <br>"
				+ "da obrisemo i nakon toga u toolbar-u izabrati opciju obrisi ili u meni bar-u <br>"
				+ "'Edit' -> 'Delete' , takodje brisanje je moguce izvrsiti precicom 'Ctrl+D'."
				+ "</p>"
				+ "<h4> Izmjena profesora </h4>"
				+ "<p>"
				+ "Izmjena profesora se vrsi tako sto se selektuje profesora kojeg zelimo da <br>"
				+ "izmjenimo iz liste i u toolbar-u izaberemo 'Izmeni' ili iz meni bara-a <br>"
				+ "'Edit' -> 'Edit' , takodje izmjenu je moguce izvrsiti precicom 'Ctrl+E' <br>"
				+ "Nakon sto smo pokrenuli izmjenu otvorice se dijalog sa svim podacima <br>"
				+ "studenta koje je moguce mijenjati i bice dozvoljena izmjena samo ukoliko <br>"
				+ "su sva polja popunjena."
				+ "</p>"
				+ "<h3> Predmeti </h3>"
				+ "<p>"
				+ "U odnosu na studente i profesore tab sa predmetima je malo drugaciji <br>"
				+ "odnosno pored uobicajenih mogucnosti dodavanje, izmjene i brisanja <br>"
				+ "sadrzi i jos dvije dodatne opcije a to su mogucnos dodavanja studenta <br> "
				+ "ili profesora na odredjeni predmet."
				+ "<h4>Dodavanje predmeta</h4>"
				+ "<p>"
				+ "Kako bi dodali novi predmet moramo se pozicionirati na tab 'Predmeti' i u <br>"
				+ "toolbar-u izabrati ikonicu 'Dodaj' ili u meni baru pod stavkom 'File' -> 'New' <br>"
				+ "Precica za dodavanje novog predmeta je kada smo pozicionirani na tab 'Predmeti' <br>"
				+ "pritisnemo precicu 'Ctrl+N'. <br>"
				+ "Ukoliko smo izvrsili neku od prethodnih akicja otvara se dijalog koji treba do <br"
				+ "kraja popuniti, i tek nakon sto su svi podaci unijeti bice omoguceno dugme za <br>"
				+ "potvrdu kreiranja novog predmeta."
				+ "</p>"
				+ "<h4>Brisanje predmeta</h4>"
				+ "<p>"
				+ "Za brisanje predmeta potrebno je prvo izabrati predmet u listi koji zelimo <br>"
				+ "da obrisemo i nakon toga u toolbar-u izabrati opciju obrisi ili u meni bar-u <br>"
				+ "'Edit' -> 'Delete' , takodje brisanje je moguce izvrsiti precicom 'Ctrl+D'."
				+ "</p>"
				+ "<h4>Izmjena predmeta</h4>"
				+ "<p>"
				+ "Izmjena predmeta se vrsi tako sto se selektuje predmet koji zelimo da <br>"
				+ "izmjenimo iz liste i u toolbar-u izaberemo 'Izmeni' ili iz meni bara-a <br>"
				+ "'Edit' -> 'Edit' , takodje izmjenu je moguce izvrsiti precicom 'Ctrl+E'. <br>"
				+ "Nakon sto smo pokrenuli izmjenu otvorice se dijalog sa svim podacima <br>"
				+ "studenta koje je moguce mijenjati i bice dozvoljena izmjena samo ukoliko <br>"
				+ "su sva polja popunjena.U ovom dijalogu postoji i opcija da se klikom na <br>"
				+ "dugme 'Ukloni profesora sa predmeta' , ukloni postojeci profesor sa <br>"
				+ "predmeta koji mijenjamo."
				+ "</p>"
				+ "<h4>Dodavanje profesora na predmet</h4>"
				+ "<p>"
				+ "Dodavanje profesora na predmet vrsi se tako sto iz liste izaberemo <br>"
				+ "zeljeni predmet i onda u toolbar-u izaberemo opciju 'Dodaj profesora'<br>"
				+ "i u dijalogu koji nam se prikaze unesemo njegov broj licne karte. <br>"
				+ "Klikom na dugme za potvrdu dodace se zeljeni profesor na zeljeni <br>"
				+ "predmet. Dugme je omoguceno samo ako profesor sa zadatim brojem <br>"
				+ "licne karte postoji."
				+ "</p>"
				+ "<h4>Dodavanje studenta na predmet</h4>"
				+ "<p>"
				+ "Dodavanje studenta na predmet vrsi se tako sto iz liste izaberemo <br>"
				+ "zeljeni predmet i onda u toolbar-u izaberemo opciju 'Dodaj studenta'<br>"
				+ "i u dijalogu koji nam se prikaze unesemo njegov broj indeksa. <br>"
				+ "Klikom na dugme za potvrdu dodace se zeljeni student na zeljeni <br>"
				+ "predmet. Dugme je omoguceno samo ako student sa zadatim brojem <br>"
				+ "indeksa postoji."
				+ "</p>"
				+ "<h4>Brisanje studenta sa predmeta </h4>"
				+ "<p>"
				+ "U listi dodatih premdeta postoji u poslednjoj koloni tabele dugme <br>"
				+ "'Prikazi' za svaki dodati predmet. Klikom na to dugme prikazace se<br>"
				+ "lista svih studenta na tom predmetu prikazanih po broju indeksa.<br>"
				+ "Brisanej nekog studenta se vrsi tako sto se prvo selektuje <br>"
				+ "student u listi i onda klikom na dugme 'Obrisi' ce biti <br>"
				+ "obrisan iz liste studenata na tom predmetu."
				+ "</p>"
				+ "<h3>Pretraga</h3>"
				+ "Pretraga je omogucena za svaki tab i vrsi se po istom principu<br>"
				+ "tako sto se pozicioniramo na zeljeni tab, popunimo prostor <br>"
				+ "za pretragu zeljenim stringom i pritisnemo dugme za pretragu. "
				+ "<br>Pretragu je moguce vrsiti po razlicitim kategorijama. <br>"
				+ "<b>Profesore</b> je moguce pretrazivati po: 'ime' , 'prezime' , <br>"
				+ "'broj licne' , 'email' ,'telefon'.<br>"
				+ "<b>Studente</b> je moguce pretrazivati po: 'ime' , 'prezime' , <br>"
				+ "'broj indeksa'.<br>"
				+ "<b>Predmet</b> je moguce pretrazivati po: 'naziv' , 'sifra' , <br>"
				+ "'semestar', 'godina', 'profesor'.<br>"
				+ "Sintaksa kojom se pretrazuje je: 'polje':vrednost;'polje':vrednost;..."
				+ "</html>");
		
		JLabel textField = new JLabel(text);

		JScrollPane scroll = new JScrollPane(textField);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.add(scroll, BorderLayout.CENTER);
		
		
	//	this.add(scroll);
	}
}
