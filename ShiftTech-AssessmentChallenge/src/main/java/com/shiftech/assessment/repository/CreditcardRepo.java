package com.shiftech.assessment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.shiftech.assessment.dto.CreditCard;

@Component
public interface  CreditcardRepo extends CrudRepository<CreditCard,Long> {

}
