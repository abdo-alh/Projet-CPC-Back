package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CpcSousClasse {
	
	// Groupement les operations comptables par SousClasseComptable

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	//montant est la somme des montants des operations pour une SousClasseComptable
	@Column(precision = 16, scale = 4)
	private BigDecimal montant;
	@ManyToOne
	private Cpc cpc;
	@ManyToOne
	private SousClasseComptable sousClasseComptable;
	@OneToMany(mappedBy = "cpcSousClasse")
	private List<CpcClasseComptable> cpcClasseComptables;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getMontant() {
		return montant;
	}
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
	public Cpc getCpc() {
		return cpc;
	}
	public void setCpc(Cpc cpc) {
		this.cpc = cpc;
	}
	public SousClasseComptable getSousClasseComptable() {
		return sousClasseComptable;
	}
	public void setSousClasseComptable(SousClasseComptable sousClasseComptable) {
		this.sousClasseComptable = sousClasseComptable;
	}
	public List<CpcClasseComptable> getCpcClasseComptables() {
		return cpcClasseComptables;
	}
	public void setCpcClasseComptables(List<CpcClasseComptable> cpcClasseComptables) {
		this.cpcClasseComptables = cpcClasseComptables;
	}
	
	

}
