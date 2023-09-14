package com.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.product.entity.Product;
import com.spring.product.entity.SubProduct;
import com.spring.product.entity.User;

@Component
public interface SubProductService {

	void addStockItem(int productId,SubProduct subProduct);
	List<SubProduct> getAll();
	List<Product> getAllByCatagoery(int id);
	void updateSubProduct(int subProductId,SubProduct subProduct);
	SubProduct getSubProduct(int subProductId);
    SubProduct getSubProductByProductId(int productId);
    void save(SubProduct sub);
}
