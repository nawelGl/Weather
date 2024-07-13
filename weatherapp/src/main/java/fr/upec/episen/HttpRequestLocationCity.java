package fr.upec.episen;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpRequestLocationCity {
    public Ville getDataFromAPI(){
        int codeInsee = Actions.getCodeInsee();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.meteo-concept.com/api/location/city?token=0e55ca414ca4921e0344ec82e2fe88065681bfbef58f57b1e392f0eaf43aa902&insee=" + codeInsee))
                .build();

        HttpResponse<String> response;
        ObjectMapper mapper = new ObjectMapper();
        Villes villes;
        Ville ville = new Ville();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            villes = mapper.readValue(response.body(), Villes.class);
            ville = villes.getCity();
            
        } catch (Exception e) {
            System.out.println("Erreur lors de la requête HTTP : " + e.getMessage());
        }
        return ville;
    }
}
