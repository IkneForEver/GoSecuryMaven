package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.AgentDAO;
import domain.Agent;

public  final class AgentService {
	
	
	private static final AgentDAO agentDao = new AgentDAO();
	
	public Agent recupererAgentEnBdd(int idAgent) {
		try {
			Agent agent = agentDao.findById(idAgent);
			return agent;
		} catch (SQLException e) {
			System.out.println("Erreur lors de la r�cup�ration des donn�es de l'agent :" + e);
		}
		return null;
	}
	
	public List<Agent> recupererTousLesAgentsEnBDD() {
		List<Agent> liste = new ArrayList<Agent>();
		try {
			liste = agentDao.findAll();
		} catch (SQLException e) {
			System.out.println(
					"Erreur lors de la r�cup�ration de l'ensemble des agents en base : " + e);
		}
		return liste;
	}
	
}
