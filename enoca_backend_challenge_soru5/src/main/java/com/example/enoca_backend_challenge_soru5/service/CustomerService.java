package com.example.enoca_backend_challenge_soru5.service;

import com.example.enoca_backend_challenge_soru5.generic.GenericResponse;
import com.example.enoca_backend_challenge_soru5.model.Customer;
import com.example.enoca_backend_challenge_soru5.model.DTO.CustomerCreateRequest;
import com.example.enoca_backend_challenge_soru5.model.DTO.CustomerCreateResponse;
import com.example.enoca_backend_challenge_soru5.model.DTO.CustomerShowResponse;
import com.example.enoca_backend_challenge_soru5.model.DTO.MessageResponse;
import com.example.enoca_backend_challenge_soru5.repository.CustomerRepository;
import error.CustomerCreationException;
import error.CustomerDatebaseException;
import error.CustomerNotFoundException;
import error.OrderNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    protected Customer getCustomerById(Long id) {
        try {
            return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        } catch (Exception e) {
            throw new CustomerNotFoundException();
        }
    }

    public GenericResponse<CustomerCreateResponse> createCustomer(CustomerCreateRequest customerCreateRequest) {
        try {
            Customer customer = Customer.builder()
                    .name(customerCreateRequest.getName())
                    .age(customerCreateRequest.getAge())
                    .build();
            customerRepository.save(customer);

            return new GenericResponse<>(new CustomerCreateResponse(
                    customer.getName(),
                    customer.getAge(),
                    "Customer created successfully"
            ), Boolean.TRUE);
        } catch (Exception e) {
            throw new CustomerCreationException();
        }
    }

    public GenericResponse<CustomerShowResponse> showCustomer(Long id) {
        try {
            Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
            return new GenericResponse<>(new CustomerShowResponse(
                    customer.getName(),
                    customer.getAge()
            ), Boolean.TRUE);
        } catch (Exception e) {
            throw new CustomerNotFoundException();
        }
    }


    public GenericResponse<List<CustomerShowResponse>> showAllCustomers() {
        try {
            List<CustomerShowResponse> customerShowResponseList = customerRepository.findAll().stream()
                    .map(
                            customer -> new CustomerShowResponse(
                                    customer.getName(),
                                    customer.getAge()
                            )
                    )
                    .collect(Collectors.toList());
            return new GenericResponse<>(customerShowResponseList, Boolean.TRUE);
        } catch (Exception e) {
            throw new CustomerNotFoundException();
        }
    }

    public GenericResponse<MessageResponse> deleteCustomer(Long id) {
        try {
            Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
            customerRepository.delete(customer);
            return new GenericResponse<>(new MessageResponse(
                    "Customer deleted succesfully."
            ), Boolean.TRUE);

        } catch (Exception e) {
            throw new CustomerNotFoundException();
        }
    }

    public GenericResponse<MessageResponse> deleteAllCustomers() {
        try {
            customerRepository.deleteAll();
            return new GenericResponse<>(new MessageResponse(
                    "All customers deleted succesfully."
            ), Boolean.TRUE);
        } catch (Exception e) {
            throw new CustomerDatebaseException();
        }
    }

    public GenericResponse<List<CustomerShowResponse>> showCustomerWithoutOrder() {
        try {
            List<CustomerShowResponse> customerShowResponseList = customerRepository.findByOrdersIsEmpty().stream()
                    .map(
                            customer -> new CustomerShowResponse(
                                    customer.getName(),
                                    customer.getAge()
                            )
                    ).collect(Collectors.toList());
            return new GenericResponse<>(customerShowResponseList, Boolean.TRUE);
        } catch (Exception e) {
            throw new CustomerDatebaseException();
        }
    }

    protected List<Customer> searchCustomerAndOrdersByKeyword(String keyword) {
        try {
            return customerRepository.findByNameLike(keyword);
        } catch (Exception e) {
            throw new CustomerDatebaseException();
        }
    }
}
