package com.shiftech.assessment.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shiftech.assessment.dto.CreditCard;
import com.shiftech.assessment.repository.CreditcardRepo;
import com.shiftech.assessment.service.CreditCardService;
import com.shiftech.assessment.utils.CreditCardUtils;
import com.shiftech.assessment.utils.CreiditCardRepository;

@Component
public class ServiceImpl implements CreditCardService  {
	Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
	List<CreditCard> allCreditCards = new ArrayList<CreditCard>();
	List<CreditCard> validCreditCards = new ArrayList<CreditCard>();
	@Autowired
	CreditCardUtils creditCardUtils;
	
	List<String> creditCardsNumbers = new ArrayList<String>();
	
	//@Autowired
	//CreiditCardRepository creditCardRepository;
	/**
	 * Validate Credit Card, store it in a list if its valid , dont store duplicates
	 */
	@Override
	public boolean isCardvalid(CreditCard ccNumber) {
		String country = getCountry(ccNumber.getCardNumber());
		boolean isCardValid = isCountrBanned(country); 
		if (isCardValid && !validCreditCards.contains(ccNumber)) {
			storeValidCreditCards(ccNumber);
		}	
		return isCardValid;
	}

	/**
	 * Method to capture all credit cards, but dont capture twice
	 * @throws IOException 
	 */
	@Override
	public CreditCard /*String*/  captureCreditCard(CreditCard creditCard) throws IOException {
		logger.info("Execute addCreditCard.....");
		boolean captured = false;
		boolean valid = false;
		String results = null;
		if (!allCreditCards.contains(creditCard) && !creditCardsNumbers.contains(creditCard.getCardNumber())) {
			logger.info("Adding Credit card :"+ creditCard.getCardNumber());
			allCreditCards.add(creditCard);
			creditCardsNumbers.add(creditCard.getCardNumber());
			captured=true;
			if (isCardvalid(creditCard)) {
				valid =true;
				logger.info("Its a valid card.....");
			}
		} else {
			logger.info("Credit card : "+creditCard.getCardNumber()+" already existing.....");
			
		}
		
		
		if (captured && valid) {
			results = "Thanks you, Credit Card no : " + creditCard.getCardNumber()+ " was successfully added";
		} else if(captured && valid) {
			results = "OOps!!..Credit Card no : " + creditCard.getCardNumber()+ " was captured but it was issued from a banned country, ";
			
		}  else {
			results = "OOps!!..Credit Card no : " +creditCard.getCardNumber() + " already captured ";
			
		}
		//writeToTempDB(creditCard);
		logger.info("Return Credit Cards");
		return creditCard;
	}

	@Override
	/**
	 * Method to get country issued for a credit card using first 6 digit of cardNumber
	 */
	public String getCountry(String creditCardNumber) {
		logger.info("Execute getCountry.....");
		String sixDigitNo = creditCardNumber.substring(0, 6);
		return creditCardUtils.getCountry(sixDigitNo);
	}

	/**
	 * Method to check if the card issued country is banned
	 */
	@Override
	public boolean isCountrBanned(String country) {
		logger.info("Execute isCountrBanned.... ");
		List<String> listOfBannedCountries = creditCardUtils.getBannedCountries();
		for (String c : listOfBannedCountries) {
			if(!StringUtils.isEmpty(country) && c.equalsIgnoreCase(country)) {
				logger.info(country +" is banned form using Visa credit cards ");
				return false;
				}			
			}
		return true;		
	}

	/**
	 * Method to get all credit cards captured 
	 */
	@Override
	public List<CreditCard> getAllCreditCards() {
		logger.info("Execute getAllCreditCards.... ");
		return allCreditCards;
	}

	/**
	 * Store only valid credit cards
	 */
	@Override
	public void storeValidCreditCards(CreditCard creditCard) {
		logger.info("Execute storeValidCreditCards.... ");
		validCreditCards.add(creditCard);		
	}

	@Override
	/*public void writeToTempDB(CreditCard creditCard) {
		logger.info("Execute writeToTempDB.... ");
		//creditcardRepo.save(creditCard);	
	}
	@Override
	/**
	 * Bulk process credit cards after 30seconds that are already captured and keep them
	 */
	@Scheduled(fixedRate=30000)
	public void bulkProcessTasks() {
		logger.info("Execute bulkProcessTasks.... ");
		for (CreditCard creditC : allCreditCards) {
			 logger.info("Bulk proccessing card No :" + creditC.getCardNumber()+" Current time : " + creditCardUtils.returnCurrentTime().format(new Date()));
			if (isCardvalid(creditC) && !validCreditCards.contains(creditC)) {
				validCreditCards.add(creditC);
			}		
		}	

	}
}
