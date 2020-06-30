package com.shiftech.assessment.utils;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.shiftech.assessment.dto.CreditCard;
@Component
public interface CreiditCardRepository extends CrudRepository<CreditCard,Integer> {

}
