package jdbc.learning;

import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileLoader {

    @Getter
    private Properties dbProperties;

    PropertiesFileLoader() throws IOException {

        FileReader reader = new FileReader("src/main/resources/config.properties");

        dbProperties = new Properties();

        dbProperties.load(reader);

    }

    public String getConfig(String key){

        return dbProperties.getProperty(key);

    }

    public String getDbUrl(){

        //String url= "jdbc:"+getConfig("serverName")+"//"+getConfig("hostName")+":"+getConfig("port")+";DatabaseName="+getConfig("databaseName");

        String url="jdbc:sqlserver://localhost:1433;DatabaseName=demodb;integratedSecurity=false;encrypt=true;trustServerCertificate=true;";

        /*String url="jdbc:"+getConfig("serverName")+"://"+"mssql.db.server\\\\MSSQLSERVER"+";databaseName="
                +getConfig("databaseName");*/
        //System.out.println(url);
        return url;
    }

}
