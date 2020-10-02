package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.SousClasseComptable;


public interface SousClasseComptableService {

	public SousClasseComptable save(SousClasseComptable sousclassecomptable);

	public SousClasseComptable saveWithCompteComptables(SousClasseComptable sousclassecomptable);

	public List<SousClasseComptable> findAll();

	public SousClasseComptable findById(Long id);

	public int delete(SousClasseComptable sousclassecomptable);

	public int deleteById(Long id);
	
	public int deleteByNumero(int numero);

	public int update(SousClasseComptable sousClasseComptable);

}
