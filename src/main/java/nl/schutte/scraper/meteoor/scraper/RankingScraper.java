/*
 * Copyright 2009-2017 PIANOo; TenderNed programma.
 */
package nl.schutte.scraper.meteoor.scraper;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.schutte.scraper.meteoor.domain.Onderdeel;
import nl.schutte.scraper.meteoor.domain.Ranking;
import nl.schutte.scraper.util.HtmlWebClient;

import nl.schutte.scraper.meteoor.domain.BadmintonSpeler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableDataCell;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 08-11-2017
 */
public class RankingScraper implements Scraper {

    private static final String BASE_URL = "http://badmintonnederland.toernooi.nl/ranking/player.aspx?rid=75&player=";

    private HtmlWebClient webClient;

    private HtmlPage page;

    public RankingScraper() {
        this.webClient = new HtmlWebClient();
    }

    public BadmintonSpeler scrape(BadmintonSpeler badmintonSpeler) {
        try {
            page = webClient.getPage(BASE_URL+badmintonSpeler.getRankingId());
        } catch (IOException e) {
            System.out.println("Fout bij het ophalen van pagina: " + BASE_URL+badmintonSpeler.getRankingId());
            return null;
        }

        List<HtmlElement> ranking1 = (List<HtmlElement>) page.getByXPath("//*[@id=\"content\"]/table[1]/tbody/tr[2]");
        List<HtmlElement> ranking2 = (List<HtmlElement>) page.getByXPath("//*[@id=\"content\"]/table[1]/tbody/tr[3]");
        List<HtmlElement> ranking3 = (List<HtmlElement>) page.getByXPath("//*[@id=\"content\"]/table[1]/tbody/tr[4]");

        Set<Ranking> combiRankings = new HashSet<Ranking>();

        if (ranking1.isEmpty() && ranking2.isEmpty() && ranking3.isEmpty()) {
            System.out.println("No items found !");
        } else {
            for (DomNode x : ranking1) {
                HtmlTableDataCell onderdeel = x.getFirstByXPath("//*/td[1]");
                HtmlTableDataCell plaats = x.getFirstByXPath("//*/td[2]");
                HtmlTableDataCell punten = x.getFirstByXPath("//*/td[5]");
                combiRankings.add(new Ranking(Onderdeel.fromString(onderdeel.getTextContent()), Long.valueOf(plaats.getTextContent()),
                        Long.valueOf(punten.getTextContent())));
            }
            for (DomNode x : ranking2) {
                HtmlTableDataCell onderdeel = x.getFirstByXPath("//*/tr[3]/td[1]");
                HtmlTableDataCell plaats = x.getFirstByXPath("//*/tr[3]/td[2]");
                HtmlTableDataCell punten = x.getFirstByXPath("//*/tr[3]/td[5]");
                combiRankings.add(new Ranking(Onderdeel.fromString(onderdeel.getTextContent()), Long.valueOf(plaats.getTextContent()),
                        Long.valueOf(punten.getTextContent())));
            }
            for (DomNode x : ranking3) {
                HtmlTableDataCell onderdeel = x.getFirstByXPath("//*/tr[4]/td[1]");
                HtmlTableDataCell plaats = x.getFirstByXPath("//*/tr[4]/td[2]");
                HtmlTableDataCell punten = x.getFirstByXPath("//*/tr[4]/td[5]");
                combiRankings.add(new Ranking(Onderdeel.fromString(onderdeel.getTextContent()), Long.valueOf(plaats.getTextContent()),
                        Long.valueOf(punten.getTextContent())));
            }

            for (Ranking rank : combiRankings) {
                System.out.println(rank);
            }
        }
        return badmintonSpeler.setRankings(combiRankings);
    }
}
