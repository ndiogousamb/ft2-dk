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
@Table(name = "escepe_demoulee_achetee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscepeDemouleeAchetee.findAll", query = "SELECT e FROM EscepeDemouleeAchetee e")
    , @NamedQuery(name = "EscepeDemouleeAchetee.findById", query = "SELECT e FROM EscepeDemouleeAchetee e WHERE e.id = :id")
    , @NamedQuery(name = "EscepeDemouleeAchetee.findByMontant", query = "SELECT e FROM EscepeDemouleeAchetee e WHERE e.montant = :montant")
    , @NamedQuery(name = "EscepeDemouleeAchetee.findByPrixUnitaire", query = "SELECT e FROM EscepeDemouleeAchetee e WHERE e.prixUnitaire = :prixUnitaire")
    , @NamedQuery(name = "EscepeDemouleeAchetee.findByPoids", query = "SELECT e FROM EscepeDemouleeAchetee e WHERE e.poids = :poids")
    , @NamedQuery(name = "EscepeDemouleeAchetee.findByNombreCartonAchete", query = "SELECT e FROM EscepeDemouleeAchetee e WHERE e.nombreCartonAchete = :nombreCartonAchete")})
public class EscepeDemouleeAchetee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT")
    private Float montant;
    @Column(name = "PRIX_UNITAIRE")
    private Float prixUnitaire;
    @Basic(optional = false)
    @Column(name = "POIDS")
    private float poids;
    @Column(name = "NOMBRE_CARTON_ACHETE")
    private Float nombreCartonAchete;
    @JoinColumn(name = "ACHAT", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Achat achat;
    @JoinColumn(name = "ESPECE_DEMOULEE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private EspeceDemoulee especeDemoulee;

    public EscepeDemouleeAchetee() {
    }

    public EscepeDemouleeAchetee(Integer id) {
        this.id = id;
    }

    public EscepeDemouleeAchetee(Integer id, float poids) {
        this.id = id;
        this.poids = poids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public Float getNombreCartonAchete() {
        return nombreCartonAchete;
    }

    public void setNombreCartonAchete(Float nombreCartonAchete) {
        this.nombreCartonAchete = nombreCartonAchete;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public EspeceDemoulee getEspeceDemoulee() {
        return especeDemoulee;
    }

    public void setEspeceDemoulee(EspeceDemoulee especeDemoulee) {
        this.especeDemoulee = especeDemoulee;
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
        if (!(object instanceof EscepeDemouleeAchetee)) {
            return false;
        }
        EscepeDemouleeAchetee other = (EscepeDemouleeAchetee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.EscepeDemouleeAchetee[ id=" + id + " ]";
    }
    
}
