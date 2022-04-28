package com.crud.students.service;

import com.crud.students.model.Catalog;

import java.util.List;

public interface CatalogService extends GenericCrud<Catalog,Integer>{

    public List<Catalog> findCatalogsByDescription(String description) throws Exception;

}
