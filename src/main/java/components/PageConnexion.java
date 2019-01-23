package components;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.bytedeco.javacv.CanvasFrame;

public class PageConnexion extends JPanel  {
	
	/**
	 * generated UID
	 */
	private static final long serialVersionUID = 1L;
	private Bouton bouton;
	public CanvasFrame canvas;

	
	public PageConnexion(CanvasFrame canvas) {
		bouton = new Bouton("S'identifier");
		this.setBackground(Color.PINK);
		this.add(bouton, BorderLayout.CENTER);
		this.canvas=canvas;
	}
	
	public Bouton getBouton() {
		return this.bouton;
	}
	
	public void setBouton(Bouton bouton) {
		this.bouton = bouton;
	}

}
