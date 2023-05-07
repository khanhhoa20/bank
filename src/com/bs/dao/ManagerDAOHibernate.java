package com.bs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bs.model.Manager;
import com.bs.util.HibernateUtil;

public class ManagerDAOHibernate {
	public void insert(Manager manager) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(manager);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session!=null) {
				session.close();
			}
		}
	}
	
	public Manager findById(Long id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Manager manager = null;
		try {
			manager = (Manager) session.get(Manager.class, id);
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session!=null) {
				session.close();
			}
		}
		return manager;
	}
	
	public void update(Manager manager) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(manager);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session!=null) {
				session.close();
			}
		}
	}
	
	public List<Manager> list() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Manager> list = new ArrayList<>();
		try {
			Query query = session.createQuery("from Manager");
			list = (List<Manager>) query.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session!=null) {
				session.close();
			}
		}
		return list;
	}
	
	public void delete(Manager manager) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(manager);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session!=null) {
				session.close();
			}
		}
	}
}


