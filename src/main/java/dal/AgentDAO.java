package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Agent;


public class AgentDAO implements IDAO<Agent, Long> {

	private static final String INSERT_QUERY = "INSERT INTO agent (id,nom,prenom,date_de_naissance) values (?,?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE agent set nom = ?, prenom = ?; date_de_naissance = ? where id = ?";
	private static final String REMOVE_QUERY = "DELETE from agent where id = ?";
	private static final String FIND_ALL_QUERY = "SELECT * from agent";

	private static final String FIND_BY_ID_QUERY = "SELECT * from agent where id = ?";

	public void create(Agent a) throws SQLException {

		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, a.getId());
		st.setString(2, a.getNom());
		st.setString(3, a.getPrenom());
		st.setDate(4, a.getDateNaissance());
		st.executeUpdate();
		st.close();

	}

	public void update(Agent a) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(UPDATE_QUERY, Statement.RETURN_GENERATED_KEYS);

		st.setString(1, a.getNom());
		st.setString(2, a.getPrenom());
		st.setDate(3, a.getDateNaissance());
		st.setInt(4, a.getId());
		st.executeUpdate();
		st.close();

	}

	public void remove(Agent a) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(REMOVE_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, a.getId());
		st.executeUpdate();
		st.close();

	}

	public List<Agent> findAll() throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(FIND_ALL_QUERY, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = st.executeQuery();
		List<Agent> liste = new ArrayList<Agent>();
		if (rs != null) {
			while (rs.next()) {
				Agent agent = new Agent();
				agent.setId(rs.getInt("id"));
				agent.setNom(rs.getString("nom"));
				agent.setPrenom(rs.getString("prenom"));
				agent.setDateNaissance(rs.getDate("date_de_naissance"));
				agent.setPhoto(rs.getString("photo"));

				liste.add(agent);
			}
		}
		st.close();
		return liste;
	}

	public Agent findById(int id) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(FIND_BY_ID_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		Agent agent = new Agent();
		if (rs != null) {
			if (rs.next()) {
				agent.setId(rs.getInt("id"));
				agent.setNom(rs.getString("nom"));
				agent.setPrenom(rs.getString("prenom"));
				agent.setDateNaissance(rs.getDate("date_de_naissance"));
				agent.setPhoto(rs.getString("photo"));
				st.close();
				return agent;
			}
		}
		return null;
	}

	public Agent findById(Agent o) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}