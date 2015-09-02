package GUI;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.Button;
import java.awt.Dimension;
import javax.swing.JTextField;
import davi.Mandelbrot.*;

public class MandelbrotGUI {

	private JFrame frame;
	private JTextField txtMandelbrotfilename;
	private int c=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MandelbrotGUI window = new MandelbrotGUI();
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
	public MandelbrotGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		ImageIcon iconLogo = new ImageIcon("saved.png");
		Dimension spinnerDimension = new Dimension(20, 0);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(iconLogo);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 21;
		gbc_lblNewLabel.gridwidth = 23;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblXstart = new JLabel("xStart");
		GridBagConstraints gbc_lblXstart = new GridBagConstraints();
		gbc_lblXstart.insets = new Insets(0, 0, 5, 5);
		gbc_lblXstart.gridx = 23;
		gbc_lblXstart.gridy = 4;
		frame.getContentPane().add(lblXstart, gbc_lblXstart);
		
		JSpinner spinnerXStart = new JSpinner();
		// get the default height of a spinner
		int height = spinnerXStart.getHeight();
		System.out.println("height: "+height);
		spinnerXStart.setMinimumSize(spinnerDimension);
		spinnerXStart.setModel(new SpinnerNumberModel(-1.6, -2.0, 100.0, 0.1));
		GridBagConstraints gbc_spinnerXStart = new GridBagConstraints();
		gbc_spinnerXStart.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerXStart.gridx = 24;
		gbc_spinnerXStart.gridy = 4;
		frame.getContentPane().add(spinnerXStart, gbc_spinnerXStart);
		
		JLabel lblNewLabel_1 = new JLabel("xEnd");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 23;
		gbc_lblNewLabel_1.gridy = 5;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JSpinner spinner_XEnd = new JSpinner();
		spinner_XEnd.setMinimumSize(spinnerDimension);
		spinner_XEnd.setModel(new SpinnerNumberModel(-0.0, -2.0, 100.0, 0.1));
		GridBagConstraints gbc_spinner_XEnd = new GridBagConstraints();
		gbc_spinner_XEnd.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_XEnd.gridx = 24;
		gbc_spinner_XEnd.gridy = 5;
		frame.getContentPane().add(spinner_XEnd, gbc_spinner_XEnd);
		
		JLabel lblNewLabel_2 = new JLabel("yStart");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 23;
		gbc_lblNewLabel_2.gridy = 6;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JSpinner spinnerYStart = new JSpinner();
		spinnerYStart.setMinimumSize(new Dimension(6, 0));
		spinnerYStart.setModel(new SpinnerNumberModel(-0.7, -2.0, 100.0, 0.1));
		GridBagConstraints gbc_spinnerYStart = new GridBagConstraints();
		gbc_spinnerYStart.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerYStart.gridx = 24;
		gbc_spinnerYStart.gridy = 6;
		frame.getContentPane().add(spinnerYStart, gbc_spinnerYStart);
		
		JLabel lblNewLabel_3 = new JLabel("yEnd");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 23;
		gbc_lblNewLabel_3.gridy = 7;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JSpinner spinnerYEnd = new JSpinner();
		spinnerYEnd.setMinimumSize(new Dimension(6, 0));
		spinnerYEnd.setModel(new SpinnerNumberModel(0.2, -2.0, 100.0, 0.1));
		GridBagConstraints gbc_spinnerYEnd = new GridBagConstraints();
		gbc_spinnerYEnd.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerYEnd.gridx = 24;
		gbc_spinnerYEnd.gridy = 7;
		frame.getContentPane().add(spinnerYEnd, gbc_spinnerYEnd);
		
		JLabel lblIterations = new JLabel("Iterations");
		GridBagConstraints gbc_lblIterations = new GridBagConstraints();
		gbc_lblIterations.anchor = GridBagConstraints.EAST;
		gbc_lblIterations.insets = new Insets(0, 0, 5, 5);
		gbc_lblIterations.gridx = 23;
		gbc_lblIterations.gridy = 8;
		frame.getContentPane().add(lblIterations, gbc_lblIterations);
		
