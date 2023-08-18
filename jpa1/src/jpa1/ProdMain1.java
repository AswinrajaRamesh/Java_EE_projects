package jpa1;

import com.trg.dao.ProductDao;
import com.trg.entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProdMain1 {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1PU");
//        EntityManager em = emf.createEntityManager();
//        
//        Query q= em.createNamedQuery("Product.findonname");//findonprice");
//        q.setParameter("pattern", "Mobile");//20000);
//        List<Product> list = q.getResultList();
//        
//        for(Product p:list){
//            System.out.println(p);
//        }
//        
            ProductDao pd = new ProductDao();
            Product p = new Product(14,"TV",234434.0);
            
            boolean saved = pd.saveProduct(p);
            if(saved)
                System.out.println("object saved");
            else
                System.out.println("object already exist");
    }
    
}
