package actions;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractAction;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;

import components.Dialogue;
import components.Fenetre;
import components.PagePrincipale;
import domain.Agent;
import services.AgentService;
import actions.CompareFacesAction;

public class SaveWebcamImageAction extends AbstractAction {

	private final static String screenPath = "src/ressources/screens/";
	private final static String targetPath = "src/ressources/agents/";
	private final static AgentService agentService = new AgentService();
	


	Fenetre fenetre;

	/**
	 * generated id
	 */
	private static final long serialVersionUID = 1L;

	private IplImage image;
	private CanvasFrame canvasFrame;
	

	public SaveWebcamImageAction(IplImage img, String libelle, CanvasFrame canvasFrame) {
		super();
		// r�cup�re le screen de la webcam
		this.image = img;
		// on recup�re la fen�tre pour pouvoir en changer le contenu
		this.canvasFrame = canvasFrame;
		// On r�affiche le libelle du bouton qui s'efface lors du setAction sur le
		// bouton;
		putValue(NAME, libelle);
		// on r�cup�re le thread afin de pouvoir stopper la webcam.
	}
	
	// action lors du clic sur le bouton
	public void actionPerformed(ActionEvent e) {

		// sauvegarde le screen dans le r�pertoire savePath
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		String photoWebcamPath = screenPath + dateFormat.format(date) + "_screen.jpg";
		cvSaveImage(photoWebcamPath, image);
		
		CompareFacesAction comparateurVisage = new CompareFacesAction();
		int idAgent = 0;	
		try {
			List<Agent>  listeAgent = agentService.recupererTousLesAgentsEnBDD();
			for(Agent a : listeAgent) {
				String photoAgentPath = targetPath + a.getPhoto();
				if(comparateurVisage.compareFacesAgent(photoWebcamPath, photoAgentPath)) {
					idAgent=a.getId();
				}	
			}
			if(idAgent==0) {
				Dialogue boiteDialogue = new Dialogue(canvasFrame,"Authentification �chou�e","Aucun agent correspondant !");
		        boiteDialogue.setSize(300, 150);
			}
			else {
				// redirection vers la page principale
				canvasFrame.setContentPane(new PagePrincipale(canvasFrame, idAgent));
				canvasFrame.revalidate();
				canvasFrame.repaint();
				Dialogue boiteDialogue = new Dialogue(canvasFrame,"Authentification r�ussie","L'agent num�ro "+idAgent+" s'est identifi� ! ");
		        boiteDialogue.setSize(300, 150);
			}
		}catch(Exception exception) {
			Dialogue boiteDialogue = new Dialogue(canvasFrame,"Authentification �chou�e","Aucun visage d�tect� !");
	        boiteDialogue.setSize(300, 150);
		}
	}
	
}
