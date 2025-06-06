package com.example.order.entity;

import com.example.order.dto.FoodItemDto;
import com.example.order.dto.RestaurantDto;
import com.example.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {

    private Integer orderId;
    private UserDto userDto;
    private RestaurantDto restaurantDto;
    private List<FoodItemDto> foodItemDtoList;
}
