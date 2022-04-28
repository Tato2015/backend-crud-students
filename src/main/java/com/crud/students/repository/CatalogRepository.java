package com.crud.students.repository;

import com.crud.students.model.Catalog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatalogRepository extends GenericRepository<Catalog,Integer>{

    @Query("SELECT new Catalog(c.code,c.originCode,c.parentCode,c.description,c.shortDescription) FROM Catalog c WHERE c.originCode = (SELECT c1.code FROM Catalog c1 WHERE c1.description LIKE '%'||:description||'%') ")
    List<Catalog> findCatalogsByDescription(@Param("description") String description);

}
