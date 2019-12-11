package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.DodajStudentaDialog;

public class DodajStudentaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DodajStudentaDialog dodajStudenta = new DodajStudentaDialog();
		dodajStudenta.setVisible(true);
	}

}
