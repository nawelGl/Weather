package fr.upec.episen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Item {
    private int insee;
    private int cp;
    private double latitude;
    private double longitude;
    private int day;
    private String datetime;
    private int wind10m;
    private int gust10m;
    private int dirwind10m;
    private int rr10;
    private int rr1;
    private int probarain;
    private int weather;
    private int tmin;
    private int tmax;
    @JsonProperty("sun_hours")
    private int sunhours;
    private int etp;
    private int probafrost;
    private int probafog;
    private int probawind70;
    private int probawind100;
    private int gustx;

    public Item(){

    }

    public Item(String json) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        Item temp = objectMapper.readValue(json, Item.class);
        this.insee = temp.getInsee();
        this.latitude = temp.getLatitude();
        this.longitude =temp.getLongitude();
        this.day =temp.getDay();
        this.datetime = temp.getDatetime();
        this.cp = temp.getCp();
        this.wind10m = temp.getWind10m();
        this.gust10m = temp.getGust10m();
        this.dirwind10m = temp.getDirwind10m();
        this.rr10 = temp.getRr10();
        this.rr1 = temp.getRr1();
        this.probarain = temp.getProbarain();
        this.weather = temp.getWeather();
        this.tmin =temp.getTmin();
        this.tmax =temp.getTmax();
        this.sunhours = temp.getSunhours();
        this.etp = temp.getEtp();
        this.probafrost = temp.getProbafrost();
        this.probafog = temp.getProbafog();
        this.probawind100 = temp.getProbawind100();
        this.probawind70 = temp.getProbawind70();
        this.gustx = temp.getGustx();
    }

    public int getInsee() {
        return insee;
    }

    public void setInsee(int insee) {
        this.insee = insee;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getWind10m() {
        return wind10m;
    }

    public void setWind10m(int wind10m) {
        this.wind10m = wind10m;
    }

    public int getGust10m() {
        return gust10m;
    }

    public void setGust10m(int gust10m) {
        this.gust10m = gust10m;
    }

    public int getDirwind10m() {
        return dirwind10m;
    }

    public void setDirwind10m(int dirwind10m) {
        this.dirwind10m = dirwind10m;
    }

    public int getRr10() {
        return rr10;
    }

    public void setRr10(int rr10) {
        this.rr10 = rr10;
    }

    public int getRr1() {
        return rr1;
    }

    public void setRr1(int rr1) {
        this.rr1 = rr1;
    }

    public int getProbarain() {
        return probarain;
    }

    public void setProbarain(int probarain) {
        this.probarain = probarain;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public int getTmin() {
        return tmin;
    }

    public void setTmin(int tmin) {
        this.tmin = tmin;
    }

    public int getTmax() {
        return tmax;
    }

    public void setTmax(int tmax) {
        this.tmax = tmax;
    }

    public int getSunhours() {
        return sunhours;
    }

    public void setSunhours(int sunhours) {
        this.sunhours = sunhours;
    }

    public int getEtp() {
        return etp;
    }

    public void setEtp(int etp) {
        this.etp = etp;
    }

    public int getProbafrost() {
        return probafrost;
    }

    public void setProbafrost(int probafrost) {
        this.probafrost = probafrost;
    }

    public int getProbafog() {
        return probafog;
    }

    public void setProbafog(int probafog) {
        this.probafog = probafog;
    }

    public int getProbawind70() {
        return probawind70;
    }

    public void setProbawind70(int probawind70) {
        this.probawind70 = probawind70;
    }

    public int getProbawind100() {
        return probawind100;
    }

    public void setProbawind100(int probawind100) {
        this.probawind100 = probawind100;
    }

    public int getGustx() {
        return gustx;
    }

    public void setGustx(int gustx) {
        this.gustx = gustx;
    }
}