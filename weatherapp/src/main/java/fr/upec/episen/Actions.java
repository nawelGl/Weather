package fr.upec.episen;

import java.util.Scanner;

public class Actions {

    //Ajouter une variable statique pour le code INSEE
    private static int codeInsee;

    public static int getCodeInsee() {
        return codeInsee;
    }

    public static void setCodeInsee(int codeInsee) {
        Actions.codeInsee = codeInsee;
    }

    public static void lancerActions(){
        System.out.println("Entrez le nom d'une ville pour obtenir son code INSEE.");
        Scanner scanner = new Scanner(System.in);
        String nomVille = scanner.nextLine();
        //Test requete en base de donnes (OK) :
        Request request = new Request();
        Ville ville;
        ville = request.getCityInseeCode(nomVille);
        if (ville.getInsee() != 0) {
            System.out.println("Code INSEE de " + nomVille + " : " +  ville.getInsee());
        } else {
            System.out.println("Code INSEE de " + nomVille + " non trouvé.");
        }

        //Test requete HTTP API Localisation :
        HttpRequestLocationCity httpRequest = new HttpRequestLocationCity();
        System.out.println("Voici le résultat de la requête HTTP :");
        System.out.println(httpRequest.getLocationFromAPI().toString());

        //Test requete HTTP API ephemeride :
        HttpRequestEphemeride httpRequestEphemeride = new HttpRequestEphemeride();
        httpRequestEphemeride.getEphemerideFromAPI();
        System.out.println(httpRequestEphemeride.getEphemerideFromAPI().toString());
    }
}
