package fr.upec.episen;

public class ForecastResponse {
    private Ville city;
    private Update update;
    private Forecast forecast;

    public ForecastResponse(){

    }

    public Ville getCity() {
        return city;
    }

    public void setCity(Ville city) {
        this.city = city;
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Ville : ").append(this.getCity().getName());
        string.append(" (").append(this.getCity().getCp()).append(")");
        string.append("\nAujourd'hui, il fait ").append(this.getForecast().getItems().get(0).getTmin()).append(" degrés minimum et ").append(this.getForecast().getItems().get(0).getTmax()).append(" degrés maximum.");
        string.append("\nDemain, il fera ").append(this.getForecast().getItems().get(1).getTmin()).append(" degrés minimum et ").append(this.getForecast().getItems().get(1).getTmax()).append(" degrés maximum.");
        string.append("\nLa probabilité qu'il pleuve aujourd'hui est de ").append(this.getForecast().getItems().get(0).getProbarain()).append("%.");
        return string.toString();
    }
}
