package com.demo.springbootcrudapp.controller;

import com.demo.springbootcrudapp.dto.CustomerDto;
import com.demo.springbootcrudapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping(value = "/savecustomer/{customerdto}")
        public boolean saveCustomer(@RequestBody CustomerDto customerdto) {
        System.out.println("Add Customersssssss");
        boolean addCustomer =false;
        try {
             addCustomer =  customerService.addCustomer(customerdto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  return "redirect:/product/" + product.getId();
        return  addCustomer;
        }


    @PostMapping(value = "/editcustomer/{customerdto}")
    public boolean editCustomer(@RequestBody CustomerDto customerdto){

           // model.addAttribute("customer", customerService.updateCustomer(model));
        boolean updateCustomer = false;
        try {
            updateCustomer = customerService.updateCustomer(customerdto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updateCustomer;
        }

    @DeleteMapping (value = "/deleteCustomer/{id}")
    public boolean deleteCustomer(@PathVariable String id){
        System.out.println("idddddddddddddd "+ id);
        boolean addCustomer = false;
        try {
        addCustomer  =  customerService.deleteCustomer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addCustomer;
        }


    @GetMapping (value = "/getAllCustomer")
    public List<CustomerDto> getAllCustomer() {
        ArrayList<CustomerDto> customers = null;
        try {
            customers = customerService.getAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}
