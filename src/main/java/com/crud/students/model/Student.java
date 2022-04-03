package com.crud.students.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "id_number")
    private Integer idNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private Short gender;

    @Column(name = "phone_1")
    private Integer phoneOne;

    @Column(name = "phone_2")
    private Integer phoneTwo;

    @Column(name = "phone_reference")
    private Integer phoneReference;

    @Column(name = "marital_status")
    private Short maritalStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private Short country;

    @Column(name = "city")
    private Short city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "other")
    private String other;

}
