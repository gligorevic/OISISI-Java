package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.DodajProfesoraDialog;

public class DodajProfesoraListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DodajProfesoraDialog dodajProfesoraDialog = new DodajProfesoraDialog();
		dodajProfesoraDialog.setVisible(true);
		
	}

}
