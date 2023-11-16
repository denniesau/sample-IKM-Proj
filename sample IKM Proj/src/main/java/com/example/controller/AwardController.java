package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AwardmodelDTO;
import com.example.service.AwardService;

@RestController
@RequestMapping("/awards")
public class AwardController {
	
	@Autowired
	AwardService awardService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> createAward(@RequestBody AwardmodelDTO award) {
        if (award.getTitle() == null || award.getTitle().isEmpty()
            || award.getRecipient() == null || award.getRecipient().isEmpty()
            || award.getAwardDate() == null) {
            return new ResponseEntity<>("Title, recipient, and award date cannot be empty", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Award created successfully. Award ID:"+awardService.CreateAward(award), HttpStatus.CREATED);
    }

}
