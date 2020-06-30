package com.shiftech.assessment.service;

import java.io.IOException;
import java.util.List;

import com.shiftech.assessment.dto.CreditCard;

public interface CreditCardService {
	
	public boolean isCardvalid(CreditCard ccNumber) ;
	public  CreditCard captureCreditCard(CreditCard creditCard ) throws  IOException;
	public String getCountry(String creditCardNumber);
	public boolean isCountrBanned(String country);
	public List<CreditCard> getAllCreditCards();
	public void storeValidCreditCards(CreditCard creditCard);
	//public void writeToTempDB(CreditCard creditCard);
	public void bulkProcessTasks();
	
}
