package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.StudentController;
import view.MainFrame;
import view.StudentTab;

public class ObrisiStudentaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (StudentTab.getInstance().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite studenta u tabeli!");
		}else {
		StudentController.getInstance().obrisiStudenta(StudentTab.getInstance().getSelectedRow());
		
		}	
	}
}
