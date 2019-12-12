package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dialogs.IzmeniStudentaDialog;
import view.MainFrame;
import view.StudentTab;

public class IzmeniStudentaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
			int row = StudentTab.getInstance().getSelectedRow();
			if(row != -1) {
				IzmeniStudentaDialog izmeniStudentaDialog = new IzmeniStudentaDialog(row);
				izmeniStudentaDialog.setVisible(true);
			}else if (row == -1) {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite studenta u tabeli!");
			}
				
		
	}

	
}
