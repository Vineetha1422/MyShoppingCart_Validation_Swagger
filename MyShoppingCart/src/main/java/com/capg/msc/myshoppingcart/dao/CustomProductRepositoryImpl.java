package com.capg.msc.myshoppingcart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.capg.msc.myshoppingcart.beans.Product;


public class CustomProductRepositoryImpl implements CustomProductRepository {

	@Autowired
	EntityManager entityManager; // Session of Hibernate
	
	@Override
	public List<Product> getProductByCategory(String productCategory) {
		Query q = entityManager.createQuery("from Product where category=:productCategory");
		q.setParameter("productCategory", productCategory);
		return q.getResultList();
	}

	@Override
	public List<Product> getProductByCategoryAndPrice(String productCategory, int range1, int range2) {
		Query q = entityManager.createQuery("from Product where category=:productCategory "
				+ "and productCost BETWEEN :range1 and :range2");
		q.setParameter("productCategory", productCategory);
		q.setParameter("range1", range1);
		q.setParameter("range2", range2);
		
		return q.getResultList();
	}

}
