package fr.upec.episen.Front;

import java.awt.*;

public class Template {
    private static String couleurPincipale = "#F8EDE3";
    private static String couleurSecondaire = "#C8B6A6";
    private static int largeur = 850;
    private static int longueur = 600;
    private static String villeParDefaut = "vitry sur seine";
    private static Font mainFont = new Font("Avenir", Font.TYPE1_FONT, 28);
    private static Font moyenneFont = new Font("Avenir", Font.TYPE1_FONT, 22);
    private static Font temperatureFont = new Font("Arial", Font.BOLD, 30);

    public static String getCouleurPincipale() {
        return couleurPincipale;
    }

    public static String getCouleurSecondaire() {
        return couleurSecondaire;
    }

    public static int getLongueur() {
        return longueur;
    }

    public static int getLargeur() {
        return largeur;
    }

    public static String getVilleParDefaut() {
        return villeParDefaut;
    }

    public static Font getMainFont() {
        return mainFont;
    }

    public static Font getMoyenneFont() {
        return moyenneFont;
    }

    public static Font getTemperatureFont() {
        return temperatureFont;
    }
}
