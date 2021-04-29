package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import LibraryManagement.panel.rank.RankBookChart;
import LibraryManagement.panel.rank.RankChart;

public class RankFrame extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private RankChart membRankChart;
	private RankBookChart bookRankChart;
	private JPanel membRankPanel;
	private JLabel lblMembRank;
	private JPanel bookRankPanel;
	private JLabel lblBookRank;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RankFrame frame = new RankFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public RankFrame() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("통계");
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		membRankPanel = new JPanel();
		tabbedPane.add("회원통계", membRankPanel);
		membRankPanel.setLayout(new BorderLayout(0, 0));

		lblMembRank = new JLabel("<  독서왕 Top 5  >");
		lblMembRank.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMembRank.setHorizontalAlignment(SwingConstants.CENTER);
		membRankPanel.add(lblMembRank, BorderLayout.NORTH);

		membRankChart = new RankChart();
		JFreeChart membChart = membRankChart.getChart();
	    ChartPanel membRankChartPanel = new ChartPanel(membChart);
	    membRankPanel.add(membRankChartPanel, BorderLayout.CENTER);
	    
	    bookRankPanel = new JPanel();
	    tabbedPane.addTab("도서통계", null, bookRankPanel, null);
	    bookRankPanel.setLayout(new BorderLayout(0, 0));
	    
	    lblBookRank = new JLabel("<  이달의 도서 순위 Top 5  >");
	    lblBookRank.setFont(new Font("Dialog", Font.BOLD, 17));
	    lblBookRank.setHorizontalAlignment(SwingConstants.CENTER);
	    bookRankPanel.add(lblBookRank, BorderLayout.NORTH);
	    
	    
	    bookRankChart = new RankBookChart();
	    JFreeChart bookChart = bookRankChart.getChart();
	    ChartPanel bookRankChartPanel = new ChartPanel(bookChart);
	    bookRankPanel.add(bookRankChartPanel, BorderLayout.CENTER);
	    
	    
	    
//	    panel1 = new RankChart();
//		JFreeChart chart1 = panel.getChart();
//	    ChartPanel membRankPanel1 = new ChartPanel(chart);
//	    tabbedPane.add("회원통계",membRankPanel1);
	}

}
