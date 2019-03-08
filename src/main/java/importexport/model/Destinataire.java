/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importexport.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Ndiogou Samb
 */
@Entity
@Table(name = "destinataire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinataire.findAll", query = "SELECT d FROM Destinataire d")
    , @NamedQuery(name = "Destinataire.findById", query = "SELECT d FROM Destinataire d WHERE d.id = :id")
    , @NamedQuery(name = "Destinataire.findByPrenomDestinataire", query = "SELECT d FROM Destinataire d WHERE d.prenomDestinataire = :prenomDestinataire")
    , @NamedQuery(name = "Destinataire.findByNomDestinataire", query = "SELECT d FROM Destinataire d WHERE d.nomDestinataire = :nomDestinataire")
    , @NamedQuery(name = "Destinataire.findByAdresseDestinataire", query = "SELECT d FROM Destinataire d WHERE d.adresseDestinataire = :adresseDestinataire")})
public class Destinataire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PRENOM_DESTINATAIRE")
    private String prenomDestinataire;
    @Basic(optional = false)
    @Column(name = "NOM_DESTINATAIRE")
    private String nomDestinataire;
    @Basic(optional = false)
    @Column(name = "ADRESSE_DESTINATAIRE")
    private String adresseDestinataire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinataire")
    @JsonIgnore
    private List<Exportation> exportationList;

    public Destinataire() {
    }

    public Destinataire(Integer id) {
        this.id = id;
    }

    public Destinataire(Integer id, String prenomDestinataire, String nomDestinataire, String adresseDestinataire) {
        this.id = id;
        this.prenomDestinataire = prenomDestinataire;
        this.nomDestinataire = nomDestinataire;
        this.adresseDestinataire = adresseDestinataire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenomDestinataire() {
        return prenomDestinataire;
    }

    public void setPrenomDestinataire(String prenomDestinataire) {
        this.prenomDestinataire = prenomDestinataire;
    }

    public String getNomDestinataire() {
        return nomDestinataire;
    }

    public void setNomDestinataire(String nomDestinataire) {
        this.nomDestinataire = nomDestinataire;
    }

    public String getAdresseDestinataire() {
        return adresseDestinataire;
    }

    public void setAdresseDestinataire(String adresseDestinataire) {
        this.adresseDestinataire = adresseDestinataire;
    }

    @XmlTransient
    public List<Exportation> getExportationList() {
        return exportationList;
    }

    public void setExportationList(List<Exportation> exportationList) {
        this.exportationList = exportationList;
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
        if (!(object instanceof Destinataire)) {
            return false;
        }
        Destinataire other = (Destinataire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Destinataire[ id=" + id + " ]";
    }
    
}
