package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.bytedeco.javacv.CanvasFrame;

import actions.RedirectionPageConnexionAction;
import dal.AgentDAO;
import domain.Agent;

public class PagePrincipale extends JPanel {

	/**
	 * generated uid
	 */
	private static final long serialVersionUID = 1L;
	
	private static final AgentDAO agentDao = new AgentDAO();
	
	private Agent agent;
	
	private  int idAgent;
	
	public CanvasFrame canvasFrame;

	public PagePrincipale(CanvasFrame canvasFrame,int idAgent) {
		this.idAgent=idAgent;
		this.canvasFrame = canvasFrame;
		this.setLayout(new GridLayout(1,2));
		this.setBackground(Color.BLUE);

		Bouton bouton = new Bouton("Identification");
		//on associe une action de redirection à notre bouton
		bouton.setAction(new RedirectionPageConnexionAction(bouton.getName(),canvasFrame) );
		
		JPanel identificationPanel = new JPanel();
		identificationPanel.setLayout(new GridLayout(2,1));
		identificationPanel.add(bouton);
		afficherInformationsAgent(recupererAgentEnBdd(),identificationPanel);
		
		JPanel photoAgent = new JPanel();
		
		JPanel pageHaut = new JPanel();
		pageHaut.setLayout(new GridLayout(1,2));
		pageHaut.add(identificationPanel);
		pageHaut.add(photoAgent);
		this.add(pageHaut,BorderLayout.CENTER);
		
		JPanel pageBas = new JPanel();
		this.add(pageBas, BorderLayout.CENTER);
		
	
	}
	
	
	public Agent recupererAgentEnBdd() {
		try {
			agent= agentDao.findById(idAgent);
			return agent;
		} catch (SQLException e) {
			System.out.println("Erreur lors de la récupération des données de l'agent :" + e);
		}
		return null;
	}
		
	public void afficherInformationsAgent(Agent agent, JPanel jpanel) {
		if(agent != null) {

			jpanel.add(new JLabel("<html>Identifiant: "
					+ agent.getId() 
					+ "<br>Nom: "
					+ agent.getNom()
					+ "<br>Prenom: "
					+ agent.getPrenom()
					+ "<br>Date de naissance: "
					+ agent.getDateNaissance().toString()),BorderLayout.SOUTH);
			
			
		}
	}
}
