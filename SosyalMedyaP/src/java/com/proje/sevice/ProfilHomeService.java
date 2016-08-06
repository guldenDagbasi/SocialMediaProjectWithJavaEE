package com.proje.sevice;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.proje.base.BaseService;
import com.proje.base.PHibernateUtil;
import com.proje.entity.Kullanici;
import com.proje.entity.ProfilHome;

public class ProfilHomeService extends BaseService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
    public ProfilHome getById( Long id) {
    	System.out.println("profilservs servise geldi id:"+ id);
    	ProfilHome kul=(ProfilHome) new BaseService().getById(Kullanici.class, id);
    	
    	return kul;
    }
    public Kullanici getByUsername(String username) {
		Session session = PHibernateUtil.getcreateSessionFactory().openSession();	
		 Criteria criteria = session.createCriteria(Kullanici.class);
		 criteria.add(Restrictions.eq("adi", username));
		 return (Kullanici) criteria.uniqueResult();
	}
    public Kullanici getByMail(String mail) {
		Session session = PHibernateUtil.getcreateSessionFactory().openSession();	
		 Criteria criteria = session.createCriteria(Kullanici.class);
		 criteria.add(Restrictions.eq("mail", mail));
		 return (Kullanici) criteria.uniqueResult();
	}
    public Object save(Object obj) {
    	
    	return super.save(obj);
    }
public void deleteById(Long id) {
		
		ProfilHome silinecekKullanici =getById(id);
		try {
			delete(silinecekKullanici);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public void guncelle(Long id)
{
	ProfilHome guncellenecekKullanici =getById(id);
	Session session = PHibernateUtil.getcreateSessionFactory().openSession();
    Transaction transaction = null;
   transaction = session.beginTransaction();
    session.update(guncellenecekKullanici);
    session.flush();
    transaction.commit();

}

	

}
