package com.university.universitytesttask.helpers;

import java.util.List;

public class OutputHelper<T> {

    public String printOutPutEntities(List<T> entities){
        if(entities.isEmpty()) {
            return "";
        }
        StringBuilder resultString = new StringBuilder("\n");
        entities.forEach(item -> {
            resultString.append(item.getClass().getSimpleName()).append(": ").append(item.toString()).append(";\n");
        });

        return String.valueOf(resultString);
    }

}
