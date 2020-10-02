package com.example.demo.service.Impl;


import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Cpc;
import com.example.demo.bean.CpcSousClasse;
import com.example.demo.dao.CpcClasseComptableDao;
import com.example.demo.dao.CpcDao;
import com.example.demo.dao.CpcSousClasseDao;
import com.example.demo.service.facade.CpcService;
import com.example.demo.service.facade.CpcSousClasseService;
import com.example.demo.service.facade.OperationComptableService;

@Service
public class CpcServiceImpl implements CpcService {

	@Autowired
	CpcClasseComptableDao cpcClasseComptableDao;
	
	@Autowired
	CpcSousClasseDao cpcSousClasseDao;
	
	@Autowired
	OperationComptableService operationComptableService;

	@Autowired
	private CpcDao cpcDao;

	@Autowired
	private CpcSousClasseService cpcsousclasseService;

	@Override
	public Cpc save(Cpc cpc) {

		if (cpc == null) {
			return null;
		} else {
			cpcDao.save(cpc);
			return cpc;
		}
	}

	@Override
	public Cpc saveWithCpcSousClasses(Cpc cpc) {

		if (cpc == null) {
			return null;
		} else {
			if (cpc.getCpcSousClasses().isEmpty()) {
				return null;
			} else {
				cpcDao.save(cpc);
				for (CpcSousClasse cpcsousclasse : cpc.getCpcSousClasses()) {
					cpcsousclasse.setCpc(cpc);
					cpcsousclasseService.saveWithCpcClasseComptables(cpcsousclasse);
				}
				return cpc;
			}
		}
	}

	@Override
	public List<Cpc> findAll() {
		return cpcDao.findAll();
	}

	@Override
	public Cpc findById(Long id) {
		return cpcDao.getOne(id);
	}

	@Override
	public int delete(Cpc cpc) {
		if (cpc == null) {
			return -1;
		} else {

			cpcDao.delete(cpc);
			return 1;
		}
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		cpcDao.deleteById(id);
	}

}
