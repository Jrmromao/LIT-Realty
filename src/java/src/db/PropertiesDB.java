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
import org.apache.jasper.tagplugins.jstl.core.Catch;
import src.entities.Properties;
import src.entities.User;

/**
 *
 * @author jrmromao
 */
public class PropertiesDB {

    public static List<Properties> getAllProperties() {

        List<Properties> pLisr = null;
        EntityManager em = null;

        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Properties> tq = em.createNamedQuery("Properties.findAll", Properties.class); // call the name query in the
            pLisr = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get All Property ERROR: " + e.getMessage());
        } finally {
            em.close();
        }
        return pLisr;
    }//end getPropTypet

    
    
    
    
    
    public static List<Properties> getLastestProperties() {

        List<Properties> pLisr = null;
        EntityManager em = null;

        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Properties> tq = em.createNamedQuery("Properties.latestProp", Properties.class); // call the name query in the
            pLisr = tq.setMaxResults(8).getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get lastest Property ERROR: " + e.getMessage());
        } finally {
            em.close();
        }
        return pLisr;
    }//end getPropTypet

    
    
    
    
    public static List<Properties> getCity() {

        List<Properties> pCity = null;
        EntityManager em = null;

        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Properties> tq = em.createNamedQuery("Properties.finfDistinct", Properties.class); // call the name query in the
            pCity = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get All Property ERROR: " + e.getMessage());
        } finally {
            em.close();
        }

        return pCity;
    }//end getCity

    
    
    
    public static List<Properties> searchResult(double minPrice, double maxPrice, String location, int type) {

        List<Properties> SearList = null;
        EntityManager em = null;

        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Properties> tq = em.createNamedQuery("Properties.SearchProp", Properties.class); // call the name query in the
            tq.setParameter("minPrice", minPrice);
            tq.setParameter("maxPrice", maxPrice);
            tq.setParameter("location", location);
            tq.setParameter("type", type);

            SearList = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get serach result ERROR: " + e.getMessage());
        } finally {
            em.close();
        }

        return SearList;
    }   //end search result 

    
    
    
    public static List<Properties> advancedSearchResult(double price, String location, int type, int nBedrooms, int squarefeet) {

        List<Properties> SearList = null;
        EntityManager em = null;

        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Properties> tq = em.createNamedQuery("Properties.advancedSearchProp", Properties.class); // call the name query in the
            tq.setParameter("price", price);
            tq.setParameter("location", location);
            tq.setParameter("type", type);
            tq.setParameter("nBedrooms", nBedrooms);
            tq.setParameter("squarefeet", squarefeet);

            SearList = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get serach result ERROR: " + e.getMessage());
        } finally {
            em.close();
        }

        return SearList;
    }   //end search result     

    
    
    
    
    public static Properties getPropDetails(int propId) {

        EntityManager em = null;
        Properties p = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            p = em.find(Properties.class, propId);

        } catch (Exception e) {
            System.err.println("Get prop details ERROR: " + e.getMessage());
        } finally {
            em.close();
        }

        return p;
    }// end get details

    
    
    
    
    
    public static List<Properties> getPropertyByAgent(int AgentID) {
        List<Properties> pLisr = null;
        EntityManager em = null;

        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Properties> tq = em.createNamedQuery("Properties.GetAllPropertiesByAgent", Properties.class); // call the name query in the
            tq.setParameter("agentID", AgentID);
            pLisr = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get All Property by Agent IDERROR: " + e.getMessage());
        } finally {
            em.close();
        }
        return pLisr;
    }// getPropertyByAgent

    
    
    public static List<Properties> getPropertyByAgent_JoinVendor(int AgentID) {
        List<Properties> pLisr = null;
        EntityManager em = null;

        try {
            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Properties> tq = em.createNamedQuery("Properties.JoinVendor", Properties.class); // call the name query in the
            tq.setParameter("agentID", AgentID);
            pLisr = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get All Property by Agent IDERROR: " + e.getMessage());
        } finally {
            em.close();
        }
        return pLisr;
    }// getPropertyByAgent

    
    
    
    
    public static boolean addProperty(Properties p) {

        EntityManager em = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(p);
            t.commit();
            return true;

        } catch (Exception e) {
            System.err.println("add property  ERROR: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }

    } //end addProperty

    
   
    public static boolean deleteProperty(Properties p) {

        EntityManager em = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.remove(em.merge(p)); //delete object
            t.commit();
            return true;

        } catch (Exception e) {
            System.err.println("delete property ERROR: " + e.getMessage());
            //  trabs.rollback();
            return false;
        } finally {
            em.close();
        }

    }// end delete property


        
    public static boolean updateProperty(Properties p) {

        EntityManager em = null;
 

        try {

            em = DBUtil.getEmf().createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.merge(p); //a diference para o method the adicionar    
            t.commit();
            return true;

        } catch (Exception e) {
            System.err.println("update prop ERROR: " + e.getMessage());
            //  trabs.rollback();
            return false;
        } finally {
            em.close();
        }
        }// end update property

    
    
    
    
//    
//    public static boolean updateStatus(int propId){
//        
//        
//      EntityManager em = null;
//
//      
//      /*
//             em = DBUtil.getEmf().createEntityManager();
//            EntityTransaction t = em.getTransaction();
//            t.begin();
//            em.remove(em.merge(p)); //delete object
//            t.commit();*/
//        try {
//        
//            
//            em = DBUtil.getEmf().createEntityManager();
//            TypedQuery<Properties> tq = em.createNamedQuery("Properties.updateStatus", Properties.class); // call the name query in the
//            tq.setParameter("status", 1);
//            tq.setParameter("propId", propId);
//
//            
//
//            return true;
//        } catch (Exception e) {
//          
//            System.err.println("Get prop details ERROR: " + e.getMessage());
//       
//        return false;
//        } finally {
//            em.close();
//        }
//        
//        
//        
//    }// end ipdate status
    
    
    
    
    
    
    
    }
    

