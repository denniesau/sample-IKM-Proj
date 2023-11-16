package com.example.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.AwardEntity;

public interface AwardDAO extends JpaRepository<AwardEntity, Long>{

}
