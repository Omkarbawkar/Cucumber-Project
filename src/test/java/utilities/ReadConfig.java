package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String path = "Config.properties";

	//constructor
	public ReadConfig() {
		try {
			properties = new Properties();

			
			//to open config .properties file in input mode and load the file
			FileInputStream  fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public String getBrowser()
	{
		String value = properties.getProperty("browser");  //browser-in Config.properties file is k- sensitive

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}
	
	
	
}
