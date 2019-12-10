package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.DodajStudentaNaPredmetDijalog;
import view.PredmetTab;

public class DodajStudentaNaPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DodajStudentaNaPredmetDijalog dsnp = new DodajStudentaNaPredmetDijalog(PredmetTab.getInstance().getSelectedRow());
		dsnp.setVisible(true);
	}

}
