package com.example.demo.service.facade;


import java.util.List;

import com.example.demo.bean.CpcSousClasse;

public interface CpcSousClasseService {
	
	public CpcSousClasse save(CpcSousClasse cpcsousclasse);

	public CpcSousClasse saveWithCpcClasseComptables(CpcSousClasse cpcsousclasse);
	
    public List<CpcSousClasse> findAll();

    public CpcSousClasse findById(Long id);

    public int delete(CpcSousClasse cpcsousclasse);

    public void deleteById(Long id);

    public int update(CpcSousClasse cpcSousClasse);
}
