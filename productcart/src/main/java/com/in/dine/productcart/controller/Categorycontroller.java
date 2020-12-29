package com.in.dine.productcart.controller;

import com.in.dine.productcart.dao.categorydao;
import com.in.dine.productcart.model.categorytable;
import com.in.dine.productcart.repository.categoryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Categorycontroller {

    @Autowired
    private categorydao categoryd;
    @Autowired
    private categoryrepo categoryrep;

    @RequestMapping("/add-category")
    public ModelAndView addproduct(categorytable category){
      categorytable categoryt=categoryrep.findByCategoryname(category.getCategoryname());
        ModelAndView mv = new ModelAndView("home");
        if (categoryt==null){
            categoryd.addCategory(category);
            mv.addObject("success","New Category Added in the List...");
        }
        else {
            mv.addObject("failure","Already this Category Exist in the List.");
        }
        List<categorytable> category1 = categoryd.getCategoryList();
        System.out.println(category1);
        mv.addObject("categoryList1", category1);
        return mv;
    }

    @RequestMapping(value = {"view"} , method = RequestMethod.GET)
    public ModelAndView findall(){
    ModelAndView mv=new ModelAndView("category-list");
        List<categorytable> category1 = categoryd.getCategoryList();
        mv.addObject("categoryList", category1);
        return mv;
    }
    @RequestMapping(value = {"delete-category"} , method = RequestMethod.GET)
    public ModelAndView deleteCategory(@RequestParam("categoryid")int categoryId){
        ModelAndView mv = new ModelAndView();
        if(categoryId>=1){
            categoryd.deleteCategory(categoryId);
            mv.addObject("deletesuccess","This category Successfully Deleted..");
        }else {
            mv.addObject("error","Try again after sometimes..");
        }
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping(value = {"/edit-category"} , method = RequestMethod.GET)
    public ModelAndView editCategory(@RequestParam("categoryid")int categoryId){
        categorytable obj = categoryd.getCategory(categoryId);
        ModelAndView mv = new ModelAndView("category-update");
        mv.addObject("category2", obj);
        return mv;
    }
    @RequestMapping(value = {"/update-category"} , method = RequestMethod.GET)
    public ModelAndView updateCategory(@RequestParam("categoryid")int no,@RequestParam("categoryname") String name){
        ModelAndView mv = new ModelAndView();
        categorytable category=new categorytable();
       category.setCategoryid(no);
       category.setCategoryname(name);
       categoryd.updateCategory(category);
       mv.setViewName("home");
        mv.addObject("updatecatagory","Category updated..");
        return mv;
    }
}
