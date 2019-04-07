package main.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import main.Servers.review;
import main.Servers.serverInterface;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CustomerGUI {

	public JFrame frame;
	serverInterface serv;
	public String op = null;

	/**
	 * Launch the application.
	 */
//	private static serverInterface look;

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

	/**
	 * Create the application.
	 */
	public CustomerGUI() {
		initialize();
	}

//	private static JPanel addPanel(int number) {
//		JPanel panel_1 = new JPanel();
//
//		panel_1.setPreferredSize(new Dimension(980, 250));
//		panel_1.setBackground(Color.GRAY);
//		panel_1.setBorder(BorderFactory.createTitledBorder(""));
//		panel_1.setLayout(null);
//
//		JLabel lblNewLabel = new JLabel("  Image");
//		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		lblNewLabel.setBounds(26, 79, 115, 115);
//		panel_1.add(lblNewLabel);
//
//		JLabel lblFoodName = new JLabel("         Food Name");
//		lblFoodName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		lblFoodName.setBounds(167, 120, 281, 33);
//		panel_1.add(lblFoodName);
//
//		JLabel lblTaste = new JLabel("Taste:");
//		lblTaste.setBounds(537, 52, 115, 33);
//		panel_1.add(lblTaste);
//
//		JLabel lblPlating = new JLabel("Plating:");
//		lblPlating.setBounds(537, 120, 115, 33);
//		panel_1.add(lblPlating);
//
//		JLabel lblPortion = new JLabel("Portion:");
//		lblPortion.setBounds(537, 189, 115, 33);
//		panel_1.add(lblPortion);
//
//		JSlider slider = new JSlider();
//		slider.setBounds(663, 59, 281, 26);
//		slider.setBackground(Color.GRAY);
//		panel_1.add(slider);
//
//		JSlider slider_1 = new JSlider();
//		slider_1.setBounds(663, 120, 281, 26);
//		slider_1.setBackground(Color.GRAY);
//		panel_1.add(slider_1);
//
//		JSlider slider_2 = new JSlider();
//		slider_2.setBounds(663, 196, 281, 26);
//		slider_2.setBackground(Color.GRAY);
//		panel_1.add(slider_2);
//
//		return panel_1;
//	}

	private void initialize() {

		String name = "rmi://localhost/test";
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

		frame = new JFrame();
		frame.setSize(1080, 1810);// (100, 100, 1080, 1920);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(Color.GRAY);
		mainpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5),
				"Restaurant Reviewing Sytem", TitledBorder.CENTER, TitledBorder.TOP));
		mainpanel.setBounds(0, 0, 1048, 1722);
		frame.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("FOOD"));
		panel.setBackground(Color.GRAY);
		panel.setBounds(26, 28, 996, 324);
		mainpanel.add(panel);

		JLabel lblRateFood = new JLabel();
		lblRateFood.setText(question1);
		lblRateFood.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRateFood.setBounds(26, 40, 944, 33);
		panel.add(lblRateFood);

		JLabel lblTaste_1 = new JLabel("Taste:");
		lblTaste_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTaste_1.setBounds(231, 110, 149, 33);
		panel.add(lblTaste_1);

		JSlider taste_sli = new JSlider(1, 5, 3);
		taste_sli.setBackground(Color.GRAY);
		taste_sli.setBounds(406, 117, 316, 26);
		panel.add(taste_sli);

		JLabel lblPlating = new JLabel("Plating:");
		lblPlating.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblPlating.setBounds(231, 171, 149, 33);
		panel.add(lblPlating);

		JSlider plating_sli = new JSlider(1, 5, 3);
		plating_sli.setBackground(Color.GRAY);
		plating_sli.setBounds(406, 178, 316, 26);
		panel.add(plating_sli);

		JLabel lblPortion = new JLabel("Portion:");
		lblPortion.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblPortion.setBounds(231, 232, 149, 33);
		panel.add(lblPortion);

		JSlider portion_sli = new JSlider(1, 5, 3);
		portion_sli.setBackground(Color.GRAY);
		portion_sli.setBounds(406, 239, 316, 26);
		panel.add(portion_sli);

		JLabel lblTasteSli = new JLabel("Average");
		lblTasteSli.setBounds(748, 112, 210, 33);
		panel.add(lblTasteSli);

		JLabel lblPlatingSli = new JLabel("Average");
		lblPlatingSli.setBounds(748, 173, 210, 33);
		panel.add(lblPlatingSli);

		JLabel lblPortionSli = new JLabel("Average");
		lblPortionSli.setBounds(748, 234, 210, 33);
		panel.add(lblPortionSli);

		JPanel quepanel = new JPanel();
		quepanel.setBackground(Color.GRAY);
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

		JSlider servetime_sli = new JSlider(1, 5, 3);
		servetime_sli.setBackground(Color.GRAY);
		servetime_sli.setBounds(406, 97, 316, 26);
		quepanel.add(servetime_sli);

		JSlider waitingstaff_sli = new JSlider(1, 5, 3);
		waitingstaff_sli.setBackground(Color.GRAY);
		waitingstaff_sli.setBounds(406, 171, 316, 26);
		quepanel.add(waitingstaff_sli);

		JLabel lblServeTimeSli = new JLabel("Average");
		lblServeTimeSli.setBounds(748, 92, 210, 33);
		quepanel.add(lblServeTimeSli);

		JLabel lblWaitingStaffSli = new JLabel("Average");
		lblWaitingStaffSli.setBounds(748, 165, 210, 33);
		quepanel.add(lblWaitingStaffSli);

		JPanel quepanel2 = new JPanel();
		quepanel2.setBackground(Color.GRAY);
		quepanel2.setLayout(null);
		quepanel2.setBorder(BorderFactory.createTitledBorder("Ambiance"));
		quepanel2.setBounds(26, 661, 996, 323);
		mainpanel.add(quepanel2);

		JLabel lblRateTheAmbience = new JLabel();
		lblRateTheAmbience.setText(question3);
		lblRateTheAmbience.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRateTheAmbience.setBounds(26, 40, 944, 33);
		quepanel2.add(lblRateTheAmbience);

		JLabel lblAmbiance = new JLabel("Cleanliness:");
		lblAmbiance.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAmbiance.setBounds(214, 110, 166, 33);
		quepanel2.add(lblAmbiance);

		JSlider cleanliness_sli = new JSlider(1, 5, 3);
		cleanliness_sli.setBackground(Color.GRAY);
		cleanliness_sli.setBounds(406, 117, 316, 26);
		quepanel2.add(cleanliness_sli);

		JLabel lblParking = new JLabel("Lighting:");
		lblParking.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblParking.setBounds(256, 165, 124, 39);
		quepanel2.add(lblParking);

		JSlider lighting_sli = new JSlider(1, 5, 3);
		lighting_sli.setBackground(Color.GRAY);
		lighting_sli.setBounds(406, 178, 316, 26);
		quepanel2.add(lighting_sli);

		JLabel lblComfort = new JLabel("Comfort:");
		lblComfort.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblComfort.setBounds(256, 232, 124, 33);
		quepanel2.add(lblComfort);

		JSlider comfort_sli = new JSlider(1, 5, 3);
		comfort_sli.setBackground(Color.GRAY);
		comfort_sli.setBounds(406, 239, 316, 26);
		quepanel2.add(comfort_sli);

		JLabel lblCleanlinessSli = new JLabel("Average");
		lblCleanlinessSli.setBounds(760, 112, 210, 33);
		quepanel2.add(lblCleanlinessSli);

		JLabel lblLightingSli = new JLabel("Average");
		lblLightingSli.setBounds(760, 170, 210, 33);
		quepanel2.add(lblLightingSli);

		JLabel lblComfortSli = new JLabel("Average");
		lblComfortSli.setBounds(760, 234, 210, 33);
		quepanel2.add(lblComfortSli);

		JPanel quepanel3 = new JPanel();
		quepanel3.setBackground(Color.GRAY);
		quepanel3.setLayout(null);
		quepanel3.setBorder(BorderFactory.createTitledBorder("Opinion"));
		quepanel3.setBounds(26, 1012, 996, 218);
		mainpanel.add(quepanel3);

		JLabel lblWouldYouRevisit = new JLabel();
		lblWouldYouRevisit.setText(question4);
		lblWouldYouRevisit.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblWouldYouRevisit.setBounds(26, 40, 944, 33);
		quepanel3.add(lblWouldYouRevisit);

		JCheckBox yes_chckbx = new JCheckBox("Yes");
		yes_chckbx.setBackground(Color.GRAY);
		yes_chckbx.setFont(new Font("Tahoma", Font.PLAIN, 32));
		yes_chckbx.setBounds(176, 106, 221, 41);
		quepanel3.add(yes_chckbx);

		JCheckBox no_chckbx = new JCheckBox("No");
		no_chckbx.setBackground(Color.GRAY);
		no_chckbx.setFont(new Font("Tahoma", Font.PLAIN, 32));
		no_chckbx.setBounds(415, 106, 221, 41);
		quepanel3.add(no_chckbx);

		JCheckBox maybe_chckbx = new JCheckBox("Maybe");
		maybe_chckbx.setBackground(Color.GRAY);
		maybe_chckbx.setFont(new Font("Tahoma", Font.PLAIN, 32));
		maybe_chckbx.setBounds(654, 106, 221, 41);
		quepanel3.add(maybe_chckbx);

		JPanel quepanel4 = new JPanel();
		quepanel4.setBackground(Color.GRAY);
		quepanel4.setLayout(null);
		quepanel4.setBorder(BorderFactory.createTitledBorder("Dining Comments"));
		quepanel4.setBounds(26, 1258, 996, 352);
		mainpanel.add(quepanel4);

		JLabel lblOtherComments = new JLabel();
		lblOtherComments.setText(question5);
		lblOtherComments.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblOtherComments.setBounds(26, 40, 944, 33);
		quepanel4.add(lblOtherComments);

		JTextArea message_txt = new JTextArea();
		message_txt.setBounds(59, 88, 878, 236);
		quepanel4.add(message_txt);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnConfirm.setBounds(796, 1638, 226, 63);
		mainpanel.add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnCancel.setBounds(544, 1638, 226, 63);
		mainpanel.add(btnCancel);

		yes_chckbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (yes_chckbx.isSelected()) {
					no_chckbx.setSelected(false);
					maybe_chckbx.setSelected(false);
					op = "Yes";
				}
			}
		});

		no_chckbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (no_chckbx.isSelected()) {
					yes_chckbx.setSelected(false);
					maybe_chckbx.setSelected(false);
					op = "No";
				}
			}
		});

		maybe_chckbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (maybe_chckbx.isSelected()) {
					no_chckbx.setSelected(false);
					yes_chckbx.setSelected(false);
					op = "Maybe";
				}
			}
		});

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

		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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
					serv.userInput(review.orderNo, taste, plating, portion, serveTime, waitingStaff, cleanliness,
							lighting, comfort, op, message, date);
				} catch (Exception e) {
					e.printStackTrace();
				}

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
				
				try {
					JOptionPane.showOptionDialog(null, "Thank You For Your Time, Have a Good Day!"," ", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
					TimeUnit.SECONDS.sleep(1);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				CustomerLoginGUI window = new CustomerLoginGUI();
				window.frame.setVisible(true);
				frame.dispose();

				

			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		});

	}
}
