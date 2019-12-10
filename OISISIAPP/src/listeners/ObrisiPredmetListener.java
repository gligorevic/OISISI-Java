package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PredmetController;
import view.PredmetTab;

public class ObrisiPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PredmetController.getInstance().obrisiPredmet(PredmetTab.getInstance().getSelectedRow());
	}

}
