/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import src.entities.User;
import src.entities.Usercategory;

/**
 *
 * @author jrmromao
 */
public class UserRoleDB {
    
    
    public static List<Usercategory> getAllCategories(){
        
       List<Usercategory> uCatList = null;
       
        EntityManager em = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Usercategory> tq = em.createNamedQuery("Role.findAll", Usercategory.class); // call the name query in the
            uCatList = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get All user category ERROR: " + e.getMessage());
        } finally {
            em.close();
        }
        
        
        
        
        
        return uCatList;
    }//end get all categories
    
    
    
}
