package com.trg.jsf;

import com.trg.dao.ProductDao;
import com.trg.entity.Product;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "productFunctions")
@RequestScoped
public class ProductFunctions {
    @Inject
      ProductDao dao;
    private int pid;
    private String name=null;
    private Double price=0.0;
    private String message=null;
    
    public ProductFunctions() {
        
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getProduct(){
        Product p = dao.getProduct(pid);
        if(p==null){
            message = "product id : "+pid+"not found";
        }
        else{
            message = p.toString();
            name = p.getName();
            price = p.getPrice();
        }
        return "index";
    }
    
    public String deleteProduct(){
        boolean t = dao.deleteProduct(pid);
        if(t){
            message = "Product id : "+pid+" deleted";
        }
        else
        {
            message = "Product id : "+pid+" not found"; 
        }
        return "index";
    }
    
    public String saveProduct(){
        Product p = new Product(pid,name,price);
        boolean t = dao.saveProduct(p);
        if(t)
        {
            message = "Product id : "+pid+" added to DB"; 
        }
        else
        {
            message = "Product id : "+pid+" not added or id already exist"; 
        }
        return "index";
    }
    
}
