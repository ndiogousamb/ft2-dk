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
@Table(name = "espece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espece.findAll", query = "SELECT e FROM Espece e")
    , @NamedQuery(name = "Espece.findById", query = "SELECT e FROM Espece e WHERE e.id = :id")
    , @NamedQuery(name = "Espece.findByCodeEspece", query = "SELECT e FROM Espece e WHERE e.codeEspece = :codeEspece")
    , @NamedQuery(name = "Espece.findByLibelleEspece", query = "SELECT e FROM Espece e WHERE e.libelleEspece = :libelleEspece")})
public class Espece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_ESPECE")
    private String codeEspece;
    @Basic(optional = false)
    @Column(name = "LIBELLE_ESPECE")
    private String libelleEspece;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espece")
    @JsonIgnore
    private List<EspeceDemoulee> especeDemouleeList;

    public Espece() {
    }

    public Espece(Integer id) {
        this.id = id;
    }

    public Espece(Integer id, String codeEspece, String libelleEspece) {
        this.id = id;
        this.codeEspece = codeEspece;
        this.libelleEspece = libelleEspece;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeEspece() {
        return codeEspece;
    }

    public void setCodeEspece(String codeEspece) {
        this.codeEspece = codeEspece;
    }

    public String getLibelleEspece() {
        return libelleEspece;
    }

    public void setLibelleEspece(String libelleEspece) {
        this.libelleEspece = libelleEspece;
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
        if (!(object instanceof Espece)) {
            return false;
        }
        Espece other = (Espece) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Espece[ id=" + id + " ]";
    }
    
}
