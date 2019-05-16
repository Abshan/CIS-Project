package main.GUI;

/*
 * Author : Kowshigan Senthilrajah
 */

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
import javax.swing.border.TitledBorder;

import main.Servers.review;
import main.Servers.serverInterface;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class CustomerLoginGUI implements ActionListener {

	public JFrame frame;
	private JLabel messagelbl;
	private JButton btnConfirm;
	private JButton button_no1;
	private JButton button_no2;
	private JButton button_no3;
	private JButton button_no4;
	private JButton button_no5;
	private JButton button_no6;
	private JButton button_no7;
	private JButton button_no8;
	private JButton button_no9;
	private JButton button_no0;
	private JButton button_clear;
	private JButton button_backspace;
	private JTextField invoiceNo;
	serverInterface serv;
	private String name = review.name;

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button_no0) {
			invoiceNo.setText(invoiceNo.getText() + "0");
		}

		if (e.getSource() == button_no1) {
			invoiceNo.setText(invoiceNo.getText() + "1");
		}

		if (e.getSource() == button_no2) {
			invoiceNo.setText(invoiceNo.getText() + "2");
		}

		if (e.getSource() == button_no3) {
			invoiceNo.setText(invoiceNo.getText() + "3");
		}

		if (e.getSource() == button_no4) {
			invoiceNo.setText(invoiceNo.getText() + "4");
		}

		if (e.getSource() == button_no5) {
			invoiceNo.setText(invoiceNo.getText() + "5");
		}

		if (e.getSource() == button_no6) {
			invoiceNo.setText(invoiceNo.getText() + "6");
		}

		if (e.getSource() == button_no7) {
			invoiceNo.setText(invoiceNo.getText() + "7");
		}

		if (e.getSource() == button_no8) {
			invoiceNo.setText(invoiceNo.getText() + "8");
		}

		if (e.getSource() == button_no9) {
			invoiceNo.setText(invoiceNo.getText() + "9");
		}

		if (e.getSource() == button_clear) {
			invoiceNo.setText("");
		}

		if (e.getSource() == button_backspace) {
			if (invoiceNo.getText().equals("")) {
				// Do nothing
			} else {
				invoiceNo.setText(invoiceNo.getText().substring(0, invoiceNo.getText().length() - 1));
			}
		}

		if (e.getSource() == btnConfirm) {

			/*
			 * Initialize confirm button for invoice number validation
			 */

			String no = invoiceNo.getText();
			int number;

			if (invoiceNo.getText().equals("")) {
				messagelbl.setText("Enter Order Number");
			} else {

				try {
					serv = (serverInterface) Naming.lookup(name);

					number = Integer.parseInt(no);

					if (serv.invoiceValidation(number)) {
						review.orderNo = number;
						CustomerGUI window = new CustomerGUI();
						window.frame.setVisible(true);
						frame.dispose();
					} else {
						messagelbl.setText("*Enter a Valid Order Number");
					}

				} catch (Exception ex) {
					messagelbl.setText("*Enter a Valid Order Number");
				}

			}
		}
	}

	public CustomerLoginGUI() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 1920);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(new Color(119, 136, 153));
		mainpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5),
				"Restaurant Reviewing Sytem", TitledBorder.CENTER, TitledBorder.TOP));
		mainpanel.setBounds(0, 0, 1048, 1832);
		frame.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(244, 380, 520, 982);
		panel.setBackground(new Color(112, 128, 144));
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5), "",
				TitledBorder.CENTER, TitledBorder.TOP));
		mainpanel.add(panel);
		panel.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(CustomerLoginGUI.class.getResource("/main/icons/logoFinal.png")));
		lblLogo.setAlignmentY(Component.TOP_ALIGNMENT);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(164, 47, 192, 205);
		panel.add(lblLogo);

		messagelbl = new JLabel("*Enter Receipt Number");
		messagelbl.setForeground(Color.LIGHT_GRAY);
		messagelbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		messagelbl.setBounds(85, 330, 350, 30);
		panel.add(messagelbl);

		invoiceNo = new JTextField();
		invoiceNo.setEditable(false);
		invoiceNo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		invoiceNo.setBounds(85, 280, 357, 52);
		panel.add(invoiceNo);
		invoiceNo.setColumns(10);

		btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(SystemColor.activeCaption);
		btnConfirm.setFont(new Font("Arial", Font.BOLD, 34));
		btnConfirm.setBounds(180, 889, 171, 65);
		panel.add(btnConfirm);
		btnConfirm.addActionListener(this);

		JPanel Num_panel = new JPanel();
		Num_panel.setBounds(76, 374, 373, 503);
		panel.add(Num_panel);
		Num_panel.setBackground(Color.GRAY);
		Num_panel.setLayout(null);

		button_no0 = new JButton("0");
		button_no0.setBackground(SystemColor.textHighlight);
		button_no0.setForeground(Color.WHITE);
		button_no0.setFont(new Font("Arial", Font.BOLD, 70));
		button_no0.setBounds(131, 379, 110, 110);
		Num_panel.add(button_no0);
		button_no0.addActionListener(this);

		button_no1 = new JButton("1");
		button_no1.setBackground(SystemColor.textHighlight);
		button_no1.setForeground(Color.WHITE);
		button_no1.setFont(new Font("Arial", Font.BOLD, 70));
		button_no1.setBounds(10, 17, 110, 110);
		Num_panel.add(button_no1);
		button_no1.addActionListener(this);

		button_no2 = new JButton("2");
		button_no2.setBackground(SystemColor.textHighlight);
		button_no2.setForeground(Color.WHITE);
		button_no2.setFont(new Font("Arial", Font.BOLD, 70));
		button_no2.setBounds(131, 17, 110, 110);
		Num_panel.add(button_no2);
		button_no2.addActionListener(this);

		button_no3 = new JButton("3");
		button_no3.setBackground(SystemColor.textHighlight);
		button_no3.setForeground(Color.WHITE);
		button_no3.setFont(new Font("Arial", Font.BOLD, 70));
		button_no3.setBounds(252, 17, 110, 110);
		Num_panel.add(button_no3);
		button_no3.addActionListener(this);

		button_no4 = new JButton("4");
		button_no4.setBackground(SystemColor.textHighlight);
		button_no4.setForeground(Color.WHITE);
		button_no4.setFont(new Font("Arial", Font.BOLD, 70));
		button_no4.setBounds(10, 136, 110, 110);
		Num_panel.add(button_no4);
		button_no4.addActionListener(this);

		button_no5 = new JButton("5");
		button_no5.setBackground(SystemColor.textHighlight);
		button_no5.setForeground(Color.WHITE);
		button_no5.setFont(new Font("Arial", Font.BOLD, 70));
		button_no5.setBounds(131, 136, 110, 110);
		Num_panel.add(button_no5);
		button_no5.addActionListener(this);

		button_no6 = new JButton("6");
		button_no6.setBackground(SystemColor.textHighlight);
		button_no6.setForeground(Color.WHITE);
		button_no6.setFont(new Font("Arial", Font.BOLD, 70));
		button_no6.setBounds(252, 136, 110, 110);
		Num_panel.add(button_no6);
		button_no6.addActionListener(this);

		button_no7 = new JButton("7");
		button_no7.setBackground(SystemColor.textHighlight);
		button_no7.setForeground(Color.WHITE);
		button_no7.setFont(new Font("Arial", Font.BOLD, 70));
		button_no7.setBounds(10, 258, 110, 110);
		Num_panel.add(button_no7);
		button_no7.addActionListener(this);

		button_no8 = new JButton("8");
		button_no8.setBackground(SystemColor.textHighlight);
		button_no8.setForeground(Color.WHITE);
		button_no8.setFont(new Font("Arial", Font.BOLD, 70));
		button_no8.setBounds(131, 258, 110, 110);
		Num_panel.add(button_no8);
		button_no8.addActionListener(this);

		button_no9 = new JButton("9");
		button_no9.setBackground(SystemColor.textHighlight);
		button_no9.setForeground(Color.WHITE);
		button_no9.setFont(new Font("Arial", Font.BOLD, 70));
		button_no9.setBounds(252, 258, 110, 110);
		Num_panel.add(button_no9);
		button_no9.addActionListener(this);

		button_clear = new JButton("C");
		button_clear.setBackground(new Color(50, 205, 50));
		button_clear.setForeground(Color.WHITE);
		button_clear.setFont(new Font("Arial", Font.BOLD, 70));
		button_clear.setBounds(10, 379, 110, 110);
		Num_panel.add(button_clear);
		button_clear.addActionListener(this);

		button_backspace = new JButton("<");
		button_backspace.setBackground(SystemColor.textHighlight);
		button_backspace.setForeground(Color.WHITE);
		button_backspace.setFont(new Font("Arial", Font.BOLD, 70));
		button_backspace.setBounds(252, 379, 110, 110);
		Num_panel.add(button_backspace);
		button_backspace.addActionListener(this);

	}

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
}
