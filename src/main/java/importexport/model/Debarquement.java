/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importexport.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Ndiogou Samb
 */
@Entity
@Table(name = "debarquement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Debarquement.findAll", query = "SELECT d FROM Debarquement d")
    , @NamedQuery(name = "Debarquement.findById", query = "SELECT d FROM Debarquement d WHERE d.id = :id")
    , @NamedQuery(name = "Debarquement.findByCodeDebarquement", query = "SELECT d FROM Debarquement d WHERE d.codeDebarquement = :codeDebarquement")
    , @NamedQuery(name = "Debarquement.findByDateDebarquement", query = "SELECT d FROM Debarquement d WHERE d.dateDebarquement = :dateDebarquement")
    , @NamedQuery(name = "Debarquement.findByNumeroManifeste", query = "SELECT d FROM Debarquement d WHERE d.numeroManifeste = :numeroManifeste")
    , @NamedQuery(name = "Debarquement.findByRegle", query = "SELECT d FROM Debarquement d WHERE d.regle = :regle")
    , @NamedQuery(name = "Debarquement.findByMontant", query = "SELECT d FROM Debarquement d WHERE d.montant = :montant")})
public class Debarquement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_DEBARQUEMENT")
    private String codeDebarquement;
    @Basic(optional = false)
    @Column(name = "DATE_DEBARQUEMENT")
    @Temporal(TemporalType.DATE)
    private Date dateDebarquement;
    @Basic(optional = false)
    @Column(name = "NUMERO_MANIFESTE")
    private String numeroManifeste;
    @Basic(optional = false)
    @Column(name = "REGLE")
    private int regle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT")
    private Float montant;
    @JoinColumn(name = "NAVIRE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Navire navire;
    @JoinColumn(name = "FOURNISSEUR", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Fournisseur fournisseur;
    @JoinColumn(name = "UTILISATEUR", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @JoinColumn(name = "UTILISATEUR_FACTURATION", referencedColumnName = "Id")
    @ManyToOne
    private Utilisateur utilisateurFacturation;
    @OneToMany(mappedBy = "debarquement")
    @JsonIgnore
    private List<EspeceDemoulee> especeDemouleeList;

    public Debarquement() {
    }

    public Debarquement(Integer id) {
        this.id = id;
    }

    public Debarquement(Integer id, String codeDebarquement, Date dateDebarquement, String numeroManifeste, int regle) {
        this.id = id;
        this.codeDebarquement = codeDebarquement;
        this.dateDebarquement = dateDebarquement;
        this.numeroManifeste = numeroManifeste;
        this.regle = regle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeDebarquement() {
        return codeDebarquement;
    }

    public void setCodeDebarquement(String codeDebarquement) {
        this.codeDebarquement = codeDebarquement;
    }

    public Date getDateDebarquement() {
        return dateDebarquement;
    }

    public void setDateDebarquement(Date dateDebarquement) {
        this.dateDebarquement = dateDebarquement;
    }

    public String getNumeroManifeste() {
        return numeroManifeste;
    }

    public void setNumeroManifeste(String numeroManifeste) {
        this.numeroManifeste = numeroManifeste;
    }

    public int getRegle() {
        return regle;
    }

    public void setRegle(int regle) {
        this.regle = regle;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Navire getNavire() {
        return navire;
    }

    public void setNavire(Navire navire) {
        this.navire = navire;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateurFacturation() {
        return utilisateurFacturation;
    }

    public void setUtilisateurFacturation(Utilisateur utilisateurFacturation) {
        this.utilisateurFacturation = utilisateurFacturation;
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
        if (!(object instanceof Debarquement)) {
            return false;
        }
        Debarquement other = (Debarquement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Debarquement[ id=" + id + " ]";
    }
    
}
