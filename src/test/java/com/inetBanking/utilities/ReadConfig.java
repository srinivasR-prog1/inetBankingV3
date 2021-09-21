package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop= new Properties();

			prop.load(fis);

		} catch (Exception e) {

			System.out.println("The message is :" + e.getMessage());

		}

	}

	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");

		return url;
	}

	public String getUsrName() {
		String name = prop.getProperty("username");

		return name;

	}

	public String getPwd() {

		String passwd = prop.getProperty("password");
		return passwd;

	}

	public String getChroPath() {

		String chrodriver = prop.getProperty("chrdriver");
		return chrodriver;

	}
	
	public String getFirefoxPath() {

		String ffdriver = prop.getProperty("ffdriver");
		return ffdriver;

	}
}
