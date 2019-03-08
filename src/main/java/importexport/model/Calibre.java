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
@Table(name = "calibre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calibre.findAll", query = "SELECT c FROM Calibre c")
    , @NamedQuery(name = "Calibre.findById", query = "SELECT c FROM Calibre c WHERE c.id = :id")
    , @NamedQuery(name = "Calibre.findByCodeCalibre", query = "SELECT c FROM Calibre c WHERE c.codeCalibre = :codeCalibre")
    , @NamedQuery(name = "Calibre.findByLibelleCalibre", query = "SELECT c FROM Calibre c WHERE c.libelleCalibre = :libelleCalibre")})
public class Calibre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_CALIBRE")
    private String codeCalibre;
    @Basic(optional = false)
    @Column(name = "LIBELLE_CALIBRE")
    private String libelleCalibre;
    @OneToMany(mappedBy = "calibre")
    @JsonIgnore
    private List<EspeceDemoulee> especeDemouleeList;

    public Calibre() {
    }

    public Calibre(Integer id) {
        this.id = id;
    }

    public Calibre(Integer id, String codeCalibre, String libelleCalibre) {
        this.id = id;
        this.codeCalibre = codeCalibre;
        this.libelleCalibre = libelleCalibre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeCalibre() {
        return codeCalibre;
    }

    public void setCodeCalibre(String codeCalibre) {
        this.codeCalibre = codeCalibre;
    }

    public String getLibelleCalibre() {
        return libelleCalibre;
    }

    public void setLibelleCalibre(String libelleCalibre) {
        this.libelleCalibre = libelleCalibre;
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
        if (!(object instanceof Calibre)) {
            return false;
        }
        Calibre other = (Calibre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Calibre[ id=" + id + " ]";
    }
    
}
