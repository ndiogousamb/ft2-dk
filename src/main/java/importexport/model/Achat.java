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
@Table(name = "achat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Achat.findAll", query = "SELECT a FROM Achat a")
    , @NamedQuery(name = "Achat.findById", query = "SELECT a FROM Achat a WHERE a.id = :id")
    , @NamedQuery(name = "Achat.findByCodeAchat", query = "SELECT a FROM Achat a WHERE a.codeAchat = :codeAchat")
    , @NamedQuery(name = "Achat.findByDateAchat", query = "SELECT a FROM Achat a WHERE a.dateAchat = :dateAchat")
    , @NamedQuery(name = "Achat.findByMontantAchat", query = "SELECT a FROM Achat a WHERE a.montantAchat = :montantAchat")
    , @NamedQuery(name = "Achat.findByRestantAPayer", query = "SELECT a FROM Achat a WHERE a.restantAPayer = :restantAPayer")
    , @NamedQuery(name = "Achat.findByRegle", query = "SELECT a FROM Achat a WHERE a.regle = :regle")
    , @NamedQuery(name = "Achat.findByCodeFacture", query = "SELECT a FROM Achat a WHERE a.codeFacture = :codeFacture")
    , @NamedQuery(name = "Achat.findByMontantEnLettre", query = "SELECT a FROM Achat a WHERE a.montantEnLettre = :montantEnLettre")})
public class Achat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_ACHAT")
    private String codeAchat;
    @Basic(optional = false)
    @Column(name = "DATE_ACHAT")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT_ACHAT")
    private Float montantAchat;
    @Column(name = "RESTANT_A_PAYER")
    private Float restantAPayer;
    @Basic(optional = false)
    @Column(name = "REGLE")
    private int regle;
    @Column(name = "CODE_FACTURE")
    private String codeFacture;
    @Column(name = "MONTANT_EN_LETTRE")
    private String montantEnLettre;
    @JoinColumn(name = "CLIENT", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "UTILISATEUR", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @JoinColumn(name = "UTILISATEUR_FACTURATION", referencedColumnName = "Id")
    @ManyToOne
    private Utilisateur utilisateurFacturation;

    public Achat() {
    }

    public Achat(Integer id) {
        this.id = id;
    }

    public Achat(Integer id, String codeAchat, Date dateAchat, int regle) {
        this.id = id;
        this.codeAchat = codeAchat;
        this.dateAchat = dateAchat;
        this.regle = regle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeAchat() {
        return codeAchat;
    }

    public void setCodeAchat(String codeAchat) {
        this.codeAchat = codeAchat;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Float getMontantAchat() {
        return montantAchat;
    }

    public void setMontantAchat(Float montantAchat) {
        this.montantAchat = montantAchat;
    }

    public Float getRestantAPayer() {
        return restantAPayer;
    }

    public void setRestantAPayer(Float restantAPayer) {
        this.restantAPayer = restantAPayer;
    }

    public int getRegle() {
        return regle;
    }

    public void setRegle(int regle) {
        this.regle = regle;
    }

    public String getCodeFacture() {
        return codeFacture;
    }

    public void setCodeFacture(String codeFacture) {
        this.codeFacture = codeFacture;
    }

    public String getMontantEnLettre() {
        return montantEnLettre;
    }

    public void setMontantEnLettre(String montantEnLettre) {
        this.montantEnLettre = montantEnLettre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achat)) {
            return false;
        }
        Achat other = (Achat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Achat[ id=" + id + " ]";
    }
    
}
