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

	public BankAccount updateBankAccount(BankAccount account) {
		BankAccount account2 = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			session.update(account);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return account2;

	}

	@SuppressWarnings("unchecked")
	public List<BankAccount> accounts() {
		List<BankAccount> list = new ArrayList<>();
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
