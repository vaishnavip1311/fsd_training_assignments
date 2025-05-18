package com.ecom.dao;

import java.util.List;

import com.ecom.model.Product;

public interface ProductDao {
	
	void addProduct(Product product,int categoryId);
	List<Product> getProductsByCategory(int categoryId);
	List<Product> getAllProducts();

}
