package main.GUI;

import java.awt.BorderLayout;
import main.GUI.Home;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import main.Servers.serverInterface;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class testWindow {

	public JFrame frame;
	serverInterface serv;
	Home hom = new Home();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testWindow window = new testWindow();
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
	public testWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setSize(1132, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(1132, 559);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel dypan = new JPanel();
		dypan.setLocation(10, 77);
		dypan.setSize(1112, 471);
		panel.add(dypan);
		
		
		
//		String closeb = "";
		
		
		if (hom.chartFlag == 1) {
			dypan.add(hom.cp1, BorderLayout.CENTER);
			dypan.validate();
		} else if (hom.chartFlag == 2) {
			dypan.add(hom.cp3, BorderLayout.CENTER);
			dypan.validate();
		} else if (hom.chartFlag == 3) {
			dypan.add(hom.cp4, BorderLayout.CENTER);
			dypan.validate();
		} else if (hom.chartFlag == 4) {
			dypan.add(hom.cp6, BorderLayout.CENTER);
			dypan.validate();
		}
		
		JButton btnColse = new JButton("Close");
		btnColse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnColse.setBounds(995, 25, 89, 23);
		panel.add(btnColse);
		
//		ChartPanel cp1 = new ChartPanel(chart4);
//		dypan.add(cp1, BorderLayout.CENTER);
//		dypan.validate();
		
//		JButton btnClickMe = new JButton("Click Me");
//		btnClickMe.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				String name = "rmi://localhost/test";
//				int tot;
//				int avg;
//				int favg;
//				int op;
//				try {
//					serv = (serverInterface) Naming.lookup(name);
//					tot = serv.getValueOf("Ambiance", "Comfort");
//					avg = serv.getAvgValueOf("Ambiance", "Comfort");
//					favg = serv.getValueOfFood("Portion", "Burger");
//					op = serv.getValueOfOpinion("Maybe");
//					JOptionPane.showMessageDialog(null, "Total is : " + tot +"\n Avg is: " + avg+"\n Food Avg is: " + favg +"\n opinion Avg is: " + op);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		btnClickMe.setBounds(273, 272, 129, 41);
//		panel.add(btnClickMe);
		
		
		
		
	}
}
