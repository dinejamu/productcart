package com.in.dine.productcart.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
public class producttable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;
    private String categoryname;
    private String productcode;
    private String productname;
    private String productdesc;
    private String price;
    private String productstatus;
    private String productimages;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private categorytable category;

    public producttable(String categoryname, String productcode, String productname, String productdesc, String price, String productstatus, String productimages, categorytable category) {
        this.categoryname = categoryname;
        this.productcode = productcode;
        this.productname = productname;
        this.productdesc = productdesc;
        this.price = price;
        this.productstatus = productstatus;
        this.productimages = productimages;
        this.category = category;
    }

    public producttable() {

    }

    @Override
    public String toString() {
        return "producttable{" +
                "productid=" + productid +
                ", categoryname='" + categoryname + '\'' +
                ", productcode='" + productcode + '\'' +
                ", productname='" + productname + '\'' +
                ", productdesc='" + productdesc + '\'' +
                ", price='" + price + '\'' +
                ", productstatus='" + productstatus + '\'' +
                ", productimages='" + productimages + '\'' +
                ", category=" + category +
                '}';
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus;
    }

    public String getProductimages() {
        return productimages;
    }

    public void setProductimages(String productimages) {
        this.productimages = productimages;
    }

    public categorytable getCategory() {
        return category;
    }

    public void setCategory(categorytable category) {
        this.category = category;
    }
}
