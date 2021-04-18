package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BookInsert extends JFrame {

	private JPanel contentPane;
	private JTextField tfBookNo;
	private JTextField tfBookTitle;
	private JTextField tfTotalCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInsert frame = new BookInsert();
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
	public BookInsert() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 20));
		
		JLabel lblBookNo = new JLabel("도서번호");
		lblBookNo.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookNo);
		
		tfBookNo = new JTextField();
		tfBookNo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfBookNo);
		tfBookNo.setColumns(10);
		
		JLabel lblBookTitle = new JLabel("도서제목");
		lblBookTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookTitle);
		
		tfBookTitle = new JTextField();
		tfBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfBookTitle);
		tfBookTitle.setColumns(10);
		
		JLabel lblBookCategory = new JLabel("도서구분");
		lblBookCategory.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblBookCategory);
		
		JComboBox cbBookCategory = new JComboBox();
		contentPane.add(cbBookCategory);
		
		JLabel lblTotalCount = new JLabel("도서 권수");
		lblTotalCount.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblTotalCount);
		
		tfTotalCount = new JTextField();
		tfTotalCount.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfTotalCount);
		tfTotalCount.setColumns(10);
		
		JLabel lblCount = new JLabel("잔여권수");
		lblCount.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblCount);
		
		JLabel tfCount = new JLabel("");
		tfCount.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfCount);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnAdd = new JButton("추 가");
		contentPane.add(btnAdd);
	}

}
