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
import src.entities.Propertyviews;
import src.entities.User;

/**
 *
 * @author jrmromao
 */
public class PropertyviewsDB {

    public static List<Propertyviews> getAllView() {

        List<Propertyviews> vList = null;
        EntityManager em = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Propertyviews> tq = em.createNamedQuery("Propertyviews.findAll", Propertyviews.class); // call the name query in the
            vList = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get All Agents ERROR: " + e.getMessage());
        } finally {
            em.close();
        }

        return vList;
    }//end get all views

    public static List<Propertyviews> getViewByPropID(int propID) {

        EntityManager em = null;
        List<Propertyviews> totalList = null;

        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Propertyviews> tq = em.createNamedQuery("Propertyviews.findByPropID", Propertyviews.class);
            tq.setParameter("propID", propID);
            totalList = tq.getResultList();

        } catch (Exception e) {
            System.err.println("updateView ERROR: " + e.getMessage());

        } finally {
            em.close();
        }

        return totalList;

    }//end get View By PropID

    public static Propertyviews hasView(int propID, String iPAddress) {

        EntityManager em = null;

        Propertyviews pv = null;
        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Propertyviews> tq = em.createNamedQuery("Propertyviews.findByPropID", Propertyviews.class);
            tq.setParameter("propID", propID);
            tq.setParameter("userIP", iPAddress);
            EntityTransaction t = em.getTransaction();
            t.begin();
            t.commit();

            pv = tq.getSingleResult();

        } catch (Exception e) {
            System.err.println("get prop view ERROR: " + e.getMessage());

        } finally {
            em.close();
        }
        return pv;
    }

    public static boolean addPropView(Propertyviews pv) {

        EntityManager em = null;
        try {

            em = DBUtil.getEmf().createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(pv);
            t.commit();
            return true;

        } catch (Exception e) {
            System.err.println("add agent ERROR: " + e.getMessage());
            //  trabs.rollback();
            return false;
        } finally {
            em.close();
        }

    } //end add prop vide 

}
