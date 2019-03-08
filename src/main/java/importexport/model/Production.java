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
@Table(name = "production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Production.findAll", query = "SELECT p FROM Production p")
    , @NamedQuery(name = "Production.findById", query = "SELECT p FROM Production p WHERE p.id = :id")
    , @NamedQuery(name = "Production.findByCodeProduction", query = "SELECT p FROM Production p WHERE p.codeProduction = :codeProduction")
    , @NamedQuery(name = "Production.findByDateDebut", query = "SELECT p FROM Production p WHERE p.dateDebut = :dateDebut")
    , @NamedQuery(name = "Production.findByDateFin", query = "SELECT p FROM Production p WHERE p.dateFin = :dateFin")
    , @NamedQuery(name = "Production.findByMontantProduction", query = "SELECT p FROM Production p WHERE p.montantProduction = :montantProduction")
    , @NamedQuery(name = "Production.findByRegle", query = "SELECT p FROM Production p WHERE p.regle = :regle")
    , @NamedQuery(name = "Production.findByDemoule", query = "SELECT p FROM Production p WHERE p.demoule = :demoule")
    , @NamedQuery(name = "Production.findByMontantEnLettre", query = "SELECT p FROM Production p WHERE p.montantEnLettre = :montantEnLettre")
    , @NamedQuery(name = "Production.findByCodeFacture", query = "SELECT p FROM Production p WHERE p.codeFacture = :codeFacture")})
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_PRODUCTION")
    private String codeProduction;
    @Basic(optional = false)
    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Basic(optional = false)
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "Montant_Production")
    private Integer montantProduction;
    @Basic(optional = false)
    @Column(name = "REGLE")
    private int regle;
    @Basic(optional = false)
    @Column(name = "DEMOULE")
    private int demoule;
    @Column(name = "MONTANT_EN_LETTRE")
    private String montantEnLettre;
    @Column(name = "CODE_FACTURE")
    private String codeFacture;
    @JoinColumn(name = "MARAYEUR", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Marayeur marayeur;
    @JoinColumn(name = "TUNNEL", referencedColumnName = "Id")
    @ManyToOne
    private Tunnel tunnel;
    @JoinColumn(name = "VEHICULE", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Vehicule vehicule;
    @JoinColumn(name = "UTILISATEUR", referencedColumnName = "Id")
    @ManyToOne
    private Utilisateur utilisateur;

    public Production() {
    }

    public Production(Integer id) {
        this.id = id;
    }

    public Production(Integer id, String codeProduction, Date dateDebut, Date dateFin, int regle, int demoule) {
        this.id = id;
        this.codeProduction = codeProduction;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.regle = regle;
        this.demoule = demoule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeProduction() {
        return codeProduction;
    }

    public void setCodeProduction(String codeProduction) {
        this.codeProduction = codeProduction;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getMontantProduction() {
        return montantProduction;
    }

    public void setMontantProduction(Integer montantProduction) {
        this.montantProduction = montantProduction;
    }

    public int getRegle() {
        return regle;
    }

    public void setRegle(int regle) {
        this.regle = regle;
    }

    public int getDemoule() {
        return demoule;
    }

    public void setDemoule(int demoule) {
        this.demoule = demoule;
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

    public Marayeur getMarayeur() {
        return marayeur;
    }

    public void setMarayeur(Marayeur marayeur) {
        this.marayeur = marayeur;
    }

    public Tunnel getTunnel() {
        return tunnel;
    }

    public void setTunnel(Tunnel tunnel) {
        this.tunnel = tunnel;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
        if (!(object instanceof Production)) {
            return false;
        }
        Production other = (Production) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Production[ id=" + id + " ]";
    }
    
}
