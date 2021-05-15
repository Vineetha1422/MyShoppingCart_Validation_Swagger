package com.capg.msc.myshoppingcart.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.capg.msc.myshoppingcart.beans.Product;
import com.capg.msc.myshoppingcart.dao.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {
    
	@Autowired
	ProductRepository repo;
	
	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public Product saveProduct(Product p) {
		repo.save(p);
		return p;
	}
	
	@Override
	public Product searchProduct(int id) {
		return repo.findById(id).get();
	}
	
	@Override
	public Product updateProduct(Product p, int id) {
		/*Optional<Product> up = repo.findById(id);
		if(up.isPresent())
		{
			Product product = up.get();
			product.setProductName(p.getProductName());
			product.setProductCost(p.getProductCost());
			product.setStarRating(p.getStarRating());
			product.setCategory(p.getCategory());
			return repo.save(product);
		}
		return null;*/
		
		//For exception handling
		Product product = searchProduct(id);
		product.setProductName(p.getProductName());
		product.setProductCost(p.getProductCost());
		product.setStarRating(p.getStarRating());
		product.setCategory(p.getCategory());
		return repo.save(product);
	}

	@Override
    @Transactional
	public boolean deleteProduct(int id) {
		boolean isdeleted = false;
		List<Product> list = getAllProducts();
		Optional<Product> search = repo.findById(id);
		if(search.isPresent()) {
			repo.delete(search.get());
			isdeleted = true;
		}
		return isdeleted;
		
	}
	
	@Override
	public List<Product> getAllProductsByCategory(String category) {
		return repo.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2) {
		return repo.getProductByCategoryAndPrice(category, range1, range2);
	}
	

}
