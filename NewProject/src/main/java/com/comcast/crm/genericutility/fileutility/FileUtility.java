package com.comcast.crm.genericutility.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProperties(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\rohan\\AdvSelenium\\NewProject\\TestData\\common.properties");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
}
