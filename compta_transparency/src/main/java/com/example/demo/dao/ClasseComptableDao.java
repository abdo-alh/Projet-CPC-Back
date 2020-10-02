package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.ClasseComptable;


@Repository
 public interface ClasseComptableDao extends JpaRepository<ClasseComptable,Long> {
	
	public int deleteByNumero(int numero);

}
