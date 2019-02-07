package dal;

import domain.Agent;

public class DAOFactory {
	
	private DAOFactory() {}
	
	public static IDAO<Agent, Long> getContactDAO() {
		return new AgentDAO();
	}
	
	
}

