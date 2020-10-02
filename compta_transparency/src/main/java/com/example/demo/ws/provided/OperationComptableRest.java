package com.example.demo.ws.provided;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.OperationComptable;
import com.example.demo.service.facade.OperationComptableService;

@RestController
@RequestMapping("/ProjetCpc/OperationComptable")
@CrossOrigin(origins = { "http://localhost:4200" })
public class OperationComptableRest {

	@Autowired
	private OperationComptableService operationComptableService;

	@PostMapping("/")
	public OperationComptable save(@RequestBody OperationComptable operationComptable) {
		return operationComptableService.save(operationComptable);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		operationComptableService.deleteById(id);
	}

	@GetMapping("/")
	public List<OperationComptable> findAll() {
		return operationComptableService.findAll();
	}

	@GetMapping("/rechercher/CompteComptable/dateDebut/{dateDebut}/dateFin/{dateFin}/code/{code}")
	public List<OperationComptable> findGroupeByCompteComptable(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin, @PathVariable int code) {
		return operationComptableService.findGroupeByCompteComptable(dateDebut, dateFin, code);
	}

	@GetMapping("/rechercher/SousClasseComptable/dateDebut/{dateDebut}/dateFin/{dateFin}/code/{code}")
	public List<OperationComptable> findGroupeBySousClasseCompteComptable(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin, @PathVariable String code) {
		return operationComptableService.findGroupeBySousClasseCompteComptable(dateDebut, dateFin, code);
	}

	@PostMapping("/excel/")
	public Resource excel(@RequestBody List<OperationComptable> operationComptables) {
		return operationComptableService.generateExcelFile(operationComptables);
	}

	@GetMapping("/rechercher/ClasseComptable/dateDebut/{dateDebut}/dateFin/{dateFin}/code/{code}")
	public List<Object[]> findGroupeByClasseCompteComptable(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin, @PathVariable String code) {
		return operationComptableService.findGroupeByClasseComptable(dateDebut, dateFin, code);
	}

}