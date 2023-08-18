/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa1;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa1.entity.Employee;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1PU");
        EntityManager em = emf.createEntityManager();
        
        Employee e = em.find(Employee.class, 105);
        
        //Employee e1 = new Employee(105, "Vaibav", 123456.0);
        
       // e.setSalary(45000.0);
        em.getTransaction().begin();
        
        em.remove(e);
        //em.persist(e1);
        //em.merge(e);
        
        
        
        em.getTransaction().commit();
        
        //System.out.println(e);
        
        em.close();
        
        
        //System.out.println(e);
    }
    
}
