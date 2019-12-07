package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class MainFrame extends JFrame {
	
	private Toolbar toolbar;
	private TabbedPane tabbedPane;
	private Integer currentTab = 0;
	
	public MainFrame() {
		this.initPositionAndSetTitle();
		this.initMenuBar();
		this.initToolBar();
		this.initTabs();
	}
	
	private void initPositionAndSetTitle() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3/4,screenHeight * 3/4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
	}
	
	private void initMenuBar() {
		this.setJMenuBar(new MenuBar());
	}
	
	private void initTabs() {
		this.tabbedPane = new TabbedPane();
		ProfesorTab pt1 = new ProfesorTab();
		StudentTab st1 = new StudentTab();
		PredmetTab p1 = new PredmetTab();
		
		tabbedPane.addTab("Studenti", st1);
		tabbedPane.addTab("Profesori", pt1);
		tabbedPane.addTab("Predmeti", p1);
		
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	             currentTab = tabbedPane.getSelectedIndex();
	             reinitToolBar();
	        }
	    });
		
		this.add(this.tabbedPane);	
	}
	
	private void initToolBar() {
		this.toolbar = new Toolbar(currentTab);
		add(toolbar, BorderLayout.NORTH);	
	}
	
	private void reinitToolBar() {
		this.remove(toolbar);
		this.toolbar = new Toolbar(currentTab);
		add(toolbar, BorderLayout.NORTH);	
	}
}
