package com.example.demo.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.CpcClasseComptable;
import com.example.demo.bean.CpcSousClasse;
import com.example.demo.dao.CpcSousClasseDao;
import com.example.demo.service.facade.CpcClasseComptableService;
import com.example.demo.service.facade.CpcSousClasseService;

@Service
public class CpcSousClasseServiceImpl implements CpcSousClasseService{
	
	@Autowired
	private CpcClasseComptableService cpcclassecomptableService;
	
	@Autowired
	private CpcSousClasseDao cpcsousclasseDao;

	@Override
	public CpcSousClasse saveWithCpcClasseComptables(CpcSousClasse cpcsousclasse) {
		if (cpcsousclasse == null) {
			return null;
		} else {
			if (cpcsousclasse.getCpcClasseComptables().isEmpty()) {
				return null;
			} else {
				cpcsousclasseDao.save(cpcsousclasse);
				for (CpcClasseComptable cpcclassecomptable : cpcsousclasse.getCpcClasseComptables()) {
					cpcclassecomptable.setCpcSousClasse(cpcsousclasse);
					cpcclassecomptableService.save(cpcclassecomptable);
				}
				return cpcsousclasse;
			}
		}
	}
	
	@Override
	public CpcSousClasse save(CpcSousClasse cpcsousclasse) {

		if (cpcsousclasse == null) {
			return null;
		} else {
			cpcsousclasseDao.save(cpcsousclasse);
			return cpcsousclasse;
		}
	}
	
	@Override
	public List<CpcSousClasse> findAll() {
		return cpcsousclasseDao.findAll();
	}

	@Override
	public CpcSousClasse findById(Long id) {
		return cpcsousclasseDao.getOne(id);
	}

	@Override
	public int delete(CpcSousClasse cpcsousclasse) {
		if (cpcsousclasse == null) {
			return -1;
		} else {
			cpcsousclasseDao.delete(cpcsousclasse);
			return 1;
		}
	}

	@Override
	public void deleteById(Long id) {
		cpcsousclasseDao.deleteById(id);
	}

}
