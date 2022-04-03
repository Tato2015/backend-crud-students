package com.crud.students.service;

import java.util.List;

public interface GenericCrud<T,ID> {

    T save(T t) throws Exception;

    T update(T t) throws Exception;

    List<T> getAll() throws Exception;

    T getAllById(ID id) throws Exception;

    void delete(ID id) throws Exception;

}
