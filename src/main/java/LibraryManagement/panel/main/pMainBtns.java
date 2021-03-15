package LibraryManagement.panel.main;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class pMainBtns extends JPanel {

	/**
	 * Create the panel.
	 */
	public pMainBtns() {

		initialize();
	}
	private void initialize() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JButton btnRent = new JButton("대출하기");
		add(btnRent);
		
		JButton btnReturn = new JButton("반납하기");
		add(btnReturn);
	}

}
