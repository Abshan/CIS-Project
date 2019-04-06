package main.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Servers.serverInterface;

public class testWindow {

	private JFrame frame;
	serverInterface serv;

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
		frame.setBounds(100, 100, 720, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 688, 632);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnClickMe = new JButton("Click Me");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = "rmi://localhost/test";
				int tot;
				int avg;
				int favg;
				int op;
				try {
					serv = (serverInterface) Naming.lookup(name);
					tot = serv.getValueOf("Ambiance", "Comfort");
					avg = serv.getAvgValueOf("Ambiance", "Comfort");
					favg = serv.getValueOfFood("Portion", "Burger");
					op = serv.getValueOfOpinion("Maybe");
					JOptionPane.showMessageDialog(null, "Total is : " + tot +"\n Avg is: " + avg+"\n Food Avg is: " + favg +"\n opinion Avg is: " + op);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnClickMe.setBounds(273, 272, 129, 41);
		panel.add(btnClickMe);
	}
}
