package com.proje.base;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.proje.entity.Kullanici;

public class BaseService {
	public List getAll(Class cls) {
        Session session = PHibernateUtil.getcreateSessionFactory().openSession();
        Criteria crtr = session.createCriteria(cls);
        List l= crtr.list();
        return l;
    }
	public List getAllFoto(Class cls,Long id) {
        Session session = PHibernateUtil.getcreateSessionFactory().openSession();
        Criteria crtr = session.createCriteria(cls);
        crtr.add(Restrictions.eq("kullanici_id", id));
        List l= crtr.list();
        return l;
    }
    public Object getById(Class cls,Long id) {
    	System.out.println("baseservisegeldi");
    	 Session session = PHibernateUtil.getcreateSessionFactory().openSession();
         Criteria crtr = session.createCriteria(cls);
         crtr.add(Restrictions.eq("id", id));
         //crtr.add(Restrictions.ilike("kitap.isbn", "234",MatchMode.ANYWHERE));
         Object o= crtr.uniqueResult();
         return o;
    }

    public Object save(Object obj)  {
        Session session = PHibernateUtil.getcreateSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        return obj;
    }

    public Boolean delete(Object obj){
        Session session = PHibernateUtil.getcreateSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        return true;
    }

    public Object update(Object obj)  {
        Session session = PHibernateUtil.getcreateSessionFactory().openSession();
        Transaction transaction = null;
       transaction = session.beginTransaction();
        session.update(obj);
        session.flush();
        transaction.commit();
        return obj;
    }
   
	
}
