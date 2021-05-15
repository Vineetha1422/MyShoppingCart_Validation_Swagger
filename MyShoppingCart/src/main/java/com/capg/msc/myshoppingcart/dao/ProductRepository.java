package com.capg.msc.myshoppingcart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.msc.myshoppingcart.beans.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>,CustomProductRepository{

	
}
