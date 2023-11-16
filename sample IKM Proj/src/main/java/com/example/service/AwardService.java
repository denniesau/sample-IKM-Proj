package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Service;

import com.example.DAO.AwardDAO;
import com.example.model.AwardmodelDTO;
import com.example.Entity.AwardEntity;

@Service
public class AwardService {
	@Autowired
	AwardDAO awardDAO;
	
	public Long CreateAward(AwardmodelDTO award) {
		AwardEntity entity = new  AwardEntity();
		entity.setTitle(award.getTitle());
		entity.setDescription(award.getDescription());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		 java.sql.Date sqlDate;
		try {
			sqlDate = new java.sql.Date(dateFormat.parse(award.getAwardDate()).getTime());
		} catch (ParseException e) {
			sqlDate = null;
		}
		entity.setAwardDate(sqlDate);
		entity.setRecipient(award.getRecipient()); 
		AwardEntity savedAward = awardDAO.save(entity);
		return savedAward.getId();
	}

}
