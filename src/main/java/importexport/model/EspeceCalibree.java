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
import javax.persistence.FetchType;
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
@Table(name = "espece_calibree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspeceCalibree.findAll", query = "SELECT e FROM EspeceCalibree e")
    , @NamedQuery(name = "EspeceCalibree.findById", query = "SELECT e FROM EspeceCalibree e WHERE e.id = :id")
    , @NamedQuery(name = "EspeceCalibree.findByCodeEspececalibree", query = "SELECT e FROM EspeceCalibree e WHERE e.codeEspececalibree = :codeEspececalibree")
    , @NamedQuery(name = "EspeceCalibree.findByPrix", query = "SELECT e FROM EspeceCalibree e WHERE e.prix = :prix")})
public class EspeceCalibree implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODE_ESPECECALIBREE")
    private String codeEspececalibree;
    @Basic(optional = false)
    @Column(name = "PRIX")
    private float prix;
    @JoinColumn(name = "ESPECE", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Espece espece;
    @JoinColumn(name = "CALIBRE", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Calibre calibre;

    public EspeceCalibree() {
    }

    public EspeceCalibree(Integer id) {
        this.id = id;
    }

    public EspeceCalibree(Integer id, String codeEspececalibree, float prix) {
        this.id = id;
        this.codeEspececalibree = codeEspececalibree;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeEspececalibree() {
        return codeEspececalibree;
    }

    public void setCodeEspececalibree(String codeEspececalibree) {
        this.codeEspececalibree = codeEspececalibree;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public Calibre getCalibre() {
        return calibre;
    }

    public void setCalibre(Calibre calibre) {
        this.calibre = calibre;
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
        if (!(object instanceof EspeceCalibree)) {
            return false;
        }
        EspeceCalibree other = (EspeceCalibree) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.EspeceCalibree[ id=" + id + " ]";
    }
    
}
