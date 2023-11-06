package com.example.enoca_backend_challenge_soru5.repository;

import com.example.enoca_backend_challenge_soru5.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer_Id(Long customerId);

    @Query("SELECT o FROM Order o WHERE o.createDate > :date")
    List<Order> findOrdersCreatedAfterDate(@Param("date") Date date);
}
