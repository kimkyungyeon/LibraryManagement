package LibraryManagement.panel.main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class pBookSearch extends JPanel {
	private JTextField tfBookSearch;

	/**
	 * Create the panel.
	 */
	public pBookSearch() {
		
		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 3, 5, 5));
		
		JLabel lblBookSearch = new JLabel("빠른 도서 검색 :");
		lblBookSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookSearch.setFont(new Font("굴림", Font.PLAIN, 15));
		add(lblBookSearch);
		
		JComboBox cbBookSearchBy = new JComboBox();
		add(cbBookSearchBy);
		
		tfBookSearch = new JTextField();
		tfBookSearch.setColumns(10);
		add(tfBookSearch);
	}

}
