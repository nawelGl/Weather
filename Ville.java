public class Ville {
    //Atributs
    private String nomVille;
    private int codePostal;
    private int codeInsee;

    //Constructeur(s)
    public Ville(String nom, int cp, int ci){
        this.nomVille = nom;
        this.codeInsee = ci;
        this.codePostal = cp;
    }

    //Accesseurs
    public int getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(int codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public int getCodePostal() {
        return codePostal;
    }
    
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
    
}
