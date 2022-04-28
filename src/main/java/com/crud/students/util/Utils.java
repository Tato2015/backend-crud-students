package com.crud.students.util;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static ModelMapper modelMapper = new ModelMapper();

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            return object.toString().trim().length() == 0;
        }
        if (object instanceof StringBuilder) {
            return object.toString().trim().length() == 0;
        }
        if (object instanceof List<?> || object instanceof ArrayList<?>) {
            return ((List<?>) object).isEmpty();
        }
        if (object instanceof Map<?, ?> || object instanceof HashMap<?, ?>) {
            return ((Map<?, ?>) object).isEmpty();
        }
        return false;
    }


    public static <A,B>  List<A> modelBToAList(List<B> listB , Class<?> classA){
        List<A> listD = (List<A>) listB.stream().map( v -> modelMapper.map(v,classA)).collect(Collectors.toList());
        return listD;
    }

    public static <A,B> A modelBToA (B modelB , Class<?> classA){
        A dto = (A) modelMapper.map(modelB,classA);
        return dto;
    }


}
