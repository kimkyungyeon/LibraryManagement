package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import LibraryManagement.panel.rentScreen.pRentMembDetail;
import LibraryManagement.service.RentScreenService;
import LibraryManagement.panel.main.pMembInfoTablePanel;
import LibraryManagement.panel.rentScreen.pMembSearch;
import javax.swing.BoxLayout;
import LibraryManagement.panel.rentScreen.pMembInfoTable;

public class RentScreen extends JFrame {

	private JPanel contentPane;
	private RentScreenService service;
	private pMembSearch pMembSearch;
	private pRentMembDetail pMembDetail;
	private pMembInfoTable pMembTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentScreen frame = new RentScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RentScreen() {
		service = new RentScreenService();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		pMembSearch = new pMembSearch();
		panel.add(pMembSearch, BorderLayout.NORTH);
		
		
		
		pMembTable = pMembSearch.getpMembTable();
		pMembTable.setService(service);
		pMembTable.loadData();
		panel.add(pMembTable, BorderLayout.CENTER);
		
		
		
		
		
		pMembDetail = pMembTable.getMembDetail();
		contentPane.add(pMembDetail);
		pMembDetail.setLayout(new BoxLayout(pMembDetail, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
	}

}
