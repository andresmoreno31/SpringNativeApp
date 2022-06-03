package com.globant.friday_academy.demo.controller;

import com.globant.friday_academy.demo.entity.Customer;
import com.globant.friday_academy.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable("id") Long customerNumber) {
        return Optional
                .ofNullable( customerService.findById(customerNumber) )
                .map( user -> ResponseEntity.ok().body(user) )          //200 OK
                .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        return Optional
                .ofNullable( customerService.findAll() )
                .map( user -> ResponseEntity.ok().body(user) )          //200 OK
                .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }
}
