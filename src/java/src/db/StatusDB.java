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
import src.entities.Status;

/**
 *
 * @author jrmromao
 */
public class StatusDB {
    
    
//    public static boolean chanceStatus(Status status){
//
//           EntityManager em = null;
//        try {
//
//            em = DBUtil.getEmf().createEntityManager();
//            EntityTransaction t = em.getTransaction();
//            t.begin();
//            em.persist(status);
//            t.commit();
//            return true;
//
//        } catch (Exception e) {
//            System.err.println(" update status  ERROR: " + e.getMessage());
//            //  trabs.rollback();
//            return false;
//        } finally {
//            em.close();
//        }
//    }//end change status
//    
//    
//    
//    public static List<Status> getAllStatus(){
//        
//       List<Status> sList = null;
//       EntityManager em = null;
//       
//          try {
//            em = DBUtil.getEmf().createEntityManager();
//            TypedQuery<Status> tq = em.createNamedQuery("Status.findAll", Status.class); // call the name query in the
//            sList = tq.getResultList();
//
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e.toString());
//            System.err.println("Get All Status ERROR: " + e.getMessage());
//        } finally {
//            em.close();
//        }
//       
//       return sList;
//    }//end get all status  

    
    



    
}
