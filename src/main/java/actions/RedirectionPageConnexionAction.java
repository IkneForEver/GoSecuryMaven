package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.bytedeco.javacv.CanvasFrame;

import components.PageConnexion;

public class RedirectionPageConnexionAction extends AbstractAction {
	
	/**
	 * generated uid
	 */
	private static final long serialVersionUID = 1L;
	CanvasFrame canvas;

	public RedirectionPageConnexionAction(String libelle,CanvasFrame canvas) {
		super();
		this.canvas = canvas;
		//le libelle du bouton s'efface lors du setAction; cela permet qu'il soit réaffiché
		putValue(NAME, libelle);
		
	}

	public void actionPerformed(ActionEvent e) {
		canvas.setContentPane(new PageConnexion(canvas));
		canvas.revalidate();
		canvas.repaint();
		
	}

}
