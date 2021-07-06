package com.cjcStudying.service;

import com.cjcStudying.domain.Order;
import com.cjcStudying.domain.OrderItem;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface OrderService {

    Boolean placeOrder(Order order)throws DataAccessException;

    Boolean updateOrderState(String oid,int state) throws DataAccessException;

    List<Order> findAllOrder() throws DataAccessException;

    Order findOrderById(String oid) throws DataAccessException;

    Boolean deleteOrder(String oid);

    List<Order> findOrderByUid(String uid);

    Boolean placeOrderAndItems(Order order, String[] pid,Integer[] buynum);

    List<OrderItem> findOrderItemById(String oid);

    Boolean deleteOrderItemByItemid(String itemid);
}
