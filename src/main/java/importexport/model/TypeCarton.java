/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importexport.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "type_carton")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeCarton.findAll", query = "SELECT t FROM TypeCarton t")
    , @NamedQuery(name = "TypeCarton.findById", query = "SELECT t FROM TypeCarton t WHERE t.id = :id")
    , @NamedQuery(name = "TypeCarton.findByLibelleTypecarton", query = "SELECT t FROM TypeCarton t WHERE t.libelleTypecarton = :libelleTypecarton")})
public class TypeCarton implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LIBELLE_TYPECARTON")
    private String libelleTypecarton;
    @OneToMany(mappedBy = "typeCarton")
    @JsonIgnore
    private List<EspeceDemoulee> especeDemouleeList;

    public TypeCarton() {
    }

    public TypeCarton(Integer id) {
        this.id = id;
    }

    public TypeCarton(Integer id, String libelleTypecarton) {
        this.id = id;
        this.libelleTypecarton = libelleTypecarton;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelleTypecarton() {
        return libelleTypecarton;
    }

    public void setLibelleTypecarton(String libelleTypecarton) {
        this.libelleTypecarton = libelleTypecarton;
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
        if (!(object instanceof TypeCarton)) {
            return false;
        }
        TypeCarton other = (TypeCarton) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.TypeCarton[ id=" + id + " ]";
    }
    
}
