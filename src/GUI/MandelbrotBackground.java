package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MandelbrotBackground extends JPanel {

	
	// The Image to store the background image in.
    
	Image img;
	/**
	 * Create the panel.
	 */
	public MandelbrotBackground() {
		img = Toolkit.getDefaultToolkit().createImage("saved.png");
	}
    
	public void paint(Graphics g)
    {
        // Draws the img to the BackgroundPanel.
        g.drawImage(img, 0, 0, null);
    }

}
