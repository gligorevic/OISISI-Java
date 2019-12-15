package dialogs;

import javax.swing.JDialog;

import view.MainFrame;

public class AboutDialog extends JDialog {
	
	
	public AboutDialog() {
	super(MainFrame.getInstance(), "About", true);

	setSize(400,350);
	setLocationRelativeTo(MainFrame.getInstance());
	}
}
