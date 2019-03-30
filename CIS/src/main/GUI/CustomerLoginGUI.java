package main.GUI;
//
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CustomerLoginGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLoginGUI window = new CustomerLoginGUI();
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
	public CustomerLoginGUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 1920);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(Color.GRAY);
		mainpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5),
				"Restaurant Reviewing Sytem", TitledBorder.CENTER, TitledBorder.TOP));
		mainpanel.setBounds(0, 0, 1048, 1832);
		frame.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(244, 636, 520, 560);
		panel.setBackground(Color.GRAY);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5), "",
				TitledBorder.CENTER, TitledBorder.TOP));
		mainpanel.add(panel);
		panel.setLayout(null);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		lblLogo.setAlignmentY(Component.TOP_ALIGNMENT);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(200, 89, 116, 116);
		panel.add(lblLogo);

		JTextArea txtpassword = new JTextArea();
		txtpassword.setFont(new Font("Monospaced", Font.PLAIN, 35));
		txtpassword.setBounds(85, 280, 350, 50);
		panel.add(txtpassword);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				int number = txtpassword.tos
				
				CustomerGUI window = new CustomerGUI();
				window.frame.setVisible(true);
				frame.dispose();

			}
		});

		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnConfirm.setBounds(175, 388, 170, 45);
		panel.add(btnConfirm);

		JLabel lblEnterReceiptNumber = new JLabel("*Enter Receipt Number");
		lblEnterReceiptNumber.setForeground(Color.LIGHT_GRAY);
		lblEnterReceiptNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterReceiptNumber.setBounds(85, 330, 350, 30);
		panel.add(lblEnterReceiptNumber);
	}
}
