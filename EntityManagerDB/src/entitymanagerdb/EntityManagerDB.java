/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitymanagerdb;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Address;
import model.Customer;

/**
 *
 * @author iarsk
 */
public class EntityManagerDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //createData();
       //printAllCustomer();
       printCustomerByCity("Bangkok");
    }

    
    public static void createData() {
        
        Customer c1 = new Customer(1L, "John", "Henry", "jh@mail.com");
        Address ad1 = new Address(1L, "123/4 Viphavadee Rd.", "Bangkok", "TH", "10900", c1);           
        persist(c1);
        persist(ad1);
        
        
        Customer c2 = new Customer(2L, "Marry", "Jane", "mj@mail.com");
        Address ad2 = new Address(2L, "123/5 Viphavadee Rd.", "Bangkok", "TH", "10900", c2);       
        persist(c2);
        persist(ad2);
        
        Customer c3 = new Customer(3L, "Peter", "Parker", "pp@mail.com");
        Address ad3 = new Address(3L, "543/21 Fake Rd.", "Nonthaburi", "TH", "20900", c3); 
        persist(c3);
        persist(ad3);
                
        Customer c4 = new Customer(4L, "Bruce", "Wayn", "bw@mail.com");
        Address ad4 = new Address(4L, "678/90 Unreal Rd.", "Pathumthani", "TH", "30500", c4); 
        persist(c4);
        persist(ad4);            
    }

    public static void printAllCustomer(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDBPU");
        EntityManager em = emf.createEntityManager();
        List<Customer> CusList = (List<Customer>) em.createNamedQuery("Customer.findAll").getResultList();
        List<Address> AdList = (List<Address>) em.createNamedQuery("Address.findAll").getResultList();
        em.close();
        
//        for(Customer cus : CusList){   
//            System.out.print(cus);
//            for(Address ad : AdList){
//                if(Objects.equals(cus, ad.getCustomerFk())){
//                    System.out.print(ad);
//                }
//            }
//            System.out.print("\n--------------------\n--------------------\n");
//        }
        
        for(Customer cus : CusList){
            Address ad = cus.getAddressCollection().iterator().next();
            System.out.print(cus + "" + ad + "\n--------------------\n--------------------\n");
        }
    }
    
    public static void printCustomerByCity(String city){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDBPU");
        EntityManager em = emf.createEntityManager();
//      List<Customer> CusList = (List<Customer>) em.createNamedQuery("Customer.findCity").getResultList();
//      List<Address> AdList = (List<Address>) em.createNamedQuery("Address.findAll").getResultList();
        List<Address> AdList = (List<Address>) em.createNamedQuery("Address.findByCity").setParameter("city", city).getResultList();
        em.close();
        
//        for(Address ad : AdList){
//            if(ad.getCity() == null ? city == null : ad.getCity().equals(city)){
//                for(Customer cus : CusList){ 
//                    if(Objects.equals(cus, ad.getCustomerFk())){
//                        System.out.print(cus);            
//                        System.out.print(ad);
//                    }
//                }
//                System.out.print("\n--------------------\n--------------------\n");
//            }        
//        } 

        for(Address ad : AdList){
            Customer cus = ad.getCustomerFk();
            System.out.print(cus + "" + ad + "\n--------------------\n--------------------\n");
        } 
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDBPU");
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
