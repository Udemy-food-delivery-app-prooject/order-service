package com.example.order.mapper;

import com.example.order.dto.OrderDto;
import com.example.order.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderEntity mapOrderDTOToOrder(OrderDto orderDTO);
    OrderDto mapOrderToOrderDTO(OrderEntity order);
}
