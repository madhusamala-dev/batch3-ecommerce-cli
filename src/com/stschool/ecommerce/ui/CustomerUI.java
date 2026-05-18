package com.stschool.ecommerce.ui;

import com.stschool.ecommerce.controller.CustomerController;
import com.stschool.ecommerce.exception.CustomerExistsException;
import com.stschool.ecommerce.exception.CustomerNotFoundException;
import com.stschool.ecommerce.exception.InvalidCredentialsException;
import com.stschool.ecommerce.model.Customer;

import java.util.Scanner;

public class CustomerUI {

    public Customer registerCustomer() throws CustomerExistsException {
        System.out.println("Customer Registration Form");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id: ");
        int id = scanner.nextInt();
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter Phone: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setPhone(phone);
        scanner.close();
        CustomerController customerController = new CustomerController();
        return customerController.save(customer);

    }
    public Customer loginCustomer() throws InvalidCredentialsException, CustomerNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        CustomerController customerController = new CustomerController();
        scanner.close();
        return customerController.login(email,password);

    }
}
