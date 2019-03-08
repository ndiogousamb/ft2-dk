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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "espece_demoulee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspeceDemoulee.findAll", query = "SELECT e FROM EspeceDemoulee e")
    , @NamedQuery(name = "EspeceDemoulee.findById", query = "SELECT e FROM EspeceDemoulee e WHERE e.id = :id")
    , @NamedQuery(name = "EspeceDemoulee.findByCodeEspecedemoulee", query = "SELECT e FROM EspeceDemoulee e WHERE e.codeEspecedemoulee = :codeEspecedemoulee")
    , @NamedQuery(name = "EspeceDemoulee.findByPoids", query = "SELECT e FROM EspeceDemoulee e WHERE e.poids = :poids")
    , @NamedQuery(name = "EspeceDemoulee.findByAfficher", query = "SELECT e FROM EspeceDemoulee e WHERE e.afficher = :afficher")
    , @NamedQuery(name = "EspeceDemoulee.findByPrixUnitaire", query = "SELECT e FROM EspeceDemoulee e WHERE e.prixUnitaire = :prixUnitaire")
    , @NamedQuery(name = "EspeceDemoulee.findByMontant", query = "SELECT e FROM EspeceDemoulee e WHERE e.montant = :montant")
    , @NamedQuery(name = "EspeceDemoulee.findByRegle", query = "SELECT e FROM EspeceDemoulee e WHERE e.regle = :regle")
    , @NamedQuery(name = "EspeceDemoulee.findByNombre", query = "SELECT e FROM EspeceDemoulee e WHERE e.nombre = :nombre")})
public class EspeceDemoulee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_ESPECEDEMOULEE")
    private String codeEspecedemoulee;
    @Basic(optional = false)
    @Column(name = "POIDS")
    private float poids;
    @Column(name = "AFFICHER")
    private Integer afficher;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRIX_UNITAIRE")
    private Float prixUnitaire;
    @Column(name = "MONTANT")
    private Float montant;
    @Basic(optional = false)
    @Column(name = "REGLE")
    private int regle;
    @Column(name = "NOMBRE")
    private Float nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especeDemoulee")
    @JsonIgnore
    private List<EscepeDemouleeAchetee> escepeDemouleeAcheteeList;
    @JoinColumn(name = "GROS_POISSON", referencedColumnName = "Id")
    @ManyToOne
    private CalibreGP grosPoisson;
    @JoinColumn(name = "UTILISATEUR_FACTURATION", referencedColumnName = "Id")
    @ManyToOne
    private Utilisateur utilisateurFacturation;
    @JoinColumn(name = "QUALITE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Qualite qualite;
    @JoinColumn(name = "ESPECE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Espece espece;
    @JoinColumn(name = "PRODUCTION", referencedColumnName = "Id")
    @ManyToOne
    private Production production;
    @JoinColumn(name = "CALIBRE", referencedColumnName = "Id")
    @ManyToOne
    private Calibre calibre;
    @JoinColumn(name = "TYPE_CARTON", referencedColumnName = "Id")
    @ManyToOne
    private TypeCarton typeCarton;
    @JoinColumn(name = "UTILISATEUR", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @JoinColumn(name = "DEBARQUEMENT", referencedColumnName = "Id")
    @ManyToOne
    private Debarquement debarquement;

    public EspeceDemoulee() {
    }

    public EspeceDemoulee(Integer id) {
        this.id = id;
    }

    public EspeceDemoulee(Integer id, String codeEspecedemoulee, float poids, int regle) {
        this.id = id;
        this.codeEspecedemoulee = codeEspecedemoulee;
        this.poids = poids;
        this.regle = regle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeEspecedemoulee() {
        return codeEspecedemoulee;
    }

    public void setCodeEspecedemoulee(String codeEspecedemoulee) {
        this.codeEspecedemoulee = codeEspecedemoulee;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public Integer getAfficher() {
        return afficher;
    }

    public void setAfficher(Integer afficher) {
        this.afficher = afficher;
    }

    public Float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public int getRegle() {
        return regle;
    }

    public void setRegle(int regle) {
        this.regle = regle;
    }

    public Float getNombre() {
        return nombre;
    }

    public void setNombre(Float nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<EscepeDemouleeAchetee> getEscepeDemouleeAcheteeList() {
        return escepeDemouleeAcheteeList;
    }

    public void setEscepeDemouleeAcheteeList(List<EscepeDemouleeAchetee> escepeDemouleeAcheteeList) {
        this.escepeDemouleeAcheteeList = escepeDemouleeAcheteeList;
    }

    public CalibreGP getGrosPoisson() {
        return grosPoisson;
    }

    public void setGrosPoisson(CalibreGP grosPoisson) {
        this.grosPoisson = grosPoisson;
    }

    public Utilisateur getUtilisateurFacturation() {
        return utilisateurFacturation;
    }

    public void setUtilisateurFacturation(Utilisateur utilisateurFacturation) {
        this.utilisateurFacturation = utilisateurFacturation;
    }

    public Qualite getQualite() {
        return qualite;
    }

    public void setQualite(Qualite qualite) {
        this.qualite = qualite;
    }

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Calibre getCalibre() {
        return calibre;
    }

    public void setCalibre(Calibre calibre) {
        this.calibre = calibre;
    }

    public TypeCarton getTypeCarton() {
        return typeCarton;
    }

    public void setTypeCarton(TypeCarton typeCarton) {
        this.typeCarton = typeCarton;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Debarquement getDebarquement() {
        return debarquement;
    }

    public void setDebarquement(Debarquement debarquement) {
        this.debarquement = debarquement;
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
        if (!(object instanceof EspeceDemoulee)) {
            return false;
        }
        EspeceDemoulee other = (EspeceDemoulee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.EspeceDemoulee[ id=" + id + " ]";
    }
    
}
