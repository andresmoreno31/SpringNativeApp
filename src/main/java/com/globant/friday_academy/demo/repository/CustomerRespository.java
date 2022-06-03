package com.globant.friday_academy.demo.repository;

import com.globant.friday_academy.demo.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class CustomerRespository implements InitializingBean {

    private Map<Long, Customer> customerMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.customerMap = new HashMap<>();
        log.info("Repository Created successfully");
    }

    public Customer save(Customer customer) {
        this.customerMap.put(customer.getCustomerId(), customer);
        return customer;
    }

    public Customer findById(Long customerId) {
        return customerMap.get(customerId);
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }
}
