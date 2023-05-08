package com.bs.dao;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bs.model.Customer;
import com.bs.util.HibernateUtil;

public class CustomerDAOHibernate {
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;

	//get all
	public List listAllCustomer() {
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		List<Customer> list=new ArrayList<>();
		try {
			Query query=session.createQuery("from Customer order by id ASC");
			list = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return list;
	}

	//insert
	public void insertCustomer(Customer c) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.save(c);
			transaction.commit();
			System.out.println("insert customer with hibernate ok");
		} catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("insert customer with hibernate fail");
		} finally {
			if(session!=null)
				session.close();
		}
	}

	//update
	public void updateCustomer(Customer c) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(c);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	//delele
	public void deleteCustomer(Customer c) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			//				session.delete(item);
			Query query = session.createQuery("delete from customer where id=:cusId");
			query.setParameter("cusId", c.getId());

			transaction.commit();
			int res = query.executeUpdate();
			//				if(res>0) System.out.println("deleted");
			//				else System.out.println("not delete");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	//find by id
	public Customer findById(long id) {
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
		Customer c=null;
		try {
			c = (Customer) session.get(Customer.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return c;
	}
}