		JSpinner spinnerIterations = new JSpinner();
		spinnerIterations.setMinimumSize(spinnerDimension);
		spinnerIterations.setModel(new SpinnerNumberModel(new Integer(500), null, null, new Integer(1)));
		GridBagConstraints gbc_spinnerIterations = new GridBagConstraints();
		gbc_spinnerIterations.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerIterations.gridx = 24;
		gbc_spinnerIterations.gridy = 8;
		frame.getContentPane().add(spinnerIterations, gbc_spinnerIterations);
		
		JLabel lblMagnitude = new JLabel("Magnitude");
		GridBagConstraints gbc_lblMagnitude = new GridBagConstraints();
		gbc_lblMagnitude.insets = new Insets(0, 0, 5, 5);
		gbc_lblMagnitude.gridx = 23;
		gbc_lblMagnitude.gridy = 9;
		frame.getContentPane().add(lblMagnitude, gbc_lblMagnitude);
		
		JSpinner spinnerMagnitude = new JSpinner();
		spinnerMagnitude.setMinimumSize(spinnerDimension);
		spinnerMagnitude.setModel(new SpinnerNumberModel(2.5, 0.0, 100.0, 0.1));
		GridBagConstraints gbc_spinnerMagnitude = new GridBagConstraints();
		gbc_spinnerMagnitude.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerMagnitude.gridx = 24;
		gbc_spinnerMagnitude.gridy = 9;
		frame.getContentPane().add(spinnerMagnitude, gbc_spinnerMagnitude);
		
		txtMandelbrotfilename = new JTextField();
		txtMandelbrotfilename.setText("MandelbrotFileName");
		GridBagConstraints gbc_txtMandelbrotfilename = new GridBagConstraints();
		gbc_txtMandelbrotfilename.insets = new Insets(0, 0, 5, 0);
		gbc_txtMandelbrotfilename.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMandelbrotfilename.gridx = 24;
		gbc_txtMandelbrotfilename.gridy = 10;
		frame.getContentPane().add(txtMandelbrotfilename, gbc_txtMandelbrotfilename);
		txtMandelbrotfilename.setColumns(10);
		
		Button buttonSave = new Button("Save high resolution");
		buttonSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "The calcualtion has ended", "End Of Calculation", JOptionPane.WARNING_MESSAGE);
				//String name = txtMandelbrotfilename.getText().toString();
				//Mandelbrot mandelbrot = new Mandelbrot(3000, 1688, (double)spinnerXStart.getValue(), (double)spinner_XEnd.getValue(), (double)spinnerYStart.getValue(), (double)spinnerYEnd.getValue(),name, (int)spinnerIterations.getValue(), (double)spinnerMagnitude.getValue());
				//mandelbrot.writeImage();
				
			}
		});
		GridBagConstraints gbc_buttonSave = new GridBagConstraints();
		gbc_buttonSave.insets = new Insets(0, 0, 5, 0);
		gbc_buttonSave.gridx = 24;
		gbc_buttonSave.gridy = 11;
		frame.getContentPane().add(buttonSave, gbc_buttonSave);
		
		Button button = new Button("Mandelbrot!");
		
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//new Thread(validateFiles).start(); 
				
				// Implement Mandelbrot as a thread
				// http://stackoverflow.com/questions/13512612/browse-for-image-file-and-display-it-using-java-swing/13512826#13512826
				
				c = c+1;
				String name = Integer.toString(c)+".png";
				Mandelbrot mandelbrot = new Mandelbrot(900, 508, (double)spinnerXStart.getValue(), (double)spinner_XEnd.getValue(), (double)spinnerYStart.getValue(), (double)spinnerYEnd.getValue(),name, (int)spinnerIterations.getValue(), (double)spinnerMagnitude.getValue());
				mandelbrot.writeImage();
				
				//button.setEnabled(true);
				
				// Set and show the new the new Picture 
				ImageIcon iconLogo = new ImageIcon(name);
				lblNewLabel.setIcon(iconLogo);
				mandelbrot = null;
				
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 24;
		gbc_button.gridy = 12;
		frame.getContentPane().add(button, gbc_button);
	}
}


