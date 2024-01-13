package com.airline.utils;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.airline.testData.AirlineRecord;
import com.airline.testData.VendorRecords;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

	public static final Logger log = LoggerFactory.getLogger(JSONUtils.class);
	//Converts Input Stream to String
	private static final ObjectMapper mapper = new ObjectMapper();
	
	
	public static <T> T getVendorRecords(String path, Class<T> type) {
		
		try(InputStream stream = ResourceLoader.getResources(path)){
			return mapper.readValue(stream, type);
		}catch(Exception err){
			log.error("Unable to read the test data"+err);
		}
		
		return null;
		
		
	}
	

	
}
