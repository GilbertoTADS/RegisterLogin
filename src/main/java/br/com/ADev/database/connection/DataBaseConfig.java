package br.com.ADev.database.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import br.com.ADev.exceptions.DatabaseException;

public class DataBaseConfig {
	private StringBuilder address = new StringBuilder();
	private String user;
	private String password;
	
	public DataBaseConfig() throws DatabaseException {
		Properties dbProp = this.getProperties();
		this.address.append(dbProp.getProperty("database.connector"))
					.append(":")
					.append(dbProp.getProperty("database.driver"))
					.append("://")
					.append(dbProp.getProperty("database.local"))
					.append(":")
					.append(dbProp.getProperty("database.port"))
					.append("/")
					.append(dbProp.getProperty("database.name"));
		this.user = dbProp.getProperty("database.user");
		this.password = dbProp.getProperty("database.password");
	}
	public Properties getProperties() throws DatabaseException {
		try {
			Properties properties = new Properties();
			FileInputStream file = new FileInputStream("src/main/resources/DATABASE/config.properties");
			properties.load(file);
			return properties;
		} catch (IOException e) {
			throw new DatabaseException("fail at in configuration properties to access database");
		}
		
	}
	public String getAddress() {
		return address.toString();
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}
