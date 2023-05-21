package com.bs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bs.model.Customer;
import com.bs.util.HibernateUtil;

public class CustomerDAOHibernate {
	SessionFactory sessionFactory;

	public CustomerDAOHibernate() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> customers() {
		List<Customer> list = new ArrayList<>();
		Session session = sessionFactory.openSession();
		Query query = (Query) session.createQuery("From customer");
		list = query.getResultList();
		return list;
	}

	//	insert customer
	public void insertCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			session.save(customer);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}



	}

	//	update customer
	public void updateCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(customer);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	//	delete customer
	public boolean deletedCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		boolean a = false;
		Transaction transaction = session.beginTransaction();
		try {

			session.delete(customer);
			a = true;

		} catch (Exception e) {
			a = false;
			transaction.rollback();
			e.printStackTrace();
		}
		return a;

	}
	
//	find by id
	public Customer findCustomerById(long id)
	{
		Customer cus2 = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			cus2 = (Customer) session.get(Customer.class, id);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return cus2;
	}


}
