package com.trg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PRTBL")
@NamedQueries(
        {
            @NamedQuery(name = "Product.findall",query = "select p from Product p order by p.productId"),
            @NamedQuery(name = "Product.findonprice",query = "select p from Product p where p.price > :pr"),
            @NamedQuery(name = "Product.findonname",query = "select p from Product p where p.name like :pattern ")
        }
)
public class Product {
    @Id
    @Column(name = "PRID")
    private int productId;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", price=" + price + '}';
    }
    
}
