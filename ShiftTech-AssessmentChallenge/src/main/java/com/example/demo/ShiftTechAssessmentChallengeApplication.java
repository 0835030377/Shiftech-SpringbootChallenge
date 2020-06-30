package com.example.demo;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.shiftech.assessment.dto.CreditCard;
import com.shiftech.assessment.repository.CreditcardRepo;

@SpringBootApplication
//@EntityScan("com.shiftech.assessment.dto")
@EnableScheduling
@ComponentScan({"com.shiftech.assessment.controller","com.shiftech.assessment.impl","com.shiftech.assessment.utils"})
public class ShiftTechAssessmentChallengeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShiftTechAssessmentChallengeApplication.class, args);		
	}
	
}
