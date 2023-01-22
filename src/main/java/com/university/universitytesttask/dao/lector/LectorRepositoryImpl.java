package com.university.universitytesttask.dao.lector;

import com.university.universitytesttask.mapper.LectorMapper;
import com.university.universitytesttask.pojo.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class LectorRepositoryImpl implements LectorRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Lector> getLectors() {
        String SQL = "SELECT * FROM lector";
        return jdbcTemplate.query(SQL, new LectorMapper());
    }
    @Override
    public List<Lector> getFilteredLectors(String template) {
        String SQL = "SELECT * FROM lector WHERE " +
                "lower(first_name) ~ lower(?) OR " +
                "lower(second_name) ~ lower(?) OR " +
                "lower(father_name) ~ lower(?)";

        List<Lector> filteredLectors;
        try{
            filteredLectors = jdbcTemplate.query(SQL, new LectorMapper(), template, template, template);

            return filteredLectors;
        } catch (Exception ex){
            return new ArrayList<>();
        }
    }
}
