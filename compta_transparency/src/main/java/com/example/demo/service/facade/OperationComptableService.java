package com.example.demo.service.facade;

import java.util.Date;
import java.util.List;

import org.springframework.core.io.Resource;

import com.example.demo.bean.OperationComptable;

public interface OperationComptableService {

	public OperationComptable save(OperationComptable operationcomptable);

	public List<OperationComptable> findAll();

	public OperationComptable findById(Long id);

	public int delete(OperationComptable operationcomptable);

	public void deleteById(Long id);

	public List<OperationComptable> findGroupeByCompteComptable(Date dateDebut, Date dateFin, int code);
	
	public List<OperationComptable> findGroupeBySousClasseCompteComptable(Date dateDebut,Date dateFin,String codeCompteComptable);

	public List<OperationComptable> findGroupeByClasseCompteComptable(Date dateDebut,Date dateFin,String codeCompteComptable);

	public Resource generateExcelFile(List<OperationComptable> operationComptables);
	
	public List<Object[]> findGroupeByClasseComptable(Date dateDebut, Date dateFin, String code);
}
