/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importexport.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ndiogou Samb
 */
@Entity
@Table(name = "exportation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exportation.findAll", query = "SELECT e FROM Exportation e")
    , @NamedQuery(name = "Exportation.findById", query = "SELECT e FROM Exportation e WHERE e.id = :id")
    , @NamedQuery(name = "Exportation.findByCodeExportation", query = "SELECT e FROM Exportation e WHERE e.codeExportation = :codeExportation")
    , @NamedQuery(name = "Exportation.findByDateExportation", query = "SELECT e FROM Exportation e WHERE e.dateExportation = :dateExportation")
    , @NamedQuery(name = "Exportation.findByMontantExportation", query = "SELECT e FROM Exportation e WHERE e.montantExportation = :montantExportation")
    , @NamedQuery(name = "Exportation.findByRegle", query = "SELECT e FROM Exportation e WHERE e.regle = :regle")
    , @NamedQuery(name = "Exportation.findByMontantEnLettre", query = "SELECT e FROM Exportation e WHERE e.montantEnLettre = :montantEnLettre")
    , @NamedQuery(name = "Exportation.findByCodeFacture", query = "SELECT e FROM Exportation e WHERE e.codeFacture = :codeFacture")})
public class Exportation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_EXPORTATION")
    private String codeExportation;
    @Basic(optional = false)
    @Column(name = "DATE_EXPORTATION")
    @Temporal(TemporalType.DATE)
    private Date dateExportation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT_EXPORTATION")
    private Float montantExportation;
    @Basic(optional = false)
    @Column(name = "REGLE")
    private int regle;
    @Column(name = "MONTANT_EN_LETTRE")
    private String montantEnLettre;
    @Column(name = "CODE_FACTURE")
    private String codeFacture;
    @JoinColumn(name = "CHARGEUR", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Chargeur chargeur;
    @JoinColumn(name = "ORIGINE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Origine origine;
    @JoinColumn(name = "UTILISATEUR", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @JoinColumn(name = "UTILISATEUR_FACTURATION", referencedColumnName = "Id")
    @ManyToOne
    private Utilisateur utilisateurFacturation;
    @JoinColumn(name = "DESTINATAIRE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Destinataire destinataire;
    @JoinColumn(name = "PAYS", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Pays pays;

    public Exportation() {
    }

    public Exportation(Integer id) {
        this.id = id;
    }

    public Exportation(Integer id, String codeExportation, Date dateExportation, int regle) {
        this.id = id;
        this.codeExportation = codeExportation;
        this.dateExportation = dateExportation;
        this.regle = regle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeExportation() {
        return codeExportation;
    }

    public void setCodeExportation(String codeExportation) {
        this.codeExportation = codeExportation;
    }

    public Date getDateExportation() {
        return dateExportation;
    }

    public void setDateExportation(Date dateExportation) {
        this.dateExportation = dateExportation;
    }

    public Float getMontantExportation() {
        return montantExportation;
    }

    public void setMontantExportation(Float montantExportation) {
        this.montantExportation = montantExportation;
    }

    public int getRegle() {
        return regle;
    }

    public void setRegle(int regle) {
        this.regle = regle;
    }

    public String getMontantEnLettre() {
        return montantEnLettre;
    }

    public void setMontantEnLettre(String montantEnLettre) {
        this.montantEnLettre = montantEnLettre;
    }

    public String getCodeFacture() {
        return codeFacture;
    }

    public void setCodeFacture(String codeFacture) {
        this.codeFacture = codeFacture;
    }

    public Chargeur getChargeur() {
        return chargeur;
    }

    public void setChargeur(Chargeur chargeur) {
        this.chargeur = chargeur;
    }

    public Origine getOrigine() {
        return origine;
    }

    public void setOrigine(Origine origine) {
        this.origine = origine;
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

    public Destinataire getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Destinataire destinataire) {
        this.destinataire = destinataire;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
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
        if (!(object instanceof Exportation)) {
            return false;
        }
        Exportation other = (Exportation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Exportation[ id=" + id + " ]";
    }
    
}
