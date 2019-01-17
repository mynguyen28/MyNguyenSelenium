package Common.Common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesHelper {

	private final Properties configProp = new Properties();

	private PropertiesHelper() {
		String str = Utilities.getProjectPath();
		String propertyFilePath = str + "\\src\\test\\java\\config.properties";
		System.out.println("Read all properties from file");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			configProp.load(reader);
			// reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class LazyHolder {
		private static final PropertiesHelper abc = new PropertiesHelper();
	}

	public static PropertiesHelper getInstance() {
		return LazyHolder.abc;
	}

	public String getProperty(String key) {
		if (key != null)
			return configProp.getProperty(key);
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:driverPath");
	}

	public Set<String> getAllPropertyNames() {
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return configProp.containsKey(key);
	}
}
