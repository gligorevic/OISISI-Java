package view;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import dialogs.AboutDialog;
import dialogs.HelpDialog;
import listeners.DodajPredmetListener;
import listeners.DodajProfesoraListener;
import listeners.DodajStudentaListener;
import listeners.IzmeniPredmetListener;
import listeners.IzmeniProfesoraListener;
import listeners.IzmeniStudentaListener;
import listeners.ObrisiPredmetListener;
import listeners.ObrisiProfesoraListener;
import listeners.ObrisiStudentaListener;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -111659266189879540L;

	
	public MenuBar(int currentTab) {
		
		JMenu mFile= new JMenu("File");
		JMenu mEdit = new JMenu("Edit");
		JMenu mHelp = new JMenu("Help");
		
		JMenuItem add = new JMenuItem("New",'n');
		JMenuItem closeApp = new JMenuItem("Close",'c');
		
		JMenuItem edit = new JMenuItem("Edit",'t') ;
		JMenuItem delete = new JMenuItem("Delete",'d');
		
		JMenuItem help = new JMenuItem("Help",'p');
		JMenuItem about = new JMenuItem("About",'b');
		
		mFile.setMnemonic('f');
		mEdit.setMnemonic('e');
		mHelp.setMnemonic('h');
		
		edit.setIcon(new ImageIcon("images/icons8-edit-24.png"));
		add.setIcon(new ImageIcon("images/icons8-add-24.png"));
		closeApp.setIcon(new ImageIcon("images/icons8-close-window-24.png"));
		delete.setIcon(new ImageIcon("images/icons8-delete-24.png"));
		about.setIcon(new ImageIcon("images/icons8-about-24.png"));
		help.setIcon(new ImageIcon("images/icons8-help-26.png"));
		
		add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));

		edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
		
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
		
		help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));

		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));

		closeApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		
		if(currentTab == 0) {
			add.addActionListener(new DodajStudentaListener());
			edit.addActionListener(new IzmeniStudentaListener());
			delete.addActionListener(new ObrisiStudentaListener());
		}else if(currentTab == 1) {
			delete.addActionListener(new ObrisiProfesoraListener());
			add.addActionListener(new DodajProfesoraListener());
			edit.addActionListener(new IzmeniProfesoraListener());
		}else {
			add.addActionListener(new DodajPredmetListener());
			edit.addActionListener(new IzmeniPredmetListener());
			delete.addActionListener(new ObrisiPredmetListener());
		}
		
		closeApp.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		      }
		    });
		
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HelpDialog hd = new HelpDialog();
				hd.setVisible(true);
			}
		});
		
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AboutDialog ad = new AboutDialog();
				ad.setVisible(true);
			}
		});
		
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
