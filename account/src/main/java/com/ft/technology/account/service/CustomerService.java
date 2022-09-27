package com.ft.technology.account.service;

import com.ft.technology.account.model.Customer;
import com.ft.technology.account.repository.CustomerRepository;
import com.ft.technology.account.request.CustomerLoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void loginCustomer(CustomerLoginRequest loginRequest){
        Customer customer = Customer.builder()
                .email(loginRequest.email())
                .password(loginRequest.password())
                .build();

        customerRepository.saveAndFlush(customer);

    }
}
