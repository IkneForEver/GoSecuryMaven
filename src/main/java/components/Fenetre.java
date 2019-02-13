package components;

import org.bytedeco.javacv.*;
import java.awt.Dimension;


public class Fenetre {
	
	PageConnexion pageConnexion;
	PagePrincipale pagePrincipale;
	CanvasFrame canvas;
	
	public Fenetre() {
		
		canvas = new CanvasFrame("Webcam");
		canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		canvas.setMinimumSize(new Dimension(1200, 800));
		canvas.setMaximumSize(new Dimension(1200, 800));
		canvas.setVisible(true);
		canvas.add(new PageConnexion(canvas));
	}

}
