package mainpackage;

import model.BazaProfesor;
import model.BazaStudent;
import view.MainFrame;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BazaProfesor.getInstance();
		MainFrame.getInstance().setVisible(true);;
	}

}
