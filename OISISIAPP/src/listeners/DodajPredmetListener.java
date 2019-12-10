package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.DodajPredmetDialog;

public class DodajPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DodajPredmetDialog dpd = new DodajPredmetDialog();
		dpd.setVisible(true);
	}

}
