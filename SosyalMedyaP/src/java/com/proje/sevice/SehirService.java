package com.proje.sevice;

import java.util.List;

import com.proje.base.BaseService;
import com.proje.base.IBaseService;
import com.proje.entity.Sehir;

public class SehirService  implements IBaseService<Sehir>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Sehir> getAll() {
		BaseService baseService=new BaseService();
		return (List<Sehir>) baseService.getAll(Sehir.class);
	}

	@Override
	public Sehir getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sehir save(Sehir obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Sehir obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sehir update(Sehir obj) {
		// TODO Auto-generated method stub
		return null;
	}
	

   
}
