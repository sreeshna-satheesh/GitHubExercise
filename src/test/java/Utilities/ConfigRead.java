package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigRead {
	Properties prop;

	public ConfigRead() throws Exception {

		FileInputStream fis = new FileInputStream("./testData/Config.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String getAppURL() {

		return prop.getProperty("app_url_QA");

	}

	public String getSampleAppURL() {

		return prop.getProperty("appURL_sample");

	}

	public String getBrowser() {

		return prop.getProperty("browser");

	}

	public String getAdminUser() {

		return prop.getProperty("adminUserName");

	}

	public String getAdminPass() {

		return prop.getProperty("adminPassword");

	}

}
