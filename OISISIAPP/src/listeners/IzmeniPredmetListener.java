package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialogs.IzmeniPredmetDialog;
import view.PredmetTab;
import view.PredmetiTable;

public class IzmeniPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = PredmetTab.getInstance().getSelectedRow();
		if( row != -1) {
			IzmeniPredmetDialog dialog = new IzmeniPredmetDialog(row);
			dialog.setVisible(true);
		}
	}

}
