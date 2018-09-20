/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jrmromao
 */
@Entity
@Table(name = "favorites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favorites.findAll", query = "SELECT f FROM Favorites f"),
    @NamedQuery(name = "Favorites.findByFavID", query = "SELECT f FROM Favorites f WHERE f.favID = :favID"),
    @NamedQuery(name = "Favorites.findByUserID", query = "SELECT f FROM Favorites f WHERE f.userID = :userID"),
    @NamedQuery(name = "Favorites.findByPropID", query = "SELECT f FROM Favorites f WHERE f.propID = :propID")})
public class Favorites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "favID")
    private Integer favID;
    @Basic(optional = false)
    @Column(name = "userID")
    private int userID;
    @Basic(optional = false)
    @Column(name = "propID")
    private int propID;

    public Favorites() {
    }

    public Favorites(Integer favID) {
        this.favID = favID;
    }

    public Favorites(Integer favID, int userID, int propID) {
        this.favID = favID;
        this.userID = userID;
        this.propID = propID;
    }

    public Integer getFavID() {
        return favID;
    }

    public void setFavID(Integer favID) {
        this.favID = favID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPropID() {
        return propID;
    }

    public void setPropID(int propID) {
        this.propID = propID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favID != null ? favID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favorites)) {
            return false;
        }
        Favorites other = (Favorites) object;
        if ((this.favID == null && other.favID != null) || (this.favID != null && !this.favID.equals(other.favID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Favorites[ favID=" + favID + " ]";
    }
    
}
