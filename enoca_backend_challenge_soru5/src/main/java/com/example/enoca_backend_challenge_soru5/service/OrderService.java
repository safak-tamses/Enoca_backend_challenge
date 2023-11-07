package com.example.enoca_backend_challenge_soru5.service;

import com.example.enoca_backend_challenge_soru5.error.*;
import com.example.enoca_backend_challenge_soru5.generic.GenericResponse;
import com.example.enoca_backend_challenge_soru5.model.Customer;
import com.example.enoca_backend_challenge_soru5.model.DTO.*;
import com.example.enoca_backend_challenge_soru5.model.Order;
import com.example.enoca_backend_challenge_soru5.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    public GenericResponse<OrderCreateResponse> createOrder(OrderCreateRequest orderCreateRequest) {
        try {
            Order order = Order.builder()
                    .customer(customerService.getCustomerById(orderCreateRequest.getCustomerId()))
                    .createDate(new Date())
                    .totalPrice(orderCreateRequest.getTotalPrice())
                    .build();
            orderRepository.save(order);

            return new GenericResponse<>(new OrderCreateResponse(
                    order.getCustomer().getName(),
                    order.getCreateDate(),
                    order.getTotalPrice(),
                    "Order created successfully"
            ), Boolean.TRUE);
        } catch (Exception e) {
            throw new OrderCreationException();
        }
    }

    public GenericResponse<OrderShowResponse> showOrder(Long id) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
            return new GenericResponse<>(new OrderShowResponse(
                    order.getCustomer().getName(),
                    order.getCreateDate(),
                    order.getTotalPrice()
            ), Boolean.TRUE);
        } catch (Exception e) {
            throw new OrderNotFoundException();
        }
    }

    public GenericResponse<List<OrderShowResponse>> showAllOrders() {
        try {
            List<OrderShowResponse> orderShowResponseList = orderRepository.findAll().stream()
                    .map(
                            order -> new OrderShowResponse(
                                    order.getCustomer().getName(),
                                    order.getCreateDate(),
                                    order.getTotalPrice()
                            )
                    )
                    .collect(Collectors.toList());
            return new GenericResponse<>(orderShowResponseList, Boolean.TRUE);
        } catch (Exception e) {
            throw new CustomerNotFoundException();
        }
    }

    public GenericResponse<OrderUpdateResponse> updateOrder(OrderUpdateRequest orderUpdateRequest, Long orderId) {
        try {
            Order currentOrder = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
            Customer updatedCustomer = customerService.getCustomerById(orderUpdateRequest.getCustomerId());
            currentOrder.setCustomer(updatedCustomer);
            currentOrder.setTotalPrice(orderUpdateRequest.getTotalPrice());
            currentOrder.setCreateDate(new Date());
            orderRepository.save(currentOrder);
            return new GenericResponse<>(new OrderUpdateResponse(
                    currentOrder.getCustomer().getName(),
                    currentOrder.getCreateDate(),
                    currentOrder.getTotalPrice(),
                    "Order updated successfully."
            ), Boolean.TRUE);
        } catch (Exception e) {
            throw new OrderNotFoundException();
        }
    }

    public GenericResponse<MessageResponse> deleteOrder(Long id) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
            orderRepository.delete(order);
            return new GenericResponse<>(new MessageResponse(
                    "Order deleted succesfully."
            ), Boolean.TRUE);

        } catch (Exception e) {
            throw new OrderNotFoundException();
        }
    }

    public GenericResponse<MessageResponse> deleteAllOrders() {
        try {
            orderRepository.deleteAll();
            return new GenericResponse<>(new MessageResponse(
                    "All orders deleted succesfully."
            ), Boolean.TRUE);
        } catch (Exception e) {
            throw new OrderDatabaseException();
        }
    }

    protected List<Order> showOrdersByCustomerId(Long id) {
        try {
            return orderRepository.findByCustomer_Id(id);
        } catch (Exception e) {
            throw new OrderDatabaseException();
        }
    }

    public GenericResponse<List<OrderShowResponse>> listOrdersCreatedAfterDate(Date date) {
        try {
            List<OrderShowResponse> orderShowResponseList = orderRepository.findOrdersCreatedAfterDate(date).stream()
                    .map(
                            order -> new OrderShowResponse(
                                    order.getCustomer().getName(),
                                    order.getCreateDate(),
                                    order.getTotalPrice()
                            )
                    ).toList();

            return new GenericResponse<>(orderShowResponseList, Boolean.TRUE);
        } catch (Exception e) {
            throw new CustomerDatebaseException();
        }

    }
}
