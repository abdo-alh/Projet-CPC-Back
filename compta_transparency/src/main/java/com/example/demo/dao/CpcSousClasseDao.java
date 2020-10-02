package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.CpcSousClasse;

@Repository
public interface CpcSousClasseDao extends JpaRepository<CpcSousClasse,Long> {
	

}
