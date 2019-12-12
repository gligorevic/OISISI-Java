package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ProfesorController;
import view.PredmetTab;
import view.ProfesorTab;

public class ObrisiProfesoraListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedRow = ProfesorTab.getInstance().getSelectedRow();
		if(selectedRow != -1) {
			ProfesorController.getInstance().obrisiProfesora(selectedRow);
		}
	}

}
