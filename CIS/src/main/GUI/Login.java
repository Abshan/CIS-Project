package main.GUI;

import java.awt.Color;
//
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import main.Servers.serverInterface;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frame;
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

		String name = "rmi://localhost/test";

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1248, 658);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLogo = new JLabel("     Logo");
		lblLogo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLogo.setBounds(565, 106, 150, 150);
		panel.add(lblLogo);

		JTextField txtUsername = new JTextField();
		txtUsername.setBounds(520, 284, 236, 39);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		JTextField txtPassword = new JTextField();
		txtPassword.setBounds(520, 338, 236, 39);
		panel.add(txtPassword);
		txtPassword.setColumns(10);

		JLabel lblInvalid = new JLabel("");
		lblInvalid.setForeground(Color.GRAY);
		lblInvalid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInvalid.setBounds(515, 377, 250, 25);
		panel.add(lblInvalid);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(580, 408, 97, 41);
		panel.add(btnLogin);
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
