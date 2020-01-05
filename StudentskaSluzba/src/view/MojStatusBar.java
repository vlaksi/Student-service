package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Klasa koja implementira status bar.
 * 
 * @author Pufke
 *
 */
public class MojStatusBar {

	public static MojStatusBar instance = null;
	JPanel statusPanel;
	
	public static MojStatusBar getInstance() {
		if (instance == null) {
			instance = new MojStatusBar();
		}
		return instance;
	}

	public MojStatusBar() {
		this.statusPanel = new JPanel();
	}

	public JPanel getStatusPanel() {
		return this.statusPanel;
	}

	public void setStatusPanel(JPanel statusPanel) {
		this.statusPanel = statusPanel;
	}

	public void prikaziStatusBar(JPanel statusPANEL) {
		statusPanel.setLayout(new BorderLayout());
		
		JLabel statusLabel = new JLabel("Studentska slu\u017Eba");
	//	String timeStamp = new SimpleDateFormat("HH:mm     dd.MM.yyyy").format(Calendar.getInstance().getTime());
		//JLabel vreme = new JLabel(timeStamp);

		 SwingUtilities.invokeLater(new Runnable(){
	            public void run() {
	                final Date date = new Date();
	                final JLabel timeLabel = new JLabel(date.toString());
	                Timer timer = new Timer(1000, new ActionListener(){
	                    public void actionPerformed(ActionEvent e) {
	                        date.setTime(System.currentTimeMillis());
	                        timeLabel.setText(date.toString());
	                    }
	                });
	                timer.start();
	               // JOptionPane.showMessageDialog(null, timeLabel);
	                
	            	// PADING
	        		statusLabel.setBorder(BorderFactory.createEmptyBorder(6, 30, 6, 10)); // kako bi napravili border malo,da ne bi bilo skroz uz ivice
	        		statusPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 30)); // kako bi napravili border malo,da ne bi bilo skroz uz ivice
	        		
	        		statusPanel.add(statusLabel, BorderLayout.WEST);
	        		statusPanel.add(timeLabel, BorderLayout.EAST);
	            }
	        });
	    
	

	}

}
