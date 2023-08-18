package com.trg.main;

import com.trg.dao.ProductDao;
import com.trg.entity.Product;
import java.util.List;

public class Main {
    public static void main(String[] args) { 
        
            ProductDao pd = new ProductDao();
            
//-----------Save Product to the Table Product.-------------------
            /*
            Product p = new Product(14,"TV",23000.0);
            
            boolean saved = pd.saveProduct(p);
            if(saved)
                System.out.println("object saved");
            else
                System.out.println("object already exists");*/
            
            
//------Get product from Product using Pid----------------------
            
         /*   Product p1 = pd.getProduct(11);
            if(p1==null)
                System.out.println("Product not found");
            else
                System.out.println(p1);*/


//----------Change the price of object------------
           /* boolean update = pd.changePrice(11, 25000);
                if(update)
                System.out.println("Product updated successfully");
            else
                System.out.println("Product not found");*/
           

//-----------delete the product from Product table----------------
           boolean delete = pd.deleteProduct(14);
           if(delete)
                System.out.println("Product deleted successfully");
            else
                System.out.println("Product not found");
         
            
//------------Listing all the object values in Product---------------
            List<Product> prod = pd.getAllProducts();
            prod.forEach(n->System.out.println(n));
    }   
}
