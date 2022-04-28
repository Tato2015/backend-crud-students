package com.crud.students.service.impl;

import com.crud.students.exception.CustomizedException;
import com.crud.students.model.Catalog;
import com.crud.students.repository.CatalogRepository;
import com.crud.students.repository.GenericRepository;
import com.crud.students.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl extends GenericCrudImpl<Catalog,Integer> implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    protected GenericRepository<Catalog, Integer> getRepo() {
        return catalogRepository;
    }


    @Override
    public List<Catalog> findCatalogsByDescription(String description) throws Exception{
        try {
            return catalogRepository.findCatalogsByDescription(description);
        }catch(Exception e){
            throw new CustomizedException("Error findCatalogsByDescription");
        }

    }
}
