package org.App.Entities;

public enum Airline {

    AZAL("J2"),
    WIZZAIR("W6"),
    TURKISH_AIRLINES("TK"),
    AIR_FRANCE("AF"),
    LUFTHANSA("LH"),
    QATAR_AIRWAYS("QR"),
    EMIRATES("EK"),
    AEROSVIT("VV"),
    LOT_AIRLINES("LO"),
    USA_AIRWAYS("US");


    private final String code;

    Airline(String IATAcode){
        this.code = IATAcode;
    }

    public String getCode(){
        return this.code;
    }



}
