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
@Table(name = "tunnel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tunnel.findAll", query = "SELECT t FROM Tunnel t")
    , @NamedQuery(name = "Tunnel.findById", query = "SELECT t FROM Tunnel t WHERE t.id = :id")
    , @NamedQuery(name = "Tunnel.findByLibelleTunnel", query = "SELECT t FROM Tunnel t WHERE t.libelleTunnel = :libelleTunnel")})
public class Tunnel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LIBELLE_TUNNEL")
    private String libelleTunnel;
    @OneToMany(mappedBy = "tunnel")
    @JsonIgnore
    private List<Production> productionList;

    public Tunnel() {
    }

    public Tunnel(Integer id) {
        this.id = id;
    }

    public Tunnel(Integer id, String libelleTunnel) {
        this.id = id;
        this.libelleTunnel = libelleTunnel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelleTunnel() {
        return libelleTunnel;
    }

    public void setLibelleTunnel(String libelleTunnel) {
        this.libelleTunnel = libelleTunnel;
    }

    @XmlTransient
    public List<Production> getProductionList() {
        return productionList;
    }

    public void setProductionList(List<Production> productionList) {
        this.productionList = productionList;
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
        if (!(object instanceof Tunnel)) {
            return false;
        }
        Tunnel other = (Tunnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Tunnel[ id=" + id + " ]";
    }
    
}
