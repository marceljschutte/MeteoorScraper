/*
 * Copyright 2009-2017 PIANOo; TenderNed programma.
 */
package nl.schutte.scraper.meteoor.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nl.schutte.scraper.meteoor.dao.BadmintonSpelerDao;
import nl.schutte.scraper.meteoor.domain.BadmintonSpeler;
import nl.schutte.scraper.meteoor.scraper.RankingScraper;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 08-11-2017
 */
public class BadmintonSpelerServiceImpl implements BadmintonSpelerService {

    private RankingScraper rankingScraper;

    private BadmintonSpelerDao badmintonSpelerDao = new BadmintonSpelerDao();

    public BadmintonSpelerServiceImpl() {
        rankingScraper =  new RankingScraper();
    }

    public BadmintonSpeler retrieveBadmintonSpelerData(BadmintonSpeler badmintonSpeler) {
        return retrieveRankingData(badmintonSpeler);
    }

    public Set<BadmintonSpeler> getAll() {
        return badmintonSpelerDao.findAllBadmintonSpelers();
    }

    private BadmintonSpeler retrieveRankingData(BadmintonSpeler badmintonSpeler){
        return rankingScraper.scrape(badmintonSpeler);
    }

    private BadmintonSpeler retrieveCompetitionResultData(BadmintonSpeler badmintonSpeler){
        throw new UnsupportedOperationException("Deze optie komt binnenkort beschikbaar");
    }
}
