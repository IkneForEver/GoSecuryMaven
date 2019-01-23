package actions;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;

import components.PagePrincipale;

public class SaveWebcamImageAction extends AbstractAction {

	private final static String savePath = "src/main/java/ressources/screens/";
	CanvasFrame canvas;

	/**
	 * generated id
	 */
	private static final long serialVersionUID = 1L;

	private IplImage image;

	public SaveWebcamImageAction(IplImage img, String libelle, CanvasFrame canvas) {
		super();
		//récupère le screen de la webcam
		this.image = img;
		//le libelle du bouton s'efface lors du setAction; cela permet qu'il soit réaffiché
		putValue(NAME, libelle);
		//on récupère le canvas de la fenetre
		this.canvas = canvas;
	}
	
	//action lors du clic sur le bouton
	public void actionPerformed(ActionEvent e) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		//sauvegarde le screen dans le répertoire savePath
		cvSaveImage(savePath + dateFormat.format(date) + "_screen.jpg", image);
		//redirection vers la page principale
		canvas.setContentPane(new PagePrincipale(canvas));
		canvas.revalidate();
		canvas.repaint();
	}
}
