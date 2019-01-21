package app;

import components.Fenetre;

public class launcher {

	public static void main(String[] args) {
		
		
	    Fenetre fenetre = new Fenetre();
        Thread th = new Thread(fenetre);
        
        //appelle la méthode run de la fenêtre
        th.start();
		
	}

}
