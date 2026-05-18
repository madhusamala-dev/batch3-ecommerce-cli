package com.stschool.ecommerce.util;

import com.stschool.ecommerce.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {



    public List<Customer> getCustomersFromCsv()  {

        List<Customer> customers = new ArrayList<>();
        /*
        1. BufferedReader
        2. Each line is a customers
        3. add customer to list
         */
        try{
            BufferedReader br = new BufferedReader(new FileReader("D://customers-data.csv"));
            /*System.out.println( br.readLine());
            System.out.println(br.readLine());*/
            br.readLine();
            String customerData = br.readLine();
            while(customerData != null){
                String[] data = customerData.split(",");
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(data[0]));
                customer.setName(data[1]);
                customer.setEmail(data[2]);
                customer.setPassword(data[3]);
                customer.setPhone(data[4]);
                customers.add(customer);
                customerData = br.readLine();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return customers;
    }
}
