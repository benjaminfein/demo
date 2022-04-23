package com.example.demo.order.service;

import com.example.demo.order.model.Orders;
import com.example.demo.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Validated
@Service
public class OrderService {
    private static Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    public OrderRepository orderRepository;

    public List<Orders> findAll() {
return orderRepository.findAll();
    }

    public void createOrder(Orders order) {
        log.info("I'm creating order" + order);
        orderRepository.save(order);
    }

    public Orders findById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such order by id: " + id));
    }

    public void updateOrder(Orders exitingOrder, Orders orderForUpdate) {
        exitingOrder.setId(orderForUpdate.getId());
        exitingOrder.setCreatedDate(orderForUpdate.getCreatedDate());
        exitingOrder.setProductCount(orderForUpdate.getProductCount());
        exitingOrder.setPrice(orderForUpdate.getPrice());
        orderRepository.save(exitingOrder);
    }

    public void deleteOrder(Orders orderForDeletion) {
        orderRepository.delete(orderForDeletion);
    }

    @Scheduled(fixedDelay = 5000)
    public void clearAllExpiredOrderByCreatedDate() {
        orderRepository.findAll().stream()
                .filter(deletingOrder -> deletingOrder.getCreatedDate().isBefore(LocalDate.now().minusDays(2)))
                .forEach(this::deleteOrder);
    }
}
