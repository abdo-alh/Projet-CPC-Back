package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Cpc {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int numero;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDebut;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFin;
	@Column(precision = 16, scale = 4)
	private BigDecimal montant;
	private String referenceSociete;
    @Column(precision = 16, scale = 4)
    private BigDecimal totalCharge;
    @Column(precision = 16, scale = 4)
    private BigDecimal totalProduit;
    @Column(precision = 16, scale = 4)
    private BigDecimal resultat;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getReferenceSociete() {
		return referenceSociete;
	}
	public void setReferenceSociete(String referenceSociete) {
		this.referenceSociete = referenceSociete;
	}
	public BigDecimal getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(BigDecimal totalCharge) {
		this.totalCharge = totalCharge;
	}
	public BigDecimal getTotalProduit() {
		return totalProduit;
	}
	public void setTotalProduit(BigDecimal totalProduit) {
		this.totalProduit = totalProduit;
	}
	public BigDecimal getResultat() {
		return resultat;
	}
	public void setResultat(BigDecimal resultat) {
		this.resultat = resultat;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public BigDecimal getMontant() {
		return montant;
	}
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
	public List<CpcSousClasse> getCpcSousClasses() {
		return cpcSousClasses;
	}
	public void setCpcSousClasses(List<CpcSousClasse> cpcSousClasses) {
		this.cpcSousClasses = cpcSousClasses;
	}
	
	

}
