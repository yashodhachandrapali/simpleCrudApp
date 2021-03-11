package com.demo.springbootcrudapp.serviceimpl;

import com.demo.springbootcrudapp.dto.CustomerDto;
import com.demo.springbootcrudapp.repository.CustomerRepository;
import com.demo.springbootcrudapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean addCustomer(CustomerDto customerDto) throws Exception {
        return customerRepository.addCustomer(customerDto);
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) throws Exception {
        return customerRepository.updateCustomer(customerDto);
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomers() throws Exception {
        return customerRepository.getAllCustomers();
    }
}
