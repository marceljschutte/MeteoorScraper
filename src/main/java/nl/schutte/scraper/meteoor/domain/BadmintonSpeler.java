/*
 * Copyright 2009-2017 PIANOo; TenderNed programma.
 */
package nl.schutte.scraper.meteoor.domain;

import java.util.Set;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 07-11-2017
 */
public class BadmintonSpeler {

    private String voorNaam;
    private String achterNaam;
    private String rankingId;
    private Set<Ranking> rankings;

    public static final String VOORNAAM = "voornaam";
    public static final String ACHTERNAAM = "achternaam";
    public static final String RANKING = "rankingid";

    public BadmintonSpeler(String voorNaam, String achterNaam, String rankingId) {
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.rankingId = rankingId;
    }

    public Set<Ranking> getRankings() {
        return rankings;
    }

    public BadmintonSpeler setRankings(Set<Ranking> rankings) {
        this.rankings = rankings;
        return this;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public String getRankingId() {
        return rankingId;
    }

    public String getNaam() { return voorNaam + " " + achterNaam;}

    public long getEnkelRanking(){return (findRanking(Onderdeel.ENKEL) != null ? findRanking(Onderdeel.ENKEL).getRanking(): 0 );}
    public long getDubbelRanking(){return (findRanking(Onderdeel.DUBBEL) != null ? findRanking(Onderdeel.DUBBEL).getRanking(): 0 );}
    public long getMixRanking(){return (findRanking(Onderdeel.GEMENGDDUBBEL) != null ? findRanking(Onderdeel.GEMENGDDUBBEL).getRanking(): 0 );}

    private Ranking findRanking(Onderdeel onderdeel){
        for (Ranking r: getRankings()){
            if(r.getOnderdeel().equals(onderdeel)){
                return r;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "BadmintonSpeler{" +
                "voorNaam='" + voorNaam + '\'' +
                ", achterNaam='" + achterNaam + '\'' +
                ", rankingId='" + rankingId + '\'' +
                ", rankings=" + rankings +
                '}';
    }
}
