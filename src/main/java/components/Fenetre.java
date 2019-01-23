package components;

import org.bytedeco.javacv.*;

import actions.SaveWebcamImageAction;

import static org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvFlip;

import java.awt.BorderLayout;
import java.awt.Dimension;


public class Fenetre implements Runnable {
	final int INTERVAL = 100;/// you may use interval
	CanvasFrame canvas = new CanvasFrame("Webcam");
	PageConnexion pageConnexion;
	PagePrincipale pagePrinciple;

	public Fenetre() {

		pageConnexion = new PageConnexion(canvas);
		canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		canvas.setMinimumSize(new Dimension(1500, 1500));
		canvas.setLayout(new BorderLayout());
		canvas.add(pageConnexion);
		canvas.setVisible(true);
	}

	// lancement de la webcam
	public void run() {

		FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
		try {
			grabber.start();
			while (true) {
				Frame frame = grabber.grab();

				IplImage img;
				img = converter.convert(frame);

				// the grabbed frame will be flipped, re-flip to make it right
				cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise

				canvas.showImage(converter.convert(img));
				pageConnexion.getBouton()
						.setAction(new SaveWebcamImageAction(img, pageConnexion.getBouton().getName(), canvas));
				pageConnexion.getBouton().repaint();

				Thread.sleep(INTERVAL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
