package fr.upec.episen;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestForecast {
    public ForecastResponse getForecastFromAPI(){
        int codeInsee = Actions.getCodeInsee();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.meteo-concept.com/api/forecast/daily?token=0e55ca414ca4921e0344ec82e2fe88065681bfbef58f57b1e392f0eaf43aa902&insee=" + codeInsee))
        .build();

        HttpResponse<String> response;
        ObjectMapper mapper = new ObjectMapper();
        ForecastResponse forecastResponse = new ForecastResponse();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            forecastResponse = mapper.readValue(response.body(), ForecastResponse.class);
        } catch (Exception e) {
            System.out.println("Erreur lors de la requête HTTP : " + e.getMessage());
        }
        return forecastResponse;
    }
}
