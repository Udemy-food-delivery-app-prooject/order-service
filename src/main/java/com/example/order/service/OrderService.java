package com.example.order.service;

import com.example.order.config.RestTemplateConfig;
import com.example.order.dto.OrderDto;
import com.example.order.dto.OrderDtoFrontEnd;
import com.example.order.dto.UserDto;
import com.example.order.entity.OrderEntity;
import com.example.order.mapper.OrderMapper;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplateConfig restTemplate;

    public OrderDto saveOrder(OrderDtoFrontEnd orderDtoFrontEnd) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        OrderEntity orderEntity = OrderEntity.builder()
                .orderId(newOrderId)
                .userDto(fetchUserDetails(orderDtoFrontEnd.getUserId()))
                .restaurantDto(orderDtoFrontEnd.getRestaurantDto())
                .foodItemDtoList(orderDtoFrontEnd.getFoodItemDtoList())
                .build();
        orderRepository.save(orderEntity);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderEntity);
    }

    public UserDto fetchUserDetails(int userId) {
        return restTemplate.restTemplate().getForObject("http://USER-SERVICE/api/user/" + userId, UserDto.class);
    }
}
