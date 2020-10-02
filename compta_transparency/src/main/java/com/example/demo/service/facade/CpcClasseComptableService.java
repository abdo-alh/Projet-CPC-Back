package com.example.demo.service.facade;

import java.util.List;

import com.example.demo.bean.CpcClasseComptable;

public interface CpcClasseComptableService {

		public CpcClasseComptable save(CpcClasseComptable cpcclasseComptable);

		public List<CpcClasseComptable> findAll();

		public CpcClasseComptable findById(Long id);

	    public int delete(CpcClasseComptable cpcclasseComptable);

	    public void deleteById(Long id);

}
