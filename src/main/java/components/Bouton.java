package components;

import java.awt.Color;
import java.awt.Dimension;
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
		this.setName(str);
		
		this.setText("<html>Text color: <font color='black'>+"
				+ str +"</font></html>");
		this.setSize(new Dimension(60,20));
		
		this.setBackground(Color.decode("#379EC1"));
		// Gr�ce � cette instruction, notre objet va s'�couter
		// D�s qu'un �v�nement de la souris sera intercept�, il en sera averti
		this.addMouseListener(this);
	}

	// M�thode appel�e lors du clic de souris
	public void mouseClicked(MouseEvent event) {

	}

	// M�thode appel�e lors du survol de la souris
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
