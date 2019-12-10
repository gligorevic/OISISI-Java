package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -111659266189879540L;

	public MenuBar() {
		JMenu mFile= new JMenu("File");
		JMenu mEdit = new JMenu("Edit");
		JMenu mHelp = new JMenu("Help");
		
		JMenuItem add = new JMenuItem("New");
		JMenuItem closeApp = new JMenuItem("Close");
		
		JMenuItem edit = new JMenuItem("Edit") ;
		JMenuItem delete = new JMenuItem("Delete");
		
		JMenuItem help = new JMenuItem("Help");
		JMenuItem about = new JMenuItem("About");
		
		mFile.add(add);
		mFile.add(closeApp);
		
		mEdit.add(edit);
		mEdit.add(delete);
		
		mHelp.add(help);
		mHelp.add(about);
		
		this.add(mFile);
		this.add(mEdit);
		this.add(mHelp);
	}
}
