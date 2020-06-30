package com.shiftech.assessment.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.shiftech.assessment.impl.ServiceImpl;
@Component
public class CreditCardUtils {
	Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
	//Load configured banned courntries 
	@Value("${banned.countries.names}")
	List<String> bannedCountries;
	
	
	public String parceJSON(String json) throws JSONException{
		logger.info("Execute parceJSON.... ");
		logger.info("Print JSON OBJECT.... " + json );
		 JSONObject obj = new JSONObject(json);
		 String countryName = obj.getJSONObject("country").getString("name");
		 logger.info("Print countryName : " +countryName);
		return countryName;		
	}
	
	/**
	 * Call an external Rest Template to retrive country name from credit card number
	 * @param sixDigitNo
	 * @return
	 * @throws URISyntaxException
	 */
	public String getCountry(String sixDigitNo) {
		logger.info("Calling Global API..... ");
		URI endpoint = null;
		String country = null;
		try {
			endpoint = new URI("https://lookup.binlist.net/523982");
			endpoint = endpoint.resolve(sixDigitNo);
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(endpoint, String.class);
			if (!(result == null)) {
				country =  parceJSON(result);
			} else {
				country= "Banned";// Default it to a banned country
				logger.info("Invalid card number , Country does not exist.... ");
			}
			
		} catch (URISyntaxException |JSONException | HttpClientErrorException e) {
			logger.info("oops Exception occured while calling global API.... ");
			country = "Banned"; //default to a banned country
			//e.printStackTrace();
		}
		return country;
	}
	
	/**
	 * Method to get banned countries
	 * @return
	 */
	public List<String> getBannedCountries() {		
		return bannedCountries;		
	}
	
	public  SimpleDateFormat returnCurrentTime() {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat; 		
	}
	
	
}
