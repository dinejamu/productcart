package com.in.dine.productcart.controller;

import com.in.dine.productcart.dao.categorydao;
import com.in.dine.productcart.dao.productdao;
import com.in.dine.productcart.model.categorytable;
import com.in.dine.productcart.model.producttable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class Productcontroller {

    @Autowired
    private filehandle filehandles;
    @Autowired
    private productdao productd;

    @Autowired
    private categorydao categoryd;

    @RequestMapping("")
    public ModelAndView home(){
        ModelAndView mv=new ModelAndView("home");
        return mv;
    }
    @RequestMapping("/getdata")
    public ModelAndView getdata(){
        ModelAndView mv=new ModelAndView("product-form");
        List<categorytable> category1 = categoryd.getCategoryList();
        System.out.println(category1);
        mv.addObject("category", category1);
        return mv;
    }
    @RequestMapping(value = {"/add-product"}, method = RequestMethod.POST)
    public ModelAndView addProduct( @RequestParam(value = "categoryname") String cname,
                                   @RequestParam(value = "productname") String name,
                                   @RequestParam(value = "productcode") String code,
                                   @RequestParam(value = "productdesc") String desc,
                                   @RequestParam(value = "price") String price,
                                    @RequestParam(value = "productstatus") String status,
                                   @RequestParam(value = "image", required = false) MultipartFile image, HttpServletRequest request ){

        categorytable category1 = categoryd.getCategory(Integer.parseInt(cname));
        String categoryname=category1.getCategoryname();
        System.out.println(category1);


        String rootDirectory=request.getSession().getServletContext().getRealPath("/");
        producttable product1=filehandles.add(image,rootDirectory);

        producttable product=new producttable(categoryname,name,code,desc,price,status,product1.getProductimages(),category1);
        productd.addProduct(product);

        List<producttable> productList = productd.getProductList();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("psuccess","Product Added successfully");
        mv.addObject("productList", productList);
        return mv;
    }
    @RequestMapping("/products-all")
    public ModelAndView showdata(){
        ModelAndView mv=new ModelAndView("product-list");
        List<producttable> producttableList = productd.getProductList();
        System.out.println(producttableList);
        mv.addObject("productList", producttableList);
        return mv;
    }
}
