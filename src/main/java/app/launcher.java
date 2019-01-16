package app;

import components.Fenetre;
import components.Webcam;

public class launcher {

	public static void main(String[] args) {
		Fenetre fenetre = new Fenetre();
		fenetre.setVisible(true);
		
		//La webcam pour le moment est dans une autre fenêtre il faut régler ça
	    Webcam webcam = new Webcam();
        Thread th = new Thread(webcam);
        th.start();
		
	}

}
