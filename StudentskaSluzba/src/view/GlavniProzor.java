package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Klasa koja nam sluzi kao podloga za nas GUI.
 * 
 * @author Vaxi
 *
 */
public class GlavniProzor extends JFrame {

	private static final long serialVersionUID = -4307414094787209222L;
	private static GlavniProzor instance = null;

	public static GlavniProzor getInstance() {
		if (instance == null) {
			instance = new GlavniProzor();
		}
		return instance;
	}

	public GlavniProzor() {
		setTitle("Studentska slu\u017Eba");

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dimenzijeEkrana = kit.getScreenSize(); // uzimamo dimenzije ekrana kako bi namestili velicinu
															// aplikacije

		setSize((dimenzijeEkrana.width * 3) / 4, (dimenzijeEkrana.height * 3) / 4); // podesavanje na 3/4 ekrana
		setLocationRelativeTo(null); // u odnosu na centar ekrana postavljamo
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // gasenje aplikacije na x

		MojToolbar toolbar = new MojToolbar();
		add(toolbar, BorderLayout.NORTH);
		validate(); // osvezavanje dodanog na frejm

		// Postavljena ikonice aplikacije
		Image img = kit.getImage("img/ikonica.png");
		setIconImage(img);

		// kreiranje naslednika klase JMenuBar i njeno postavljanje u glavni prozor
		// aplikacije
		MojMenyBar meny = new MojMenyBar();
		this.setJMenuBar(meny);
		validate(); // osvezavanje dodanog na frejm

		prikaziStatusBar();
		add((Tabovi.getInstance()).getScrollPane(),BorderLayout.CENTER);//prikaz tabova
		validate();
	}

	private void prikaziStatusBar() {

		// create the status bar panel and shove it down the bottom of the frame
		JPanel statusPanel = new JPanel();
		add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setLayout(new BorderLayout());

		// statusPanel.setPreferredSize(new Dimension(getWidth(), 16));
		// statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		JLabel statusLabel = new JLabel("Studentska sluzba");

		String timeStamp = new SimpleDateFormat("HH:mm     dd.MM.yyyy").format(Calendar.getInstance().getTime());
		JLabel vreme = new JLabel(timeStamp);
		// statusLabel.setHorizontalAlignment(SwingConstants.LEFT);

		// PADING
		statusLabel.setBorder(BorderFactory.createEmptyBorder(6, 30, 6, 10)); // kako bi napravili border malo,da ne bi
																				// bilo skroz uz ivice
		statusPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 30)); // kako bi napravili border malo,da ne bi
																				// bilo skroz uz ivice

		statusPanel.add(statusLabel, BorderLayout.WEST);
		statusPanel.add(vreme, BorderLayout.EAST);
		setVisible(true);
	}

}
