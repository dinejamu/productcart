package com.in.dine.productcart.repository;

import com.in.dine.productcart.model.producttable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productrepo extends JpaRepository<producttable, Long> {
}
