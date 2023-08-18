
package jpa1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.trg.entity.Product;


public class ProductMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1PU");
        EntityManager em = emf.createEntityManager();
        
        Product p1 = new Product(11, "Laptop",30000);
        Product p2 = new Product(12, "Monitor",40000);
        Product p3 = new Product(13, "Mobile",20000);
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        
        em.close();
    }
}

