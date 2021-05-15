package com.capg.msc.myshoppingcart.dao;

import java.util.List;

import com.capg.msc.myshoppingcart.beans.Product;

public interface CustomProductRepository {

	public List<Product> getProductByCategory(String productCategory);
	public List<Product> getProductByCategoryAndPrice(String productCategory,int range1,int range2);
	
}
