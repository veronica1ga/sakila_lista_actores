/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ejemplojsfgonzalezv.web.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Veronica Gonzalez
 */
public class DaoFactory implements ConnectionProvider{
    

    //private static final Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);

    private static DaoFactory instance;

    private DataSource ds;
    private DatabaseConfig dbCfg;

    private DaoFactory() {

        ResourceBundle rb = ResourceBundle.getBundle("database");

        try {
            InitialContext ctx = new InitialContext();
            dbCfg = new DatabaseConfig(rb.getString("db.driver"),
                    rb.getString("db.url"),rb.getString("db.user"),rb.getString("db.password"));

            //LOGGER.debug("Pidiendo datasource: {}", dbCfg.getDatasourceName());
            
    
        } catch (NamingException ex) {
            //LOGGER.error(null, ex);
        }

    }

    public static synchronized DaoFactory getInstance() {

        if (instance == null) {
            instance = new DaoFactory();
        }

        return instance;
    }

  
    @Override
    public Connection getConexion() {

        try {
        	Class.forName(dbCfg.getDriverName());
            Connection conn=DriverManager.getConnection(dbCfg.getUrl(),dbCfg.getUser(),dbCfg.getPassword());
            return conn;
        } catch (ClassNotFoundException ex) {
            //LOGGER.error(null, ex);
            ex.printStackTrace();
        }
        catch(SQLException e) {
        	e.printStackTrace();
        }
		return null;
    }

   
}
