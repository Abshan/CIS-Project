package main.GUI;
//
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class Home {

	public JFrame frame;

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

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		// get the screen size as a java dimension
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//		// get 2/3 of the height, and 2/3 of the width
//		int height = screenSize.height * 2 / 3;
//		int width = screenSize.width * 2 / 3;
//
//		// set the jframe height and width
//		frame.setPreferredSize(new Dimension(width, height));
//		
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		int xSize = ((int) tk.getScreenSize().getWidth());
//		int ySize = ((int) tk.getScreenSize().getHeight());
//		frame.setSize(xSize,ySize);

		frame.setSize(1920, 1080);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 128, 128));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1888, Short.MAX_VALUE)
				.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1888, Short.MAX_VALUE)
				.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1888, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		JLabel lblThisMonth = new JLabel("THIS MONTH");
		lblThisMonth.setBounds(154, 21, 122, 36);
		lblThisMonth.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(21)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(889, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(18)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(19, Short.MAX_VALUE)));
		panel_6.setLayout(null);
		panel_6.add(lblThisMonth);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.GRAY);
		panel_14.setBounds(0, 0, 71, 78);
		panel_6.add(panel_14);

		JLabel label_2 = new JLabel("");

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/gui/Icons/icons8_graph_35px_1.png")));
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(gl_panel_14.createParallelGroup(Alignment.LEADING).addGap(0, 71, Short.MAX_VALUE)
				.addGroup(gl_panel_14
						.createSequentialGroup().addGap(18).addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3).addComponent(label_2))
						.addContainerGap(18, Short.MAX_VALUE)));
		gl_panel_14.setVerticalGroup(gl_panel_14.createParallelGroup(Alignment.LEADING).addGap(0, 78, Short.MAX_VALUE)
				.addGroup(gl_panel_14
						.createSequentialGroup().addGap(21).addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3).addComponent(label_2))
						.addContainerGap(22, Short.MAX_VALUE)));
		panel_14.setLayout(gl_panel_14);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(128, 128, 128));

		JLabel lblToday = new JLabel("TODAY");
		lblToday.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
						.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addComponent(lblToday, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addGap(23)));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup().addContainerGap(29, Short.MAX_VALUE)
						.addComponent(lblToday).addGap(27)));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/gui/Icons/icons8_bar_chart_35px_1.png")));
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(gl_panel_13.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_13
				.createSequentialGroup().addGap(18).addComponent(lblNewLabel_2).addContainerGap(18, Short.MAX_VALUE)));
		gl_panel_13.setVerticalGroup(gl_panel_13.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_13
				.createSequentialGroup().addGap(21).addComponent(lblNewLabel_2).addContainerGap(22, Short.MAX_VALUE)));
		panel_13.setLayout(gl_panel_13);
		panel_5.setLayout(gl_panel_5);
		panel_3.setLayout(gl_panel_3);
		panel_4.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 43, 716, 709);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_4.add(scrollPane);

		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
