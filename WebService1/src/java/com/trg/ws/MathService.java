package com.trg.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

@WebService(serviceName = "MathService")
public class MathService {
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "addNumbers")
    public @WebResult(name = "sum") int add(@WebParam(name = "number1") int a,@WebParam(name = "number2") int b) {
        System.out.println("sum of 2 numbers : ");
        return a+b;
    }
}
