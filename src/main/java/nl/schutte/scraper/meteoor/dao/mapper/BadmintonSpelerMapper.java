/*
 * Copyright 2009-2017 PIANOo; TenderNed programma.
 */
package nl.schutte.scraper.meteoor.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import nl.schutte.scraper.meteoor.domain.BadmintonSpeler;

import nl.schutte.scraper.meteoor.domain.BadmintonSpeler;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 09-11-2017
 */
public class BadmintonSpelerMapper {

    public static Set<BadmintonSpeler> mapFromResultSet(ResultSet input) throws SQLException {
        Set<BadmintonSpeler> resultaat = new HashSet<BadmintonSpeler>();
        while (input.next()) {
            BadmintonSpeler result = new BadmintonSpeler(input.getString(BadmintonSpeler.VOORNAAM), input.getString(BadmintonSpeler.ACHTERNAAM), input.getString(BadmintonSpeler.RANKING));
            resultaat.add(result);
        }
        return resultaat;
    }
}
