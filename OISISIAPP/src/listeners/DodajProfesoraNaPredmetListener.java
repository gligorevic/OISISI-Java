package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dialogs.DodajProfesoraNaPredmetDijalog;
import view.MainFrame;
import view.PredmetTab;

public class DodajProfesoraNaPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = PredmetTab.getInstance().getSelectedRow();
		if(row != -1) {
			DodajProfesoraNaPredmetDijalog dpnp = new DodajProfesoraNaPredmetDijalog();
			dpnp.setVisible(true);
		}else if (row == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite predmet u tabeli!");
		}

	}

}
