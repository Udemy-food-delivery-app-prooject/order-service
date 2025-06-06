package com.example.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private Integer orderId;
    private UserDto userDto;
    private RestaurantDto restaurantDto;
    private List<FoodItemDto> foodItemDtoList;
}
