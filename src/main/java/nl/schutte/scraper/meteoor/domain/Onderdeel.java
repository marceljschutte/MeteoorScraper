/*
 * Copyright 2009-2017 PIANOo; TenderNed programma.
 */
package nl.schutte.scraper.meteoor.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * introWebScraping - Description.
 *
 * @author Marcel Schutte
 * @since 07-11-2017
 */
public enum Onderdeel {
//    MANNENENKEL("Mannen enkel"),
//    MANNENDUBBEL("Mannen dubbel"),
//    VROUWENENKEL("Vrouwen enkel"),
//    VROUWENDUBBEL("Vrouwen dubbel"),
    ENKEL("Enkel"),
    DUBBEL("Dubbel"),
    GEMENGDDUBBEL("Gemengd dubbel");

    private String text;

    Onderdeel(String text) {
        this.text = text;
    }

    public static Onderdeel fromString(String text) {
        Onderdeel onderdeel;
        switch (StringUtils.lowerCase(text)) {
            case "dames enkel":
            case "damesenkel":
            case "vrouwen enkel":
            case "vrouwenenkel":
            case "mannenenkel":
            case "mannen enkel":
                onderdeel = Onderdeel.ENKEL;
                break;
            case "mannendubbel":
            case "mannen dubbel":
            case "vrouwendubbel":
            case "vrouwen dubbel":
                onderdeel = Onderdeel.DUBBEL;
                break;
            case "gemengd dubbel":
            case "gemengdubbel":
                onderdeel = Onderdeel.GEMENGDDUBBEL;
                break;
            default:
                throw new IllegalArgumentException("Invalide onderdeel: " + text);
        }
        return onderdeel;
    }
}
