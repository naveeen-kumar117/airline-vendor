package com.airline.utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

	private static final Logger log = LoggerFactory.getLogger(Config.class);
	
	private static final String DEFAULT_CONFIG_PATH = "config/defaultconfig.properties";
	
	private static Properties global_property;
	
	public static void initialize() {
		
		// load default properites
		global_property = readProperties();
		
		//check for override.
		for(String key:global_property.stringPropertyNames()) {
			if(System.getProperties().containsKey(key)) {
				global_property.setProperty(key, System.getProperty(key));
			}
		}
		
		//print for debugging
		log.info("Test Properties overridden");
		for(String key:global_property.stringPropertyNames()) {
			
			log.info("KEY --> "+key+"\nVALUE --->"+global_property.getProperty(key));
			
		}
	}
	
	public static String get(String Key) {
		return global_property.getProperty(Key);
	}
	
	
	public static Properties readProperties() {
		
		Properties property = new Properties();
		try(InputStream stream =  ResourceLoader.getResources(DEFAULT_CONFIG_PATH)){
			property.load(stream);
			
		}catch(Exception err) {
			log.error("Unable to read properties file "+err);
		}
		
		return property;
	}


}
