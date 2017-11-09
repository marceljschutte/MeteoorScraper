/*
 * Copyright 2009-2017 PIANOo; TenderNed programma.
 */
package nl.schutte.scraper.meteoor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import nl.schutte.scraper.dao.BaseDao;
import nl.schutte.scraper.meteoor.dao.mapper.BadmintonSpelerMapper;
import nl.schutte.scraper.meteoor.domain.BadmintonSpeler;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 09-11-2017
 */
public class BadmintonSpelerDao extends BaseDao {

    private Statement createNewStatement(){
        return this.em.createStatement();
    }

    public Set<BadmintonSpeler> findAllBadmintonSpelers(){
        Statement statement = createNewStatement();
        try {
            try (ResultSet result = statement.executeQuery("select * from badmintonspeler")) {
                return BadmintonSpelerMapper.mapFromResultSet(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error", e);  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
