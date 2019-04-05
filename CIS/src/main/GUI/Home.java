package main.GUI;

//
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import main.Servers.serverInterface;

import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RefineryUtilities;

// comment
public class Home {

	public JFrame frame;
	serverInterface serv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280, 971);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);

		JPanel outerScrollPanel = new JPanel();
		outerScrollPanel.setBackground(new Color(128, 128, 128));
		outerScrollPanel.setLayout(null);

		outerScrollPanel.setPreferredSize(new Dimension(491, 800));

		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(outerScrollPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE));
		gl_mainPanel.setVerticalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel
						.createSequentialGroup().addComponent(outerScrollPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(151, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1264, 800);
		outerScrollPanel.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel innerScrollPanel = new JPanel();
		innerScrollPanel.setPreferredSize(new Dimension(290, 1550));
		innerScrollPanel.setBackground(Color.WHITE);
		scrollPane.setViewportView(innerScrollPanel);

		JPanel outerScrollPanel2 = new JPanel();
		outerScrollPanel2.setLayout(null);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(0, 0, 1026, 256);
		outerScrollPanel2.add(scrollPane2);

		JPanel dypan1 = new JPanel();
		dypan1.setBackground(Color.LIGHT_GRAY);
		dypan1.setLayout(new BorderLayout());

		JPanel dypan4 = new JPanel();
		dypan4.setBackground(Color.LIGHT_GRAY);
		dypan4.setLayout(new BorderLayout());

		JPanel dypan2 = new JPanel();
		dypan2.setBackground(Color.GRAY);

		JPanel dypan3 = new JPanel();
		dypan3.setBackground(Color.LIGHT_GRAY);

		JPanel dypan6 = new JPanel();
		dypan6.setBackground(Color.LIGHT_GRAY);

		JPanel dypan5 = new JPanel();
		dypan5.setBackground(Color.GRAY);

		JPanel dypan7 = new JPanel();
		dypan7.setBackground(Color.GRAY);

		JPanel dypan8 = new JPanel();
		dypan8.setBackground(Color.LIGHT_GRAY);

		JPanel dypan9 = new JPanel();
		dypan9.setBackground(Color.GRAY);
		GroupLayout gl_innerScrollPanel = new GroupLayout(innerScrollPanel);
		gl_innerScrollPanel.setHorizontalGroup(
				gl_innerScrollPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_innerScrollPanel
						.createSequentialGroup().addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_innerScrollPanel.createSequentialGroup().addGap(104)
										.addComponent(outerScrollPanel2, GroupLayout.PREFERRED_SIZE, 1026,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_innerScrollPanel.createSequentialGroup().addGap(61)
										.addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(dypan8, GroupLayout.PREFERRED_SIZE, 516,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_innerScrollPanel.createSequentialGroup()
														.addComponent(dypan1, GroupLayout.PREFERRED_SIZE, 516,
																GroupLayout.PREFERRED_SIZE)
														.addGap(82)
														.addComponent(dypan4, GroupLayout.PREFERRED_SIZE, 516,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_innerScrollPanel.createSequentialGroup()
														.addGroup(gl_innerScrollPanel
																.createParallelGroup(Alignment.LEADING)
																.addComponent(dypan2, GroupLayout.PREFERRED_SIZE, 516,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(dypan3, GroupLayout.PREFERRED_SIZE, 516,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(dypan7, GroupLayout.PREFERRED_SIZE, 516,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(82)
														.addGroup(gl_innerScrollPanel
																.createParallelGroup(Alignment.LEADING)
																.addComponent(dypan5, GroupLayout.PREFERRED_SIZE, 516,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(dypan9, GroupLayout.PREFERRED_SIZE, 516,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(dypan6, GroupLayout.PREFERRED_SIZE, 516,
																		GroupLayout.PREFERRED_SIZE))))))
						.addContainerGap(70, Short.MAX_VALUE)));
		gl_innerScrollPanel.setVerticalGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_innerScrollPanel.createSequentialGroup().addGap(79)
						.addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(dypan4, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addComponent(dypan1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_innerScrollPanel.createSequentialGroup()
										.addComponent(dypan5, GroupLayout.PREFERRED_SIZE, 195,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(dypan6,
												GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_innerScrollPanel.createSequentialGroup()
										.addComponent(dypan2, GroupLayout.PREFERRED_SIZE, 195,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(dypan3, GroupLayout.PREFERRED_SIZE, 195,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(87)
						.addGroup(gl_innerScrollPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_innerScrollPanel.createSequentialGroup()
										.addComponent(dypan7, GroupLayout.PREFERRED_SIZE, 195,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(dypan8,
												GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
								.addComponent(dypan9, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
						.addComponent(outerScrollPanel2, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		innerScrollPanel.setLayout(gl_innerScrollPanel);
		
		

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(1.5, "Overall Taste", "Jan");
		dataset.addValue(4.0, "Overall Taste", "Feb");
		dataset.addValue(3.0, "Overall Taste", "March");
		dataset.addValue(3.5, "Overall Taste", "AApril");
		dataset.addValue(5.0, "Overall Taste", "June");

		final JFreeChart chart = ChartFactory.createBarChart("Taste", // chart title
				"Month",                  // domain axis label
				"Rating",                 // range axis label
				dataset,                  // data
				PlotOrientation.VERTICAL, // orientation
				false,                    // include legend
				true,                     // tool tips?
				false                     // URLs?
		);
		chart.getTitle().setHorizontalAlignment(HorizontalAlignment.LEFT);

		chart.setBackgroundPaint(Color.white);

		// get a reference to the plot for further customization...
		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);

		dypan1.setLayout(new java.awt.BorderLayout());
		ChartPanel cp1 = new ChartPanel(chart);
		dypan1.add(cp1, BorderLayout.CENTER);
		dypan1.validate();

		dypan2.setLayout(new java.awt.BorderLayout());
		ChartPanel cp2 = new ChartPanel(chart);
		dypan2.add(cp2, BorderLayout.CENTER);
		dypan2.validate();
//
//		// set the range axis to display integers only...
//		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//		rangeAxis.setUpperMargin(0.15);
//
//		// disable bar outlines...
		final CategoryItemRenderer renderer = plot.getRenderer();
		renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);
		mainPanel.setLayout(gl_mainPanel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(mainPanel,
				GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(121).addComponent(mainPanel,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
