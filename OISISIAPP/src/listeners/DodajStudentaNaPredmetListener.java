package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dialogs.DodajStudentaNaPredmetDijalog;
import view.MainFrame;
import view.PredmetTab;

public class DodajStudentaNaPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = PredmetTab.getInstance().getSelectedRow();
		if(row != -1) {
			DodajStudentaNaPredmetDijalog dsnp = new DodajStudentaNaPredmetDijalog();
			dsnp.setVisible(true);
		}else if (row == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite predmet u tabeli!");
		}
	}

}
