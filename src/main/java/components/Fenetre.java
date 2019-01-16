package components;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	/**
	 * generated UID
	 */
	private static final long serialVersionUID = 1L;

	public Fenetre() {
		
		this.setTitle("Go Secury");
	    this.setSize(400, 100);
	    this.setLocationRelativeTo(null);
	    //Un JPanel peut contenir des composents tels que des boutons, des labels, des formes
	    JPanel container = new JPanel();
	    container.setBackground(Color.ORANGE);
	    //Le layout gère le positionnent des composents qui ont été ajoutés au JPanel
	    //Pour l'instant le layout est un layout de base
	    container.setLayout(new BorderLayout());
	    this.setContentPane(container);               
	    this.setVisible(true);

	    
        
	  
	}
}
