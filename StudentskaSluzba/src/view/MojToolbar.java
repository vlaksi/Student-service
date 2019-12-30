package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

/**
 * Klasa koja sluzi za implementaciju toolbara-a u glavnom prozoru.
 * 
 * @author Vaxi
 *
 */
public class MojToolbar extends JToolBar {

	private static final long serialVersionUID = 4684825905522190943L;

	public MojToolbar() {
		super(SwingConstants.HORIZONTAL); // podesavanje orijentacije toolbar-a

		JButton novoDugme = new JButton();
		novoDugme.setToolTipText("Dodaj");
		ImageIcon iconNew = formatirajSliku("./img/add.png", 15, 15);
		novoDugme.setIcon(iconNew);
		add(novoDugme);

		addSeparator();

		JButton izmeniDugme = new JButton();
		izmeniDugme.setToolTipText("Izmeni");
		ImageIcon iconNew2 = formatirajSliku("./img/edit.jpg", 15, 15);
		izmeniDugme.setIcon(iconNew2);
		add(izmeniDugme);

		addSeparator();

		JToggleButton tglBtnBold = new JToggleButton();
		tglBtnBold.setToolTipText("Bold");
		ImageIcon iconNew3 = formatirajSliku("./img/new.png", 15, 15);
		tglBtnBold.setIcon(iconNew3);
		add(tglBtnBold);

		JTextField searchable = new JTextField(30); // search polje
		ImageIcon search = new ImageIcon("./img/search.png");
		JButton searchB = new JButton("Search", search); // search dugme

		add(Box.createHorizontalGlue()); // Posle ovoga su svi elementi zalepljeni za desnu stranu
		add(searchable);
		add(searchB);
		searchable.setMaximumSize(new Dimension(100, 40));

		setFloatable(false);// toolbar je pokretljiv, probati i sa staticnim toolbarom
		setBackground(new Color(255, 255, 254));
	}

	/**
	 * Metoda koja pretvara prosledjenu sliku u zeljenu velicinu.
	 * 
	 * @param putanja
	 * @param x
	 * @param y
	 * @return
	 */
	public ImageIcon formatirajSliku(String putanja, int x, int y) {
		/* prebacivanje slike u odredjenu velicinu 15x15 jer je prevelika na pocetku */
		ImageIcon imageIcon = new ImageIcon(putanja); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		ImageIcon iconExit = new ImageIcon(newimg); // transform it back
		return iconExit;
	}
}
