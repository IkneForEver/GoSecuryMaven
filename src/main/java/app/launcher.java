package app;

import components.Fenetre;
import components.Webcam;

public class launcher {

	public static void main(String[] args) {
		Fenetre fenetre = new Fenetre();
		fenetre.setVisible(true);
		
		//La webcam pour le moment est dans une autre fen�tre il faut r�gler �a
	    Webcam webcam = new Webcam();
        Thread th = new Thread(webcam);
        th.start();
		
	}

}
