package fr.upec.episen;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Ephemeride {
    private float latitude;
    private float longitude;
    private int insee;
    private int day;
    private String datetime;
    private String sunrise;
    private String sunset;
    @JsonProperty("duration_day")
    private String durationDay;
    @JsonProperty("diff_duration_day")
    private int diffDurationDay;
    @JsonProperty("moon_age")
    private float moonAge;
    @JsonProperty("moon_phase")
    private String moonPhase;

    // Constructeur(s)
    public Ephemeride() {

    }

    public Ephemeride(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Ephemeride temp = objectMapper.readValue(json, Ephemeride.class);
        this.insee = temp.getInsee();
        this.latitude = temp.getLatitude();
        this.longitude =temp.getLongitude();
        this.day =temp.getDay();
        this.datetime = temp.getDatetime();
        this.sunrise = temp.getSunrise();
        this.sunset = temp.getSunset();
        this.durationDay = temp.getDurationDay();
        this.diffDurationDay = temp.getDiffDurationDay();
        this.moonAge = temp.getMoonAge();
        this.moonPhase = temp.getMoonPhase();
    }

    // Accesseurs et Mutateurs
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getInsee() {
        return insee;
    }

    public void setInsee(int codeInsee) {
        this.insee = codeInsee;
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

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getDurationDay() {
        return durationDay;
    }

    public void setDurationDay(String durationDay) {
        this.durationDay = durationDay;
    }

    public int getDiffDurationDay() {
        return diffDurationDay;
    }

    public void setDiffDurationDay(int diffDurationDay) {
        this.diffDurationDay = diffDurationDay;
    }

    public float getMoonAge() {
        return moonAge;
    }

    public void setMoonAge(float moonAge) {
        this.moonAge = moonAge;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }
}
