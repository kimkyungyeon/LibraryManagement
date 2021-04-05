package LibraryManagement.panel.main;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import LibraryManagement.RentScreen;
import LibraryManagement.ReturnScreen;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pMainBtns extends JPanel implements ActionListener {
	private JButton btnRent;
	private JButton btnReturn;

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
		
		btnReturn = new JButton("반납하기");
		btnReturn.addActionListener(this);
		add(btnReturn);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReturn) {
			actionPerformedBtnReturn(e);
		}
		if (e.getSource() == btnRent) {
			actionPerformedBtnRent(e);
		}
	}
	protected void actionPerformedBtnRent(ActionEvent e) {
		RentScreen frame = new RentScreen();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnReturn(ActionEvent e) {
		ReturnScreen frame = new ReturnScreen();
		frame.setVisible(true);
	}
}
