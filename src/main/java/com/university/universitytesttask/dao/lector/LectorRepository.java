package com.university.universitytesttask.dao.lector;

import com.university.universitytesttask.pojo.Lector;

import java.util.List;

public interface LectorRepository {
    List<Lector> getLectors();

    List<Lector> getFilteredLectors(String template);
}
