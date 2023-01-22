package com.university.universitytesttask.mapper;

import com.university.universitytesttask.pojo.Lector;
import com.university.universitytesttask.pojo.enums.LectorDegree;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LectorMapper implements RowMapper<Lector> {

    @Override
    public Lector mapRow(ResultSet rs, int rowNum) throws SQLException {
        Lector lector = new Lector();
        lector.setId(rs.getInt("id"));
        lector.setDegree(LectorDegree.valueOf(rs.getString("lector_degree")));
        lector.setFirstName(rs.getString("first_name"));
        lector.setSecondName(rs.getString("second_name"));
        lector.setFatherName(rs.getString("father_name"));
        lector.setSalary(rs.getInt("salary"));
        return lector;
    }
}
