/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa1;

/**
 *
 * @author oracle
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa1.entity.Employee;

public class Main1 {

    public static void main(String [] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1PU");
        EntityManager em = emf.createEntityManager();
        
        String stmt = "select e from Employee e where e.salary>50000";
        Query q= em.createQuery(stmt);
        List<Employee> list=q.getResultList();
        
        for(Employee x: list){
            System.out.println(x);
        }
    }
    
}
