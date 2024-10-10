package com.orgHrm.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropOperation {
	private Properties prop;

	public PropOperation(String path) throws IOException {
		File file = new File(path);//open file
		FileInputStream inputstream = new FileInputStream(file);//read only mode file

		prop = new Properties();
		prop.load(inputstream);
	}

	public String getvalue(String key) {
		return prop.getProperty(key);
	}

}
