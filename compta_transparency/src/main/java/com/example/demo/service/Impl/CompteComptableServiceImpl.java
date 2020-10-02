package com.example.demo.service.Impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.CompteComptable;
import com.example.demo.dao.CompteComptableDao;
import com.example.demo.service.facade.CompteComptableService;

@Service
public class CompteComptableServiceImpl implements CompteComptableService {

	@Autowired
	private CompteComptableDao comptecomptableDao;

	@Override
	public CompteComptable save(CompteComptable comptecomptable) {

		if (comptecomptable == null) {
			return null;
		} else {
			comptecomptableDao.save(comptecomptable);
			return comptecomptable;
		}
	}

	@Override
	public List<CompteComptable> findAll() {
		return comptecomptableDao.findAll();
	}

	@Override
	public CompteComptable findById(Long id) {
		return comptecomptableDao.getOne(id);
	}

	@Override
	public int delete(CompteComptable comptecomptable) {
		if (comptecomptable == null) {
			return -1;
		} else {
			comptecomptableDao.delete(comptecomptable);
			return 1;
		}
	}
	
	public int update(CompteComptable comptecomptable) {
		// if the product is already in the table and its not the product who will be updated
		if (comptecomptableDao.findById(comptecomptable.getId()) == null) {
			return -1;
		} else {
			comptecomptableDao.save(comptecomptable);
			return 1;
		}
	}

	@Override
	public void deleteById(Long id) {
		comptecomptableDao.deleteById(id);
	}
	
	@Override
	public int deleteByCode(String code) {
		return comptecomptableDao.deleteByCode(code);
	}
}
