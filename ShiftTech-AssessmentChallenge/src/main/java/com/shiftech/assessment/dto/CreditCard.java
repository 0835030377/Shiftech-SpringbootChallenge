package com.shiftech.assessment.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name="CreditCard")
public class CreditCard {
	//@Id
	//@GeneratedValue
	//private int creditcardId;
	private String cardNumber;
	private String type;
	private String bankName;
	/*public int getCreditcardId() {
		return creditcardId;
	}
	public void setCreditcardId(int creditcardId) {
		this.creditcardId = creditcardId;*
	}*/
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public CreditCard(/*int creditcardId, */String cardNumber, String type, String bankName) {
		super();
		//this.creditcardId = creditcardId;
		this.cardNumber = cardNumber;
		this.type = type;
		this.bankName = bankName;
	}
	
	
}
