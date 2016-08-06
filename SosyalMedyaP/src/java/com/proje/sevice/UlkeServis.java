package com.proje.sevice;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.proje.base.BaseService;
import com.proje.base.PHibernateUtil;
import com.proje.entity.Ulkeler;

public class UlkeServis  extends BaseService{
	
	 public Ulkeler getById() {
			Session session = PHibernateUtil.getcreateSessionFactory().openSession();	
			 Criteria criteria = session.createCriteria(Ulkeler.class);
			 criteria.add(Restrictions.eq("id", 1l));
			 return (Ulkeler) criteria.uniqueResult();
		}
}
