package org.App.Entities;

public enum Airport {

    BAKU("GYD"),
    ISTANBUL("IST"),
    KYIV("IEV"),
    NEW_YORK("JFK"),
    MOSCOW("SVO"),
    MILAN("MIL"),
    LONDON("LON"),
    TOKYO("TYO"),
    BUDAPEST("BUD"),
    VIENNA("VIE");


    private final String code;

    Airport(String IATACode){
        this.code = IATACode;
    }

    public String getCode(){ return this.code;}

}
