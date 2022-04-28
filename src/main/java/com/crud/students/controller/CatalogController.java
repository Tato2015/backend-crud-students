package com.crud.students.controller;

import com.crud.students.model.Catalog;
import com.crud.students.service.CatalogService;
import com.crud.students.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public ResponseEntity<List<Catalog>> getCatalogsByDescription(@RequestParam(name = "description") String description) throws Exception{
        List<Catalog> catalogsDB = Utils.isEmpty(description) ? new ArrayList<>() : catalogService.findCatalogsByDescription(description);
        return new ResponseEntity<List<Catalog>>(catalogsDB, HttpStatus.OK);
    }


}
