package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
	public MenuBar() {
		JMenu mNew= new JMenu("New");
		JMenu mEdit = new JMenu("Edit");
		JMenu mHelp = new JMenu("Help");
		
		this.add(mNew);
		this.add(mEdit);
		this.add(mHelp);
	}
}
