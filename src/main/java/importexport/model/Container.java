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
@Table(name = "container")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Container.findAll", query = "SELECT c FROM Container c")
    , @NamedQuery(name = "Container.findById", query = "SELECT c FROM Container c WHERE c.id = :id")
    , @NamedQuery(name = "Container.findByNumeroContaineur", query = "SELECT c FROM Container c WHERE c.numeroContaineur = :numeroContaineur")
    , @NamedQuery(name = "Container.findByNumeroPlombs", query = "SELECT c FROM Container c WHERE c.numeroPlombs = :numeroPlombs")})
public class Container implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NUMERO_CONTAINEUR")
    private String numeroContaineur;
    @Basic(optional = false)
    @Column(name = "NUMERO_PLOMBS")
    private String numeroPlombs;
    @JoinColumn(name = "TYPE_CONTAINER", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TypeContainer typeContainer;

    public Container() {
    }

    public Container(Integer id) {
        this.id = id;
    }

    public Container(Integer id, String numeroContaineur, String numeroPlombs) {
        this.id = id;
        this.numeroContaineur = numeroContaineur;
        this.numeroPlombs = numeroPlombs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroContaineur() {
        return numeroContaineur;
    }

    public void setNumeroContaineur(String numeroContaineur) {
        this.numeroContaineur = numeroContaineur;
    }

    public String getNumeroPlombs() {
        return numeroPlombs;
    }

    public void setNumeroPlombs(String numeroPlombs) {
        this.numeroPlombs = numeroPlombs;
    }

    public TypeContainer getTypeContainer() {
        return typeContainer;
    }

    public void setTypeContainer(TypeContainer typeContainer) {
        this.typeContainer = typeContainer;
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
        if (!(object instanceof Container)) {
            return false;
        }
        Container other = (Container) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Container[ id=" + id + " ]";
    }
    
}
