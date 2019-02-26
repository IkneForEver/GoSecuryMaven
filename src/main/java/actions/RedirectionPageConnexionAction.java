package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.bytedeco.javacv.CanvasFrame;

import components.Fenetre;
import components.PageConnexion;

public class RedirectionPageConnexionAction extends AbstractAction {

	/**
	 * generated uid
	 */

	private static final long serialVersionUID = 1L;
	Fenetre fenetre;
	public CanvasFrame canvasFrame;

	public RedirectionPageConnexionAction(String libelle, CanvasFrame canvasFrame) {
		super();
		this.canvasFrame = canvasFrame;
		// le libelle du bouton s'efface lors du setAction; cela permet qu'il soit
		// réaffiché
		putValue(NAME, libelle);
	}

	public void actionPerformed(ActionEvent e) {
		
		canvasFrame.dispose();
		Fenetre fenetre = new Fenetre();	
	}

}
