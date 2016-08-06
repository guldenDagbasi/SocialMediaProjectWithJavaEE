package com.proje.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> extends Serializable {
    
public List<T> getAll();
    
    public T getById(Long id);
    
    public T save(T obj) ;
    
    public Boolean delete(T obj) ;
    
    public T update(T obj) ;
    
}
