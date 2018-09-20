/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import src.entities.User;
 
public class UserDB {

    public static User getUserObj(String username) {

        EntityManager em = null;
        User u = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<User> tq = em.createNamedQuery("User.findByUsername", User.class);
            tq.setParameter("username", username);
          

            u = tq.getSingleResult();

        } catch (Exception e) {
           // JOptionPane.showConfirmDialog(null, e.toString());
           System.out.print("ERROR:"+e.getMessage());
        } finally {
            em.close();
        }
        return u;

    }//end agent login
    
    
       public static User getUserByID(int id) {

        EntityManager em = null;
        User u = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<User> tq = em.createNamedQuery("User.findByUserId", User.class);
            tq.setParameter("userId", id);
            u = tq.getSingleResult();

        } catch (Exception e) {
            // JOptionPane.showConfirmDialog(null, e.toString());
            System.out.print("ERROR:" + e.getMessage());
        } finally {
            em.close();
        }
        return u;

    }//end get user by id
        
    
    

    public static List<User> getAllAgent() {

        List<User> agentsList = null;
        EntityManager em = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<User> tq = em.createNamedQuery("User.findAll", User.class); // call the name query in the
            agentsList = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get All Agents ERROR: " + e.getMessage());
        } finally {
            em.close();
        }

        return agentsList;
    }//end get all agents

    public static boolean registerUser(User u) {

        EntityManager em = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(u);
            t.commit();
            return true;

        } catch (Exception e) {
            System.err.println("add agent ERROR: " + e.getMessage());
            //  trabs.rollback();
            return false;
        } finally {
            em.close();
        }

    }//end resgister user
    
    

    
    public static boolean updateUserDetails(User u){
        
        
              EntityManager em = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.merge(u); //a diference para o method the adicionar dovo autor
            t.commit();
            return true;

        } catch (Exception e) {
            System.err.println("update user ERROR: " + e.getMessage());
            //  trabs.rollback();
            return false;
        } finally {
            em.close();
        }
        
    }//end update user

    
    
     
   

    
    
    
    
    
    
    
    
    
    
    
}
