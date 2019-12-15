package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dialogs.IzmeniProfesoraDialog;
import view.MainFrame;
import view.ProfesorTab;

public class IzmeniProfesoraListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int row = ProfesorTab.getInstance().getSelectedRow();
		if(row != -1) {
			IzmeniProfesoraDialog izmeniProfesoraDialog = new IzmeniProfesoraDialog(row);
			izmeniProfesoraDialog.setVisible(true);
		}else if (row == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite profesora u tabeli!");
		}
	}

}
