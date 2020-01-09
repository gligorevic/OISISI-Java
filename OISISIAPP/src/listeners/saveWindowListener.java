package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.BazaPredmet;
import model.BazaProfesor;
import model.BazaStudent;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.StudentTab;

public class saveWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		File f = new File("predmeti.txt");
		File f1 = new File("studenti.txt");
		File f2 = new File("profesori.txt");
		ObjectInputStream ois = null;
		ObjectInputStream ois1 = null;
		ObjectInputStream ois2 = null;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			ois1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f1)));
			ois2 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f2)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			List<Predmet> ucitaniPredmeti = (List<Predmet>)ois.readObject();
			List<Student> ucitaniStudenti = (List<Student>)ois1.readObject();
			List<Profesor> ucitaniProfesori = (List<Profesor>)ois2.readObject();
			BazaPredmet.getInstance().setPredmeti(ucitaniPredmeti);
			BazaStudent.getInstance().setStudenti(ucitaniStudenti);
			StudentTab.getInstance().azurirajPrikaz();
			BazaProfesor.getInstance().setProfesori(ucitaniProfesori);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				ois.close();
				ois1.close();
				ois2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {	
		File f = new File("predmeti.txt");
		File f1 = new File("studenti.txt");
		File f2 = new File("profesori.txt");
		ObjectOutputStream oos = null;
		ObjectOutputStream oos1 = null;
		ObjectOutputStream oos2 = null;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oos1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f1)));
			oos2 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f2)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(BazaPredmet.getInstance().getPredmeti());
			oos1.writeObject(BazaStudent.getInstance().getStudenti());
			oos2.writeObject(BazaProfesor.getInstance().getProfesori());
			
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			try {
				oos.close();
				oos1.close();
				oos2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
