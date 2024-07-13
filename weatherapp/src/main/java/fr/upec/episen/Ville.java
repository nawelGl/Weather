package fr.upec.episen;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ville {
    //Atributs
    private String nomVille;
    private int codePostal;
    private int codeInsee;
    private int altitude;
    private double longitude;
    private double latitude;

    //Constructeur(s)
    public Ville(){

    }

    public Ville(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Ville temp = objectMapper.readValue(json, Ville.class);
        this.codeInsee = temp.getCodeInsee();
        this.codePostal = temp.getCodePostal();
        this.nomVille =temp.getNomVille();
        this.altitude =temp.getAltitude();
        this.longitude = temp.getLongitude();
        this.altitude = temp.getAltitude();
    }

    public Ville(int codeInsee, int codePostal, String nomVille){
        this.codeInsee = codeInsee;
        this.nomVille = nomVille;
        this.codePostal = codePostal;
    }

    public Ville(int codeInsee, int codePostal, String nomVille, double latitude, double longitude, int altitude){
        this.codeInsee = codeInsee;
        this.codePostal = codePostal;
        this.nomVille = nomVille;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    //Accesseurs
    public int getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(int codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public int getCodePostal() {
        return codePostal;
    }
    
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
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
        string.append(nomVille);
        string.append(" (" + codePostal + ") : ");
        string.append(" altitude : " + altitude + ",");
        string.append(" latitude : " + latitude + ",");
        string.append(" longitude : " + longitude);
        return String.valueOf(string);
    }
    
}
