package com.trg.jsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "calc")
@RequestScoped
public class Calculator {
    
    private int firstNumber;
    private int secondNumber;
    private int sum;
    private String message;

    public Calculator() {
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String add(){
        if(firstNumber<0 || secondNumber<0){
            message = "Negative number are not accepted";
        }
        else
        {
            sum = firstNumber+secondNumber;
            message = "Sum is "+sum;
            
        }
        return "index";
    }
    
    
}
