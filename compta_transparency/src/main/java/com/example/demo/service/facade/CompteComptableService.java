package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.CompteComptable;


public interface CompteComptableService {

	public CompteComptable save(CompteComptable comptecomptable);

	public List<CompteComptable> findAll();

	public CompteComptable findById(Long id);

	public int delete(CompteComptable comptecomptable);

	public void deleteById(Long id);
	
	public int deleteByCode(String code);

	public int update(CompteComptable compteComptable);

}
