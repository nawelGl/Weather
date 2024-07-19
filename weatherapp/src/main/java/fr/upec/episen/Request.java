package fr.upec.episen;

import java.sql.*;
import java.util.Properties;

public class Request {

    protected Connection connection;

    public Request(){
        //1. Charger la classe du Driver
        Properties props = Feature.instance.getProps();
        String className= props.getProperty("db.driver");
        
        try{
        Class <?> driverClass = Class.forName(className);
        Driver driver= (Driver) driverClass.getConstructor().newInstance() ;
        DriverManager.registerDriver(driver);

        //2. Creer la connexion
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion à la base de données réussie !");

        } catch (Exception e){
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }

    public Ville getCityInseeCode(String nomCommune){
        String nomMaj = nomCommune.toUpperCase();
        Properties props = Feature.instance.getProps();
        String readReq= props.getProperty("city.read");
        Ville result = new Ville();
        try{
            PreparedStatement pstmt = connection.prepareStatement(readReq, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, nomMaj);
            ResultSet rs =  pstmt.executeQuery();
            if(rs.first()){
                result.setInsee(rs.getInt("code_insee"));
                result.setName(rs.getString("nom_commune"));
                result.setCp(rs.getInt("code_postal"));

                Actions.setCodeInsee(result.getInsee());
            }
        } catch (SQLException sqle){
            System.out.println("Erreur lors de l'exécution de la requête : " + sqle.getMessage());
        }
        return result;
    }

    public String getWeatherInfo(int code){
        String result = "";
        Properties props = Feature.instance.getProps();
        String readReq= props.getProperty("weatherCode.read");
        try{
            PreparedStatement pstmt = connection.prepareStatement(readReq, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setInt(1, code);
            ResultSet rs =  pstmt.executeQuery();
            if(rs.first()){
                result = (rs.getString("description"));
            }
        } catch (SQLException sqle){
            System.out.println("Erreur lors de l'exécution de la requête : " + sqle.getMessage());
        }
        return result;
    }
}
