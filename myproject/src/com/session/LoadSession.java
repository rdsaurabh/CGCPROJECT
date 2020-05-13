package com.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadSession {
	
	public static Session getSession() {
				Configuration config = new Configuration();
				config.configure();
				SessionFactory factory = config.buildSessionFactory();
				return factory.openSession();
	}

}
