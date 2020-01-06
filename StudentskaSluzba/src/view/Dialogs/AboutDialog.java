package view.Dialogs;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import view.GlavniProzor;

public class AboutDialog extends JDialog {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -5887953918333596075L;
	private static final String IMAGE_URL = "aboutDialog.png";
	 
	 
	public AboutDialog() {
			JDialog dialog = new JDialog();     
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("About");

			try {
				dialog.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream(IMAGE_URL)))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dialog.pack();
			dialog.setLocationRelativeTo(GlavniProzor.getInstance());
     		dialog.setVisible(true);
		}
}
