package com.bs.dao;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bs.model.SchedulePlan_Hibernate;
import com.bs.util.HibernateUtil;

public class SchedulePlanDAO_Hibernate {
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
	//insert
	public void insertSchedulePlan(SchedulePlan_Hibernate s) {
		sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(s);
            transaction.commit();
            System.out.println("insert schedule_plan with hibernate ok");
        } catch(HibernateException e) {
            e.printStackTrace();
            System.out.println("insert schedule_plan with hibernate fail");
        } finally {
            if(session!=null)
                session.close();
        }
	}
	
	//del
	public void deleteSchedulePlan(SchedulePlan_Hibernate s) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
//			session.delete(item);
			Query query = session.createQuery("delete from schedule_plan where id=:scheduleId");
			query.setParameter("scheduleId", s.getId());
			
			transaction.commit();
			int res = query.executeUpdate();
//			if(res>0) System.out.println("deleted");
//			else System.out.println("not delete");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//update
	public void updateSchedulePlan(SchedulePlan_Hibernate s) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(s);
//			session.update(owner); //fail
//			Query query=session.createQuery("update stallLicense set expiryDate=:expiryDate WHERE stallId=:id");
//			query.setParameter("expiryDate", stall.getLicense().getExpiryDate());
//			query.setParameter("id", stall.getStallId());
			
			transaction.commit();
//			int res = query.executeUpdate();
//			if(res>0) System.out.println("updated");
//			else System.out.println("not update");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//find by id
	public SchedulePlan_Hibernate findById(long id) {
    	sessionFactory=HibernateUtil.getSessionFactory();
    	session=sessionFactory.openSession();
    	SchedulePlan_Hibernate s=null;
    	try {
			s = (SchedulePlan_Hibernate) session.get(SchedulePlan_Hibernate.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
            if(session!=null)
                session.close();
        }
        return s;
	}
	
	//get all
	public List listAllSchedulePlan() {
    	sessionFactory=HibernateUtil.getSessionFactory();
    	session=sessionFactory.openSession();
    	transaction=session.beginTransaction();
    	List<SchedulePlan_Hibernate> list=new ArrayList<>();
    	try {
        	Query query=session.createQuery("from schedule_plan order by id ASC");
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
}
