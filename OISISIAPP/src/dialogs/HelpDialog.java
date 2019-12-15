package dialogs;

import javax.swing.JDialog;

import view.MainFrame;

public class HelpDialog extends JDialog {

	public HelpDialog(){

		super(MainFrame.getInstance(), "Help", true);

		setSize(400,350);
		setLocationRelativeTo(MainFrame.getInstance());
	}
}
