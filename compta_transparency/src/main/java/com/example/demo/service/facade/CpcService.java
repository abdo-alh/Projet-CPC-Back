package com.example.demo.service.facade;


import java.util.List;

import com.example.demo.bean.Cpc;

public interface CpcService {
	
	public Cpc save(Cpc cpc);

	public Cpc saveWithCpcSousClasses(Cpc cpc);

	public List<Cpc> findAll();

	public Cpc findById(Long id);

	public int delete(Cpc cpc);

	public void deleteById(Long id);
	
	public int update(Cpc cpc);

}
