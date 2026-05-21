package com.stschool.ecommerce.service;

import com.stschool.ecommerce.exception.CustomerExistsException;
import com.stschool.ecommerce.exception.CustomerNotFoundException;
import com.stschool.ecommerce.exception.InvalidCredentialsException;
import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.repository.CustomerRepository;
import com.stschool.ecommerce.util.CsvReader;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }



    @Override
    public Customer save(Customer customer) throws CustomerExistsException {
        /*
        1. check if customer exists
        2. if exist then throw exception
        3. if not exist then save customer

         */
        if(customerRepository.existsByEmail(customer.getEmail()) != null)
            throw new CustomerExistsException("Customer already exists with email: " + customer.getEmail());

        return customerRepository.save(customer);
    }

    @Override
    public Customer login(String email, String password) throws CustomerNotFoundException, InvalidCredentialsException {
        Customer existingCustomer = customerRepository.existsByEmail(email);
        if(existingCustomer == null)
            throw new CustomerNotFoundException("Customer not found with email: " + email);
        if(existingCustomer.getPassword().equals(password))
        return existingCustomer;
        else
            throw new InvalidCredentialsException("Invalid password");
    }
}
