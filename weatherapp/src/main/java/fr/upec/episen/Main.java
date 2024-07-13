package fr.upec.episen;

import java.util.Scanner;
import fr.upec.episen.Request;

public class Main {
    public static void main(String[] args) {
        System.out.println("Entrez le nom d'une ville pour obtenir son code INSEE.");
        Scanner scanner = new Scanner(System.in);
        String ville = scanner.nextLine();
        //Test requete en base de donnes (OK) :
        Request request = new Request();
        int codeInsee = request.getCityInseeCode(ville);
        if (codeInsee != 0) {
            System.out.println("Code INSEE de " + ville + " : " +  codeInsee);
        } else {
            System.out.println("Code INSEE de " + ville + " non trouvé.");
        }

        //Test requete HTTP API :
        HttpRequestApi httpRequest = new HttpRequestApi();
        System.out.println("Voici le résultat de la requête HTTP :");
        System.out.println(httpRequest.getDataFromAPI().toString());
    }
}