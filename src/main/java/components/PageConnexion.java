package components;

import static org.bytedeco.javacpp.opencv_core.cvFlip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.VideoInputFrameGrabber;

import actions.SaveWebcamImageAction;

public class PageConnexion extends JPanel implements Runnable   {
	
	/**
	 * generated UID
	 */
	private static final long serialVersionUID = 1L;
	final int INTERVAL = 100;/// you may use interval
	
	public CanvasFrame canvasFrame;
	public JPanel ecran;
	public Bouton bouton;
	public Thread th;

	
	public PageConnexion(CanvasFrame canvasFrame) {
	
		this.canvasFrame = canvasFrame;
		ecran = new JPanel();
		ecran.setBackground(Color.GRAY);
		bouton = new Bouton("S'identifier");
		ecran.add(bouton, BorderLayout.CENTER);
		canvasFrame.add(ecran,BorderLayout.EAST);
		this.revalidate();
		this.repaint();
		th = new Thread(this);
		th.start();
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
					
					bouton.setAction(new SaveWebcamImageAction(img, bouton.getName(), canvasFrame, th));
					//bouton.repaint();

					Thread.sleep(INTERVAL);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
