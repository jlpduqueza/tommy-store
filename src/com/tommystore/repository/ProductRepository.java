package com.tommystore.repository;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tommystore.domain.Product;

public interface ProductRepository {

	public Product find(Integer id);
	public Product save(Product product);
	
	public List<Product> findProductByCategoryId(Integer id);
	public List<Product> findProducts();
	public List<Product> searchProduct(String keyword);
	public List<Product> searchProductByCategory(String keyword);
	public List<Product> searchProductByName(String keyword);
	
	public Boolean isExistByNameAndCategoryId(String name, Integer id);
	public Boolean isExistByPicture(MultipartFile file);
	public Boolean isNameValid(String name, Integer id);
	
	public void delete(Integer id);
	
}
