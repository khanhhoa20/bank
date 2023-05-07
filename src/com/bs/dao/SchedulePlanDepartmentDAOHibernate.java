package com.bs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bs.model.*;
import com.bs.util.HibernateUtil;


import org.hibernate.HibernateException;
public class SchedulePlanDepartmentDAOHibernate {
//	  private final SessionFactory sessionFactory;
//
//	    public SchedulePlanDepartmentDAOHibernate(SessionFactory sessionFactory) {
//	        this.sessionFactory = sessionFactory;
//	    }

	    @SuppressWarnings("unchecked")
	    public void insert(SchedulePlanDepartment spd) {
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
	        try {
	            transaction = session.beginTransaction();
	            session.save(spd);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    

	    public void update(SchedulePlanDepartment spd) {
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
	        try {
	            transaction = session.beginTransaction();
	            session.update(spd);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }


	    public void delete(SchedulePlanDepartment spd) {
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
	        try {
	            transaction = session.beginTransaction();
	            session.delete(spd);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }


	    public SchedulePlanDepartment findById(long departmentId) {
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
	        try  {
	            return (SchedulePlanDepartment) session.get(SchedulePlanDepartment.class, departmentId);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }


	    @SuppressWarnings("unchecked")
		public List<SchedulePlanDepartment> findBySchedulePlanId(long schedulePlanId) {
	    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
	        try{
	            Query query = session.createQuery("from SchedulePlanDepartment where schedule_plan_id = :schedulePlanId");
	            query.setParameter("schedulePlanId", schedulePlanId);
	            return query.list();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}
