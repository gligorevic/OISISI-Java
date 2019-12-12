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
		// TODO Auto-generated method stub
		
		if (PredmetTab.getInstance().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite predmet u tabeli!");
		}else if (PredmetTab.getInstance().getSelectedRow() != -1) {
		PredmetController.getInstance().obrisiPredmet(PredmetTab.getInstance().getSelectedRow());
		}
	}
}
