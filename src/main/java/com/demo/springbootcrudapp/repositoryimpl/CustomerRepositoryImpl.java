package com.demo.springbootcrudapp.repositoryimpl;

import com.demo.springbootcrudapp.dto.CustomerDto;
import com.demo.springbootcrudapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean addCustomer(CustomerDto customerDto) throws Exception {

        String sql  = "insert into customer(id,name,address,salary) values(:id,:name,:address,:salary)";
        System.out.println("SLLLLL "+ sql);
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id",customerDto.getId());
        mapSqlParameterSource.addValue("name" , customerDto.getName());
        mapSqlParameterSource.addValue("address" , customerDto.getAddress());
        mapSqlParameterSource.addValue("salary", customerDto.getSalary());
        System.out.println(customerDto);
        System.out.println("mapSqlParameterSource "+ mapSqlParameterSource);
        return namedParameterJdbcTemplate.update(sql,mapSqlParameterSource) > 0;

    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) throws Exception {
        String sql  = "UPDATE customer SET name=:name, address=:address, salary=:salary where id=:id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id",customerDto.getId());
        mapSqlParameterSource.addValue("name" , customerDto.getName());
        mapSqlParameterSource.addValue("address" , customerDto.getAddress());
        mapSqlParameterSource.addValue("salary", customerDto.getSalary());

        return namedParameterJdbcTemplate.update(sql,mapSqlParameterSource) > 0;
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        String sql = "DELETE FROM Customer WHERE id=:id";
        System.out.println("IIIIIIIIIDDDDDDDD "+ id);
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id",id);
        return namedParameterJdbcTemplate.update(sql,mapSqlParameterSource) > 0;
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomers() throws Exception {

        String sql = "SELECT * FROM CUSTOMER";

        ArrayList<CustomerDto> customers = (ArrayList<CustomerDto>) jdbcTemplate.query(sql,new BeanPropertyRowMapper(CustomerDto.class));

        return customers;

    }
}
