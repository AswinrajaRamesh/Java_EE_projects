/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsclientapp;

import com.client.ws.MathService;
import com.client.ws.MathService_Service;
import com.trg.ws.Product;
import com.trg.ws.ProductService;
import com.trg.ws.ProductService_Service;
import java.util.List;

/**
 *
 * @author oracle
 */
public class WSClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        MathService_Service ms = new MathService_Service();
//        MathService service = ms.getMathServicePort();
        
        
        
//        int sum = service.addNumbers(123, 456);
//        System.out.println("sum : "+sum);
//        
//        System.out.println(service.hello("aswinraja"));

            ProductService_Service ps = new ProductService_Service();
            ProductService service1 = ps.getProductServicePort();
            
            Product p = service1.getProduct(11);
            System.out.println(p.toString());
            
            List<Product> p1 = service1.setAllProducts();
            p1.forEach(n->System.out.println(n.toString()));
            
            
            Product p2 = new Product(16,"note",120.0);
            String t = service1.saveProduct(p2);
            System.out.println(t);
    }
    
}
