package IdealGasSimulator;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.*; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

public class MainDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPressure;
	private JTextField txtVolume;
	private JTextField txtTemperature;
	private JTextField txtMoles;
	JLabel lblInfo;
	JLabel lblImage;
	private JTextField txtOldPressure;
	private JTextField txtOldVolume;
	private JTextField txtOldTemp;
	private JTextField txtOldMol;
	//private java.util.List<Ball> balls;

/**
* Launch the application.
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDisplay frame = new MainDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/**
* Create the frame.
*/
public MainDisplay() {
	setTitle("Ideal Gas Simulator");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 559, 676);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblNewLabel = new JLabel("Pressure");
	lblNewLabel.setBounds(38, 27, 61, 16);
	contentPane.add(lblNewLabel);

	JLabel lblVolume = new JLabel("Volume");
	lblVolume.setBounds(38, 69, 61, 16);
	contentPane.add(lblVolume);

	JLabel lblTemperature = new JLabel("Temperature");
	lblTemperature.setBounds(19, 114, 90, 16);
	contentPane.add(lblTemperature);

	JLabel lblMoles = new JLabel("Moles");
	lblMoles.setBounds(19, 160, 61, 16);
	contentPane.add(lblMoles);

	txtPressure = new JTextField();
	txtPressure.setBounds(111, 22, 61, 26);
	contentPane.add(txtPressure);
	txtPressure.setColumns(10);

	txtVolume = new JTextField();
	txtVolume.setColumns(10);
	txtVolume.setBounds(111, 64, 61, 26);
	contentPane.add(txtVolume);

	txtTemperature = new JTextField();
	txtTemperature.setColumns(10);
	txtTemperature.setBounds(111, 109, 61, 26);
	contentPane.add(txtTemperature);

	txtMoles = new JTextField();
	txtMoles.setColumns(10);
	txtMoles.setBounds(71, 155, 48, 26);
	contentPane.add(txtMoles);

	JButton btnReset = new JButton("Reset");
	btnReset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtPressure.setText("1.0");
			txtVolume.setText("1.0");
			txtMoles.setText("10.0");
			txtTemperature.setText("273.15");
			lblInfo.setText("");
			lblImage.setIcon(new ImageIcon(MainDisplay.class.getResource("/IdealGasSimulator/slowmoving.gif")));
		}
	});
	btnReset.setBounds(19, 203, 117, 29);
	contentPane.add(btnReset);

	JButton btnNewButton_1 = new JButton("Changed?");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double P_1 = Double.parseDouble(txtOldPressure.getText());
			double V_1 = Double.parseDouble(txtVolume.getText());
			double P_2 = Double.parseDouble(txtPressure.getText());
			double V_2 = ((P_1 * V_1) / P_2);
			txtVolume.setText(Double.toString(V_2));
		}
	});
	btnNewButton_1.setBounds(173, 22, 117, 29);
	contentPane.add(btnNewButton_1);

	JButton btnNewButton_1_1 = new JButton("Changed?");
	btnNewButton_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double P_1 = Double.parseDouble(txtPressure.getText());
			double V_1 = Double.parseDouble(txtOldVolume.getText());
			double V_2 = Double.parseDouble(txtVolume.getText());
			double P_2 = ((P_1 * V_1) / V_2);
			txtPressure.setText(Double.toString(P_2));
		}
	});
	btnNewButton_1_1.setBounds(173, 64, 117, 29);
	contentPane.add(btnNewButton_1_1);

	JButton btnNewButton_1_2 = new JButton("Changed?");
	btnNewButton_1_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double P_1 = Double.parseDouble(txtPressure.getText());
			double T_1 = Double.parseDouble(txtOldTemp.getText());
			double T_2 = Double.parseDouble(txtTemperature.getText());
			double P_2 = ((P_1 * T_2) / T_1);
			txtPressure.setText(Double.toString(P_2));
		}
	});
	btnNewButton_1_2.setBounds(173, 109, 117, 29);
	contentPane.add(btnNewButton_1_2);

	JButton btnNewButton_1_3 = new JButton("Changed?");
	btnNewButton_1_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double V_1 = Double.parseDouble(txtVolume.getText());
			double N_1 = Double.parseDouble(txtOldMol.getText());
			double N_2 = Double.parseDouble(txtMoles.getText());
			double V_2 = ((N_2 * V_1) / N_1);
			txtVolume.setText(Double.toString(V_2));
		}
	});
	btnNewButton_1_3.setBounds(121, 155, 117, 29);
	contentPane.add(btnNewButton_1_3);

	lblInfo = new JLabel("");
	lblInfo.setBackground(Color.RED);
	lblInfo.setBounds(19, 243, 514, 26);
	contentPane.add(lblInfo);

	JButton btnNewButton = new JButton("Display");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			lblInfo.setText("Pressure: " + txtPressure.getText() + "\n" + " Volume: " + txtVolume.getText() + "\n" +
					" Temperature: " + txtTemperature.getText() + "\n" +
					" Moles: " + txtMoles.getText());
		}
	});
	btnNewButton.setBounds(173, 203, 117, 29);
	contentPane.add(btnNewButton);

	JButton btnNewButton_2 = new JButton("Increased?");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			lblImage.setIcon(new ImageIcon(MainDisplay.class.getResource("/IdealGasSimulator/Gaz_molecules.gif")));
		}
	});

	btnNewButton_2.setBounds(344, 22, 100, 29);
	contentPane.add(btnNewButton_2);

	JButton btnNewButton_2_1 = new JButton("Increased?");
	btnNewButton_2_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			lblImage.setIcon(new ImageIcon(MainDisplay.class.getResource("/IdealGasSimulator/fastmoving.gif")));
		}
	});
	btnNewButton_2_1.setBounds(344, 64, 100, 29);
	contentPane.add(btnNewButton_2_1);

	JButton btnNewButton_2_2 = new JButton("Increased?");
	btnNewButton_2_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			lblImage.setIcon(new ImageIcon(MainDisplay.class.getResource("/IdealGasSimulator/Gaz_molecules.gif")));
		}
	});
	btnNewButton_2_2.setBounds(344, 109, 100, 29);
	contentPane.add(btnNewButton_2_2);

	JButton btnNewButton_2_3 = new JButton("Increased?");
	btnNewButton_2_3.setBounds(327, 155, 100, 29);
	contentPane.add(btnNewButton_2_3);

	txtOldPressure = new JTextField();
	txtOldPressure.setBounds(288, 22, 61, 26);
	contentPane.add(txtOldPressure);
	txtOldPressure.setColumns(10);

	txtOldVolume = new JTextField();
	txtOldVolume.setColumns(10);
	txtOldVolume.setBounds(288, 64, 61, 26);
	contentPane.add(txtOldVolume);

	txtOldTemp = new JTextField();
	txtOldTemp.setColumns(10);
	txtOldTemp.setBounds(288, 109, 61, 26);
	contentPane.add(txtOldTemp);

	txtOldMol = new JTextField();
	txtOldMol.setColumns(10);
	txtOldMol.setBounds(240, 155, 78, 26);
	contentPane.add(txtOldMol);
	
	lblImage = new JLabel("");
	lblImage.setBounds(10, 286, 523, 340);
	contentPane.add(lblImage);

	}
	
}