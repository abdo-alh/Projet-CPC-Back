
package com.example.demo.service.Impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.CompteComptable;
import com.example.demo.bean.SousClasseComptable;
import com.example.demo.dao.SousClasseComptableDao;
import com.example.demo.service.facade.CompteComptableService;
import com.example.demo.service.facade.SousClasseComptableService;

@Service
public class SousClasseComptableServiceImpl implements SousClasseComptableService {

	@Autowired
	private SousClasseComptableDao sousclassecomptableDao;

	@Autowired
	private CompteComptableService comptecomptableService;

	@Override
	public SousClasseComptable save(SousClasseComptable sousclassecomptable) {

		if (sousclassecomptable == null) {
			return null;
		} else {
			sousclassecomptableDao.save(sousclassecomptable);
			return sousclassecomptable;
		}
	}

	@Override
	public SousClasseComptable saveWithCompteComptables(SousClasseComptable sousclassecomptable) {

		if (sousclassecomptable == null) {
			return null;
		} else {
			if (sousclassecomptable.getCompteComptables().isEmpty()) {
				return null;
			} else {
				sousclassecomptableDao.save(sousclassecomptable);
				for (CompteComptable comptecomptable : sousclassecomptable.getCompteComptables()) {
					comptecomptable.setSousClasseComptable(sousclassecomptable);
					comptecomptableService.save(comptecomptable);
				}
				return sousclassecomptable;
			}
		}
	}

	@Override
	public List<SousClasseComptable> findAll() {
		return sousclassecomptableDao.findAll();
	}

	@Override
	public SousClasseComptable findById(Long id) {
		return sousclassecomptableDao.getOne(id);
	}

	@Override
	public int delete(SousClasseComptable sousclassecomptable) {
		if (sousclassecomptable == null) {
			return -1;
		} else {
			sousclassecomptableDao.delete(sousclassecomptable);
			return 1;
		}
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return -1;
		} else {
			sousclassecomptableDao.deleteById(id);
			return 1;
		}
	}
	
	@Override
	public int deleteByNumero(int numero) {
		return sousclassecomptableDao.deleteByNumero(numero);
	}
	
	public int update(SousClasseComptable sousclassecomptable) {
		// if the product is already in the table and its not the product who will be updated
		if (sousclassecomptableDao.findById(sousclassecomptable.getId()) == null) {
			return -1;
		} else {
			sousclassecomptableDao.save(sousclassecomptable);
			return 1;
		}
	}
	
}
