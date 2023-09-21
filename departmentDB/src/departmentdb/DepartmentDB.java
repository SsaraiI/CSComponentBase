/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departmentdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author iarsk
 */
public class DepartmentDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Department d1 = new Department("IT");
        Department d2 = new Department("HR");
        Employee e1 = new Employee("John", "Network Admin", 56789, d1);
        Employee e2 = new Employee("Marry", "HR Manager", 46789, d2);
        Employee e3 = new Employee("Henry", "Programmer", 67890, d1);
        Employee e4 = new Employee("Clark", "HR recruiter", 36789, d2);

        
        persist(d1);
        persist(d2);
        persist(e1);
        persist(e2);              
        persist(e3);              
        persist(e4);              
            
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentDBPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
