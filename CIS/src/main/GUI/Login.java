package main.GUI;

/*
 * Author : Kowshigan Senthilrajah
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import main.Servers.review;
import main.Servers.serverInterface;
import java.awt.SystemColor;

public class Login {

	public JFrame frame;
	serverInterface serv;

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

		String name = "rmi://192.168.43.123:8050/test";

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(0, 0, 1274, 658);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/main/icons/admin.png")));
		lblLogo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLogo.setBounds(565, 106, 150, 150);
		panel.add(lblLogo);

		JTextField txtUsername = new JTextField();
		txtUsername.setBounds(520, 284, 236, 39);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(520, 338, 236, 39);
		panel.add(txtPassword);
		txtPassword.setColumns(10);

		JLabel lblInvalid = new JLabel("");
		lblInvalid.setForeground(Color.GRAY);
		lblInvalid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInvalid.setBounds(515, 377, 250, 25);
		panel.add(lblInvalid);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnLogin.setBackground(SystemColor.activeCaption);
		btnLogin.setBounds(583, 405, 122, 54);
		panel.add(btnLogin);

		/*
		 * Initialize login button
		 */
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String username = txtUsername.getText();
				String password = txtPassword.getText();

				if (txtUsername.getText().equals("") || txtPassword.getText().equals("")) {
					lblInvalid.setText("Enter Username & Password");
				} else {

					try {

						serv = (serverInterface) Naming.lookup(name);

						if (serv.loginConfirmation(username, password)) {

							lblInvalid.setText("");

							Home window = new Home();
							window.frame.setVisible(true);
							frame.dispose();

						} else {
							lblInvalid.setText("*Invalid Username or Password ");
							txtPassword.setText("");
						}

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Connection Error!");
					}

				}
			}
		});

	}
}
