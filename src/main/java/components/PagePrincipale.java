package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.bytedeco.javacv.CanvasFrame;
import actions.RedirectionPageConnexionAction;
import domain.Agent;
import domain.Materiel;
import services.AgentService;
import services.MaterielService;

public class PagePrincipale extends JPanel {

	/**
	 * generated uid
	 */
	private static final long serialVersionUID = 1L;

	public static final AgentService agentService = new AgentService();

	public static final MaterielService materielService = new MaterielService();
	
	private int idAgent;

	private Agent agent;

	public CanvasFrame canvasFrame;

	public PagePrincipale(CanvasFrame canvasFrame, int idAgent) {
		this.idAgent = idAgent;
		agent = agentService.recupererAgentEnBdd(idAgent);
		this.canvasFrame = canvasFrame;

		// on définit le layout manager de la page entière
		this.setLayout(new GridBagLayout());

		// L'objet servant à positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();

		// On positionne la case de départ du composant
		gbc.gridx = 0;
		gbc.gridy = 0;
		// La taille en hauteur et en largeur
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		// Espace autour du composant
		gbc.ipadx = 40;
		gbc.ipady = 40;
		Bouton bouton = new Bouton("Identification");
		// on associe une action de redirection à notre bouton
		bouton.setAction(new RedirectionPageConnexionAction(bouton.getName(), canvasFrame));
		this.add(bouton, gbc);

		Image photoAgent = new Image("profil_vide.jpg");

		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(photoAgent, gbc);

		// Cette instruction informe le layout que c'est une fin de ligne
		Box infosAgent = Box.createVerticalBox();
		afficherInfosAgent(infosAgent);

		gbc.gridx = 2;
		gbc.gridy = 2;
		this.add(infosAgent, gbc);

		gbc.gridx = 10;
		gbc.gridy = 10;

		JPanel materielsAgent = new JPanel();
		afficherMaterielAgent(materielsAgent);
		this.add(materielsAgent);

	}

	/*
	 * Cette méthode permet d'afficher les infos relatives à l'agent qui s'est
	 * connecté
	 */
	public void afficherInfosAgent(JComponent c) {
		c.add(new JLabel("Identifiant : " + agent.getId()));
		c.add(new JLabel("Nom : " + agent.getNom()));
		c.add(new JLabel("Prénom :" + agent.getPrenom()));
		c.add(new JLabel("Date de naissance: " + agent.getDateNaissance()));

	}

	/*
	 * Cette méthode permet d'afficher l'ensemble du materiel disponible ainsi que
	 * des cases à cocher pour emprunter le matériel que l'on souhaite
	 */
	public void afficherMaterielAgent(JComponent c) {

		List<Materiel> materiel = new ArrayList<Materiel>();
		materiel = materielService.recupererToutLeMaterielEnBDD(idAgent);

		GridLayout layoutMateriel = new GridLayout();
		layoutMateriel.setRows(materiel.size());
		layoutMateriel.setColumns(3);
		// nombre de pixels d'espace entre les colonnes
		layoutMateriel.setHgap(10);
		// nombre de pixels d'espace entre les lignes
		layoutMateriel.setVgap(10);
		c.setLayout(layoutMateriel);

		for (Materiel m : materiel) {
			c.add(new JLabel(m.getLibelle()));
			c.add(new Checkbox(m,agent));
		}
	}
}
