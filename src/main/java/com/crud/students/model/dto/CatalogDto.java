package com.crud.students.model.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true, includeFieldNames=true)
public class CatalogDto implements Serializable {

    private Long code;
    private Integer originCode;
    private Integer parentCode;
    private String description;
    private String shortDescription;


}
