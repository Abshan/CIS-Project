package main.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;

import main.Servers.review;
import main.Servers.serverInterface;

/**
 * @author Illyas Nairoos
 *
 */
public class Home {

	public JFrame frame;
	public int chartFlag =0;
	serverInterface serv;
	public ChartPanel cp1;
	public ChartPanel cp3;
	public ChartPanel cp4;
	public ChartPanel cp6;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */

	public Home() {
		initialize();
	}

	/*
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		/*
		 * Retrieving feedback questions from server
		 */

		String name = review.name;
		String question1 = "";
		String question2 = "";
		String question3 = "";
		String question4 = "";
		String question5 = "";
		try {
			serv = (serverInterface) Naming.lookup(name);

			Vector<String> que = new Vector<String>(serv.questions());
			question1 = que.get(0).toString();
			question2 = que.get(1).toString();
			question3 = que.get(2).toString();
			question4 = que.get(3).toString();
			question5 = que.get(4).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Retrieving different user feedback from the database using relevant functions
		 */

		int taste = 0;
		int plating = 0;
		int portion = 0;
		int serveTime = 0;
		int waitingStaff = 0;
		int cleanliness = 0;
		int lighting = 0;
		int comfort = 0;
		int yes = 0;
		int no = 0;
		int maybe = 0;
		Vector<String> message = null;

		try {

			serv = (serverInterface) Naming.lookup(name);

			taste = serv.getAvgValueOf("Food", "Taste");
			plating = serv.getAvgValueOf("Food", "Plating");
			portion = serv.getAvgValueOf("Food", "Portion");
			serveTime = serv.getAvgValueOf("Service", "ServeTime");
			waitingStaff = serv.getAvgValueOf("Service", "WaitingStaff");
			cleanliness = serv.getAvgValueOf("Ambiance", "Cleanliness");
			lighting = serv.getAvgValueOf("Ambiance", "Lighting");
			comfort = serv.getAvgValueOf("Ambiance", "Comfort");

			yes = serv.getValueOfOpinion("Yes");
			no = serv.getValueOfOpinion("No");
			maybe = serv.getValueOfOpinion("Maybe");

			message = new Vector<String>(serv.getComments(20));

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * GUI
		 */

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280, 971);
		frame.setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 107, 1264, 951);
		mainPanel.setLayout(null);

		JPanel outerScrollPanel = new JPanel();
		outerScrollPanel.setBackground(new Color(128, 128, 128));
		outerScrollPanel.setLayout(null);

