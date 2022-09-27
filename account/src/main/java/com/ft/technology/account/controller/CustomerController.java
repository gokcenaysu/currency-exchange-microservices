package com.ft.technology.account.controller;

import com.ft.technology.account.request.CustomerLoginRequest;
import com.ft.technology.account.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void loginCustomer (@RequestBody CustomerLoginRequest customerLoginRequest){
        log.info("customer login {}", customerLoginRequest);
        customerService.loginCustomer(customerLoginRequest);
    }
}
