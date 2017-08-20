package javastud;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LogoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;

	@Override
	protected void paintComponent(Graphics g) {
		try {
			super.paintComponent(g);

			BufferedImage bImg = ImageIO.read(LogoPanel.class.getResource("/nepal.png"));
			g.drawImage(bImg, 0, 0, 185, 90, null);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}