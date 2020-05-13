package com.easyclean.easycleanAPI.controller;

import com.easyclean.easycleanAPI.model.Customer;
import com.easyclean.easycleanAPI.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@Slf4j
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<Customer> listaCustomer() {
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        log.info("Gravando dados do cliente {}", customer.getName());
        return customerRepository.save(customer);
    }
}

