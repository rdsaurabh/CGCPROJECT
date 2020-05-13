package com.managers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.models.Category;
import com.session.LoadSession;

public class CategoryManager {

public void addCategory(Category category) {
Session session = LoadSession.getSession();
Transaction t = session.beginTransaction();
try {
	session.save(category);
	t.commit();
}catch(Exception e) {
	t.rollback();
}
}

public List<Category> getCategories() {
	Session session = LoadSession.getSession();
	return session.createQuery("from Category").list();
	
}

}
