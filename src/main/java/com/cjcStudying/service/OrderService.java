package com.cjcStudying.service;

import com.cjcStudying.domain.Order;

import java.util.List;

public interface OrderService {

    Boolean placeOrder(Order order);

    Boolean updateOrderState(int state);

    List<Order> findAllOrder();

    Order findOrderById(String oid);
}
