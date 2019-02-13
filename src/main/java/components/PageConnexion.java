package components;

import static org.bytedeco.javacpp.opencv_core.cvFlip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.VideoInputFrameGrabber;

import actions.SaveWebcamImageAction;

public class PageConnexion extends JPanel implements Runnable {

	/**
	 * generated UID
	 */
	private static final long serialVersionUID = 1L;
	final int INTERVAL = 100;/// you may use interval

	public CanvasFrame canvasFrame;
	public JPanel bandeau;
	public Bouton bouton;
	public Thread th;

	public PageConnexion(CanvasFrame canvasFrame) {
		canvasFrame.setLayout(new BorderLayout());
		if (th == null) {
			th = new Thread(this);
			th.start();
		}
		this.canvasFrame = canvasFrame;
		bouton = new Bouton("S'identifier");

		bandeau = new JPanel();
		bandeau.setBackground(Color.GRAY);
		bandeau.setSize(new Dimension(300, 1000));
		bandeau.add(bouton, BorderLayout.CENTER);
		
		canvasFrame.add(bandeau, BorderLayout.EAST);

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

				canvasFrame.showImage(converter.convert(img));

				bouton.setAction(new SaveWebcamImageAction(img, bouton.getName(), canvasFrame));
				// bouton.repaint();

				Thread.sleep(INTERVAL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
