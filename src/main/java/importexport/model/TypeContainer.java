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
@Table(name = "type_container")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeContainer.findAll", query = "SELECT t FROM TypeContainer t")
    , @NamedQuery(name = "TypeContainer.findById", query = "SELECT t FROM TypeContainer t WHERE t.id = :id")
    , @NamedQuery(name = "TypeContainer.findByNomTyepcontainer", query = "SELECT t FROM TypeContainer t WHERE t.nomTyepcontainer = :nomTyepcontainer")})
public class TypeContainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOM_TYEPCONTAINER")
    private String nomTyepcontainer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeContainer")
    @JsonIgnore
    private List<Container> containerList;

    public TypeContainer() {
    }

    public TypeContainer(Integer id) {
        this.id = id;
    }

    public TypeContainer(Integer id, String nomTyepcontainer) {
        this.id = id;
        this.nomTyepcontainer = nomTyepcontainer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomTyepcontainer() {
        return nomTyepcontainer;
    }

    public void setNomTyepcontainer(String nomTyepcontainer) {
        this.nomTyepcontainer = nomTyepcontainer;
    }

    @XmlTransient
    public List<Container> getContainerList() {
        return containerList;
    }

    public void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
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
        if (!(object instanceof TypeContainer)) {
            return false;
        }
        TypeContainer other = (TypeContainer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.TypeContainer[ id=" + id + " ]";
    }
    
}
