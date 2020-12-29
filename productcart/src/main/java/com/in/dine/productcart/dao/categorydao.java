package com.in.dine.productcart.dao;

import com.in.dine.productcart.model.categorytable;
import com.in.dine.productcart.repository.categoryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class categorydao {
    @Autowired
    private categoryrepo categoryrep;

    public void addCategory(categorytable category) {
       categoryrep.save(category);
    }

    public void updateCategory(categorytable category) {
        categoryrep.save(category);
    }

    public List<categorytable> getCategoryList() {
        return categoryrep.findAll();
    }

    public int deleteCategory(int categoryId) {
        categoryrep.deleteById(categoryId);
        return categoryId;
    }

    public categorytable getCategory(int categoryId) {
        categorytable a=categoryrep.findByCategoryid(categoryId);
        return a;
    }

}
