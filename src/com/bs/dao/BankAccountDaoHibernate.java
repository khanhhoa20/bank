package com.bs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bs.model.BankAccount;
import com.bs.model.BankAccountHibernateModel;
import com.bs.util.HbUtil;

public class BankAccountDaoHibernate {
	SessionFactory sessionFactory;

	public BankAccountDaoHibernate() {
		sessionFactory = HbUtil.getSessionFactory();
	}

	public void insertBankAccount(BankAccountHibernateModel accountDaoHibernate) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			session.save(accountDaoHibernate);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		

	}
	public BankAccountHibernateModel findAccount(long id)
	{
		BankAccountHibernateModel account2 = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			account2 = (BankAccountHibernateModel) session.get(BankAccountHibernateModel.class, id);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return account2;
	}

	public int updateBankAccount(BankAccountHibernateModel accountHibernateModel) {
		
		int a = 0;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			
			
			session.update(accountHibernateModel);
			transaction.commit();
			a=1;
			
		} catch (Exception e) {
			transaction.rollback();
			a=2;
			e.printStackTrace();
		}

		return a;

	}

	@SuppressWarnings("unchecked")
	public List<BankAccountHibernateModel> accounts() {
		List<BankAccountHibernateModel> list = new ArrayList<>();
		Session session = sessionFactory.openSession();
		Query query = (Query) session.createQuery("From BankAccount");
		list = query.getResultList();
		return list;
	}

	public boolean deletedBankAccount(BankAccountHibernateModel account) {
		Session session = sessionFactory.openSession();
		boolean a = false;
		Transaction transaction = session.beginTransaction();
		try {

			session.delete(account);
			a = true;

		} catch (Exception e) {
			a = false;
			transaction.rollback();
			e.printStackTrace();
		}
		return a;

	}
}
