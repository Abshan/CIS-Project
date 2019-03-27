package main.GUI;

//
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import main.Servers.functions;
import main.Servers.serverInterface;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerGUI {

	public JFrame frame;
	serverInterface serv;

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

		JSlider slider_3 = new JSlider(1, 5, 3);
		slider_3.setBackground(Color.GRAY);
		slider_3.setBounds(406, 117, 316, 26);
		panel.add(slider_3);

		JLabel lblPlating = new JLabel("Plating:");
		lblPlating.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblPlating.setBounds(231, 171, 149, 33);
		panel.add(lblPlating);

		JSlider slider_5 = new JSlider(1, 5, 3);
		slider_5.setBackground(Color.GRAY);
		slider_5.setBounds(406, 178, 316, 26);
		panel.add(slider_5);

		JLabel lblPortion = new JLabel("Portion:");
		lblPortion.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblPortion.setBounds(231, 232, 149, 33);
		panel.add(lblPortion);

		JSlider slider_4 = new JSlider(1, 5, 3);
		slider_4.setBackground(Color.GRAY);
		slider_4.setBounds(406, 239, 316, 26);
		panel.add(slider_4);

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

		JSlider slider = new JSlider(1, 5, 3);
		slider.setBackground(Color.GRAY);
		slider.setBounds(406, 97, 316, 26);
		quepanel.add(slider);

		JSlider slider_1 = new JSlider(1, 5, 3);
		slider_1.setBackground(Color.GRAY);
		slider_1.setBounds(406, 171, 316, 26);
		quepanel.add(slider_1);

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

		JSlider slider_2 = new JSlider(1, 5, 3);
		slider_2.setBackground(Color.GRAY);
		slider_2.setBounds(406, 117, 316, 26);
		quepanel2.add(slider_2);

		JLabel lblParking = new JLabel("Lighting:");
		lblParking.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblParking.setBounds(256, 165, 124, 39);
		quepanel2.add(lblParking);

		JSlider slider_6 = new JSlider(1, 5, 3);
		slider_6.setBackground(Color.GRAY);
		slider_6.setBounds(406, 178, 316, 26);
		quepanel2.add(slider_6);

		JLabel lblComfort = new JLabel("Comfort:");
		lblComfort.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblComfort.setBounds(256, 232, 124, 33);
		quepanel2.add(lblComfort);

		JSlider slider_7 = new JSlider(1, 5, 3);
		slider_7.setBackground(Color.GRAY);
		slider_7.setBounds(406, 239, 316, 26);
		quepanel2.add(slider_7);

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

		JCheckBox chckbxNo = new JCheckBox("Yes");
		chckbxNo.setBackground(Color.GRAY);
		chckbxNo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		chckbxNo.setBounds(176, 106, 221, 41);
		quepanel3.add(chckbxNo);

		JCheckBox chckbxYes = new JCheckBox("No");
		chckbxYes.setBackground(Color.GRAY);
		chckbxYes.setFont(new Font("Tahoma", Font.PLAIN, 32));
		chckbxYes.setBounds(415, 106, 221, 41);
		quepanel3.add(chckbxYes);

		JCheckBox chckbxMaybe = new JCheckBox("Maybe");
		chckbxMaybe.setBackground(Color.GRAY);
		chckbxMaybe.setFont(new Font("Tahoma", Font.PLAIN, 32));
		chckbxMaybe.setBounds(654, 106, 221, 41);
		quepanel3.add(chckbxMaybe);

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

		JTextArea textArea = new JTextArea();
		textArea.setBounds(59, 88, 878, 236);
		quepanel4.add(textArea);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnConfirm.setBounds(796, 1638, 226, 63);
		mainpanel.add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnCancel.setBounds(544, 1638, 226, 63);
		mainpanel.add(btnCancel);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Date now = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String date = df.format(now);
				
				try {
					serv.userInput(1, 2, 3, 4, 5, 6, 7, 8, 9, "10", "11", date);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		

	}
}
