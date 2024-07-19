package fr.upec.episen.Front;

public class DisplayImages {
    private static String nomImage;
    public static String displayImage(String weatherDescription){
        if(weatherDescription.contains("pluie") || weatherDescription.contains("Pluie")){
            nomImage = "/pluie-abondante.png";
        } else if(weatherDescription.contains("nuage") || weatherDescription.contains("Nuage")){
            nomImage = "/des-nuages.png";
        } else {
            nomImage = "/soleil.png";
        }
        return nomImage;
    }
}
