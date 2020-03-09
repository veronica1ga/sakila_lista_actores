package es.cifpcm.ejemplojsfgonzalezv.web.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cifpcm.ejemplojsfgonzalezv.web.model.Actor;

public class ActorDAOImpl implements ActorDAO {
	// private final org.slf4j.Logger logger = LoggerFactory.getLogger(Actor.class);
	DaoFactory dao=DaoFactory.getInstance();
	Connection conn = dao.getConexion();
	private Actor actor1;
	
	@Override
	public Actor insert(Actor actor) {
		Actor actorInsertado= actor;
        String sql= "insert into actor (first_name, last_name) value (?,?)";
        try{
        	PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, actor.getFirstName());
            stmt.setString(2, actor.getLastName());
            stmt.executeUpdate();
            ResultSet rs=stmt.getGeneratedKeys();
            while(rs.next()){
                actor.setActorId(rs.getInt(1));
            }
            actorInsertado=actor;
            //logger.info("Consulta OK: {}", sql);
            
        }catch(SQLException ex){
            //logger.error("ERROR sql: {}", ex.getMessage());
        	ex.printStackTrace();
        }
        return actorInsertado;
	}

	@Override
	public List<Actor> selectAll() {
		
		List<Actor> actores = new ArrayList<Actor>();
		try {
			String sql = "SELECT * FROM actor";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setMaxRows(20);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Actor a = new Actor();
				a.setActorId(rs.getInt(1));
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				actores.add(a);
			}

			// logger.info("Consulta OK: {}", sql);
		} catch (SQLException ex) {
			// logger.error("ERROR: {}", ex.getMessage());
			ex.printStackTrace();
		} finally { // Se cierra la conexión con la base de datos.
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				// logger.error("ERROR: {}", ex.getMessage());
				ex.printStackTrace();
			}
		}
		return actores;
	}

}
