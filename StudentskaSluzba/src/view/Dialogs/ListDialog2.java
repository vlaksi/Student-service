package view.Dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.GlavniProzor;

public class ListDialog2 {
	private JList<?> list;
	private JLabel label;
	private JOptionPane optionPane;
	private JButton okButton;
	private ActionListener okEvent;
	private JDialog dialog;

	public ListDialog2(String message, JList<?> listToDisplay) {
		list = listToDisplay;
		label = new JLabel(message);
		createAndDisplayOptionPane();
	}

	public ListDialog2(String title, String message, JList<?> listToDisplay) {
		this(message, listToDisplay);
		dialog.setTitle(title);
	}

	private void createAndDisplayOptionPane() {
		setupButtons();
		JPanel pane = layoutComponents();
		optionPane = new JOptionPane(pane);
		optionPane.setOptions(new Object[] { okButton });
		dialog = optionPane.createDialog("Spisak studenata");
	}

	private void setupButtons() {
		okButton = new JButton("OK");
		okButton.addActionListener(e -> handleOkButtonClick(e));

	}

	private JPanel layoutComponents() {
		centerListElements();
		JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.add(label, BorderLayout.NORTH);
		panel.add(list, BorderLayout.CENTER);
		return panel;
	}

	private void centerListElements() {
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void setOnOk(ActionListener event) {
		okEvent = event;
	}

	private void handleOkButtonClick(ActionEvent e) {
		if (okEvent != null) {
			okEvent.actionPerformed(e);
		}
		hide();
	}

	public void show() {
		dialog.setLocationRelativeTo(GlavniProzor.getInstance());
		dialog.setVisible(true);
	}

	private void hide() {
		dialog.setVisible(false);
	}

	public Object getSelectedItem() {
		return list.getSelectedValue();
	}
}
