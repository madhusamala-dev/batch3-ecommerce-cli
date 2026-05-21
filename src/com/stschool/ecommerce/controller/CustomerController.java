package com.stschool.ecommerce.controller;

import com.stschool.ecommerce.exception.CustomerExistsException;
import com.stschool.ecommerce.exception.CustomerNotFoundException;
import com.stschool.ecommerce.exception.InvalidCredentialsException;
import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.service.CustomerService;
import com.stschool.ecommerce.service.CustomerServiceImpl;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistsException {

        return customerService.save(customer);


    }

    public Customer login(String email, String password) throws InvalidCredentialsException, CustomerNotFoundException {
         return customerService.login(email,password);
    }
}
