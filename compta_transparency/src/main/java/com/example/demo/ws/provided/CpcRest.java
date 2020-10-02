package com.example.demo.ws.provided;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Cpc;
import com.example.demo.service.facade.CpcService;

@RestController
@RequestMapping("/ProjetCpc/Cpc")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CpcRest {

	@Autowired
	private CpcService cpcService;
	
	@PostMapping("/")
    public Cpc save(@RequestBody Cpc cpc) {
        return cpcService.saveWithCpcSousClasses(cpc);
    }
	
	@GetMapping("/")
    public List<Cpc> findAll() {
        return cpcService.findAll();
    }
	
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        cpcService.deleteById(id);
    }

    @DeleteMapping("/")
    public void delete(@RequestBody Cpc cpc) {
        cpcService.delete(cpc);
    }

}