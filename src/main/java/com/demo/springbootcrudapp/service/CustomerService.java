package com.demo.springbootcrudapp.service;

import com.demo.springbootcrudapp.dto.CustomerDto;
import com.demo.springbootcrudapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public interface CustomerService {

    public boolean addCustomer(CustomerDto customerDto) throws Exception;

    public boolean updateCustomer(CustomerDto customerDto) throws  Exception;

    public boolean deleteCustomer (String id) throws Exception;

    public ArrayList<CustomerDto> getAllCustomers() throws  Exception;

}
