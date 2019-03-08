/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importexport.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ndiogou Samb
 */
@Entity
@Table(name = "espece_produite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspeceProduite.findAll", query = "SELECT e FROM EspeceProduite e")
    , @NamedQuery(name = "EspeceProduite.findById", query = "SELECT e FROM EspeceProduite e WHERE e.id = :id")
    , @NamedQuery(name = "EspeceProduite.findByCodeEspeceProduite", query = "SELECT e FROM EspeceProduite e WHERE e.codeEspeceProduite = :codeEspeceProduite")
    , @NamedQuery(name = "EspeceProduite.findByPoids", query = "SELECT e FROM EspeceProduite e WHERE e.poids = :poids")
    , @NamedQuery(name = "EspeceProduite.findByDemoule", query = "SELECT e FROM EspeceProduite e WHERE e.demoule = :demoule")
    , @NamedQuery(name = "EspeceProduite.findByPrixEspeceCalibree", query = "SELECT e FROM EspeceProduite e WHERE e.prixEspeceCalibree = :prixEspeceCalibree")
    , @NamedQuery(name = "EspeceProduite.findByMontant", query = "SELECT e FROM EspeceProduite e WHERE e.montant = :montant")
    , @NamedQuery(name = "EspeceProduite.findByPoidsRestantADemouler", query = "SELECT e FROM EspeceProduite e WHERE e.poidsRestantADemouler = :poidsRestantADemouler")})
public class EspeceProduite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_ESPECE_PRODUITE")
    private String codeEspeceProduite;
    @Basic(optional = false)
    @Column(name = "POIDS")
    private float poids;
    @Basic(optional = false)
    @Column(name = "Demoule")
    private int demoule;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRIX_ESPECE_CALIBREE")
    private Float prixEspeceCalibree;
    @Column(name = "Montant")
    private Integer montant;
    @Column(name = "POIDS_RESTANT_A_DEMOULER")
    private Float poidsRestantADemouler;
    @JoinColumn(name = "ESPECE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Espece espece;
    @JoinColumn(name = "PRODUCTION", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Production production;
    @JoinColumn(name = "CALIBRE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Calibre calibre;
    @Basic(optional = false)
    @Column(name = "REGLE")
    private int regle;
    @Basic(optional = false)
    @Column(name = "PLAIGNAT")
    private float plaignat;
    public float getPlaignat() {
		return plaignat;
	}

	public void setPlaignat(float plaignat) {
		this.plaignat = plaignat;
	}

	public int getRegle() {
		return regle;
	}

	public void setRegle(int regle) {
		this.regle = regle;
	}

	public void setPoidsRestantADemouler(Float poidsRestantADemouler) {
		this.poidsRestantADemouler = poidsRestantADemouler;
	}

	public EspeceProduite() {
    }

    public EspeceProduite(Integer id) {
        this.id = id;
    }

    public EspeceProduite(Integer id, String codeEspeceProduite, float poids, int demoule, float poidsRestantADemouler) {
        this.id = id;
        this.codeEspeceProduite = codeEspeceProduite;
        this.poids = poids;
        this.demoule = demoule;
        this.poidsRestantADemouler = poidsRestantADemouler;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeEspeceProduite() {
        return codeEspeceProduite;
    }

    public void setCodeEspeceProduite(String codeEspeceProduite) {
        this.codeEspeceProduite = codeEspeceProduite;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public int getDemoule() {
        return demoule;
    }

    public void setDemoule(int demoule) {
        this.demoule = demoule;
    }

    public Float getPrixEspeceCalibree() {
        return prixEspeceCalibree;
    }

    public void setPrixEspeceCalibree(Float prixEspeceCalibree) {
        this.prixEspeceCalibree = prixEspeceCalibree;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public float getPoidsRestantADemouler() {
        return poidsRestantADemouler;
    }

    public void setPoidsRestantADemouler(float poidsRestantADemouler) {
        this.poidsRestantADemouler = poidsRestantADemouler;
    }

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Calibre getCalibre() {
        return calibre;
    }

    public void setCalibre(Calibre calibre) {
        this.calibre = calibre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspeceProduite)) {
            return false;
        }
        EspeceProduite other = (EspeceProduite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.EspeceProduite[ id=" + id + " ]";
    }
    
}
