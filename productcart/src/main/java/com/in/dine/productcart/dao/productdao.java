package com.in.dine.productcart.dao;

import com.in.dine.productcart.model.producttable;
import com.in.dine.productcart.repository.categoryrepo;
import com.in.dine.productcart.repository.productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class productdao {

    @Autowired
    private productrepo productrep;

    public void addProduct(producttable product) {
        productrep.save(product);
    }

    public List<producttable> getProductList() {
        List<producttable> product=productrep.findAll();
        return product;
    }
}
