package org.bettysinventory.repository;

import org.bettysinventory.beans.ProductImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Integer> {
	
	ProductImage findByProductId(Integer id);
	
	
}