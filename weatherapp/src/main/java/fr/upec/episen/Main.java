package fr.upec.episen;

import java.util.Scanner;

import fr.upec.episen.Request;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ville = scanner.nextLine();
        //Test requete :
        Request request = new Request();
        int codeInsee = request.getCityInseeCode(ville);
        if (codeInsee != 0) {
            System.out.println("CODE INSEE de " + ville + " : " +  codeInsee);
        } else {
            System.out.println("CODE INSEE de " + ville + " non trouvé.");
        }
    }
}