package com.crud.students.service.impl;

import com.crud.students.exception.CustomizedException;
import com.crud.students.model.Catalog;
import com.crud.students.model.Student;
import com.crud.students.model.dto.StudentDto;
import com.crud.students.repository.CatalogRepository;
import com.crud.students.repository.GenericRepository;
import com.crud.students.repository.StudentRepository;
import com.crud.students.service.StudentService;
import com.crud.students.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl extends GenericCrudImpl<Student,Long> implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    protected GenericRepository<Student, Long> getRepo() {
        return studentRepository;
    }

    @Override
    public List<StudentDto> getStudentsDto() throws Exception {
        Optional<List<Student>> studentsDB = Optional.ofNullable(getAll());
        if(!studentsDB.isPresent()) throw new CustomizedException("There aren't students in database");
        Optional<List<Catalog>> countriesDB = Optional.ofNullable(catalogRepository.findCatalogsByDescription("COUNTRY"));
        if(!countriesDB.isPresent()) throw new CustomizedException("There aren't countries in database");
        Optional<List<Catalog>> maritalStatusDB = Optional.ofNullable(catalogRepository.findCatalogsByDescription("MARITAL STATUS"));
        if(!maritalStatusDB.isPresent()) throw new CustomizedException("There aren't marital status in database");
        Optional<List<Catalog>> gendersDB = Optional.ofNullable(catalogRepository.findCatalogsByDescription("GENDER"));
        if(!gendersDB.isPresent()) throw new CustomizedException("There aren't genders in database");
        Optional<List<Catalog>> citiesDB = Optional.ofNullable(catalogRepository.findCatalogsByDescription("CITY"));
        if(!citiesDB.isPresent()) throw new CustomizedException("There aren't cities in database");

        List<StudentDto> studentsDto = Utils.modelBToAList(studentsDB.get(),StudentDto.class);

        studentsDto.stream()
                .forEach( dto -> studentsDB.get()
                        .stream()
                        .filter( db -> db.getStudentId() == dto.getStudentId() )
                        .forEach( data ->{
                            dto.getCountryDto().setCode(data.getCountry().longValue());
                            dto.getGenderDto().setCode(data.getGender().longValue());
                            dto.getMaritalStatusDto().setCode(data.getMaritalStatus().longValue());
                            dto.getCityDto().setCode(data.getCity().longValue());
                        }));

        studentsDto.stream()
                .forEach( dto -> countriesDB.get()
                        .stream()
                        .filter( countryDB -> countryDB.getCode() == dto.getCountryDto().getCode())
                        .forEach( data -> {
                           dto.getCountryDto().setOriginCode(data.getOriginCode());
                           dto.getCountryDto().setParentCode(data.getParentCode());
                           dto.getCountryDto().setDescription(data.getDescription());
                           dto.getCountryDto().setShortDescription(data.getShortDescription());
                        }));

        studentsDto.stream()
                .forEach( dto -> maritalStatusDB.get()
                        .stream()
                        .filter( maritalStatusDb -> maritalStatusDb.getCode() == dto.getMaritalStatusDto().getCode())
                        .forEach( data -> {
                          dto.getMaritalStatusDto().setOriginCode(data.getOriginCode());
                          dto.getMaritalStatusDto().setParentCode(data.getParentCode());
                          dto.getMaritalStatusDto().setDescription(data.getDescription());
                          dto.getMaritalStatusDto().setShortDescription(data.getShortDescription());
                        }));

        studentsDto.stream()
                .forEach( dto -> gendersDB.get()
                        .stream()
                        .filter( genderDB -> genderDB.getCode() == dto.getGenderDto().getCode())
                        .forEach( data -> {
                          dto.getGenderDto().setOriginCode(data.getOriginCode());
                          dto.getGenderDto().setParentCode(data.getParentCode());
                          dto.getGenderDto().setDescription(data.getDescription());
                          dto.getGenderDto().setShortDescription(data.getShortDescription());
                        }));

        studentsDto.stream()
                .forEach( dto -> citiesDB.get()
                        .stream()
                        .filter( cityDB -> cityDB.getCode() == dto.getCityDto().getCode())
                        .forEach( data-> {
                            dto.getCityDto().setOriginCode(data.getOriginCode());
                            dto.getCityDto().setParentCode(data.getParentCode());
                            dto.getCityDto().setDescription(data.getDescription());
                            dto.getCityDto().setShortDescription(data.getShortDescription());
                        }));

        return studentsDto;
    }
}
