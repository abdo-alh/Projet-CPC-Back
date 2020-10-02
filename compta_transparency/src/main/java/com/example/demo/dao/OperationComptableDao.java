package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.CompteComptable;
import com.example.demo.bean.OperationComptable;

@Repository
public interface OperationComptableDao extends JpaRepository<OperationComptable, Long> {
	
	public int deleteByCompteComptable(CompteComptable compteComptable);
	
	@Query("SELECT NEW com.example.demo.bean.OperationComptable(o.compteComptable, SUM(o.montant)) FROM OperationComptable o"
			+ " WHERE o.compteComptable.sousClasseComptable.numero = :code"
		+ " AND o.dateOperationComptable BETWEEN :dateDebut AND :dateFin GROUP BY o.compteComptable")
	public List<OperationComptable> findGroupeByCompteComptable(@Param("dateDebut") Date dateDebut,@Param("dateFin") Date dateFin,@Param("code") int codeSousClasseComptable);
	
	@Query("SELECT NEW com.example.demo.bean.OperationComptable(o.compteComptable.sousClasseComptable, SUM(o.montant)) FROM OperationComptable o"
			+ " WHERE o.compteComptable.code LIKE :code%"
		+ " AND o.dateOperationComptable BETWEEN :dateDebut AND :dateFin GROUP BY o.compteComptable.sousClasseComptable")
	public List<OperationComptable> findGroupeBySousClasseCompteComptable(@Param("dateDebut") Date dateDebut,@Param("dateFin") Date dateFin,@Param("code") String codeCompteComptable);

	@Query("SELECT NEW com.example.demo.bean.OperationComptable(o.compteComptable.sousClasseComptable.classeComptable, "
			+ "SUM(o.montant)) FROM OperationComptable o"
			+ " WHERE o.compteComptable.code LIKE :code%"
		+ " AND o.dateOperationComptable BETWEEN :dateDebut AND :dateFin GROUP BY o.compteComptable.sousClasseComptable.classeComptable")
	public List<OperationComptable> findGroupeByClasseCompteComptable(@Param("dateDebut") Date dateDebut,@Param("dateFin") Date dateFin,@Param("code") String codeCompteComptable);

}
