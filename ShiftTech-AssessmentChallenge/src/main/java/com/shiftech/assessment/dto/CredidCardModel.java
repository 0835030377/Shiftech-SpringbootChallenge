package com.shiftech.assessment.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CredidCardModel {
	@Id
	private int creditcardId;
	private String cardNumber;
	private String type;
	private String bankName;
	
	
	public CredidCardModel(int creditcardId, String cardNumber, String type, String bankName) {
		super();
		this.creditcardId = creditcardId;
		this.cardNumber = cardNumber;
		this.type = type;
		this.bankName = bankName;
	}
	public int getCreditcardId() {
		return creditcardId;
	}
	public void setCreditcardId(int creditcardId) {
		this.creditcardId = creditcardId;
	}
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
	
	

}
