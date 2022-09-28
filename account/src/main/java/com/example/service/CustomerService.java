package com.example.service;

import com.example.config.CustomerConfig;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.request.CustomerLoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void loginCustomer(CustomerLoginRequest loginRequest){
        Customer customer = Customer.builder()
                .email(loginRequest.email())
                .password(loginRequest.password())
                .build();

         customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );


        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
    }

    public Customer findById(Integer id){
        return customerRepository.getById(id);
    }
}
