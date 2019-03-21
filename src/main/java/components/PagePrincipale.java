package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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

		Bouton bouton = new Bouton("Identification");
		// on associe une action de redirection à notre bouton
		bouton.setAction(new RedirectionPageConnexionAction(bouton.getName(), canvasFrame));

		// On positionne la case de départ du composant
		gbc.gridx = gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		// gbc.weighty= 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;

		// Espace autour du composant
		gbc.insets = new Insets(10, 15, 0, 0); // Marge à gauche de 15 et marge au dessus de 10.
		this.add(bouton, gbc);

		Image photoAgent = new Image("profil_vide.jpg");

		gbc.gridx = 1;
		gbc.gridy = 0;
	

		// Espace autour du composant
		// gbc.insets = new Insets(10, 0, 15, 0); // Marge à droite de 15 et marge au
		// dessus de 10.
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;

		this.add(photoAgent, gbc);

		// Cette instruction informe le layout que c'est une fin de ligne

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;

		Box infosAgent = Box.createVerticalBox();
		afficherInfosAgent(infosAgent);

		this.add(infosAgent, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.PAGE_END;

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
		layoutMateriel.setColumns(2);
		// nombre de pixels d'espace entre les colonnes
		layoutMateriel.setHgap(10);
		// nombre de pixels d'espace entre les lignes
		layoutMateriel.setVgap(10);
		c.setLayout(layoutMateriel);

		for (Materiel m : materiel) {
			c.add(new JLabel(m.getLibelle()));
			c.add(new Checkbox(m, agent));
		}
	}
}
