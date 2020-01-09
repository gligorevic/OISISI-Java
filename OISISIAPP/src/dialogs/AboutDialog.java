package dialogs;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import view.MainFrame;

public class AboutDialog extends JDialog {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7571189229681651679L;

	public AboutDialog() {
	super(MainFrame.getInstance(), "About", true);

	setSize(520,400);
	setLocationRelativeTo(MainFrame.getInstance());
	
	this.setLayout(new BorderLayout());
	
	String text = new String("<html>"
			+ "<h2>About</h2>"
			+ "Aplikacija je namjenjena upravljanjem entitetima u okviru Studentske sluzbe.<br>"
			+ "Postoji mogucnost raznih operacija nad entitetima sto je bolje objasnjeno <br>"
			+ "u okviru 'Help' dokumentacije. <br>"
			+ "Verzija aplikacije: 1.0.1 BETA<br> <br>"
			+ "<h3>Autori:</h3><br>"
			+ "<b>Marko Ristic RA76/2015</b><br>"
			+ "<b>Igor Gligorevic RA99/2016</b><br>"
			+ "</html>");
	
	JLabel textField = new JLabel(text);

	JScrollPane scroll = new JScrollPane(textField);
	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	
	this.add(scroll, BorderLayout.CENTER);
	}
}