		outerScrollPanel.setPreferredSize(new Dimension(491, 800));

		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(outerScrollPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE));
		gl_mainPanel.setVerticalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel
						.createSequentialGroup().addComponent(outerScrollPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(151, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1264, 800);
		outerScrollPanel.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel innerScrollPanel = new JPanel();
		innerScrollPanel.setPreferredSize(new Dimension(290, 1000));
		innerScrollPanel.setBackground(SystemColor.inactiveCaptionBorder);
		scrollPane.setViewportView(innerScrollPanel);


		JPanel dypan1 = new JPanel();
		dypan1.setBackground(Color.LIGHT_GRAY);
		dypan1.setLayout(new BorderLayout());

		JPanel dypan4 = new JPanel();
		dypan4.setBackground(Color.LIGHT_GRAY);
		dypan4.setLayout(new BorderLayout());

		JPanel dypan3 = new JPanel();
		dypan3.setBackground(Color.LIGHT_GRAY);

		JPanel dypan6 = new JPanel();
		dypan6.setBackground(Color.LIGHT_GRAY);

		JLabel lblSetOne = new JLabel();
		lblSetOne.setText("\"" + question1 + "\"");
		lblSetOne.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblSetTwo = new JLabel();
		lblSetTwo.setText("\"" + question3 + "\"");
		lblSetTwo.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblSetThree = new JLabel();
		lblSetThree.setText("\"" + question2 + "\"");
		lblSetThree.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblSetFour = new JLabel();
		lblSetFour.setText("\"" + question4 + "\"");
		lblSetFour.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblSetFive = new JLabel();
		lblSetFive.setText("\"" + question5 + "\"");
		lblSetFive.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JScrollPane feedbackScrollPane = new JScrollPane();
		feedbackScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		feedbackScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JTextArea areaFeedback = new JTextArea();
		areaFeedback.setPreferredSize(new Dimension(1026, 1000));
		feedbackScrollPane.setViewportView(areaFeedback);
		areaFeedback.setEditable(false);
		areaFeedback.setFont(new Font("Tahoma", Font.PLAIN, 20));

		for (int i = 0; i < message.size(); i++) {

			areaFeedback.setText(areaFeedback.getText() + "\n \n " + message.get(i));
		}

		GroupLayout gl_innerScrollPanel = new GroupLayout(innerScrollPanel);
		gl_innerScrollPanel
				.setHorizontalGroup(gl_innerScrollPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_innerScrollPanel
										.createSequentialGroup().addContainerGap(114, Short.MAX_VALUE)
										.addComponent(
												feedbackScrollPane, GroupLayout.PREFERRED_SIZE, 1026,
												GroupLayout.PREFERRED_SIZE)
										.addGap(105))
						.addGroup(Alignment.LEADING,
								gl_innerScrollPanel.createSequentialGroup().addGap(61)
										.addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_innerScrollPanel
														.createSequentialGroup()
														.addComponent(lblSetFive, GroupLayout.PREFERRED_SIZE, 516,
																GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
												.addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_innerScrollPanel.createSequentialGroup()
																.addGroup(gl_innerScrollPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_innerScrollPanel
																				.createSequentialGroup()
																				.addComponent(lblSetThree,
																						GroupLayout.PREFERRED_SIZE, 516,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(82).addComponent(lblSetFour,
																						GroupLayout.PREFERRED_SIZE, 516,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_innerScrollPanel
																				.createSequentialGroup()
																				.addComponent(dypan3,
																						GroupLayout.PREFERRED_SIZE, 516,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(82)
																				.addComponent(dypan6,
																						GroupLayout.PREFERRED_SIZE, 516,
																						GroupLayout.PREFERRED_SIZE)))
																.addContainerGap())
														.addGroup(gl_innerScrollPanel.createSequentialGroup()
																.addGroup(gl_innerScrollPanel
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(lblSetOne, Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE, 516,
																				Short.MAX_VALUE)
																		.addComponent(dypan1, Alignment.LEADING,
																				GroupLayout.PREFERRED_SIZE, 516,
																				GroupLayout.PREFERRED_SIZE))
																.addGap(82)
																.addGroup(gl_innerScrollPanel
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(dypan4,
																				GroupLayout.PREFERRED_SIZE, 516,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblSetTwo,
																				GroupLayout.PREFERRED_SIZE, 516,
																				GroupLayout.PREFERRED_SIZE))
																.addContainerGap(70, Short.MAX_VALUE))))));
		gl_innerScrollPanel.setVerticalGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_innerScrollPanel.createSequentialGroup().addGap(32)
						.addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSetOne, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSetTwo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(dypan4, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addComponent(dypan1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGap(50)
						.addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSetThree, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSetFour, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(dypan6, GroupLayout.PREFERRED_SIZE, 195,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(dypan3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 195,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
						.addComponent(lblSetFive, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(feedbackScrollPane, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addGap(49)));
		innerScrollPanel.setLayout(gl_innerScrollPanel);

		/*
		 * Chart data set creation and setting up
		 */

		

		final DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		dataset1.addValue(taste,"Rating", "Taste");
		dataset1.addValue(plating,"Rating", "Plating");
		dataset1.addValue(portion,"Rating", "Portion");

		final DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		dataset2.addValue(cleanliness,"Rating", "Cleanliness");
		dataset2.addValue(lighting,"Rating", "Lighting");
		dataset2.addValue(comfort,"Rating", "Comfort");

		final DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
		dataset3.addValue(serveTime,"Rating", "Serve Time");
		dataset3.addValue(waitingStaff,"Rating", "Waiting Staff");

		final DefaultCategoryDataset dataset4 = new DefaultCategoryDataset();
		dataset4.addValue(yes,"Rating", "Yes");
		dataset4.addValue(no,"Rating", "No");
		dataset4.addValue(maybe,"Rating", "Maybe");

		/*
		 * Chart creation and setting up
		 */

		final JFreeChart chart1 = ChartFactory.createBarChart("", "", "Rating", dataset1, PlotOrientation.VERTICAL,
				false, true, false);
		chart1.getTitle().setHorizontalAlignment(HorizontalAlignment.LEFT);

		final JFreeChart chart2 = ChartFactory.createBarChart("", "", "Rating", dataset2, PlotOrientation.VERTICAL,
				false, true, false);
		chart2.getTitle().setHorizontalAlignment(HorizontalAlignment.LEFT);

		final JFreeChart chart3 = ChartFactory.createBarChart("", "", "Rating", dataset3, PlotOrientation.VERTICAL,
				false, true, false);
		chart3.getTitle().setHorizontalAlignment(HorizontalAlignment.LEFT);

		final JFreeChart chart4 = ChartFactory.createBarChart("", "", "Rating", dataset4, PlotOrientation.VERTICAL,
				false, true, false);
		chart4.getTitle().setHorizontalAlignment(HorizontalAlignment.LEFT);

		/*
		 * Assigning charts to chartpanels and adding them to panels
		 */
		

		dypan1.setLayout(new java.awt.BorderLayout());
		cp1 = new ChartPanel(chart1);
		cp1.setBackground(new Color(112, 128, 144));
		dypan1.add(cp1, BorderLayout.CENTER);
		dypan1.validate();

		dypan4.setLayout(new java.awt.BorderLayout());
		cp3 = new ChartPanel(chart2);
		cp3.setBackground(new Color(112, 128, 144));
		dypan4.add(cp3, BorderLayout.CENTER);
		dypan4.validate();

		dypan3.setLayout(new java.awt.BorderLayout());
		cp4 = new ChartPanel(chart3);
		cp4.setBackground(new Color(112, 128, 144));
		dypan3.add(cp4, BorderLayout.CENTER);
		dypan3.validate();

		dypan6.setLayout(new java.awt.BorderLayout());
		cp6 = new ChartPanel(chart4);
		cp6.setBackground(new Color(112, 128, 144));
		dypan6.add(cp6, BorderLayout.CENTER);
		dypan6.validate();

		/*
		 * GUI
		 */

		mainPanel.setLayout(gl_mainPanel);
		frame.getContentPane().setLayout(null);

		/*
		 * Logout button
		 */

		JButton btnLogout = new JButton("Logout ");
		btnLogout.setBackground(SystemColor.activeCaption);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int conf = JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Confirm logout",
						JOptionPane.YES_NO_OPTION);
				if (conf == JOptionPane.YES_OPTION) {
					Login window = new Login();
					window.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnLogout.setBounds(1086, 36, 130, 44);
		frame.getContentPane().add(btnLogout);

		/*
		 * Cover image
		 */

		JLabel label = new JLabel("");
		label.setBackground(UIManager.getColor("menu"));
		label.setBounds(0, 0, 1264, 107);
		frame.getContentPane().add(label);
		frame.getContentPane().add(mainPanel);
	}
}
