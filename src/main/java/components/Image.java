package components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Image extends JPanel {

	/**
	 * generated uid
	 */
	private static final long serialVersionUID = 1L;

	private final static String imagesPath = "src/ressources/images/";

	private BufferedImage image;

	public Image(String filename) {
		try {
			setImage(ImageIO.read(new File(imagesPath + filename)));
		} catch (IOException e) {
			System.out.println("Erreur lors de la récupération de l'image " + imagesPath + filename + ": " + e);
		}

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
