package com.managers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.Address;
import com.models.User;
import com.session.LoadSession;

public class AddressManager {
public void addAddress(Address address) {
	Session session = LoadSession.getSession();
	Transaction t = session.beginTransaction();
	try {
		session.saveOrUpdate(address);
		t.commit();
		session.close();
	}
	catch(Exception e) {
		t.rollback();
	}
}

public List<Address> getAddressByUserId(int userId){
	Session session = LoadSession.getSession();
	List list  = session.createQuery("from Address where userId="+userId).list();
	session.close();
	return list;
	}

public Address getAddressByAddressId(int addressId) {
	Session session = LoadSession.getSession();
	List<Address> addressList  = session.createQuery("from Address where userId="+addressId).list();
	session.close();
	Address address=addressList.size()>0?addressList.get(0):null;
	return address;
}
}
