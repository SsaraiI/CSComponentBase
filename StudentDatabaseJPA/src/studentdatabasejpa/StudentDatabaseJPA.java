/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabasejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author iarsk
 */
public class StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student emp1 = new Student(1, "Tong", 4.00);
       Student emp2 = new Student(2, "Pun", 3.5);
       Student emp3 = new Student(3, "Mai", 3.8);
       StudentTable.insertStudent(emp1);
       StudentTable.insertStudent(emp2);
       StudentTable.insertStudent(emp3);
       System.out.println(StudentTable.findAllStudent());
       Student std;
       std = StudentTable.findStudentById(2);
       if (std != null) {
           std.setName("PunPun");
//           StudentTable.deleteStudent(std);
           StudentTable.updateStudent(std);
       }
       System.out.println(StudentTable.findAllStudent());
       List<Student> stdList = StudentTable.findStudentByName("PunPun"); 
       System.out.println(stdList);
       StudentTable.deleteStudent(emp2);
       System.out.println(StudentTable.findAllStudent());
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
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
