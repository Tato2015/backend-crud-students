package com.crud.students.service.impl;

import com.crud.students.repository.GenericRepository;
import com.crud.students.service.GenericCrud;

import java.util.List;

public abstract class GenericCrudImpl<T,ID> implements GenericCrud<T,ID> {

    protected abstract GenericRepository<T,ID> getRepo();

    @Override
    public T save(T t) throws Exception{
        return getRepo().save(t);
    }

    @Override
    public T update(T t) throws Exception{
        return getRepo().save(t);
    }

    @Override
    public List<T> getAll() throws Exception{
        return getRepo().findAll();
    }

    @Override
    public T getAllById(ID id) throws Exception{
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception{
        getRepo().deleteById(id);
    }


}
