/*
 * Copyright 2009-2017 PIANOo; TenderNed programma.
 */
package nl.schutte.scraper;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import nl.schutte.scraper.meteoor.dao.BadmintonSpelerDao;
import nl.schutte.scraper.meteoor.domain.BadmintonSpeler;
import nl.schutte.scraper.meteoor.service.BadmintonSpelerService;
import nl.schutte.scraper.meteoor.service.BadmintonSpelerServiceImpl;

import org.apache.commons.lang3.StringUtils;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 08-11-2017
 */
public class StartScraper {

    static BadmintonSpelerService service;

    public static void main(String[] args) {
        BadmintonSpelerDao dao = new BadmintonSpelerDao();
        dao.findAllBadmintonSpelers();
        service = new BadmintonSpelerServiceImpl();
        Set<BadmintonSpeler> alleSpelers = service.getAll();
        Set<BadmintonSpeler> alleVerrijkteSpelers = new HashSet<BadmintonSpeler>();
        for(BadmintonSpeler bs: service.getAll()) {
            alleVerrijkteSpelers.add(retrieveSpelerData(bs));
       //     System.out.println(bs);
        }
        printConsoleTabel(alleVerrijkteSpelers);
    }

    private static void printConsoleTabel(Set<BadmintonSpeler> alleSpelers) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("|                               | Enkel    | Dubbel   | Mix      |");
        System.out.println("------------------------------------------------------------------");
        for (BadmintonSpeler bs: alleSpelers) {
        System.out.println("| " + StringUtils.rightPad(bs.getNaam(), 30) + "| " + StringUtils.rightPad(String.valueOf(bs.getEnkelRanking()), 9) + "| "+ StringUtils.rightPad(String.valueOf(bs.getDubbelRanking()), 9) + "| "+ StringUtils.rightPad(String.valueOf(bs.getMixRanking()), 9) + "|");
        }
        System.out.println("------------------------------------------------------------------");


    }

    private static BadmintonSpeler retrieveSpelerData(BadmintonSpeler speler){
        return service.retrieveBadmintonSpelerData(speler);
    }


}
