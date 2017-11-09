/*
 * Copyright 2009-2017 PIANOo; TenderNed programma.
 */
package nl.schutte.scraper.meteoor.scraper;

import nl.schutte.scraper.meteoor.domain.BadmintonSpeler;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 08-11-2017
 */
public interface Scraper {

    public BadmintonSpeler scrape(BadmintonSpeler badmintonSpeler);
}
