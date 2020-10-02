package com.example.demo.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CpcClasseComptable {
	
	// Groupement les operations comptables par ClasseComptable
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	//montant est la somme des montants des operations pour une ClasseComptable
	@Column(precision = 16, scale = 4)
	private BigDecimal montant;
	@ManyToOne
	private CpcSousClasse cpcSousClasse;
	@ManyToOne
	private ClasseComptable classeComptable;
	
	public CpcClasseComptable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CpcClasseComptable(Long id, BigDecimal montant, CpcSousClasse cpcSousClasse,
			ClasseComptable classeComptable) {
		super();
		this.id = id;
		this.montant = montant;
		this.cpcSousClasse = cpcSousClasse;
		this.classeComptable = classeComptable;
	}
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
	public CpcSousClasse getCpcSousClasse() {
		return cpcSousClasse;
	}
	public void setCpcSousClasse(CpcSousClasse cpcSousClasse) {
		this.cpcSousClasse = cpcSousClasse;
	}
	public ClasseComptable getClasseComptable() {
		return classeComptable;
	}
	public void setClasseComptable(ClasseComptable classeComptable) {
		this.classeComptable = classeComptable;
	}
	
	

}
