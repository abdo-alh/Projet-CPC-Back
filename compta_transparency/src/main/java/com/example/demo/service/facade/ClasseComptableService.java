package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.ClasseComptable;

public interface ClasseComptableService {

	public int save(ClasseComptable classecomptable);

	public ClasseComptable saveWithSousClasseComptables(ClasseComptable classecomptable);

	public List<ClasseComptable> findAll();

	public ClasseComptable findById(Long id);

	public int delete(ClasseComptable classecomptable);

	public void deleteById(Long id);
	
	public int deleteByNumero(int numero);

	public int update(ClasseComptable classeComptable);

}
