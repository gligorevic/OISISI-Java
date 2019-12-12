package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import listeners.saveWindowListener;



public class MainFrame extends JFrame {
	public static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private Toolbar toolbar;
	private TabbedPane tabbedPane;
	private Integer currentTab = 0;
	
	private PredmetiTable predmetiTable;
	
	
	private MainFrame() {
		this.addWindowListener(new saveWindowListener());
		this.initPositionAndSetTitle();
		this.initMenuBar();
		this.initTabs();
		this.initToolBar();
		this.initStatusBar();
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
	
	private void initStatusBar() {
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 16));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		this.add(statusPanel,BorderLayout.SOUTH);
		
		
		JLabel nameLabel = new JLabel("Studentska sluÅ¾ba");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(nameLabel);
		
		statusPanel.add(Box.createHorizontalGlue());     // odvajanje naziva na lijevu a vrijeme i datum desno
		
		JLabel timeLabel = new JLabel();
		statusPanel.add(timeLabel);
		
		final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");   //formatiranje vremena za labelu
        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date();
                String time = timeFormat.format(date);
                timeLabel.setText(time);
            }
        };
        Timer timer = new Timer(1000, timerListener);
        // to make sure it doesn't wait one second at the start
        timer.setInitialDelay(0);
        timer.start();
		
        statusPanel.add(Box.createRigidArea(new Dimension(10,16))); //odvaja vrijeme od datuma
        
        
        JLabel dateLabel = new JLabel();                                  // dodavanje labele za datum u status bar
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String dateText = dateFormat.format(date);
		dateLabel.setText(dateText);
		statusPanel.add(dateLabel);	
	}
	
	private void initMenuBar() {
		this.setJMenuBar(new MenuBar());
	}
	
	private void initTabs() {
		this.tabbedPane = new TabbedPane();
		
		tabbedPane.addTab("Studenti", StudentTab.getInstance());
		tabbedPane.addTab("Profesori", ProfesorTab.getInstance());
		tabbedPane.addTab("Predmeti", PredmetTab.getInstance());
		
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	             currentTab = tabbedPane.getSelectedIndex();
	             reinitToolBar();
	        }
	    });
		
		this.add(this.tabbedPane, BorderLayout.CENTER);	
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
