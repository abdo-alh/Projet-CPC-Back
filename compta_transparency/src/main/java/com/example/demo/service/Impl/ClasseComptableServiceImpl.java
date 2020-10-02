package com.example.demo.service.Impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.ClasseComptable;
import com.example.demo.bean.SousClasseComptable;
import com.example.demo.dao.ClasseComptableDao;
import com.example.demo.service.facade.ClasseComptableService;
import com.example.demo.service.facade.SousClasseComptableService;

@Service
public class ClasseComptableServiceImpl implements ClasseComptableService {

	@Autowired
	private ClasseComptableDao classecomptableDao;

	@Autowired
	private SousClasseComptableService sousclassecomptableService;

	@Override
	public int save(ClasseComptable classecomptable) {

		if (classecomptable == null) {
			return -1;
		} else {
			classecomptableDao.save(classecomptable);
			return 1;
		}
	}

	@Override
	public ClasseComptable saveWithSousClasseComptables(ClasseComptable classecomptable) {

		if (classecomptable == null) {
			return null;
		} else {
			if (classecomptable.getSousClasseComptables().isEmpty()) {
				return null;
			} else {
				classecomptableDao.save(classecomptable);
				for (SousClasseComptable sousclassecomptable : classecomptable.getSousClasseComptables()) {
					sousclassecomptable.setClasseComptable(classecomptable);
					sousclassecomptableService.save(sousclassecomptable);
				}
				return classecomptable;
			}
		}
	}

	@Override
	public List<ClasseComptable> findAll() {
		return classecomptableDao.findAll();
	}

	@Override
	public ClasseComptable findById(Long id) {
		return classecomptableDao.getOne(id);
	}

	@Override
	public int delete(ClasseComptable classecomptable) {
		if (classecomptable == null) {
			return -1;
		} else {
			classecomptableDao.delete(classecomptable);
			return 1;
		}
	}

	@Override
	public void deleteById(Long id) {
		classecomptableDao.deleteById(id);
	}

	@Override
	public int deleteByNumero(int numero) {
		return classecomptableDao.deleteByNumero(numero);
	}
	
	public int update(ClasseComptable classeComptable) {
		// if the product is already in the table and its not the product who will be updated
		if (classecomptableDao.findById(classeComptable.getId()) == null) {
			return -1;
		} else {
			classecomptableDao.save(classeComptable);
			return 1;
		}
	}
	
	
	
}
