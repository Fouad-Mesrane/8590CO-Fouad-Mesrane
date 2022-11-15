package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {


    public static Properties properties;
    private static final File propertiesFile = new File(System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "main" + File.separator + "resources" + File.separator + "data" + File.separator
            + "testData.properties");



    public static Properties getTestData(){
        try {
            properties = loadProperties();
        } catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }

    private static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(propertiesFile);

        prop.load(fis);
        fis.close();

        return prop;
    }
}
