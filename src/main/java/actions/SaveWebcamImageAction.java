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

import components.Fenetre;
import components.PagePrincipale;

public class SaveWebcamImageAction extends AbstractAction {

	private final static String savePath = "src/ressources/screens/";
	Fenetre fenetre;

	/**
	 * generated id
	 */
	private static final long serialVersionUID = 1L;

	private IplImage image;
	private CanvasFrame canvasFrame;
	private boolean estDansPagePrincipale = false;

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

		if (!estDansPagePrincipale) {
			estDansPagePrincipale = true;
			// sauvegarde le screen dans le r�pertoire savePath
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			Date date = new Date();
			cvSaveImage(savePath + dateFormat.format(date) + "_screen.jpg", image);
			// redirection vers la page principale
			canvasFrame.setContentPane(new PagePrincipale(canvasFrame, 1));
			canvasFrame.revalidate();
			canvasFrame.repaint();
		}

	}
}
