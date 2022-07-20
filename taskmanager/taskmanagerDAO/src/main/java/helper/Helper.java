package helper;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * An auxiliary class used to get environment variables values from the
 * config.properties file
 */
public class Helper {
	private static final Logger logger = LogManager.getLogger(Helper.class);
	private final Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public Helper(String fileName) {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(fileName));

		} catch (IOException ioex) {
			logger.error("IOException Occured while loading properties file::::" + ioex.getMessage());
		}
	}

	public String readProperty(String keyName) {
		logger.info("Reading Property " + keyName);
		return properties.getProperty(keyName, "There is no key in the properties file");
	}
}