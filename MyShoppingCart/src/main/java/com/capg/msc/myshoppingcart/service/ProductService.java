package com.capg.msc.myshoppingcart.service;

import java.util.List;
import com.capg.msc.myshoppingcart.beans.Product;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product saveProduct(Product p);
    public Product searchProduct(int id);
    public boolean deleteProduct(int id);
	public Product updateProduct(Product p, int id);
	
    public List<Product> getAllProductsByCategory(String category);
	public List<Product> getAllProductsByCategoryAndPrice(String category,int range1,int range2);
	
}
