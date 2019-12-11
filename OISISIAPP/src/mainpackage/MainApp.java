package mainpackage;

import model.BazaStudent;
import view.MainFrame;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BazaStudent.getInstance();
		MainFrame.getInstance().setVisible(true);;
	}

}
