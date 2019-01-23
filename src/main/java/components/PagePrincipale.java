package components;

import java.awt.Color;

import javax.swing.JPanel;

import org.bytedeco.javacv.CanvasFrame;

import actions.RedirectionPageConnexionAction;

public class PagePrincipale extends JPanel {

	/**
	 * generated uid
	 */
	private static final long serialVersionUID = 1L;
	public CanvasFrame canvas;

	public PagePrincipale(CanvasFrame canvas) {
		this.canvas = canvas;
		Bouton bouton = new Bouton("Identification");
		//on associe une action de redirection à notre bouton
		bouton.setAction(new RedirectionPageConnexionAction(bouton.getName(),canvas) );
		this.setBackground(Color.ORANGE);
		this.add(bouton);

	}

}
