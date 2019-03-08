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
@Table(name = "fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f")
    , @NamedQuery(name = "Fournisseur.findById", query = "SELECT f FROM Fournisseur f WHERE f.id = :id")
    , @NamedQuery(name = "Fournisseur.findByCodeFournisseur", query = "SELECT f FROM Fournisseur f WHERE f.codeFournisseur = :codeFournisseur")
    , @NamedQuery(name = "Fournisseur.findByNomFournisseur", query = "SELECT f FROM Fournisseur f WHERE f.nomFournisseur = :nomFournisseur")
    , @NamedQuery(name = "Fournisseur.findByPrenomFournisseur", query = "SELECT f FROM Fournisseur f WHERE f.prenomFournisseur = :prenomFournisseur")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_FOURNISSEUR")
    private String codeFournisseur;
    @Basic(optional = false)
    @Column(name = "NOM_FOURNISSEUR")
    private String nomFournisseur;
    @Basic(optional = false)
    @Column(name = "PRENOM_FOURNISSEUR")
    private String prenomFournisseur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fournisseur")
    @JsonIgnore
    private List<Debarquement> debarquementList;

    public Fournisseur() {
    }

    public Fournisseur(Integer id) {
        this.id = id;
    }

    public Fournisseur(Integer id, String codeFournisseur, String nomFournisseur, String prenomFournisseur) {
        this.id = id;
        this.codeFournisseur = codeFournisseur;
        this.nomFournisseur = nomFournisseur;
        this.prenomFournisseur = prenomFournisseur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeFournisseur() {
        return codeFournisseur;
    }

    public void setCodeFournisseur(String codeFournisseur) {
        this.codeFournisseur = codeFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getPrenomFournisseur() {
        return prenomFournisseur;
    }

    public void setPrenomFournisseur(String prenomFournisseur) {
        this.prenomFournisseur = prenomFournisseur;
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
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Fournisseur[ id=" + id + " ]";
    }
    
}
