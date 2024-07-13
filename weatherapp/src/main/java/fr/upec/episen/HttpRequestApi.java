package fr.upec.episen;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestApi {
    public String getDataFromAPI(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                //.uri(URI.create("https://api.example.com/data"))
                .uri(URI.create("https://api.meteo-concept.com/api/location/city?token=0e55ca414ca4921e0344ec82e2fe88065681bfbef58f57b1e392f0eaf43aa902&insee=35238"))
                .build();

        HttpResponse<String> response;
        String rep = "";
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            rep = response.body();
        } catch (Exception e) {
            System.out.println("Erreur lors de la requête HTTP : " + e.getMessage());
        }
        return rep;
    }
}