//		panel_19.se
		scrollPane.setViewportView(panel_19);
		panel_19.setLayout(null);

		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.GRAY);
		panel_20.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"This Week's Highlights", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_20.setBounds(16, 13, 660, 282);
		panel_19.add(panel_20);
		panel_20.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(25, 38, 188, 36);
		panel_20.add(panel_8);
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Highest Rated Item");
		lblNewLabel_7.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel_7.setForeground(new Color(0, 0, 128));
		lblNewLabel_7.setBounds(20, 0, 168, 36);
		panel_8.add(lblNewLabel_7);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(25, 74, 188, 177);
		panel_20.add(panel_7);
		panel_7.setBackground(new Color(25, 25, 112));

		JLabel lblNewLabel_4 = new JLabel("");
		// lblNewLabel_4.setIcon(new
		// ImageIcon(Home.class.getResource("/Icons/Star_rating_4_of_5.png")));
		// ImageIcon imageIcon = new ImageIcon(new
		// ImageIcon("/Icons/Star_rating_4_of_5.png").getImage().getScaledInstance(50,
		// 20, Image.SCALE_DEFAULT));
		lblNewLabel_4.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Icons/Star_rating_4.5_of_5.png"))
						.getImage().getScaledInstance(90, 15, Image.SCALE_SMOOTH)));

		JLabel lblNewLabel_5 = new JLabel("");
		// lblNewLabel_5.setIcon(new
		// ImageIcon(Home.class.getResource("/Icons/Hamburger-PNG-Photos.png")));
		lblNewLabel_5.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Icons/Hamburger-PNG-Photos.png"))
						.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)));

		JLabel lblNewLabel_6 = new JLabel("Beese Churger");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		// lblNewLabel_4.setIcon(imageIcon);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7
				.setHorizontalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup().addContainerGap(49, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 100,
										GroupLayout.PREFERRED_SIZE)
								.addGap(39))
						.addGroup(gl_panel_7.createSequentialGroup().addGap(18).addComponent(lblNewLabel_5)
								.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(
								Alignment.TRAILING, gl_panel_7.createSequentialGroup()
										.addContainerGap(52, Short.MAX_VALUE).addComponent(lblNewLabel_6,
												GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGap(32)));
		gl_panel_7.setVerticalGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE).addGap(18)
						.addComponent(lblNewLabel_6).addGap(13)));
		panel_7.setLayout(gl_panel_7);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(237, 74, 188, 177);
		panel_20.add(panel_9);
		panel_9.setBackground(new Color(25, 25, 112));

		JLabel label = new JLabel("");
		// label.setIcon(new
		// ImageIcon(Home.class.getResource("/Icons/Star_rating_1.5_of_5.png")));
		label.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Icons/Star_rating_1.5_of_5.png"))
						.getImage().getScaledInstance(90, 15, Image.SCALE_SMOOTH)));

		JLabel label_1 = new JLabel("");

		JLabel lblBu = new JLabel("Hot Wings");
		lblBu.setHorizontalAlignment(SwingConstants.CENTER);
		lblBu.setForeground(Color.WHITE);
		lblBu.setFont(new Font("Lucida Sans", Font.BOLD, 12));

		JLabel label_3 = new JLabel("");
		// label_3.setIcon(new ImageIcon(Home.class.getResource("/Icons/bufff.png")));
		label_3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Icons/bufff.png"))
				.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(gl_panel_9.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_9.createSequentialGroup().addContainerGap(49, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(39))
				.addGroup(gl_panel_9.createSequentialGroup().addGap(18).addComponent(label_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(gl_panel_9.createSequentialGroup().addContainerGap(44, Short.MAX_VALUE)
						.addComponent(lblBu, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE).addGap(40)));
		gl_panel_9.setVerticalGroup(gl_panel_9.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_9
				.createSequentialGroup().addContainerGap()
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_9.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE).addComponent(label_3))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblBu).addGap(12)));
		panel_9.setLayout(gl_panel_9);

		JPanel panel_10 = new JPanel();
		panel_10.setBounds(237, 38, 188, 36);
		panel_20.add(panel_10);
		panel_10.setLayout(null);
		panel_10.setBackground(Color.WHITE);

		JLabel lblNeedsImprovement = new JLabel("Needs Improvement");
		lblNeedsImprovement.setForeground(new Color(0, 0, 128));
		lblNeedsImprovement.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNeedsImprovement.setBounds(27, 0, 161, 36);
		panel_10.add(lblNeedsImprovement);

		JPanel panel_17 = new JPanel();
		panel_17.setBounds(446, 74, 188, 177);
		panel_20.add(panel_17);
		panel_17.setBackground(new Color(25, 25, 112));

		JLabel label_4 = new JLabel("");
