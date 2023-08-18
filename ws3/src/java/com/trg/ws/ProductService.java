package com.trg.ws;

import com.trg.dao.ProductDao;
import com.trg.entity.Product;
import java.util.List;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

@WebService(serviceName = "ProductService")
public class ProductService {
    @Inject
     ProductDao dao;
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name")String txt) {
        
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getProduct")
    public @WebResult(name = "Details") Product getProduct(@WebParam(name = "ProductID")int id){
        //ProductDao dao = new ProductDao();
        Product p = dao.getProduct(id);
        return p;
    }
    @WebMethod(operationName = "setAllProducts")
    public @WebResult(name = "AllProdDetails") List<Product> getAllProducts(){
        //ProductDao dao = new ProductDao();
        return dao.getAllProducts();
    }
    
    @WebMethod(operationName = "saveProduct")
    public @WebResult(name = "SaveResult") String saveProduct(@WebParam(name = "ProdID")Product p){
        //ProductDao dao = new ProductDao();
        boolean t = dao.saveProduct(p);
        if(t){
            return "added";
        }
        return "not added";
    }
    
}
