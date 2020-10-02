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

import com.example.demo.bean.CpcClasseComptable;
import com.example.demo.service.facade.CpcClasseComptableService;

@RestController
@RequestMapping("/ProjetCpc/CpcClasseComptable")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CpcClasseComptableRest {
	
	@Autowired
	private CpcClasseComptableService cpcClasseComptableService;
	
    @PostMapping("/")
    public CpcClasseComptable save(@RequestBody CpcClasseComptable cpcClasseComptable) {
        return cpcClasseComptableService.save(cpcClasseComptable);
    }
    
    @Transactional
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
    	cpcClasseComptableService.deleteById(id);
    }

    @GetMapping("/")
    public List<CpcClasseComptable> findAll() {
        return cpcClasseComptableService.findAll();
    }
    
    @PutMapping("/update/")
	public int update(@RequestBody CpcClasseComptable cpcClasseComptable) {
		return cpcClasseComptableService.update(cpcClasseComptable);
	}

}
