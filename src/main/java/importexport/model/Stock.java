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
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findById", query = "SELECT s FROM Stock s WHERE s.id = :id")
    , @NamedQuery(name = "Stock.findBySoldeStock", query = "SELECT s FROM Stock s WHERE s.soldeStock = :soldeStock")
    , @NamedQuery(name = "Stock.findBySoldeAvant", query = "SELECT s FROM Stock s WHERE s.soldeAvant = :soldeAvant")
    , @NamedQuery(name = "Stock.findByNombre", query = "SELECT s FROM Stock s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Stock.findByDate", query = "SELECT s FROM Stock s WHERE s.date = :date")
    , @NamedQuery(name = "Stock.findByAfficher", query = "SELECT s FROM Stock s WHERE s.afficher = :afficher")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "SOLDE_STOCK")
    private float soldeStock;
    @Basic(optional = false)
    @Column(name = "SOLDE_AVANT")
    private float soldeAvant;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private float nombre;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "AFFICHER")
    private int afficher;
    @JoinColumn(name = "ESPECE_DEMOULEE", referencedColumnName = "Id")
    @ManyToOne
    private EspeceDemoulee especeDemoulee;

    public Stock() {
    }

    public Stock(Integer id) {
        this.id = id;
    }

    public Stock(Integer id, float soldeStock, float soldeAvant, float nombre, Date date, int afficher) {
        this.id = id;
        this.soldeStock = soldeStock;
        this.soldeAvant = soldeAvant;
        this.nombre = nombre;
        this.date = date;
        this.afficher = afficher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getSoldeStock() {
        return soldeStock;
    }

    public void setSoldeStock(float soldeStock) {
        this.soldeStock = soldeStock;
    }

    public float getSoldeAvant() {
        return soldeAvant;
    }

    public void setSoldeAvant(float soldeAvant) {
        this.soldeAvant = soldeAvant;
    }

    public float getNombre() {
        return nombre;
    }

    public void setNombre(float nombre) {
        this.nombre = nombre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAfficher() {
        return afficher;
    }

    public void setAfficher(int afficher) {
        this.afficher = afficher;
    }

    public EspeceDemoulee getEspeceDemoulee() {
        return especeDemoulee;
    }

    public void setEspeceDemoulee(EspeceDemoulee especeDemoulee) {
        this.especeDemoulee = especeDemoulee;
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
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "importexport.model.Stock[ id=" + id + " ]";
    }
    
}
