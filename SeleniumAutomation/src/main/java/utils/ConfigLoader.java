package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Aman
 *
 */
public class ConfigLoader {

	private static Properties properties;

	public static void readConfigFile() {

		String path = "./src/test/resources/env-config/" + ConfigLoader.getConfigValue("env") + "-" + "config.properties";
		System.out.println("Run env: " + ConfigLoader.getConfigValue("env"));

		properties = new Properties();
		try {
			FileInputStream ip = new FileInputStream(path);
			properties.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readMasterFile(String fileName) {

		properties = new Properties();
		try {
			FileInputStream ip = new FileInputStream(fileName);
			properties.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getConfigValue(String key) {
		return properties.getProperty(key);
	}

}
