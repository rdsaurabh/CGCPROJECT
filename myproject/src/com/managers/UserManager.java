package com.managers;

import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.models.User;
import com.session.LoadSession;
import java.util.List;

public class UserManager {
	public boolean saveOrUpdate(User user) throws Exception {
		Session session = LoadSession.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw e;
		}
		session.close();
		return true;
	}

	public boolean createUser(User user) {
		String token = new Date().hashCode() + "";
		user.setToken(token);
		try {
			saveOrUpdate(user);
			MailManager m = new MailManager();
			String subject = "VERIFY Account";
			String message = "Please click on following link to verify  href='http://localhost:8080/myproject/verify-email/"
					+ token;
			m.sendEmail(user.getEmail(), subject, message);
		} catch (Exception e) {
		}
		return true;
	}

	public User authenticUser(String token) {
		Session session = LoadSession.getSession();
		Query query = session.createQuery("from User where token='" + token + "'");
		List<User> list = query.list();
		User user = list.size() > 0 ? list.get(0) : null;

		if (user != null) {
			user.setToken(null);
			user.setStatus(1);
			try {
				saveOrUpdate(user);
			} catch (Exception e) {

			}
		}
		return user;
	}

	public User userLogin(String email, String password) {

		User user = getUserByEmailId(email);
		if (user != null) {
			if (!password.equals(user.getPassword())) {
				user = null;
			}
		}

		return user;
	}

	public User getUserByEmailId(String email) {

		Session session = LoadSession.getSession();
		Query result = session.createQuery("from User where email='" + email + "' and status=1");
		List<User> list = result.list();
		User user = list.size() > 0 ? list.get(0) : null;

		return user;
	}

	public User signinWithGoogle(User user) {
		User euser = getUserByEmailId(user.getEmail());
		if (euser != null) {
			return euser;
		} else {
			if (createUser(user)) {
				euser = getUserByEmailId(user.getEmail());
			}
		}
		return user;
	}
}
