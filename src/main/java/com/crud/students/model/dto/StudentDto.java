package com.crud.students.model.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true, includeFieldNames=true)
public class StudentDto implements Serializable {

    private Long studentId;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private Integer idNumber;
    private String email;
    private CatalogDto genderDto = new CatalogDto();
    private Integer phoneOne;
    private Integer phoneTwo;
    private Integer phoneReference;
    private CatalogDto maritalStatusDto = new CatalogDto();
    private String address;
    private CatalogDto countryDto = new CatalogDto();
    private CatalogDto cityDto = new CatalogDto();
    private String postalCode;
    private String other;

}
