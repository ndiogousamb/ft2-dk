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
@Table(name = "marayeur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marayeur.findAll", query = "SELECT m FROM Marayeur m")
    , @NamedQuery(name = "Marayeur.findById", query = "SELECT m FROM Marayeur m WHERE m.id = :id")
    , @NamedQuery(name = "Marayeur.findByCodeMarayeur", query = "SELECT m FROM Marayeur m WHERE m.codeMarayeur = :codeMarayeur")
    , @NamedQuery(name = "Marayeur.findByCinMarayeur", query = "SELECT m FROM Marayeur m WHERE m.cinMarayeur = :cinMarayeur")
    , @NamedQuery(name = "Marayeur.findByNomMarayeur", query = "SELECT m FROM Marayeur m WHERE m.nomMarayeur = :nomMarayeur")
    , @NamedQuery(name = "Marayeur.findByPrenomMarayeur", query = "SELECT m FROM Marayeur m WHERE m.prenomMarayeur = :prenomMarayeur")})
public class Marayeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_MARAYEUR")
    private String codeMarayeur;
    @Basic(optional = false)
    @Column(name = "CIN_MARAYEUR")
    private String cinMarayeur;
    @Basic(optional = false)
    @Column(name = "NOM_MARAYEUR")
    private String nomMarayeur;
    @Basic(optional = false)
    @Column(name = "PRENOM_MARAYEUR")
    private String prenomMarayeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marayeur")
    @JsonIgnore
    private List<Production> productionList;

    public Marayeur() {
    }

    public Marayeur(Integer id) {
        this.id = id;
    }

    public Marayeur(Integer id, String codeMarayeur, String cinMarayeur, String nomMarayeur, String prenomMarayeur) {
        this.id = id;
        this.codeMarayeur = codeMarayeur;
        this.cinMarayeur = cinMarayeur;
        this.nomMarayeur = nomMarayeur;
        this.prenomMarayeur = prenomMarayeur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeMarayeur() {
        return codeMarayeur;
    }

    public void setCodeMarayeur(String codeMarayeur) {
        this.codeMarayeur = codeMarayeur;
    }

    public String getCinMarayeur() {
        return cinMarayeur;
    }

    public void setCinMarayeur(String cinMarayeur) {
        this.cinMarayeur = cinMarayeur;
    }

    public String getNomMarayeur() {
        return nomMarayeur;
    }

    public void setNomMarayeur(String nomMarayeur) {
        this.nomMarayeur = nomMarayeur;
    }

    public String getPrenomMarayeur() {
        return prenomMarayeur;
    }

    public void setPrenomMarayeur(String prenomMarayeur) {
        this.prenomMarayeur = prenomMarayeur;
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
        if (!(object instanceof Marayeur)) {
            return false;
        }
        Marayeur other = (Marayeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Marayeur[ id=" + id + " ]";
    }
    
}
