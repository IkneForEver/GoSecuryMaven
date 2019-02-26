package actions;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;

import components.Dialogue;
import components.Fenetre;
import components.PagePrincipale;
import actions.CompareFacesAction;

public class SaveWebcamImageAction extends AbstractAction {

	private final static String savePath = "src/ressources/screens/";
	private final static String targetPath1 = "src/ressources/agents/agent1.jpg";
	private final static String targetPath2 = "src/ressources/agents/agent2.jpg";


	Fenetre fenetre;

	/**
	 * generated id
	 */
	private static final long serialVersionUID = 1L;

	private IplImage image;
	private CanvasFrame canvasFrame;
	private boolean estDansPagePrincipale = false;
	private Thread th;

	public SaveWebcamImageAction(IplImage img, String libelle, CanvasFrame canvasFrame, Thread th) {
		super();
		// récupère le screen de la webcam
		this.image = img;
		// on recupère la fenêtre pour pouvoir en changer le contenu
		this.canvasFrame = canvasFrame;
		// On réaffiche le libelle du bouton qui s'efface lors du setAction sur le
		// bouton;
		putValue(NAME, libelle);
		// on récupère le thread afin de pouvoir stopper la webcam.
		this.th=th;
	}

	// action lors du clic sur le bouton
	public void actionPerformed(ActionEvent e) {

		estDansPagePrincipale = true;
		// sauvegarde le screen dans le répertoire savePath
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();

		String imageEnregistreePath = savePath + dateFormat.format(date) + "_screen.jpg";
		cvSaveImage(imageEnregistreePath, image);

		CompareFacesAction comparateurVisage = new CompareFacesAction();
		int idAgent1 = 0;
		int idAgent2 = 0;
		try {
			idAgent1 = comparateurVisage.compareFacesAgent1(imageEnregistreePath, targetPath1);
			idAgent2 = comparateurVisage.compareFacesAgent2(imageEnregistreePath, targetPath2);
			if(idAgent1==0 && idAgent2==0) {
				Dialogue boiteDialogue = new Dialogue(canvasFrame,"Authentification échouée","Aucun agent correspondant !");
		        boiteDialogue.setSize(300, 150);
			}
			else if(idAgent1!=0 && idAgent2==0){
				
				// redirection vers la page principale
				canvasFrame.setContentPane(new PagePrincipale(canvasFrame, idAgent1));
				canvasFrame.revalidate();
				canvasFrame.repaint();
				Dialogue boiteDialogue = new Dialogue(canvasFrame,"Authentification réussie","L'agent numéro "+idAgent1+" s'est identifié ! ");
		        boiteDialogue.setSize(300, 150);
		        //th.interrupt();
			}
			else {
				// redirection vers la page principale
				canvasFrame.setContentPane(new PagePrincipale(canvasFrame, idAgent2));
				canvasFrame.revalidate();
				canvasFrame.repaint();
				
				Dialogue boiteDialogue = new Dialogue(canvasFrame,"Authentification réussie","L'agent numéro "+idAgent2+" s'est identifié ! ");
		        boiteDialogue.setSize(300, 150);
		        //th.interrupt();
			}
		}catch(Exception exception) {
			Dialogue boiteDialogue = new Dialogue(canvasFrame,"Authentification échouée","Aucun visage détecté !");
	        boiteDialogue.setSize(300, 150);
		}
	}

}
