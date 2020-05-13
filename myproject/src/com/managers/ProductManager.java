package com.managers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.models.Product;
import com.session.LoadSession;

public class ProductManager {

	public void addProduct(Product product) {
	Session session = LoadSession.getSession();
	Transaction t = session.beginTransaction();
	try {
		session.saveOrUpdate(product);
		t.commit();
	}catch(Exception e) {
		t.rollback();
	}
		
	}
	
	
	public List<Product> allProducts(int categoryId) {
		Session session = LoadSession.getSession();
		 return session.createQuery("from Product where categoryId="+categoryId).list();
	}


	public Product getProductDetails(Integer productId) {
		Session session = LoadSession.getSession();
		 return (Product)session.createQuery("from Product where id="+productId).list().get(0);
		
	}
	
	

}
