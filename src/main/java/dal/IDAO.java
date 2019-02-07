package dal;



import java.sql.SQLException;
import java.util.List;

public interface IDAO<E, ID> {
	
	public void create( E o ) throws SQLException;
		
	public List<E> findAll() throws SQLException;
	
	public void update( E o ) throws SQLException;
	
	public void remove( E o ) throws SQLException;

	public E findById(E o) throws SQLException;
}
