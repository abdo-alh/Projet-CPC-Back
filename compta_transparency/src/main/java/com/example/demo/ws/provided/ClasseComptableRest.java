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

import com.example.demo.bean.ClasseComptable;
import com.example.demo.service.facade.ClasseComptableService;


@RestController
@RequestMapping("/ProjetCpc/ClasseComptable")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ClasseComptableRest {

	@Autowired
	private ClasseComptableService classeComptableService;

	@PostMapping("/")
	public int save(@RequestBody ClasseComptable classeComptable) {
		return classeComptableService.save(classeComptable);
	}
	
	@PutMapping("/update/")
	public int update(@RequestBody ClasseComptable classeComptable) {
		return classeComptableService.update(classeComptable);
	}

	@Transactional
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id) {
		classeComptableService.deleteById(id);
	}

	@GetMapping("/")
	public List<ClasseComptable> findAll() {
		return classeComptableService.findAll();
	}
	
	@Transactional
	@DeleteMapping("/delete/numero/{numero}")
	public int deleteByNumero(@PathVariable int numero) {
		return classeComptableService.deleteByNumero(numero);
	}

}