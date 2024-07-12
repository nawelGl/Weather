package fr.upec.episen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum Feature {
    instance;
    protected Properties props; 

    Feature(){
        try{
            props= new Properties();
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
            props.load(is);
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    public Properties getProps(){
        return props;
    }
}
