package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Bouton(String str) {
		super();
		this.setText(str);
    	this.setBackground(Color.decode("#379EC1"));
		// Grâce à cette instruction, notre objet va s'écouter
		// Dès qu'un événement de la souris sera intercepté, il en sera averti
		this.addMouseListener(this);
	}

	// Méthode appelée lors du clic de souris
	public void mouseClicked(MouseEvent event) {

	}

	// Méthode appelée lors du survol de la souris
	public void mouseEntered(MouseEvent event) {
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
