package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.DodajProfesoraNaPredmetDijalog;
import view.PredmetTab;

public class DodajProfesoraNaPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = PredmetTab.getInstance().getSelectedRow();
		if(row != -1) {
			DodajProfesoraNaPredmetDijalog dpnp = new DodajProfesoraNaPredmetDijalog();
			dpnp.setVisible(true);
		}

	}

}
