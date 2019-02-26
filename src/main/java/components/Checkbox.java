package components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;

import domain.Agent;
import domain.Materiel;
import services.EmpruntService;
import services.MaterielService;

public class Checkbox extends JCheckBox implements MouseListener {

	/**
	 * Generated uid
	 */
	private static final long serialVersionUID = 1L;

	private static final MaterielService materielService = new MaterielService();
	
	private static final EmpruntService empruntService = new EmpruntService();

	private boolean estCoche = false;
	
	private Materiel materiel;
	
	private Agent agent;

	public Checkbox(Materiel materiel, Agent agent) {
		super();
		this.addMouseListener(this);
		this.materiel = materiel;
		this.agent=agent;
		this.setText(" "+ materiel.getQuantite());
		init();
	}

	public void mouseClicked(MouseEvent e) {

		// Si la checkbox n'est pas cochée on incrémente la quantité du materiel
		// correspondant

		if (!estCoche) {
			materielService.decrementerMateriel(materiel);
			empruntService.ajouterEmprunt(agent, materiel);
			estCoche=true;
		}
		// Sinon on la décrémente
		else {
			materielService.incrementerMateriel(materiel);
			empruntService.supprimerEmprunt(agent, materiel);
			estCoche=false;
		}
		this.setText(" "+materiel.getQuantite());
		this.repaint();
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void init() {
		if(empruntService.trouverEmprunt(agent,materiel)) {
			this.setSelected(true);
		}
		else {
			this.setSelected(false);
		}
	}

}
