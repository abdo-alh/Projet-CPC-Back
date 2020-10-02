package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.ClasseComptable;
import com.example.demo.bean.SousClasseComptable;


@Repository
 public interface SousClasseComptableDao extends JpaRepository<SousClasseComptable,Long> {

	 public SousClasseComptable findByClasseComptable(ClasseComptable classeComptable);

	 public int deleteByClasseComptable(ClasseComptable classeComptable);
	 
	 public int deleteByNumero(int numero);

}
