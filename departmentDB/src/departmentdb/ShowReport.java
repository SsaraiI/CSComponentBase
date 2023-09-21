/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departmentdb;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author iarsk
 */
public class ShowReport {
    public static void main (String[] args) {
        
        findAllEmpByID();
        System.out.println();
        findAllEmpByDepartment();
    }
    
    public static void findAllEmpByID(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentDBPU");
        EntityManager em = emf.createEntityManager();
        List<Employee> empList = (List<Employee>) em.createNamedQuery("Employee.findAll").getResultList();
        em.close();
        System.out.print("All employee (by ID)\n--------------------");
        for(Employee emp : empList){
            System.out.print(emp);
        }
    }
    
    public static void findAllEmpByDepartment(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentDBPU");
        EntityManager em = emf.createEntityManager();
        List<Department> depList = (List<Department>) em.createNamedQuery("Department.findAll").getResultList();
        List<Employee> empList = (List<Employee>) em.createNamedQuery("Employee.findAll").getResultList();
        em.close();
        System.out.print("All employee (by ID)\n--------------------");
        for(Department dep : depList){   
            System.out.print(dep);
            for(Employee emp : empList){
                if(Objects.equals(dep, emp.getDepartmentid())){
                    System.out.print(emp);
                }
            }
        }
    }
}
