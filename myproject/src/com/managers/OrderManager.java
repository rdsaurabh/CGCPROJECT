package com.managers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.Order;
import com.models.OrderItems;
import com.session.LoadSession;

public class OrderManager {

	public void placeOrder(Order order) {
		Session session = LoadSession.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(order);
			for (OrderItems item : order.getOrderItems()) {
				session.save(item);
			}
			t.commit();

		} catch (Exception e) {
			t.rollback();
		}

	}
	
	
	public Order getOrderById(int orderId) {
		Session session = LoadSession.getSession();
			List<Order> list = session.createQuery("from Order where id="+orderId).list();
			return list.size()>0?list.get(0):null;
	}


	public void updateOrder(Order order) {
		Session session = LoadSession.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(order);
			t.commit();

		} catch (Exception e) {
			t.rollback();
		}

		
	}
}
