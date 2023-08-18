package com.trg.dao;

import com.trg.entity.Product;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


@Named
@ApplicationScoped
public class ProductDao {
    EntityManagerFactory emf;
    EntityManager em;
    
    public ProductDao(){
        emf = Persistence.createEntityManagerFactory("jpa1PU");
        em = emf.createEntityManager();
    }
    
    public boolean saveProduct(Product p){
        Product temp = em.find(Product.class, p.getProductId());
        if(temp != null){
            return false;
        }
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return true;        
    }
    
    public Product getProduct(int pid){
        Product temp = em.find(Product.class, pid);
        return temp;        
    }
    
    public List<Product> getAllProducts(){
        Query q = em.createNamedQuery("Product.findall");
        List<Product> list = q.getResultList();
        return list;        
    }
    
    public boolean deleteProduct(int pid){
        Product temp = em.find(Product.class, pid);
        if(temp == null){
            return false;
        }
        em.getTransaction().begin();
        em.remove(temp);
        em.getTransaction().commit();
        return true;
    }
    
    public boolean changePrice(int pid, double price){
        Product temp = em.find(Product.class, pid);
        if(temp == null){
            return false;
        }
        em.getTransaction().begin();
        temp.setPrice(price);
        em.merge(temp);
        em.getTransaction().commit();
        return true;        
    }
    
    public boolean changeName(int pid, String name){
        Product temp = em.find(Product.class, pid);
        if(temp == null){
            return false;
        }
        em.getTransaction().begin();
        temp.setName(name);
        em.merge(temp);
        em.getTransaction().commit();
        return true;        
    }
    public void close(){
        if(em.isOpen())
            em.close();
    }
    
    @Override
    public void finalize(){
        if(em.isOpen())
            em.close();
    }
    
}
