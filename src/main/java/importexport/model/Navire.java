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
@Table(name = "navire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Navire.findAll", query = "SELECT n FROM Navire n")
    , @NamedQuery(name = "Navire.findById", query = "SELECT n FROM Navire n WHERE n.id = :id")
    , @NamedQuery(name = "Navire.findByNomNavire", query = "SELECT n FROM Navire n WHERE n.nomNavire = :nomNavire")})
public class Navire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOM_NAVIRE")
    private String nomNavire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "navire")
    @JsonIgnore
    private List<Debarquement> debarquementList;

    public Navire() {
    }

    public Navire(Integer id) {
        this.id = id;
    }

    public Navire(Integer id, String nomNavire) {
        this.id = id;
        this.nomNavire = nomNavire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomNavire() {
        return nomNavire;
    }

    public void setNomNavire(String nomNavire) {
        this.nomNavire = nomNavire;
    }

    @XmlTransient
    public List<Debarquement> getDebarquementList() {
        return debarquementList;
    }

    public void setDebarquementList(List<Debarquement> debarquementList) {
        this.debarquementList = debarquementList;
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
        if (!(object instanceof Navire)) {
            return false;
        }
        Navire other = (Navire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Navire[ id=" + id + " ]";
    }
    
}
