import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class connexion {

    protected Connection connection;
    
    public connexion(){
        //1. Charger la classe du Driver
        Properties props = new Properties();
        try{
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
            props.load(is);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

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

        }catch(Exception e){ System.out.println(e.getMessage());}

    }
    
    
}
