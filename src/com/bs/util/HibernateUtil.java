package com.bs.util;

import java.util.ResourceBundle;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	
	static {
		try {
			ResourceBundle rb = ResourceBundle.getBundle("oracle");
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.setProperty("hibernate.connection.url", rb.getString("db.url"));
			cfg.setProperty("hibernate.connection.username", rb.getString("db.username"));
			cfg.setProperty("hibernate.connection.password", rb.getString("db.password"));
			sessionFactory = cfg.buildSessionFactory();
		} catch (Throwable e) {
			// TODO: handle exception
			System.err.println("SessionFactory initial creation error."+ e);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
