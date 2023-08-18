package com.trg.model;

import com.trg.dao.ProductDao;
import com.trg.entity.Product;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
//import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Named
@ApplicationScoped
public class ProductDataProcessor {
    
    @Inject
    ProductDao dao;

//    public ProductDataProcessor() {
//        dao = new ProductDao();
//    }
    
    
    public String saveProduct(HttpServletRequest request, HttpServletResponse response){
        String temp = request.getParameter("pid");
        int prodID = Integer.parseInt(temp);
        String name = request.getParameter("pnm");
        Double price = Double.parseDouble(request.getParameter("ppr"));
        Product p = new Product(prodID,name,price);
        boolean saved = dao.saveProduct(p);
        if(saved){
            request.setAttribute("message", "Product with id "+prodID+" saved");
        }
        else{
            request.setAttribute("message", "Product with id "+prodID+"already exists");
        }
        return "response";
    }
    
    public String getProduct(HttpServletRequest request, HttpServletResponse response){
        String temp = request.getParameter("pid");
        int prodID = Integer.parseInt(temp);
        Product p = dao.getProduct(prodID);
        if(p!=null){
            request.setAttribute("prd", p);
            return "showproduct";
        }
        else{
            request.setAttribute("message", "product with id "+prodID+" not found");
            return "response";
        }
        
    }
    
    public String getAll(HttpServletRequest request, HttpServletResponse response){
        List<Product> list= dao.getAllProducts();
        request.setAttribute("Products", list);
        return "showall";
    }
   
    
}
