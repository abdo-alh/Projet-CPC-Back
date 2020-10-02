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

import com.example.demo.bean.CompteComptable;
import com.example.demo.service.facade.CompteComptableService;

@RestController
@RequestMapping("/ProjetCpc/CompteComptable")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CompteComptableRest {

	@Autowired
	private CompteComptableService compteComptableService;

	@PostMapping("/")
	public CompteComptable save(@RequestBody CompteComptable compteComptable) {
		return compteComptableService.save(compteComptable);
	}
	
	@PutMapping("/update/")
	public int update(@RequestBody CompteComptable compteComptable) {
		return compteComptableService.update(compteComptable);
	}

	@Transactional
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		compteComptableService.deleteById(id);
	}
	
	@Transactional
	@DeleteMapping("/code/{code}")
	public int deleteByCode(@PathVariable String code) {
		return compteComptableService.deleteByCode(code);
	}

	@GetMapping("/")
	public List<CompteComptable> findAll() {
		return compteComptableService.findAll();
	}

}