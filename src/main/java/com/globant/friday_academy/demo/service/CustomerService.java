package com.globant.friday_academy.demo.service;

import com.globant.friday_academy.demo.entity.Customer;
import com.globant.friday_academy.demo.repository.CustomerRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRespository customerRespository;

    public Customer save(Customer customer) {
        log.info("Save Customer: {}", customer);
        return this.customerRespository.save(customer);
    }

    public List<Customer> findAll() {
        log.info("Find All Customers");
        return this.customerRespository.findAll();
    }

    public Customer findById(Long customerId) {
        log.info("Find by Id Customer: {}", customerId);
        return this.customerRespository.findById(customerId);
    }
}