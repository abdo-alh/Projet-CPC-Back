package com.example.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.CpcClasseComptable;

@Repository
public interface CpcClasseComptableDao extends JpaRepository<CpcClasseComptable,Long> {
	
	
	//public void deleteByCpcSousClasseCpcId(Long id);

	
}
