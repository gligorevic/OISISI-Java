package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.PredmetController;
import view.MainFrame;
import view.PredmetTab;

public class ObrisiPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		int selectedRow = PredmetTab.getInstance().getSelectedRow();
		if(selectedRow != -1) {
			PredmetController.getInstance().obrisiPredmet(selectedRow);
		} else {
      JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite predmet u tabeli!");
    }
	}
}
