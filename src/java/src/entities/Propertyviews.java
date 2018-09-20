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
 *  @NamedQuery(name = "Propertyviews.addView" query = "UPDATE Country c SET c.population = c.population * 11 / 10"),
 * @author jrmromao
 */
@Entity
@Table(name = "propertyviews")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propertyviews.findAll", query = "SELECT p FROM Propertyviews p"),
    @NamedQuery(name = "Propertyviews.findByViewID", query = "SELECT p FROM Propertyviews p WHERE p.viewID = :viewID AND p.userIP = :userIP"),
    @NamedQuery(name = "Propertyviews.findByPropID", query = "SELECT p FROM Propertyviews p WHERE p.propID = :propID"),
    @NamedQuery(name = "Propertyviews.findByNumViews", query = "SELECT p FROM Propertyviews p WHERE p.numViews = :numViews"),
    @NamedQuery(name = "Propertyviews.findByUserIP", query = "SELECT p FROM Propertyviews p WHERE p.userIP = :userIP")})
public class Propertyviews implements Serializable {

    @Basic(optional = false)
    @Column(name = "userIP")
    private String userIP;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "viewID")
    private Integer viewID;
    @Basic(optional = false)
    @Column(name = "propID")
    private int propID;
    @Basic(optional = false)
    @Column(name = "numViews")
    private int numViews;

    public Propertyviews() {
    }

    public Propertyviews(Integer viewID) {
        this.viewID = viewID;
    }

    public Propertyviews(Integer viewID, int propID, int numViews, String userIP) {
        this.viewID = viewID;
        this.propID = propID;
        this.numViews = numViews;
        this.userIP = userIP;
    }

    public Integer getViewID() {
        return viewID;
    }

    public void setViewID(Integer viewID) {
        this.viewID = viewID;
    }

    public int getPropID() {
        return propID;
    }

    public void setPropID(int propID) {
        this.propID = propID;
    }

    public int getNumViews() {
        return numViews;
    }

    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viewID != null ? viewID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertyviews)) {
            return false;
        }
        Propertyviews other = (Propertyviews) object;
        if ((this.viewID == null && other.viewID != null) || (this.viewID != null && !this.viewID.equals(other.viewID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Propertyviews[ viewID=" + viewID + " ]";
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }
    
}
