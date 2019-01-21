package actions;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;

import org.bytedeco.javacpp.opencv_core.IplImage;

public class SaveWebcamImageAction extends AbstractAction{
	
	private final static String savePath = "src/main/java/ressources/screens/";

	/**
	 * generated id
	 */
	private static final long serialVersionUID = 1L;
	
	
	private IplImage image;
	static int nbScreen;
	
	public SaveWebcamImageAction(IplImage img) {
		super();
		this.image=img;
	}
	

	public void actionPerformed(ActionEvent e) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		cvSaveImage(savePath + dateFormat.format(date) + "_screen.jpg", image);
	}
}