//		label_4.setIcon(new ImageIcon(Home.class.getResource("/Icons/Star_rating_4_of_5.png")));
		label_4.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Icons/Star_rating_4_of_5.png"))
						.getImage().getScaledInstance(90, 15, Image.SCALE_SMOOTH)));

		JLabel label_5 = new JLabel("");

		JLabel label_6 = new JLabel("");

		JLabel lblJasonJ = new JLabel("Jason J.");
		lblJasonJ.setHorizontalAlignment(SwingConstants.CENTER);
		lblJasonJ.setForeground(Color.WHITE);
		lblJasonJ.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		GroupLayout gl_panel_17 = new GroupLayout(panel_17);
		gl_panel_17.setHorizontalGroup(gl_panel_17.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_17.createSequentialGroup().addContainerGap(49, Short.MAX_VALUE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(39))
				.addGroup(gl_panel_17.createSequentialGroup().addGap(18).addComponent(label_5)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(gl_panel_17.createSequentialGroup().addContainerGap(44, Short.MAX_VALUE)
						.addComponent(lblJasonJ, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addGap(40)));
		gl_panel_17.setVerticalGroup(gl_panel_17.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_17
				.createSequentialGroup().addContainerGap()
				.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_17.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE).addComponent(label_6))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblJasonJ).addGap(12)));
		panel_17.setLayout(gl_panel_17);

		JPanel panel_18 = new JPanel();
		panel_18.setBounds(446, 38, 188, 36);
		panel_20.add(panel_18);
		panel_18.setLayout(null);
		panel_18.setBackground(Color.WHITE);

		JLabel lblHighestRatedWaiter = new JLabel("Highest Rated Waiter");
		lblHighestRatedWaiter.setForeground(new Color(0, 0, 128));
		lblHighestRatedWaiter.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblHighestRatedWaiter.setBounds(20, 0, 168, 36);
		panel_18.add(lblHighestRatedWaiter);

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.DARK_GRAY);
		panel_23.setBorder(new CompoundBorder());
		panel_23.setBounds(814, 43, 1048, 709);
		panel_4.add(panel_23);
		panel_23.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 97, 1029, 601);
		panel_23.add(scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panel_21 = new JPanel();
		scrollPane_1.setViewportView(panel_21);
		panel_21.setBackground(Color.WHITE);
		panel_21.setLayout(null);

		JPanel panel_22 = new JPanel();
		panel_22.setBounds(6, 15, 1029, 83);
		panel_23.add(panel_22);
		panel_22.setBackground(Color.RED);
		panel_22.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Reviews");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Gill Sans MT", Font.BOLD, 30));
		lblNewLabel_9.setBounds(25, 10, 225, 68);
		panel_22.add(lblNewLabel_9);
		panel_2.setLayout(null);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(1661, 10, 75, 23);
		panel_11.setLayout(null);
		panel_2.add(panel_11);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 20, 20);
		panel_11.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/gui/Icons/user_filled_20px.png")));

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(36, 0, 29, 20);
		panel_11.add(lblUser);
		lblUser.setFont(new Font("Arial", Font.BOLD, 13));

		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(1762, 10, 75, 23);
		panel_2.add(panel_12);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(55, 0, 20, 20);
		panel_12.add(lblNewLabel_1);
		lblNewLabel_1
				.setIcon(new ImageIcon(Home.class.getResource("/gui/Icons/icons8_logout_rounded_left_35px_2.png")));

		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setFont(new Font("Arial", Font.BOLD, 13));
		lblLogout.setBounds(10, 0, 55, 20);
		panel_12.add(lblLogout);

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		panel_15.setBounds(0, 0, 45, 43);
		panel_2.add(panel_15);

		JLabel lblNewLabel_8 = new JLabel("");
		panel_15.add(lblNewLabel_8);
		lblNewLabel_8
				.setIcon(new ImageIcon(Home.class.getResource("/gui/Icons/icons8_year_of_rooster_filled_35px_1.png")));

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(25, 25, 112));
		panel_16.setBounds(44, 0, 130, 43);
		panel_2.add(panel_16);

		JLabel lblElChicko = new JLabel("El Chicko");
		panel_16.add(lblElChicko);
		lblElChicko.setForeground(new Color(255, 255, 255));
		lblElChicko.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 23));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
