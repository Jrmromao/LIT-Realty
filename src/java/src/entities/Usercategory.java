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
@Table(name = "usercategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usercategory.findAll", query = "SELECT u FROM Usercategory u"),
    @NamedQuery(name = "Usercategory.findByCategoryID", query = "SELECT u FROM Usercategory u WHERE u.categoryID = :categoryID"),
    @NamedQuery(name = "Usercategory.findByCategory", query = "SELECT u FROM Usercategory u WHERE u.category = :category")})
public class Usercategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "categoryID")
    private Integer categoryID;
    @Column(name = "category")
    private String category;

    public Usercategory() {
    }

    public Usercategory(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryID != null ? categoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usercategory)) {
            return false;
        }
        Usercategory other = (Usercategory) object;
        if ((this.categoryID == null && other.categoryID != null) || (this.categoryID != null && !this.categoryID.equals(other.categoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.db.Usercategory[ categoryID=" + categoryID + " ]";
    }
    
}
