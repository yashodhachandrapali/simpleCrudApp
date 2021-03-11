package com.demo.springbootcrudapp.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerDto {
    private  String  id;
    private String name;
    private String address;
    private double salary;
}
