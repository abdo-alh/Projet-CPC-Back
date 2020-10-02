package com.example.demo.ws.provided;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.SousClasseComptable;
import com.example.demo.service.facade.SousClasseComptableService;

@RestController
@RequestMapping("/ProjetCpc/SousClasseComptable")
@CrossOrigin(origins = { "http://localhost:4200" })
public class SousClasseComptableRest {

	@Autowired
	private SousClasseComptableService sousClasseComptableService;

	@PostMapping("/")
	public SousClasseComptable save(@RequestBody SousClasseComptable sousClasseComptable) {
		return sousClasseComptableService.save(sousClasseComptable);
	}
	
	@PutMapping("/update/")
	public int update(@RequestBody SousClasseComptable sousClasseComptable) {
		return sousClasseComptableService.update(sousClasseComptable);
	}

	@Transactional
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return sousClasseComptableService.deleteById(id);
	}
	
	@Transactional
	@DeleteMapping("/numero/{numero}")
	public int deleteByNumero(@PathVariable int numero) {
		return sousClasseComptableService.deleteByNumero(numero);
	}

	@GetMapping("/")
	public List<SousClasseComptable> findAll() {
		return sousClasseComptableService.findAll();
	}

}