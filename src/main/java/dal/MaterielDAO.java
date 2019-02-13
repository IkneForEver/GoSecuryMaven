package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Materiel;

public class MaterielDAO {
	private static final String INSERT_QUERY = "INSERT INTO materiel (id,libelle,quantite) values (?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE materiel set libelle = ?, quantite = ? where id = ?";
	private static final String REMOVE_QUERY = "DELETE from materiel where id = ?";
	private static final String FIND_ALL_QUERY = "SELECT * from materiel";

	private static final String FIND_BY_ID_QUERY = "SELECT * from materiel where id = ?";

	public void create(Materiel m) throws SQLException {

		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, m.getId());
		st.setString(2, m.getLibelle());
		st.setInt(3, m.getQuantite());
		st.executeUpdate();
		st.close();

	}

	public void update(Materiel m) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(UPDATE_QUERY, Statement.RETURN_GENERATED_KEYS);

		st.setString(1, m.getLibelle());
		st.setInt(2, m.getQuantite());
		st.setInt(3, m.getId());
		st.executeUpdate();
		st.close();

	}

	public void remove(Materiel m) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(REMOVE_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, m.getId());
		st.executeUpdate();
		st.close();

	}

	public List<Materiel> findAll() throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(FIND_ALL_QUERY, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = st.executeQuery();
		List<Materiel> liste = new ArrayList<Materiel>();
		if (rs != null) {
			while (rs.next()) {
				Materiel materiel = new Materiel();
				materiel.setId(rs.getInt("id"));
				materiel.setLibelle(rs.getString("libelle"));
				materiel.setQuantite(rs.getInt("quantite"));

				liste.add(materiel);
			}
		}
		st.close();
		return liste;
	}

	public Materiel findById(int id) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		PreparedStatement st = connection.prepareStatement(FIND_BY_ID_QUERY, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		Materiel materiel = new Materiel();
		if (rs != null) {
			if (rs.next()) {
				materiel.setId(rs.getInt("id"));
				materiel.setLibelle(rs.getString("libelle"));
				materiel.setQuantite(rs.getInt("quantite"));

				st.close();
				return materiel;
			}
		}
		return null;
	}

	public Materiel findById(Materiel m) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
