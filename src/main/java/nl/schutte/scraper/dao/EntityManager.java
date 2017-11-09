package nl.schutte.scraper.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 09-11-2017
 */
public final class EntityManager {

    private static final EntityManager INSTANCE = new EntityManager();
    private Connection dsConnection;

    private EntityManager() {
        try {
            initDB();
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);
        }
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    public static EntityManager getInstance() {
        return INSTANCE;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cannot clone instance of this class");
    }

    private void initDB() throws SQLException {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:meteoorscraper");
        ds.setUser("sa");
        ds.setPassword("sa");
        dsConnection = ds.getConnection();

        try (Statement st = dsConnection.createStatement()) {
            RunScript.execute(dsConnection, new FileReader("src/main/resources/schema.sql"));
            RunScript.execute(dsConnection, new FileReader("src/main/resources/populate.sql"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error", e);  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public Statement createStatement() {
        try {
            return dsConnection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
