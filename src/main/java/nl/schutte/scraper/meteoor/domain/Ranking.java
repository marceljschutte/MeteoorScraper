/*
 * Copyright 2009-2017 PIANOo; TenderNed programma.
 */
package nl.schutte.scraper.meteoor.domain;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 07-11-2017
 */
public class Ranking {
    private Onderdeel onderdeel;
    private long ranking;
    private long punten;

    public Ranking(Onderdeel onderdeel, long ranking, long punten) {
        this.onderdeel = onderdeel;
        this.ranking = ranking;
        this.punten = punten;
    }

    public Onderdeel getOnderdeel() {
        return onderdeel;
    }

    public void setOnderdeel(Onderdeel onderdeel) {
        this.onderdeel = onderdeel;
    }

    public long getRanking() {
        return ranking;
    }

    public void setRanking(long ranking) {
        this.ranking = ranking;
    }

    public long getPunten() {
        return punten;
    }

    public void setPunten(long punten) {
        this.punten = punten;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "onderdeel=" + onderdeel +
                ", ranking=" + ranking +
                ", punten=" + punten +
                '}';
    }
}
