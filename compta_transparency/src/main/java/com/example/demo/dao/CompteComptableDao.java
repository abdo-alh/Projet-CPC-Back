package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.CompteComptable;
import com.example.demo.bean.SousClasseComptable;


@Repository
 public interface CompteComptableDao extends JpaRepository<CompteComptable,Long> {

	 public CompteComptable findBySousClasseComptable(SousClasseComptable sousClasseComptable);

	 public int deleteBySousClasseComptable(SousClasseComptable sousClasseComptable);
	 
	 public int deleteByCode(String code);

}
