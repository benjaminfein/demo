package com.example.demo.order.controller;

import com.example.demo.order.exception.OrderIdNotFoundException;
import com.example.demo.order.model.Orders;
import com.example.demo.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class OrderController {
    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Orders> findAll() {
        return orderService.findAll();
    }

    @PostMapping("/createOrder")
    public HttpStatus createOrder(@Valid @RequestBody Orders order) {
        orderService.createOrder(order);
        return HttpStatus.OK;
    }

    @PutMapping("/orders/{id}")
    public HttpStatus updateOrder(@RequestBody Orders order, @PathVariable Integer id) {
        try {
            Orders orderById = orderService.findById(id);
            orderService.updateOrder(orderById, order);
            return HttpStatus.NO_CONTENT;
        } catch (Exception ex) {
            throw new OrderIdNotFoundException("No such order by written id");
        }
    }

    @DeleteMapping("/orders/{id}")
    public HttpStatus deleteOrders(@PathVariable Integer id) {
        try {
            Orders orderById = orderService.findById(id);
            orderService.deleteOrder(orderById);
            return HttpStatus.NO_CONTENT;
        } catch (Exception ex) {
            throw new OrderIdNotFoundException("No such order by written id");
        }
    }
}
