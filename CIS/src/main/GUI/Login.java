package main.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtPassword;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
//		frame.setSize(623, 422);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 720);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtPassword = new JTextField(10);
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		txtPassword.setText("Password");
		txtPassword.setBounds(534, 299, 211, 19);
		panel.add(txtPassword);

		txtUsername = new JTextField(10);
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setText("Username");
		txtUsername.setBounds(534, 265, 211, 19);
		panel.add(txtUsername);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(574, 164, 143, 61);
		panel.add(panel_1);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Home home = new Home();
				home.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(600, 328, 85, 21);
		panel.add(btnNewButton);
	}
}
