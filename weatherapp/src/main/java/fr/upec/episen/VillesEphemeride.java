package fr.upec.episen;

public class VillesEphemeride {
    private Ville city;
    private Ephemeride ephemeride;

    public Ville getCity() {
        return city;
    }

    public void setCity(Ville ville) {
        this.city = ville;
    }

    public Ephemeride getEphemeride() {
        return ephemeride;
    }

    public void setEphemeride(Ephemeride ephemeride) {
        this.ephemeride = ephemeride;
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("Ville : " + this.getCity().getName());
        string.append(" (" + this.getCity().getCp() + ")");
        string.append("\nLever de soleil : " + this.getEphemeride().getSunrise());
        string.append("\nCoucher de soleil : " + this.getEphemeride().getSunset());
        string.append("\nDurée du jour : " + this.getEphemeride().getDurationDay());
        return String.valueOf(string);
    }
}
