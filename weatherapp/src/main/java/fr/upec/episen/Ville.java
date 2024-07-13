package fr.upec.episen;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ville {
    //Atributs
    private String name;
    private int cp;
    private int insee;
    private int altitude;
    private double longitude;
    private double latitude;

    //Constructeur(s)
    public Ville(){

    }

    public Ville(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Ville temp = objectMapper.readValue(json, Ville.class);
        this.insee = temp.getInsee();
        this.cp = temp.getCp();
        this.name =temp.getName();
        this.altitude =temp.getAltitude();
        this.longitude = temp.getLongitude();
        this.altitude = temp.getAltitude();
    }

    public Ville(int codeInsee, int codePostal, String nomVille){
        this.insee = codeInsee;
        this.name = nomVille;
        this.cp = codePostal;
    }

    public Ville(int codeInsee, int codePostal, String nomVille, double latitude, double longitude, int altitude){
        this.insee = codeInsee;
        this.cp = codePostal;
        this.name = nomVille;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    //Accesseurs
    public int getInsee() {
        return insee;
    }

    public void setInsee(int codeInsee) {
        this.insee = codeInsee;
    }

    public String getName() {
        return name;
    }

    public void setName(String nomVille) {
        this.name = nomVille;
    }

    public int getCp() {
        return cp;
    }
    
    public void setCp(int codePostal) {
        this.cp = codePostal;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    //toString
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append(name);
        string.append(" (" + cp + ") : ");
        string.append(" altitude : " + altitude + ",");
        string.append(" latitude : " + latitude + ",");
        string.append(" longitude : " + longitude);
        return String.valueOf(string);
    }
    
}
