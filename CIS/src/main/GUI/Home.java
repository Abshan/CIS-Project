package main.GUI;

//
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
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
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import main.Servers.serverInterface;

import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

// comment
public class Home {

	public JFrame frame;
	serverInterface serv;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

//		frame.setSize(1400, 971);
		frame.setSize(1280, 971);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 128, 128));
		panel_4.setLayout(null);

//	    panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		panel_4.setPreferredSize(new Dimension(491, 800));

//	    JScrollPane scrollPaneCenter = new JScrollPane(panel_4,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		/*
		 * String name = "rmi://localhost/test"; String question1 = ""; String question2
		 * = ""; String question3 = ""; String question4 = ""; String question5 = "";
		 * try { serv = (serverInterface) Naming.lookup(name);
		 * 
		 * Vector<String> que = new Vector<String>(serv.questions()); question1 =
		 * que.get(0).toString(); question2 = que.get(1).toString(); question3 =
		 * que.get(2).toString(); question4 = que.get(3).toString(); question5 =
		 * que.get(4).toString(); } catch (Exception e) { e.printStackTrace(); }
		 */
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(151, Short.MAX_VALUE))
		);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1264, 800);
		panel_4.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel1);
		panel1.setPreferredSize(new Dimension(290, 1200));

		JPanel dypan1 = new JPanel();
		dypan1.setBackground(Color.LIGHT_GRAY);

		JPanel dypan2 = new JPanel();
		dypan2.setBackground(Color.LIGHT_GRAY);

		JPanel dypan3 = new JPanel();
		dypan3.setBackground(Color.GRAY);

		JPanel dypan4 = new JPanel();
		dypan4.setBackground(Color.GRAY);
		
		JPanel dypan5 = new JPanel();
		dypan5.setBackground(Color.LIGHT_GRAY);
		
		JPanel dypan8 = new JPanel();
		dypan8.setBackground(Color.LIGHT_GRAY);
		
		JPanel dypan6 = new JPanel();
		dypan6.setBackground(Color.GRAY);
		
		JPanel dypan7 = new JPanel();
		dypan7.setBackground(Color.GRAY);
		
		JPanel compan = new JPanel();
		compan.setLayout(null);
		compan.setSize(1026, 164);
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(0, 0, 1026, 256);
		compan.add(scrollPane2);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		JPanel panelcom = new JPanel();
		panelcom.setBackground(Color.WHITE);
		scrollPane2.setViewportView(panelcom);
		panelcom.setPreferredSize(new Dimension(1026, 450));


		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(dypan1, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
									.addGap(82)
									.addComponent(dypan2, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel1.createSequentialGroup()
									.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
										.addComponent(dypan3, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
										.addComponent(dypan5, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
										.addComponent(dypan6, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE))
									.addGap(82)
									.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
										.addComponent(dypan7, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
										.addComponent(dypan4, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
										.addComponent(dypan8, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(104)
							.addComponent(compan, GroupLayout.PREFERRED_SIZE, 1026, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(dypan1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(dypan2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(dypan3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(dypan4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
						.addComponent(dypan8, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(dypan5, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(dypan6, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(dypan7, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(compan, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		panel1.setLayout(gl_panel1);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(121).addComponent(panel,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		frame.getContentPane().setLayout(groupLayout);

	}
}
