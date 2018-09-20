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
import src.entities.Propertytypes;

/**
 *
 * @author jrmromao
 */
public class PropertyTypesDB {
    
    
    
    public static List<Propertytypes> getPropTypet() {

        List<Propertytypes> typesLisr = null;
        EntityManager em = null;

        try {

            em = DBUtil.getEmf().createEntityManager();
            TypedQuery<Propertytypes> tq = em.createNamedQuery("Propertytypes.findAll", Propertytypes.class); // call the name query in the
            typesLisr = tq.getResultList();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
            System.err.println("Get Property types  ERROR: " + e.getMessage());
        } finally {
            em.close();
        }

        return typesLisr;
    }//end getPropTypet
}
