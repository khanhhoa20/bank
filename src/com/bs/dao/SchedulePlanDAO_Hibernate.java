package com.bs.dao;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bs.model.SchedulePlan;
import com.bs.util.HibernateUtil;

public class SchedulePlanDAO_Hibernate {
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
	//insert
	public void insertSchedulePlan(SchedulePlan s) {
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
	public void deleteSchedulePlan(SchedulePlan s) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
//			session.delete(item);
			Query query = session.createQuery("delete from SchedulePlan where id=:scheduleId");
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
	public void updateSchedulePlan(SchedulePlan s) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(s);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//find by id
	public SchedulePlan findById(long id) {
    	sessionFactory=HibernateUtil.getSessionFactory();
    	session=sessionFactory.openSession();
    	SchedulePlan s=null;
    	try {
			s = (SchedulePlan) session.get(SchedulePlan.class, id);
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
    	List<SchedulePlan> list=new ArrayList<>();
    	try {
        	Query query=session.createQuery("from SchedulePlan order by id ASC");
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
