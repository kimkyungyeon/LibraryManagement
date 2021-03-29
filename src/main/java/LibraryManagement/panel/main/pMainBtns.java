package LibraryManagement.panel.main;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import LibraryManagement.RentScreen;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pMainBtns extends JPanel implements ActionListener {
	private JButton btnRent;

	/**
	 * Create the panel.
	 */
	public pMainBtns() {

		initialize();
	}
	private void initialize() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		btnRent = new JButton("대출하기");
		btnRent.addActionListener(this);
		add(btnRent);
		
		JButton btnReturn = new JButton("반납하기");
		add(btnReturn);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRent) {
			actionPerformedBtnRent(e);
		}
	}
	protected void actionPerformedBtnRent(ActionEvent e) {
		RentScreen frame = new RentScreen();
		frame.setVisible(true);
	}
}
