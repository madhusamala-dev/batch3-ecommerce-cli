package com.stschool.ecommerce.repository;

import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.util.CsvReader;

import java.util.List;

public class CustomerRepository {

    private List<Customer> customers;

    private CsvReader csvReader;
    public CustomerRepository(CsvReader csvReader) {
        this.csvReader = csvReader;
        this.customers = csvReader.getCustomersFromCsv();
    }

    public List<Customer> getCustomers(){
        return customers;
    }
    public Customer existsByEmail(String email){
        for(Customer customer : customers){
            if(customer.getEmail().equals(email)){
                return customer;
            }
        }
        return null;
    }

    public Customer save(Customer customer){
        this.customers.add(customer);
         return customer;
    }


}
