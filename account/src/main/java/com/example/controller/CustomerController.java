package com.example.controller;

import com.example.model.Customer;
import com.example.request.CustomerLoginRequest;
import com.example.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/login")
    public void loginCustomer (@RequestBody CustomerLoginRequest customerLoginRequest){
        log.info("customer login {}", customerLoginRequest);
         customerService.loginCustomer(customerLoginRequest);
    }

    @GetMapping("/{id}")
    public Customer findById (@PathVariable("id") Integer id){
        log.info("Inside 'findById' of customerService");
        return customerService.findById(id);
    }
}
