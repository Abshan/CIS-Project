package main.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

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

public class CustomerGUI {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
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

	private static JPanel addPanel(int number) {
		JPanel panel_1 = new JPanel();

		panel_1.setPreferredSize(new Dimension(980, 250));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(BorderFactory.createTitledBorder(""));
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("  Image");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel.setBounds(26, 79, 115, 115);
		panel_1.add(lblNewLabel);

		JLabel lblFoodName = new JLabel("         Food Name");
		lblFoodName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblFoodName.setBounds(167, 120, 281, 33);
		panel_1.add(lblFoodName);

		JLabel lblTaste = new JLabel("Taste:");
		lblTaste.setBounds(537, 52, 115, 33);
		panel_1.add(lblTaste);

		JLabel lblPlating = new JLabel("Plating:");
		lblPlating.setBounds(537, 120, 115, 33);
		panel_1.add(lblPlating);

		JLabel lblPortion = new JLabel("Portion:");
		lblPortion.setBounds(537, 189, 115, 33);
		panel_1.add(lblPortion);

		JSlider slider = new JSlider();
		slider.setBounds(663, 59, 281, 26);
		slider.setBackground(Color.GRAY);
		panel_1.add(slider);

		JSlider slider_1 = new JSlider();
		slider_1.setBounds(663, 120, 281, 26);
		slider_1.setBackground(Color.GRAY);
		panel_1.add(slider_1);

		JSlider slider_2 = new JSlider();
		slider_2.setBounds(663, 196, 281, 26);
		slider_2.setBackground(Color.GRAY);
		panel_1.add(slider_2);

		return panel_1;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(1080, 1920);// (100, 100, 1080, 1920);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(Color.GRAY);
		mainpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5),
				"Restaurant Reviewing Sytem", TitledBorder.CENTER, TitledBorder.TOP));
		mainpanel.setBounds(0, 0, 1048, 1832);
		frame.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 62, 996, 596);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Food Items"));
		scrollPane.setBackground(Color.GRAY);
		mainpanel.add(scrollPane);

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.GRAY);
		panel.getPreferredSize();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(panel);

		JPanel quepanel = new JPanel();
		quepanel.setBackground(Color.GRAY);
		quepanel.setBounds(26, 686, 996, 200);
		quepanel.setBorder(BorderFactory.createTitledBorder("Question No 1"));
		mainpanel.add(quepanel);
		quepanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("    Rate the service based on the following criteria.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1.setBounds(26, 40, 944, 33);
		quepanel.add(lblNewLabel_1);

		JLabel lblServeTime = new JLabel("Serve Time:");
		lblServeTime.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblServeTime.setBounds(209, 90, 171, 33);
		quepanel.add(lblServeTime);

		JLabel lblWaitingStaff = new JLabel("Waiting Staff:");
		lblWaitingStaff.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblWaitingStaff.setBounds(186, 126, 194, 57);
		quepanel.add(lblWaitingStaff);

		JSlider slider = new JSlider();
		slider.setBackground(Color.GRAY);
		slider.setBounds(406, 97, 316, 26);
		quepanel.add(slider);

		JSlider slider_1 = new JSlider();
		slider_1.setBackground(Color.GRAY);
		slider_1.setBounds(406, 146, 316, 26);
		quepanel.add(slider_1);

		JPanel quepanel2 = new JPanel();
		quepanel2.setBackground(Color.GRAY);
		quepanel2.setLayout(null);
		quepanel2.setBorder(BorderFactory.createTitledBorder("Question No 2"));
		quepanel2.setBounds(26, 914, 996, 200);
		mainpanel.add(quepanel2);

		JLabel lblRateTheAmbience = new JLabel("    Rate the ambience in the restaurant.");
		lblRateTheAmbience.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRateTheAmbience.setBounds(26, 40, 944, 33);
		quepanel2.add(lblRateTheAmbience);

		JLabel lblAmbiance = new JLabel("Ambiance:");
		lblAmbiance.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAmbiance.setBounds(231, 110, 149, 33);
		quepanel2.add(lblAmbiance);

		JSlider slider_2 = new JSlider();
		slider_2.setBackground(Color.GRAY);
		slider_2.setBounds(406, 117, 316, 26);
		quepanel2.add(slider_2);

		JPanel quepanel3 = new JPanel();
		quepanel3.setBackground(Color.GRAY);
		quepanel3.setLayout(null);
		quepanel3.setBorder(BorderFactory.createTitledBorder("Question No 3"));
		quepanel3.setBounds(26, 1142, 996, 200);
		mainpanel.add(quepanel3);

		JLabel lblWouldYouRevisit = new JLabel("    Would you revisit our restaurant in future?");
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
		quepanel4.setBorder(BorderFactory.createTitledBorder("Question No 4"));
		quepanel4.setBounds(26, 1370, 996, 352);
		mainpanel.add(quepanel4);

		JLabel lblOtherComments = new JLabel("    Other comments.");
		lblOtherComments.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblOtherComments.setBounds(26, 40, 944, 33);
		quepanel4.add(lblOtherComments);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(59, 88, 878, 236);
		quepanel4.add(textArea);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnConfirm.setBounds(796, 1741, 226, 63);
		mainpanel.add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnCancel.setBounds(544, 1741, 226, 63);
		mainpanel.add(btnCancel);

		for (int i = 0; i < 5; i++) {
			panel.add(addPanel(i + 1));
		}
	}
}
