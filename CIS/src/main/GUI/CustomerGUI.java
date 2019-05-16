package main.GUI;

/*
 * Author : Mohamed Abshan
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.Servers.review;
import main.Servers.serverInterface;

public class CustomerGUI implements ActionListener {

	// Customer GUI Options
	private JButton btnConfirm;
	private JButton btnCancel;
	private JSlider taste_sli;
	private JSlider plating_sli;
	private JSlider portion_sli;
	private JSlider servetime_sli;
	private JSlider waitingstaff_sli;
	private JSlider cleanliness_sli;
	private JSlider lighting_sli;
	private JSlider comfort_sli;
	private JCheckBox yes_chckbx;
	private JCheckBox no_chckbx;
	private JCheckBox maybe_chckbx;

	// Keyboard Buttons
	private Boolean shift = false;
	private JButton btnQ;
	private JButton btnW;
	private JButton btnE;
	private JButton btnR;
	private JButton btnT;
	private JButton btnY;
	private JButton btnU;
	private JButton btnI;
	private JButton btnO;
	private JButton btnP;
	private JButton btnA;
	private JButton btnS;
	private JButton btnD;
	private JButton btnF;
	private JButton btnG;
	private JButton btnH;
	private JButton btnJ;
	private JButton btnK;
	private JButton btnL;
	private JButton btnZ;
	private JButton btnX;
	private JButton btnC;
	private JButton btnV;
	private JButton btnB;
	private JButton btnN;
	private JButton btnM;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private JButton btnComma;
	private JButton btnEnter;
	private JButton btnBackspace;
	private JButton btnDone;
	private JButton btnShift;
	private JButton btnSpace;
	private JButton btnFullstop;

	public JFrame frame;
	private JPanel blurpane;
	private JPanel greetingPanel;
	serverInterface serv;
	private String op = null;
	private JTextArea textArea;
	private JTextArea message_txt;
	private String name = "rmi://192.168.43.123:1102/test";

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnConfirm) {

			/*
			 * Confirm button coding to insert values into the database
			 */

			Date now = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(now);

			int taste = taste_sli.getValue();
			int plating = plating_sli.getValue();
			int portion = portion_sli.getValue();
			int serveTime = servetime_sli.getValue();
			int waitingStaff = waitingstaff_sli.getValue();
			int cleanliness = cleanliness_sli.getValue();
			int lighting = lighting_sli.getValue();
			int comfort = comfort_sli.getValue();
			String message = message_txt.getText();

			try {
				serv.userInput(review.orderNo, taste, plating, portion, serveTime, waitingStaff, cleanliness, lighting,
						comfort, op, message, date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			/*
			 * Reseting GUI values
			 */

			taste_sli.setValue(3);
			plating_sli.setValue(3);
			portion_sli.setValue(3);
			servetime_sli.setValue(3);
			waitingstaff_sli.setValue(3);
			cleanliness_sli.setValue(3);
			lighting_sli.setValue(3);
			comfort_sli.setValue(3);
			message_txt.setText("");
			yes_chckbx.setSelected(false);
			no_chckbx.setSelected(false);
			maybe_chckbx.setSelected(false);
			review.orderNo = 0;

				JOptionPane.showOptionDialog(null, "Thank You For Your Time, Have a Good Day!", " ",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {}, null);
				

			CustomerLoginGUI window = new CustomerLoginGUI();
			window.frame.setVisible(true);
			frame.dispose();
		}

		if (e.getSource() == btnCancel) {

			/*
			 * Cancel button coding
			 */

			taste_sli.setValue(3);
			plating_sli.setValue(3);
			portion_sli.setValue(3);
			servetime_sli.setValue(3);
			waitingstaff_sli.setValue(3);
			cleanliness_sli.setValue(3);
			lighting_sli.setValue(3);
			comfort_sli.setValue(3);
			message_txt.setText("");
			yes_chckbx.setSelected(false);
			no_chckbx.setSelected(false);
			maybe_chckbx.setSelected(false);
			review.orderNo = 0;

			CustomerLoginGUI window = new CustomerLoginGUI();
			window.frame.setVisible(true);
			frame.dispose();
		}

		/*
		 * User opinion check_box validation and controling
		 */

		if (e.getSource() == yes_chckbx) {
			if (yes_chckbx.isSelected()) {
				no_chckbx.setSelected(false);
				maybe_chckbx.setSelected(false);
				op = "Yes";
			}
		}

		if (e.getSource() == no_chckbx) {
			if (no_chckbx.isSelected()) {
				yes_chckbx.setSelected(false);
				maybe_chckbx.setSelected(false);
				op = "No";
			}
		}

		if (e.getSource() == maybe_chckbx) {
			if (maybe_chckbx.isSelected()) {
				no_chckbx.setSelected(false);
				yes_chckbx.setSelected(false);
				op = "Maybe";
			}
		}

		/*
		 * Keyboard implementation
		 */

		if (e.getSource() == btnShift) {
			if (shift == false) {
				shift = true;
				btnShift.setBackground(SystemColor.activeCaption);
				btnQ.setText("Q");
				btnW.setText("W");
				btnE.setText("E");
				btnR.setText("R");
				btnT.setText("T");
				btnY.setText("Y");
				btnU.setText("U");
				btnI.setText("I");
				btnO.setText("O");
				btnP.setText("P");
				btnA.setText("A");
				btnS.setText("S");
				btnD.setText("D");
				btnF.setText("F");
				btnG.setText("G");
				btnH.setText("H");
				btnJ.setText("J");
				btnK.setText("K");
				btnL.setText("L");
				btnZ.setText("Z");
				btnX.setText("X");
				btnC.setText("C");
				btnV.setText("V");
				btnB.setText("B");
				btnN.setText("N");
				btnM.setText("M");

			} else {
				shift = false;
				btnShift.setBackground(SystemColor.inactiveCaptionBorder);

				btnQ.setText("q");
				btnW.setText("w");
				btnE.setText("e");
				btnR.setText("r");
				btnT.setText("t");
				btnY.setText("y");
				btnU.setText("u");
				btnI.setText("i");
				btnO.setText("o");
				btnP.setText("p");
				btnA.setText("a");
				btnS.setText("s");
				btnD.setText("d");
				btnF.setText("f");
				btnG.setText("g");
				btnH.setText("h");
				btnJ.setText("j");
				btnK.setText("k");
				btnL.setText("l");
				btnZ.setText("z");
				btnX.setText("x");
				btnC.setText("c");
				btnV.setText("v");
				btnB.setText("b");
				btnN.setText("n");
				btnM.setText("m");
			}

		}

		if (e.getSource() == btnQ) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "q");
			} else {
				textArea.setText(textArea.getText() + "Q");
			}
		}

		if (e.getSource() == btnW) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "w");
			} else {
				textArea.setText(textArea.getText() + "W");
			}
		}

		if (e.getSource() == btnE) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "e");
			} else {
				textArea.setText(textArea.getText() + "E");
			}
		}

		if (e.getSource() == btnR) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "r");
			} else {
				textArea.setText(textArea.getText() + "R");
			}
		}

		if (e.getSource() == btnT) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "t");
			} else {
				textArea.setText(textArea.getText() + "T");
			}
		}

		if (e.getSource() == btnY) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "y");
			} else {
				textArea.setText(textArea.getText() + "Y");
			}
		}

		if (e.getSource() == btnU) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "u");
			} else {
				textArea.setText(textArea.getText() + "U");
			}
		}

		if (e.getSource() == btnI) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "i");
			} else {
				textArea.setText(textArea.getText() + "I");
			}
		}

		if (e.getSource() == btnO) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "o");
			} else {
				textArea.setText(textArea.getText() + "O");
			}
		}

		if (e.getSource() == btnP) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "p");
			} else {
				textArea.setText(textArea.getText() + "P");
			}
		}

		if (e.getSource() == btnA) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "a");
			} else {
				textArea.setText(textArea.getText() + "A");
			}
		}

		if (e.getSource() == btnS) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "s");
			} else {
				textArea.setText(textArea.getText() + "S");
			}
		}

		if (e.getSource() == btnD) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "d");
			} else {
				textArea.setText(textArea.getText() + "D");
			}
		}

		if (e.getSource() == btnF) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "f");
			} else {
				textArea.setText(textArea.getText() + "F");
			}
		}

		if (e.getSource() == btnG) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "g");
			} else {
				textArea.setText(textArea.getText() + "G");
			}
		}

		if (e.getSource() == btnH) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "h");
			} else {
				textArea.setText(textArea.getText() + "H");
			}
		}

		if (e.getSource() == btnJ) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "j");
			} else {
				textArea.setText(textArea.getText() + "J");
			}
		}

		if (e.getSource() == btnK) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "k");
			} else {
				textArea.setText(textArea.getText() + "K");
			}
		}

		if (e.getSource() == btnL) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "l");
			} else {
				textArea.setText(textArea.getText() + "L");
			}
		}

		if (e.getSource() == btnZ) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "z");
			} else {
				textArea.setText(textArea.getText() + "Z");
			}
		}

		if (e.getSource() == btnX) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "x");
			} else {
				textArea.setText(textArea.getText() + "X");
			}
		}

		if (e.getSource() == btnC) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "c");
			} else {
				textArea.setText(textArea.getText() + "C");
			}
		}

		if (e.getSource() == btnV) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "v");
			} else {
				textArea.setText(textArea.getText() + "V");
			}
		}

		if (e.getSource() == btnB) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "b");
			} else {
				textArea.setText(textArea.getText() + "B");
			}
		}

		if (e.getSource() == btnN) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "n");
			} else {
				textArea.setText(textArea.getText() + "N");
			}
		}

		if (e.getSource() == btnM) {
			if (shift == false) {
				textArea.setText(textArea.getText() + "m");
			} else {
				textArea.setText(textArea.getText() + "M");
			}
		}

		if (e.getSource() == btn1) {
			textArea.setText(textArea.getText() + "1");
		}

		if (e.getSource() == btn2) {
			textArea.setText(textArea.getText() + "2");
		}

		if (e.getSource() == btn3) {
			textArea.setText(textArea.getText() + "3");
		}

		if (e.getSource() == btn4) {
			textArea.setText(textArea.getText() + "4");
		}

		if (e.getSource() == btn5) {
			textArea.setText(textArea.getText() + "5");
		}

		if (e.getSource() == btn6) {
			textArea.setText(textArea.getText() + "6");
		}

		if (e.getSource() == btn7) {
			textArea.setText(textArea.getText() + "7");
		}

		if (e.getSource() == btn8) {
			textArea.setText(textArea.getText() + "8");
		}

		if (e.getSource() == btn9) {
			textArea.setText(textArea.getText() + "9");
		}

		if (e.getSource() == btn0) {
			textArea.setText(textArea.getText() + "0");
		}

		if (e.getSource() == btnComma) {
			textArea.setText(textArea.getText() + ", ");
		}

		if (e.getSource() == btnFullstop) {
			textArea.setText(textArea.getText() + ".");
		}

		if (e.getSource() == btnSpace) {
			textArea.setText(textArea.getText() + " ");
		}

		if (e.getSource() == btnBackspace) {
			if (textArea.getText().equals("")) {
				// Do nothing
			} else {
				textArea.setText(textArea.getText().substring(0, textArea.getText().length() - 1));
			}
		}

		if (e.getSource() == btnEnter) {
			if (textArea.getText().equals("")) {
				// Do nothing
			} else {
				textArea.setText(textArea.getText() + "\n");
			}
		}

		if (e.getSource() == btnDone) {
			message_txt.setText(textArea.getText());
			blurpane.setVisible(false);
		}

	}

	public CustomerGUI() {
		initialize();
	}

	private void initialize() {
		/*
		 * Get questions from the server
		 */
		String question1 = "";
		String question2 = "";
		String question3 = "";
		String question4 = "";
		String question5 = "";
		try {
			serv = (serverInterface) Naming.lookup(name);

			Vector<String> que = new Vector<String>(serv.questions());
			question1 = que.get(0).toString();
			question2 = que.get(1).toString();
			question3 = que.get(2).toString();
			question4 = que.get(3).toString();
			question5 = que.get(4).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Customer GUI creation
		 */

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

		blurpane = new JPanel();
		blurpane.setVisible(false);
		blurpane.setBackground(new Color(0, 0, 0, 130));
		blurpane.setBounds(0, 0, 1048, 1832);
		mainpanel.add(blurpane);
		blurpane.setLayout(null);
		blurpane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				message_txt.setText(textArea.getText());
				blurpane.setVisible(false);
			}
		});

		JPanel innerpane = new JPanel();
		innerpane.setBackground(Color.GRAY);
		innerpane.setBounds(26, 382, 996, 816);
		blurpane.add(innerpane);
		innerpane.setLayout(null);
		innerpane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Do nothing when clicked
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel_1.setBounds(26, 351, 944, 437);
		innerpane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Do nothing when clicked
			}
		});
		
		greetingPanel = new JPanel();
		greetingPanel.setBackground(new Color(100, 149, 237));
		greetingPanel.setBounds(204, 116, 493, 141);
		panel_1.add(greetingPanel);
		greetingPanel.setLayout(null);
		greetingPanel.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Thank You For Your Time, \r\n");
		lblNewLabel.setBounds(87, 28, 344, 47);
		greetingPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Have a Good Day!");
		lblNewLabel_1.setBounds(87, 69, 235, 47);
		greetingPanel.add(lblNewLabel_1);

		btnQ = new JButton("q");
		btnQ.setBackground(SystemColor.menu);
		btnQ.setFont(new Font("Arial", Font.BOLD, 35));
		btnQ.setBounds(26, 118, 80, 64);
		panel_1.add(btnQ);
		btnQ.addActionListener(this);

		btnW = new JButton("w");
		btnW.setBackground(SystemColor.menu);
		btnW.setFont(new Font("Arial", Font.BOLD, 35));
		btnW.setBounds(115, 118, 80, 64);
		panel_1.add(btnW);
		btnW.addActionListener(this);

		btnE = new JButton("e");
		btnE.setBackground(SystemColor.menu);
		btnE.setFont(new Font("Arial", Font.BOLD, 35));
		btnE.setBounds(204, 118, 80, 64);
		panel_1.add(btnE);
		btnE.addActionListener(this);

		btnR = new JButton("r");
		btnR.setBackground(SystemColor.menu);
		btnR.setFont(new Font("Arial", Font.BOLD, 35));
		btnR.setBounds(292, 118, 80, 64);
		panel_1.add(btnR);
		btnR.addActionListener(this);

		btnT = new JButton("t");
		btnT.setBackground(SystemColor.menu);
		btnT.setFont(new Font("Arial", Font.BOLD, 35));
		btnT.setBounds(381, 118, 80, 64);
		panel_1.add(btnT);
		btnT.addActionListener(this);

		btnY = new JButton("y");
		btnY.setBackground(SystemColor.menu);
		btnY.setFont(new Font("Arial", Font.BOLD, 35));
		btnY.setBounds(469, 118, 80, 64);
		panel_1.add(btnY);
		btnY.addActionListener(this);

		btnU = new JButton("u");
		btnU.setBackground(SystemColor.menu);
		btnU.setFont(new Font("Arial", Font.BOLD, 35));
		btnU.setBounds(558, 118, 80, 64);
		panel_1.add(btnU);
		btnU.addActionListener(this);

		btnI = new JButton("i");
		btnI.setBackground(SystemColor.menu);
		btnI.setFont(new Font("Arial", Font.BOLD, 35));
		btnI.setBounds(647, 118, 80, 64);
		panel_1.add(btnI);
		btnI.addActionListener(this);

		btnO = new JButton("o");
		btnO.setBackground(SystemColor.menu);
		btnO.setFont(new Font("Arial", Font.BOLD, 35));
		btnO.setBounds(735, 118, 80, 64);
		panel_1.add(btnO);
		btnO.addActionListener(this);

		btnP = new JButton("p");
		btnP.setBackground(SystemColor.menu);
		btnP.setFont(new Font("Arial", Font.BOLD, 35));
		btnP.setBounds(824, 118, 80, 64);
		panel_1.add(btnP);
		btnP.addActionListener(this);

		btnA = new JButton("a");
		btnA.setBackground(SystemColor.menu);
		btnA.setFont(new Font("Arial", Font.BOLD, 35));
		btnA.setBounds(64, 193, 80, 64);
		panel_1.add(btnA);
		btnA.addActionListener(this);

		btnS = new JButton("s");
		btnS.setBackground(SystemColor.menu);
		btnS.setFont(new Font("Arial", Font.BOLD, 35));
		btnS.setBounds(153, 193, 80, 64);
		panel_1.add(btnS);
		btnS.addActionListener(this);

		btnD = new JButton("d");
		btnD.setBackground(SystemColor.menu);
		btnD.setFont(new Font("Arial", Font.BOLD, 35));
		btnD.setBounds(242, 193, 80, 64);
		panel_1.add(btnD);
		btnD.addActionListener(this);

		btnF = new JButton("f");
		btnF.setBackground(SystemColor.menu);
		btnF.setFont(new Font("Arial", Font.BOLD, 35));
		btnF.setBounds(330, 193, 80, 64);
		panel_1.add(btnF);
		btnF.addActionListener(this);

		btnG = new JButton("g");
		btnG.setBackground(SystemColor.menu);
		btnG.setFont(new Font("Arial", Font.BOLD, 35));
		btnG.setBounds(419, 193, 80, 64);
		panel_1.add(btnG);
		btnG.addActionListener(this);

		btnH = new JButton("h");
		btnH.setBackground(SystemColor.menu);
		btnH.setFont(new Font("Arial", Font.BOLD, 35));
		btnH.setBounds(507, 193, 80, 64);
		panel_1.add(btnH);
		btnH.addActionListener(this);

		btnJ = new JButton("j");
		btnJ.setBackground(SystemColor.menu);
		btnJ.setFont(new Font("Arial", Font.BOLD, 35));
		btnJ.setBounds(596, 193, 80, 64);
		panel_1.add(btnJ);
		btnJ.addActionListener(this);

		btnK = new JButton("k");
		btnK.setBackground(SystemColor.menu);
		btnK.setFont(new Font("Arial", Font.BOLD, 35));
		btnK.setBounds(685, 193, 80, 64);
		panel_1.add(btnK);
		btnK.addActionListener(this);

		btnL = new JButton("l");
		btnL.setBackground(SystemColor.menu);
		btnL.setFont(new Font("Arial", Font.BOLD, 35));
		btnL.setBounds(773, 193, 80, 64);
		panel_1.add(btnL);
		btnL.addActionListener(this);

		btnZ = new JButton("z");
		btnZ.setBackground(SystemColor.menu);
		btnZ.setFont(new Font("Arial", Font.BOLD, 35));
		btnZ.setBounds(153, 269, 80, 64);
		panel_1.add(btnZ);
		btnZ.addActionListener(this);

		btnM = new JButton("m");
		btnM.setBackground(SystemColor.menu);
		btnM.setFont(new Font("Arial", Font.BOLD, 35));
		btnM.setBounds(685, 269, 80, 64);
		panel_1.add(btnM);
		btnM.addActionListener(this);

		btnX = new JButton("x");
		btnX.setBackground(SystemColor.menu);
		btnX.setFont(new Font("Arial", Font.BOLD, 35));
		btnX.setBounds(242, 269, 80, 64);
		panel_1.add(btnX);
		btnX.addActionListener(this);

		btnC = new JButton("c");
		btnC.setBackground(SystemColor.menu);
		btnC.setFont(new Font("Arial", Font.BOLD, 35));
		btnC.setBounds(330, 269, 80, 64);
		panel_1.add(btnC);
		btnC.addActionListener(this);

		btnV = new JButton("v");
		btnV.setBackground(SystemColor.menu);
		btnV.setFont(new Font("Arial", Font.BOLD, 35));
		btnV.setBounds(419, 269, 80, 64);
		panel_1.add(btnV);
		btnV.addActionListener(this);

		btnB = new JButton("b");
		btnB.setBackground(SystemColor.menu);
		btnB.setFont(new Font("Arial", Font.BOLD, 35));
		btnB.setBounds(507, 269, 80, 64);
		panel_1.add(btnB);
		btnB.addActionListener(this);

		btnN = new JButton("n");
		btnN.setBackground(SystemColor.menu);
		btnN.setFont(new Font("Arial", Font.BOLD, 35));
		btnN.setBounds(596, 269, 80, 64);
		panel_1.add(btnN);
		btnN.addActionListener(this);

		btnComma = new JButton(",");
		btnComma.setBackground(SystemColor.menu);
		btnComma.setFont(new Font("Arial", Font.BOLD, 35));
		btnComma.setBounds(153, 345, 80, 64);
		panel_1.add(btnComma);
		btnComma.addActionListener(this);

		btnSpace = new JButton("");
		btnSpace.setBackground(SystemColor.menu);
		btnSpace.setFont(new Font("Arial", Font.BOLD, 35));
		btnSpace.setBounds(242, 345, 434, 64);
		panel_1.add(btnSpace);
		btnSpace.addActionListener(this);

		btnFullstop = new JButton(".");
		btnFullstop.setBackground(SystemColor.menu);
		btnFullstop.setFont(new Font("Arial", Font.BOLD, 35));
		btnFullstop.setBounds(685, 345, 80, 64);
		panel_1.add(btnFullstop);
		btnFullstop.addActionListener(this);

		btnBackspace = new JButton("\u232B");
		btnBackspace.setBackground(SystemColor.activeCaptionBorder);
		btnBackspace.setFont(new Font("Arial Unicode MS", Font.BOLD, 50));
		btnBackspace.setBounds(773, 269, 131, 64);
		panel_1.add(btnBackspace);
		btnBackspace.addActionListener(this);

		btnEnter = new JButton("\u21B5");
		btnEnter.setBackground(SystemColor.textHighlight);
		btnEnter.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 55));
		btnEnter.setBounds(773, 345, 131, 64);
		panel_1.add(btnEnter);
		btnEnter.addActionListener(this);

		btnShift = new JButton("\u21EA");
		btnShift.setBackground(SystemColor.inactiveCaptionBorder);
		btnShift.setFont(new Font("Arial Unicode MS", Font.BOLD, 35));
		btnShift.setBounds(26, 269, 118, 64);
		panel_1.add(btnShift);
		btnShift.addActionListener(this);

		btnDone = new JButton("DONE");
		btnDone.setBackground(new Color(60, 179, 113));
		btnDone.setFont(new Font("Arial", Font.BOLD, 25));
		btnDone.setBounds(26, 345, 118, 64);
		panel_1.add(btnDone);
		btnDone.addActionListener(this);

		btn1 = new JButton("1");
		btn1.setFont(new Font("Arial", Font.BOLD, 35));
		btn1.setBackground(SystemColor.inactiveCaptionBorder);
		btn1.setBounds(26, 28, 80, 64);
		panel_1.add(btn1);
		btn1.addActionListener(this);

		btn2 = new JButton("2");
		btn2.setFont(new Font("Arial", Font.BOLD, 35));
		btn2.setBackground(SystemColor.inactiveCaptionBorder);
		btn2.setBounds(115, 28, 80, 64);
		panel_1.add(btn2);
		btn2.addActionListener(this);

		btn3 = new JButton("3");
		btn3.setFont(new Font("Arial", Font.BOLD, 35));
		btn3.setBackground(SystemColor.inactiveCaptionBorder);
		btn3.setBounds(204, 28, 80, 64);
		panel_1.add(btn3);
		btn3.addActionListener(this);

		btn4 = new JButton("4");
		btn4.setFont(new Font("Arial", Font.BOLD, 35));
		btn4.setBackground(SystemColor.inactiveCaptionBorder);
		btn4.setBounds(292, 28, 80, 64);
		panel_1.add(btn4);
		btn4.addActionListener(this);

		btn5 = new JButton("5");
		btn5.setFont(new Font("Arial", Font.BOLD, 35));
		btn5.setBackground(SystemColor.inactiveCaptionBorder);
		btn5.setBounds(381, 28, 80, 64);
		panel_1.add(btn5);
		btn5.addActionListener(this);

		btn6 = new JButton("6");
		btn6.setFont(new Font("Arial", Font.BOLD, 35));
		btn6.setBackground(SystemColor.inactiveCaptionBorder);
		btn6.setBounds(469, 28, 80, 64);
		panel_1.add(btn6);
		btn6.addActionListener(this);

		btn7 = new JButton("7");
		btn7.setFont(new Font("Arial", Font.BOLD, 35));
		btn7.setBackground(SystemColor.inactiveCaptionBorder);
		btn7.setBounds(558, 28, 80, 64);
		panel_1.add(btn7);
		btn7.addActionListener(this);

		btn8 = new JButton("8");
		btn8.setFont(new Font("Arial", Font.BOLD, 35));
		btn8.setBackground(SystemColor.inactiveCaptionBorder);
		btn8.setBounds(647, 28, 80, 64);
		panel_1.add(btn8);
		btn8.addActionListener(this);

		btn9 = new JButton("9");
		btn9.setFont(new Font("Arial", Font.BOLD, 35));
		btn9.setBackground(SystemColor.inactiveCaptionBorder);
		btn9.setBounds(735, 28, 80, 64);
		panel_1.add(btn9);
		btn9.addActionListener(this);

		btn0 = new JButton("0");
		btn0.setFont(new Font("Arial", Font.BOLD, 35));
		btn0.setBackground(SystemColor.inactiveCaptionBorder);
		btn0.setBounds(824, 28, 80, 64);
		panel_1.add(btn0);
		btn0.addActionListener(this);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Calibri", Font.PLAIN, 24));
		textArea.setBounds(26, 17, 944, 306);
		innerpane.add(textArea);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("FOOD"));
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(26, 28, 996, 324);
		mainpanel.add(panel);
		panel.setLayout(null);

		JLabel lblRateFood = new JLabel();
		lblRateFood.setBounds(26, 40, 944, 33);
		lblRateFood.setText(question1);
		lblRateFood.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblRateFood);

		JLabel lblTaste_1 = new JLabel("Taste:");
		lblTaste_1.setBounds(231, 110, 149, 33);
		lblTaste_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblTaste_1);

		taste_sli = new JSlider(1, 5, 3);
		taste_sli.setBounds(406, 117, 316, 26);
		taste_sli.setBackground(new Color(119, 136, 153));
		panel.add(taste_sli);

		JLabel lblPlating = new JLabel("Plating:");
		lblPlating.setBounds(231, 171, 149, 33);
		lblPlating.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblPlating);

		plating_sli = new JSlider(1, 5, 3);
		plating_sli.setBounds(406, 178, 316, 26);
		plating_sli.setBackground(new Color(119, 136, 153));
		panel.add(plating_sli);

		JLabel lblPortion = new JLabel("Portion:");
		lblPortion.setBounds(231, 232, 149, 33);
		lblPortion.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblPortion);

		portion_sli = new JSlider(1, 5, 3);
		portion_sli.setBounds(406, 239, 316, 26);
		portion_sli.setBackground(new Color(119, 136, 153));
		panel.add(portion_sli);

		JLabel lblTasteSli = new JLabel("Average");
		lblTasteSli.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTasteSli.setBounds(748, 112, 210, 33);
		panel.add(lblTasteSli);

		JLabel lblPlatingSli = new JLabel("Average");
		lblPlatingSli.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblPlatingSli.setBounds(748, 173, 210, 33);
		panel.add(lblPlatingSli);

		JLabel lblPortionSli = new JLabel("Average");
		lblPortionSli.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblPortionSli.setBounds(748, 234, 210, 33);
		panel.add(lblPortionSli);

		JPanel quepanel = new JPanel();
		quepanel.setBackground(new Color(119, 136, 153));
		quepanel.setBounds(26, 380, 996, 253);
		quepanel.setBorder(BorderFactory.createTitledBorder("Service & Server"));
		mainpanel.add(quepanel);
		quepanel.setLayout(null);

		JLabel lblRateService = new JLabel();
		lblRateService.setText(question2);
		lblRateService.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRateService.setBounds(26, 40, 944, 33);
		quepanel.add(lblRateService);

		JLabel lblServeTime = new JLabel("Serve Time:");
		lblServeTime.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblServeTime.setBounds(209, 90, 171, 33);
		quepanel.add(lblServeTime);

		JLabel lblWaitingStaff = new JLabel("Waiting Staff:");
		lblWaitingStaff.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblWaitingStaff.setBounds(186, 151, 194, 57);
		quepanel.add(lblWaitingStaff);

		servetime_sli = new JSlider(1, 5, 3);
		servetime_sli.setBackground(new Color(119, 136, 153));
		servetime_sli.setBounds(406, 97, 316, 26);
		quepanel.add(servetime_sli);

		waitingstaff_sli = new JSlider(1, 5, 3);
		waitingstaff_sli.setBackground(new Color(119, 136, 153));
		waitingstaff_sli.setBounds(406, 171, 316, 26);
		quepanel.add(waitingstaff_sli);

		JLabel lblServeTimeSli = new JLabel("Average");
		lblServeTimeSli.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblServeTimeSli.setBounds(748, 92, 210, 33);
		quepanel.add(lblServeTimeSli);

		JLabel lblWaitingStaffSli = new JLabel("Average");
		lblWaitingStaffSli.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblWaitingStaffSli.setBounds(748, 165, 210, 33);
		quepanel.add(lblWaitingStaffSli);

		JPanel quepanel2 = new JPanel();
		quepanel2.setBackground(new Color(119, 136, 153));
		quepanel2.setLayout(null);
		quepanel2.setBorder(BorderFactory.createTitledBorder("Ambiance"));
		quepanel2.setBounds(26, 661, 996, 323);
		mainpanel.add(quepanel2);

		JLabel lblRateTheAmbience = new JLabel();
		lblRateTheAmbience.setText(question3);
		lblRateTheAmbience.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRateTheAmbience.setBounds(26, 40, 944, 42);
		quepanel2.add(lblRateTheAmbience);

		JLabel lblAmbiance = new JLabel("Cleanliness:");
		lblAmbiance.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAmbiance.setBounds(214, 110, 166, 33);
		quepanel2.add(lblAmbiance);

		cleanliness_sli = new JSlider(1, 5, 3);
		cleanliness_sli.setBackground(new Color(119, 136, 153));
		cleanliness_sli.setBounds(406, 117, 316, 26);
		quepanel2.add(cleanliness_sli);

		JLabel lblParking = new JLabel("Lighting:");
		lblParking.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblParking.setBounds(256, 165, 124, 39);
		quepanel2.add(lblParking);

		lighting_sli = new JSlider(1, 5, 3);
		lighting_sli.setBackground(new Color(119, 136, 153));
		lighting_sli.setBounds(406, 178, 316, 26);
		quepanel2.add(lighting_sli);

		JLabel lblComfort = new JLabel("Comfort:");
		lblComfort.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblComfort.setBounds(256, 232, 124, 33);
		quepanel2.add(lblComfort);

		comfort_sli = new JSlider(1, 5, 3);
		comfort_sli.setBackground(new Color(119, 136, 153));
		comfort_sli.setBounds(406, 239, 316, 26);
		quepanel2.add(comfort_sli);

		JLabel lblCleanlinessSli = new JLabel("Average");
		lblCleanlinessSli.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblCleanlinessSli.setBounds(760, 112, 210, 33);
		quepanel2.add(lblCleanlinessSli);

		JLabel lblLightingSli = new JLabel("Average");
		lblLightingSli.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblLightingSli.setBounds(760, 170, 210, 33);
		quepanel2.add(lblLightingSli);

		JLabel lblComfortSli = new JLabel("Average");
		lblComfortSli.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblComfortSli.setBounds(760, 234, 210, 33);
		quepanel2.add(lblComfortSli);

		JPanel quepanel3 = new JPanel();
		quepanel3.setBackground(new Color(119, 136, 153));
		quepanel3.setLayout(null);
		quepanel3.setBorder(BorderFactory.createTitledBorder("Opinion"));
		quepanel3.setBounds(26, 1012, 996, 218);
		mainpanel.add(quepanel3);

		JLabel lblWouldYouRevisit = new JLabel();
		lblWouldYouRevisit.setText(question4);
		lblWouldYouRevisit.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblWouldYouRevisit.setBounds(26, 40, 944, 33);
		quepanel3.add(lblWouldYouRevisit);

		yes_chckbx = new JCheckBox("Yes");
		yes_chckbx.setBackground(new Color(119, 136, 153));
		yes_chckbx.setFont(new Font("Tahoma", Font.PLAIN, 32));
		yes_chckbx.setBounds(176, 106, 221, 41);
		quepanel3.add(yes_chckbx);
		yes_chckbx.addActionListener(this);

		no_chckbx = new JCheckBox("No");
		no_chckbx.setBackground(new Color(119, 136, 153));
		no_chckbx.setFont(new Font("Tahoma", Font.PLAIN, 32));
		no_chckbx.setBounds(415, 106, 221, 41);
		quepanel3.add(no_chckbx);
		no_chckbx.addActionListener(this);

		maybe_chckbx = new JCheckBox("Maybe");
		maybe_chckbx.setBackground(new Color(119, 136, 153));
		maybe_chckbx.setFont(new Font("Tahoma", Font.PLAIN, 32));
		maybe_chckbx.setBounds(654, 106, 221, 41);
		quepanel3.add(maybe_chckbx);
		maybe_chckbx.addActionListener(this);

		JPanel quepanel4 = new JPanel();
		quepanel4.setBackground(new Color(119, 136, 153));
		quepanel4.setLayout(null);
		quepanel4.setBorder(BorderFactory.createTitledBorder("Dining Comments"));
		quepanel4.setBounds(26, 1258, 996, 437);
		mainpanel.add(quepanel4);

		JLabel lblOtherComments = new JLabel();
		lblOtherComments.setText(question5);
		lblOtherComments.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblOtherComments.setBounds(26, 40, 944, 33);
		quepanel4.add(lblOtherComments);

		message_txt = new JTextArea();
		message_txt.setFont(new Font("Calibri", Font.PLAIN, 24));
		message_txt.setEditable(false);
		message_txt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				blurpane.setVisible(true);
				textArea.setText(message_txt.getText());
			}
		});
		message_txt.setBounds(26, 88, 944, 321);
		quepanel4.add(message_txt);

		btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(SystemColor.activeCaption);
		btnConfirm.setFont(new Font("Arial", Font.BOLD, 36));
		btnConfirm.setBounds(796, 1723, 226, 81);
		mainpanel.add(btnConfirm);
		btnConfirm.addActionListener(this);

		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(SystemColor.control);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 36));
		btnCancel.setBounds(544, 1723, 226, 81);
		mainpanel.add(btnCancel);
		btnCancel.addActionListener(this);

		/*
		 * Component change listner to detect change from rating sliders
		 */

		taste_sli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (taste_sli.getValue() == 1) {
					lblTasteSli.setText("Poor");
				} else if (taste_sli.getValue() == 2) {
					lblTasteSli.setText("Below Average");
				} else if (taste_sli.getValue() == 3) {
					lblTasteSli.setText("Average");
				} else if (taste_sli.getValue() == 4) {
					lblTasteSli.setText("Good");
				} else if (taste_sli.getValue() == 5) {
					lblTasteSli.setText("Excellent");
				}
			}
		});

		plating_sli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (plating_sli.getValue() == 1) {
					lblPlatingSli.setText("Poor");
				} else if (plating_sli.getValue() == 2) {
					lblPlatingSli.setText("Below Average");
				} else if (plating_sli.getValue() == 3) {
					lblPlatingSli.setText("Average");
				} else if (plating_sli.getValue() == 4) {
					lblPlatingSli.setText("Good");
				} else if (plating_sli.getValue() == 5) {
					lblPlatingSli.setText("Excellent");
				}
			}
		});

		portion_sli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (portion_sli.getValue() == 1) {
					lblPortionSli.setText("Poor");
				} else if (portion_sli.getValue() == 2) {
					lblPortionSli.setText("Below Average");
				} else if (portion_sli.getValue() == 3) {
					lblPortionSli.setText("Average");
				} else if (portion_sli.getValue() == 4) {
					lblPortionSli.setText("Good");
				} else if (portion_sli.getValue() == 5) {
					lblPortionSli.setText("Excellent");
				}
			}
		});

		servetime_sli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (servetime_sli.getValue() == 1) {
					lblServeTimeSli.setText("Poor");
				} else if (servetime_sli.getValue() == 2) {
					lblServeTimeSli.setText("Below Average");
				} else if (servetime_sli.getValue() == 3) {
					lblServeTimeSli.setText("Average");
				} else if (servetime_sli.getValue() == 4) {
					lblServeTimeSli.setText("Good");
				} else if (servetime_sli.getValue() == 5) {
					lblServeTimeSli.setText("Excellent");
				}
			}
		});

		waitingstaff_sli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (waitingstaff_sli.getValue() == 1) {
					lblWaitingStaffSli.setText("Poor");
				} else if (waitingstaff_sli.getValue() == 2) {
					lblWaitingStaffSli.setText("Below Average");
				} else if (waitingstaff_sli.getValue() == 3) {
					lblWaitingStaffSli.setText("Average");
				} else if (waitingstaff_sli.getValue() == 4) {
					lblWaitingStaffSli.setText("Good");
				} else if (waitingstaff_sli.getValue() == 5) {
					lblWaitingStaffSli.setText("Excellent");
				}
			}
		});

		cleanliness_sli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (cleanliness_sli.getValue() == 1) {
					lblCleanlinessSli.setText("Poor");
				} else if (cleanliness_sli.getValue() == 2) {
					lblCleanlinessSli.setText("Below Average");
				} else if (cleanliness_sli.getValue() == 3) {
					lblCleanlinessSli.setText("Average");
				} else if (cleanliness_sli.getValue() == 4) {
					lblCleanlinessSli.setText("Good");
				} else if (cleanliness_sli.getValue() == 5) {
					lblCleanlinessSli.setText("Excellent");
				}
			}
		});

		lighting_sli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (lighting_sli.getValue() == 1) {
					lblLightingSli.setText("Poor");
				} else if (lighting_sli.getValue() == 2) {
					lblLightingSli.setText("Below Average");
				} else if (lighting_sli.getValue() == 3) {
					lblLightingSli.setText("Average");
				} else if (lighting_sli.getValue() == 4) {
					lblLightingSli.setText("Good");
				} else if (lighting_sli.getValue() == 5) {
					lblLightingSli.setText("Excellent");
				}
			}
		});

		comfort_sli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (comfort_sli.getValue() == 1) {
					lblComfortSli.setText("Poor");
				} else if (comfort_sli.getValue() == 2) {
					lblComfortSli.setText("Below Average");
				} else if (comfort_sli.getValue() == 3) {
					lblComfortSli.setText("Average");
				} else if (comfort_sli.getValue() == 4) {
					lblComfortSli.setText("Good");
				} else if (comfort_sli.getValue() == 5) {
					lblComfortSli.setText("Excellent");
				}
			}
		});

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGUI window = new CustomerGUI();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
