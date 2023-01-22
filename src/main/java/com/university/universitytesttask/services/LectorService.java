package com.university.universitytesttask.services;

import com.university.universitytesttask.dao.lector.LectorRepository;
import com.university.universitytesttask.pojo.Lector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LectorService {
    @Autowired
    LectorRepository lectorRepository;

    // search the lectors is conducted by firstName, secondName and fatherName
    public List<Lector> getFilteredLectors(String template){
        return lectorRepository.getFilteredLectors(template);
    }

    public List<Lector> getAllLectors() {
        return lectorRepository.getLectors();
    }
}
