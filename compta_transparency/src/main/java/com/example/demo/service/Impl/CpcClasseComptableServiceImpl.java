package com.example.demo.service.Impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.CpcClasseComptable;
import com.example.demo.dao.CpcClasseComptableDao;
import com.example.demo.service.facade.CpcClasseComptableService;

@Service
public class CpcClasseComptableServiceImpl implements CpcClasseComptableService{
	
	@Autowired
	private CpcClasseComptableDao cpcclassecomptableDao;

	@Override
	public CpcClasseComptable save(CpcClasseComptable cpcclassecomptable) {

		if (cpcclassecomptable == null) {
			return null;
		} else {
			cpcclassecomptableDao.save(cpcclassecomptable);
			return cpcclassecomptable;
		}
	}

	@Override
	public List<CpcClasseComptable> findAll() {
		return cpcclassecomptableDao.findAll();
	}

	@Override
	public CpcClasseComptable findById(Long id) {
		return cpcclassecomptableDao.getOne(id);
	}

	@Override
	public int delete(CpcClasseComptable cpccomptecomptable) {
		if (cpccomptecomptable == null) {
			return -1;
		} else {
			cpcclassecomptableDao.delete(cpccomptecomptable);
			return 1;
		}
	}

	@Override
	public void deleteById(Long id) {
		cpcclassecomptableDao.deleteById(id);
	}

	public int update(CpcClasseComptable cpcClasseComptable) {
		if(cpcclassecomptableDao.findById(cpcClasseComptable.getId()) == null) {
			return -1;
		}
		else {
			cpcclassecomptableDao.save(cpcClasseComptable);
			return 1;
		}
	}
	
}
