package com.example.order.controller;

import com.example.order.dto.OrderDto;
import com.example.order.dto.OrderDtoFrontEnd;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFrontEnd orderDtoFrontEnd) {
        return new ResponseEntity<>(orderService.saveOrder(orderDtoFrontEnd), HttpStatus.CREATED);
    }
}
