package com.in.dine.productcart.controller;

import com.in.dine.productcart.model.producttable;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class filehandle {
    public producttable add(MultipartFile image, String rootDirectory){
        producttable product=new producttable();
        String filename= StringUtils.cleanPath(image.getOriginalFilename());
        product.setProductimages(filename);
        System.out.println("5--->>>" + rootDirectory);
        File reportLocation = new File(rootDirectory+"/photo/" + product.getProductimages() + "/");
        try {
            FileUtils.writeByteArrayToFile(reportLocation, image.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;

    }
}
