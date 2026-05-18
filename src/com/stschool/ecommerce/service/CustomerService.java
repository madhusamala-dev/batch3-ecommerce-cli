package com.stschool.ecommerce.service;

import com.stschool.ecommerce.exception.CustomerExistsException;
import com.stschool.ecommerce.exception.CustomerNotFoundException;
import com.stschool.ecommerce.exception.InvalidCredentialsException;
import com.stschool.ecommerce.model.Customer;

public interface CustomerService {

    Customer save(Customer customer) throws CustomerExistsException;
    Customer login(String email, String password) throws CustomerNotFoundException, InvalidCredentialsException;
}
