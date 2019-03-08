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
@Table(name = "espece_debarquee_transportees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspeceDebarqueeTransportees.findAll", query = "SELECT e FROM EspeceDebarqueeTransportees e")
    , @NamedQuery(name = "EspeceDebarqueeTransportees.findById", query = "SELECT e FROM EspeceDebarqueeTransportees e WHERE e.id = :id")
    , @NamedQuery(name = "EspeceDebarqueeTransportees.findByNombreTransporte", query = "SELECT e FROM EspeceDebarqueeTransportees e WHERE e.nombreTransporte = :nombreTransporte")
    , @NamedQuery(name = "EspeceDebarqueeTransportees.findByPoids", query = "SELECT e FROM EspeceDebarqueeTransportees e WHERE e.poids = :poids")
    , @NamedQuery(name = "EspeceDebarqueeTransportees.findByPrixUnitaire", query = "SELECT e FROM EspeceDebarqueeTransportees e WHERE e.prixUnitaire = :prixUnitaire")
    , @NamedQuery(name = "EspeceDebarqueeTransportees.findByMontantPartiel", query = "SELECT e FROM EspeceDebarqueeTransportees e WHERE e.montantPartiel = :montantPartiel")})
public class EspeceDebarqueeTransportees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TRANSPORTE")
    private float nombreTransporte;
    @Basic(optional = false)
    @Column(name = "POIDS")
    private float poids;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRIX_UNITAIRE")
    private Float prixUnitaire;
    @Column(name = "MONTANT_PARTIEL")
    private Float montantPartiel;
    @JoinColumn(name = "VEHICULE", referencedColumnName = "Id")
    @ManyToOne
    private Vehicule vehicule;
    @JoinColumn(name = "CONTAINER", referencedColumnName = "Id")
    @ManyToOne
    private Container container;
    @JoinColumn(name = "DESTINATION", referencedColumnName = "Id")
    @ManyToOne
    private Destination destination;
    @JoinColumn(name = "ESPECE_DEMOULEE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private EspeceDemoulee especeDemoulee;
    @JoinColumn(name = "EXPORTATION", referencedColumnName = "Id")
    @ManyToOne
    private Exportation exportation;

    public EspeceDebarqueeTransportees() {
    }

    public EspeceDebarqueeTransportees(Integer id) {
        this.id = id;
    }

    public EspeceDebarqueeTransportees(Integer id, float nombreTransporte, float poids) {
        this.id = id;
        this.nombreTransporte = nombreTransporte;
        this.poids = poids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getNombreTransporte() {
        return nombreTransporte;
    }

    public void setNombreTransporte(float nombreTransporte) {
        this.nombreTransporte = nombreTransporte;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public Float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Float getMontantPartiel() {
        return montantPartiel;
    }

    public void setMontantPartiel(Float montantPartiel) {
        this.montantPartiel = montantPartiel;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public EspeceDemoulee getEspeceDemoulee() {
        return especeDemoulee;
    }

    public void setEspeceDemoulee(EspeceDemoulee especeDemoulee) {
        this.especeDemoulee = especeDemoulee;
    }

    public Exportation getExportation() {
        return exportation;
    }

    public void setExportation(Exportation exportation) {
        this.exportation = exportation;
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
        if (!(object instanceof EspeceDebarqueeTransportees)) {
            return false;
        }
        EspeceDebarqueeTransportees other = (EspeceDebarqueeTransportees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.EspeceDebarqueeTransportees[ id=" + id + " ]";
    }
    
}
