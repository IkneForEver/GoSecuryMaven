package app;

import components.Fenetre;

public class launcher {

	public static void main(String[] args) {
		
		
	    Fenetre fenetre = new Fenetre();
        Thread th = new Thread(fenetre);
        
        //appelle la m�thode run de la fen�tre
        th.start();
		
	}

}
