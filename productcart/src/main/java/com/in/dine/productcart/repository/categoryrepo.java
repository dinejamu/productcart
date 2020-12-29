package com.in.dine.productcart.repository;

import com.in.dine.productcart.model.categorytable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  categoryrepo  extends JpaRepository<categorytable, Integer> {
     categorytable findByCategoryname(String Name);
    categorytable findByCategoryid(int id);
}
