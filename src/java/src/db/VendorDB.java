/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import src.entities.Properties;
import src.entities.User;
import src.entities.Vendor;

/**
 *
 * @author jrmromao
 */
public class VendorDB {

    public static Vendor getVendorById(int vendorId) {

        EntityManager em = null;
        Vendor v = null;

        try {
            em = DBUtil.getEmf().createEntityManager();
            v = em.find(Vendor.class, vendorId);

        } catch (Exception e) {
            System.err.println("Get prop details ERROR: " + e.getMessage());
        } finally {
            em.close();
        }
        return v;
    }// end get details

        
    
    
    public static List<Vendor> getAllVendors() {

          List<Vendor> vendorList = null;
        EntityManager em = null;
      
        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Vendor> tq = em.createNamedQuery("Vendor.findAll", Vendor.class); // call the name query in the
            vendorList = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get All Agents ERROR: " + e.getMessage());
        } finally {
            em.close();
        }

        return vendorList;

    }// end get all vendord

    
    
    
    
    public static boolean addVendor(Vendor v) {
        EntityManager em = null;
        try {

            em = DBUtil.getEmf().createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(v);
            t.commit();
            return true;

        } catch (Exception e) {
            System.err.println("add vendor  ERROR: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }

    } //end add vendor
    
    
        public static boolean deleteVendor(Vendor v) {

        EntityManager em = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.remove(em.merge(v)); //delete object
            t.commit();
            return true;

        } catch (Exception e) {
            System.err.println("delete vendor ERROR: " + e.getMessage());
            //  trabs.rollback();
            return false;
        } finally {
            em.close();
        }

    }// end delete vendor
    
    
    
    
    
           
    public static boolean updateVendor(Vendor v) {

        EntityManager em = null;
 

        try {

            em = DBUtil.getEmf().createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.merge(v); //a diference para o method the adicionar    
            t.commit();
            return true;

        } catch (Exception e) {
            System.err.println("update vendor ERROR: " + e.getMessage());
            //  trabs.rollback();
            return false;
        } finally {
            em.close();
        }
        }// end update vendor
    
    
    
    
    
    
    
    
}
