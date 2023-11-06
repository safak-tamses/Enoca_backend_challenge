package com.example.enoca_backend_challenge_soru5.repository;

import com.example.enoca_backend_challenge_soru5.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByOrdersIsEmpty();

    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:keyword%")
    List<Customer> findByNameLike(String keyword);
}
