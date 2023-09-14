package com.spring.product.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.product.entity.Product;
import com.spring.product.entity.SubProduct;
import com.spring.product.repositories.SubProductRepository;
import com.spring.product.service.ProductService;
import com.spring.product.service.SubProductService;

@Service
public class SubProductServiceImpl implements SubProductService{

	@Autowired
	SubProductRepository repo;
	@Autowired
	ProductService ps;
	

	@Override
	public void addStockItem(int productId, SubProduct subProduct) {
		// TODO Auto-generated method stub
		Product product=ps.getById(productId);
		subProduct.setProduct(product);
		repo.save(subProduct);
	}


	@Override
	public List<SubProduct> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	@Override
	public List<Product> getAllByCatagoery(int id) {
		// TODO Auto-generated method stub
		return ps.getProductsByCatageoryId(id);
	}


	@Override
	public void updateSubProduct(int subProductId, SubProduct subProduct) {
		// TODO Auto-generated method stub
		SubProduct sp=repo.getById(subProductId);
		sp.setPrice(subProduct.getPrice()!=0?subProduct.getPrice():sp.getPrice());
		sp.setQuantity(subProduct.getQuantity()!=0?subProduct.getQuantity():sp.getQuantity());
		sp.setSubProductName(subProduct.getSubProductName().isEmpty()?sp.getSubProductName():subProduct.getSubProductName());
	     repo.save(sp);
	
	}


	@Override
	public SubProduct getSubProduct(int subProductId) {
		// TODO Auto-generated method stub
		return repo.getById(subProductId);
	}


	@Override
	public SubProduct getSubProductByProductId(int productId) {
		// TODO Auto-generated method stub
		return repo.getSubProductFromProductId(productId);
	}


	@Override
	public void save(SubProduct sub) {
		// TODO Auto-generated method stub
		repo.save(sub);
	}


	

	

}
