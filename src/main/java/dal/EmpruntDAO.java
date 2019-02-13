package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Emprunt;

public class EmpruntDAO {
	private static final String INSERT_QUERY = "INSERT INTO emprunt (id_agent,id_materiel,date_emprunt) values (?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE emprunt set date_emprunt = ? where id_agent = ? and id_materiel = ?";
	private static final String REMOVE_QUERY = "DELETE from emprunt where id_agent = ? and id_materiel = ?";
	private static final String FIND_ALL_QUERY = "SELECT * from emprunt";
	private static final String FIND_BY_ID_QUERY = "SELECT * from emprunt where id_agent = ? and id_materiel = ?";

	public void create(Emprunt e) throws SQLException {

		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, e.getIdAgent());
		st.setInt(2, e.getIdMateriel());
		st.setDate(3, e.getDateEmprunt());
		st.executeUpdate();
		st.close();

	}

	public void update(Emprunt e) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(UPDATE_QUERY, Statement.RETURN_GENERATED_KEYS);

		st.setDate(1, e.getDateEmprunt());
		st.setInt(2, e.getIdAgent());
		st.setInt(3, e.getIdMateriel());
		st.executeUpdate();
		st.close();

	}

	public void remove(Emprunt e) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(REMOVE_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, e.getIdAgent());
		st.setInt(2, e.getIdMateriel());
		st.executeUpdate();
		st.close();

	}

	public List<Emprunt> findAll() throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(FIND_ALL_QUERY, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = st.executeQuery();
		List<Emprunt> liste = new ArrayList<Emprunt>();
		if (rs != null) {
			while (rs.next()) {
				Emprunt emprunt = new Emprunt();
				emprunt.setIdAgent(rs.getInt("id_agent"));
				emprunt.setIdMateriel(rs.getInt("id_materiel"));
				emprunt.setDateEmprunt(rs.getDate("date_emprunt"));
				liste.add(emprunt);
			}
		}
		st.close();
		return liste;
	}

	public Emprunt findById(int id_agent, int id_materiel) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(FIND_BY_ID_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, id_agent);
		st.setInt(2,id_materiel);
		ResultSet rs = st.executeQuery();
		Emprunt emprunt = new Emprunt();
		if (rs != null) {
			if (rs.next()) {
				emprunt.setIdAgent(rs.getInt("id_agent"));
				emprunt.setIdMateriel(rs.getInt("id_materiel"));
				emprunt.setDateEmprunt(rs.getDate("date_emprunt"));
				st.close();
				return emprunt;
			}
		}
		return null;
	}

	public Emprunt findById(Emprunt m) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
