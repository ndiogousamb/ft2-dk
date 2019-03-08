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
@Table(name = "chargeur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chargeur.findAll", query = "SELECT c FROM Chargeur c")
    , @NamedQuery(name = "Chargeur.findById", query = "SELECT c FROM Chargeur c WHERE c.id = :id")
    , @NamedQuery(name = "Chargeur.findByNomChargeur", query = "SELECT c FROM Chargeur c WHERE c.nomChargeur = :nomChargeur")})
public class Chargeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOM_CHARGEUR")
    private String nomChargeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chargeur")
    @JsonIgnore
    private List<Exportation> exportationList;

    public Chargeur() {
    }

    public Chargeur(Integer id) {
        this.id = id;
    }

    public Chargeur(Integer id, String nomChargeur) {
        this.id = id;
        this.nomChargeur = nomChargeur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomChargeur() {
        return nomChargeur;
    }

    public void setNomChargeur(String nomChargeur) {
        this.nomChargeur = nomChargeur;
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
        if (!(object instanceof Chargeur)) {
            return false;
        }
        Chargeur other = (Chargeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Chargeur[ id=" + id + " ]";
    }
    
}
