package com.shiftech.assessment.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shiftech.assessment.dto.CreditCard;
import com.shiftech.assessment.impl.ServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200/creditcards")
@RequestMapping("/creditcards")
public class CreditCardController {
	Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
	@Autowired
	ServiceImpl service;
		 
	@CrossOrigin("http://localhost:4200")
	@PostMapping(/*value = "/captureCreditcards"*/)
	public /* String */CreditCard captureCreditCard(@RequestBody CreditCard creditCardss) throws IOException {
		logger.info("Execute captureCreditCard ");	
		return service.captureCreditCard(creditCardss);	
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/getAllcreditcards")
	public List<CreditCard> getAllCreditCards() {
		logger.info("Execute getAllCreditCards ");
		return service.getAllCreditCards();
	}
}
