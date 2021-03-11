package com.demo.springbootcrudapp.repository;

import com.demo.springbootcrudapp.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerRepository {

    public boolean addCustomer(CustomerDto customerDto) throws Exception;

    public boolean updateCustomer(CustomerDto customerDto) throws  Exception;

    public boolean deleteCustomer (String id) throws Exception;

    public ArrayList<CustomerDto> getAllCustomers() throws  Exception;
}
