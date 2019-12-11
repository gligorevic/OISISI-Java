package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.DodajStudentaNaPredmetDijalog;
import view.PredmetTab;

public class DodajStudentaNaPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = PredmetTab.getInstance().getSelectedRow();
		if(row != -1) {
			DodajStudentaNaPredmetDijalog dsnp = new DodajStudentaNaPredmetDijalog();
			dsnp.setVisible(true);
		}
	}

}
