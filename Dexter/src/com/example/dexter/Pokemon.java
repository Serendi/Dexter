package com.example.dexter;

/**
 * Pokemon object contains all the data
 * related to a specific Pokemon.
 */

public class Pokemon {
    //Pokemon data
    private int id;
    private String pID;
    private String name;
    private String imgSrc;
    private String type1;
    private String type2;
    private String locX;
    private String locY;
    private String dmgTaken;
    private String own;
    private String favorite;

    public Pokemon(){}

    public Pokemon(String pID, String name, String imgSrc, String type1, String type2, String locX, String locY, String dmgTaken, String own, String favorite) {
        this.pID = pID;
        this.name = name;
        this.imgSrc = imgSrc;
        this.type1 = type1;
        this.type2 = type2;
        this.locX = locX;
        this.locY = locY;
        this.dmgTaken = dmgTaken;
        this.own = own;
        this.favorite = favorite;
    }

    /* setters */
    public void setId(int id) { this.id = id; }
    public void setPID(String pID) { this.pID = pID; }
    public void setName(String name) { this.name = name; }
    public void setImgSrc(String imgSrc) { this.imgSrc = imgSrc; }
    public void setType1(String type1) { this.type1 = type1; }
    public void setType2(String type2) { this.type2 = type2; }
    public void setLocX(String locX) { this.locX = locX; }
    public void setLocY(String locY) { this.locY = locY; }
    public void setDmgTaken(String dmgTaken) { this.dmgTaken = dmgTaken; }
    public void setOwn(String own) { this.own = own; }
    public void setFavorite(String favorite) { this.favorite = favorite; }

    /* getters */
    public int getID() { return this.id; }
    public String getPID() { return this.pID; }
    public String getName() { return this.name; }
    public String getImgSrc() { return this.imgSrc; }
    public String getType1() { return this.type1; }
    public String getType2() { return this.type2; }
    public String getLocX() { return this.locX; }
    public String getLocY() { return this.locY; }
    public String getDmgTaken() { return this.dmgTaken; }
    public String getOwn() { return this.own; }
    public String getFavorite() {return this.favorite; }

    /**
     * Returns a string containing all of the Pokemon data.
     */
    public String toString() {
        return
            "ID : " + id + "\n" +
            "PID : " + pID + "\n" +
            "NAME : " + name + "\n" +
            "IMG_SRC: " + imgSrc + "\n" +
            "TYPE1: " + type1 + "\n" +
            "TYPE2: " + type2 + "\n" +
            "LOC(X): " + locX + "\n" +
            "LOC(Y): " + locY + "\n" +
            "DMG_TAKEN: " + dmgTaken + "\n" +
            "OWNED: " + own + "\n" +
            "FAVORITE: " + favorite;
    }

}
