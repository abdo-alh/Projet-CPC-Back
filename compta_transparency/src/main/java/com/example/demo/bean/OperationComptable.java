package com.example.demo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class OperationComptable implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String referenceSociete;
    private String referenceFacture;
    @Column(precision = 16, scale = 4)
    private BigDecimal montant;
   
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateOperationComptable;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateSaisie;
    @ManyToOne
    private CompteComptable compteComptable;
    
    

    public OperationComptable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperationComptable(CompteComptable compteComptable,BigDecimal montant) {
		super();
		this.compteComptable = compteComptable;
		this.montant = montant;
	}
	
	public OperationComptable(ClasseComptable classeComptable,BigDecimal montant) {
		super();
		if(this.compteComptable==null) {
			this.compteComptable=new CompteComptable();
		}
		if(this.compteComptable.getSousClasseComptable().getClasseComptable()==null) {
			this.compteComptable.getSousClasseComptable().setClasseComptable(new ClasseComptable());
		}
		this.compteComptable.getSousClasseComptable().setClasseComptable(classeComptable); 
		this.montant = montant;
	}
	
	public OperationComptable(SousClasseComptable sousClasseComptable,BigDecimal montant) {
		super();
		if(this.compteComptable==null) {
			this.compteComptable=new CompteComptable();
		}
		if(this.compteComptable.getSousClasseComptable()==null) {
			this.compteComptable.setSousClasseComptable(new SousClasseComptable());
		}
		this.compteComptable.setSousClasseComptable(sousClasseComptable); 
		this.montant = montant;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReferenceSociete() {
        return referenceSociete;
    }

    public void setReferenceSociete(String referenceSociete) {
        this.referenceSociete = referenceSociete;
    }

    public String getReferenceFacture() {
        return referenceFacture;
    }

    public void setReferenceFacture(String referenceFacture) {
        this.referenceFacture = referenceFacture;
    }


    public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

    public Date getDateOperationComptable() {
        return dateOperationComptable;
    }

    public void setDateOperationComptable(Date dateOperationComptable) {
        this.dateOperationComptable = dateOperationComptable;
    }

    public Date getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(Date dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public CompteComptable getCompteComptable() {
        return compteComptable;
    }

    public void setCompteComptable(CompteComptable compteComptable) {
        this.compteComptable = compteComptable;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OperationComptable other = (OperationComptable) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    

   
}
