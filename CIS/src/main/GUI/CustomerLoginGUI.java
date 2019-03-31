package main.GUI;

//
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import main.Servers.review;
import main.Servers.serverInterface;

public class CustomerLoginGUI {

	public JFrame frame;
	serverInterface serv;

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

		String name = "rmi://localhost/test";

		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 1920);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

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

		JLabel lblEnterReceiptNumber = new JLabel("*Enter Receipt Number");
		lblEnterReceiptNumber.setForeground(Color.LIGHT_GRAY);
		lblEnterReceiptNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterReceiptNumber.setBounds(85, 330, 350, 30);
		panel.add(lblEnterReceiptNumber);

		JTextField txtpassword = new JTextField();
		txtpassword.setBounds(85, 293, 350, 39);
		panel.add(txtpassword);
		txtpassword.setColumns(10);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String no = txtpassword.getText();
				int number;

				if (txtpassword.getText().equals("")) {
					lblEnterReceiptNumber.setText("Enter Order Number");
				} else {

					try {
						serv = (serverInterface) Naming.lookup(name);

						number = Integer.parseInt(no);

						if (serv.invoiceValidation(number)) {
							review.orderNo = number;
							CustomerGUI window = new CustomerGUI();
							window.frame.setVisible(true);
							frame.dispose();
						}else {
							lblEnterReceiptNumber.setText("Enter a Valid Order Number");
							txtpassword.setText("");
						}

					} catch (Exception e) {
						lblEnterReceiptNumber.setText("Enter a Valid Order Number");
					}

				}

			}
		});

		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnConfirm.setBounds(175, 388, 170, 45);
		panel.add(btnConfirm);

	}
}
