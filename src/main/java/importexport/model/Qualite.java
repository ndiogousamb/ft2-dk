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
@Table(name = "qualite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualite.findAll", query = "SELECT q FROM Qualite q")
    , @NamedQuery(name = "Qualite.findById", query = "SELECT q FROM Qualite q WHERE q.id = :id")
    , @NamedQuery(name = "Qualite.findByLibelleQualite", query = "SELECT q FROM Qualite q WHERE q.libelleQualite = :libelleQualite")})
public class Qualite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LIBELLE_QUALITE")
    private String libelleQualite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualite")
    @JsonIgnore
    private List<EspeceDemoulee> especeDemouleeList;

    public Qualite() {
    }

    public Qualite(Integer id) {
        this.id = id;
    }

    public Qualite(Integer id, String libelleQualite) {
        this.id = id;
        this.libelleQualite = libelleQualite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelleQualite() {
        return libelleQualite;
    }

    public void setLibelleQualite(String libelleQualite) {
        this.libelleQualite = libelleQualite;
    }

    @XmlTransient
    public List<EspeceDemoulee> getEspeceDemouleeList() {
        return especeDemouleeList;
    }

    public void setEspeceDemouleeList(List<EspeceDemoulee> especeDemouleeList) {
        this.especeDemouleeList = especeDemouleeList;
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
        if (!(object instanceof Qualite)) {
            return false;
        }
        Qualite other = (Qualite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Qualite[ id=" + id + " ]";
    }
    
}
