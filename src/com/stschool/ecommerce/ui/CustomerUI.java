package com.stschool.ecommerce.ui;

import com.stschool.ecommerce.controller.CustomerController;
import com.stschool.ecommerce.exception.CustomerExistsException;
import com.stschool.ecommerce.exception.CustomerNotFoundException;
import com.stschool.ecommerce.exception.InvalidCredentialsException;
import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.util.InputUtil;

import java.util.Scanner;

public class CustomerUI {
    private final CustomerController customerController;

    public CustomerUI(CustomerController customerController) {
        this.customerController = customerController;
    }

    public Customer registerCustomer() throws CustomerExistsException {
        System.out.println("Customer Registration Form");
        int id = InputUtil.getIntInput("Enter Customer ID: ");
        String name = InputUtil.getStringInput("Enter Customer Name: ");
        String email = InputUtil.getStringInput("Enter Customer Email: ");
        String password = InputUtil.getStringInput("Enter Customer Password: ");
        String phone = InputUtil.getStringInput("Enter Customer Phone: ");
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setPhone(phone);
        InputUtil.closeScanner();
         return customerController.save(customer);

    }
    public Customer loginCustomer() throws InvalidCredentialsException, CustomerNotFoundException {
        String email = InputUtil.getStringInput("Enter Customer Email: ");
        String password = InputUtil.getStringInput("Enter Customer Password: ");
        return customerController.login(email,password);

    }
}
