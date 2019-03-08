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
@Table(name = "calibre_g_p")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalibreGP.findAll", query = "SELECT c FROM CalibreGP c")
    , @NamedQuery(name = "CalibreGP.findById", query = "SELECT c FROM CalibreGP c WHERE c.id = :id")
    , @NamedQuery(name = "CalibreGP.findByLibelleCalibreGP", query = "SELECT c FROM CalibreGP c WHERE c.libelleCalibreGP = :libelleCalibreGP")})
public class CalibreGP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LIBELLE_CALIBRE_G_P")
    private String libelleCalibreGP;
    @OneToMany(mappedBy = "grosPoisson")
    @JsonIgnore
    private List<EspeceDemoulee> especeDemouleeList;

    public CalibreGP() {
    }

    public CalibreGP(Integer id) {
        this.id = id;
    }

    public CalibreGP(Integer id, String libelleCalibreGP) {
        this.id = id;
        this.libelleCalibreGP = libelleCalibreGP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelleCalibreGP() {
        return libelleCalibreGP;
    }

    public void setLibelleCalibreGP(String libelleCalibreGP) {
        this.libelleCalibreGP = libelleCalibreGP;
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
        if (!(object instanceof CalibreGP)) {
            return false;
        }
        CalibreGP other = (CalibreGP) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.CalibreGP[ id=" + id + " ]";
    }
    
}
