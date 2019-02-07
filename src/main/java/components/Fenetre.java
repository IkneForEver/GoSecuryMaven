package components;

import org.bytedeco.javacv.*;

import actions.SaveWebcamImageAction;

import static org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvFlip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


public class Fenetre {
	
	PageConnexion pageConnexion;
	PagePrincipale pagePrincipale;
	CanvasFrame canvas;
	
	public Fenetre() {
		
		canvas = new CanvasFrame("Webcam");
		canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		canvas.setMinimumSize(new Dimension(1500, 1500));
		canvas.setLayout(new BorderLayout());
		canvas.setVisible(true);
		canvas.setBackground(Color.decode("#379EC1"));
		canvas.add(new PageConnexion(canvas));
	}

}
