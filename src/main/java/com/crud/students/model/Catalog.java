package com.crud.students.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Long code;

    @Column(name = "origin_code")
    private Integer originCode;

    @Column(name = "parent_code")
    private Integer parentCode;

    @Column(name = "description")
    private String description;

    @Column(name = "short_description")
    private String shortDescription;

}
