package com.srishti.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srishti.orderservice.dto.OrderLineItemDto;
import com.srishti.orderservice.dto.OrderRequest;
import com.srishti.orderservice.model.Order;
import com.srishti.orderservice.model.OrderLineItem;
import com.srishti.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    
    public void placeOrder(OrderRequest orderRequest) {

        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItemsDtos()
        .stream()
        .map(orderLineItemDto -> mapToOrderLineItem(orderLineItemDto))
                .toList();

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsList(orderLineItems)
                .build();

        orderRepository.save(order);
    }

    private OrderLineItem mapToOrderLineItem(OrderLineItemDto orderLineItemDto) {
        return OrderLineItem.builder()
                .skuCode(orderLineItemDto.getSkuCode())
                .price(orderLineItemDto.getPrice())
                .quantity(orderLineItemDto.getQuantity())
                .build();
    }
}
