package com.proje.sevice;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.proje.base.BaseService;
import com.proje.base.PHibernateUtil;
import com.proje.base.Sort;
import com.proje.entity.Kullanici;
import com.proje.mbean.KullaniciPage;

public class KullaniciService extends BaseService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	
	@SuppressWarnings("unchecked")
	public List<Kullanici> getAll() {
		BaseService baseService =new BaseService();
		return (List<Kullanici>) baseService.getAll(Kullanici.class);
		
	}

    public Kullanici getById( Long id) {
    	System.out.println("kullanýcý servise geldi id:"+ id);
    	Kullanici kul=(Kullanici) new BaseService().getById(Kullanici.class, id);
    	System.out.println(kul.getAdi());
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
		
		Kullanici silinecekKullanici =getById(id);
		try {
			delete(silinecekKullanici);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public void guncelle(Long id)
{
	Kullanici guncellenecekKullanici =getById(id);
	Session session = PHibernateUtil.getcreateSessionFactory().openSession();
    Transaction transaction = null;
   transaction = session.beginTransaction();
    session.update(guncellenecekKullanici);
    session.flush();
    transaction.commit();

}
@SuppressWarnings("unchecked")
public KullaniciPage getByPaging(int first, int pageSize,Map<String, Object> filters,String sortField,Sort sort) {
	Session session = PHibernateUtil.getcreateSessionFactory().openSession();		
	 Criteria criteria = session.createCriteria(Kullanici.class);
	 
	 if(filters.get("id")!=null){
		 criteria.add(Restrictions.eq("id", Long.parseLong(filters.get("id").toString())));
	 }
	 
	 if(filters.get("adi")!=null){
		 criteria.add(Restrictions.ilike("adi", filters.get("adi").toString(),MatchMode.ANYWHERE));
	 }
	 
	 if(filters.get("mail")!=null){
		 criteria.add(Restrictions.ilike("mail",filters.get("mail").toString(),MatchMode.ANYWHERE));
	 }
	 

	 criteria.setProjection(Projections.rowCount());
	 int recordCount = Integer.parseInt(criteria.uniqueResult().toString());
	 criteria.setProjection(null);
	 
	 if(sortField!=null && !sortField.equals("")){
		 if(sort==Sort.ASC)
			 criteria.addOrder(Order.asc(sortField));
		 else
			 criteria.addOrder(Order.desc(sortField));	 
	 }
	 
	 criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	 criteria.setFirstResult(first);
	 criteria.setMaxResults(pageSize);
	 return new KullaniciPage(criteria.list(), recordCount);		
}
}
