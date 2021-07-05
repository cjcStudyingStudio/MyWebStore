package com.cjcStudying.service.imp;

import com.cjcStudying.dao.OrderDao;
import com.cjcStudying.domain.Order;
import com.cjcStudying.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public Boolean placeOrder(Order order) throws DataAccessException {
        Boolean flag = orderDao.insertOrder(order);
        return flag;
    }

    @Override
    public Boolean updateOrderState(String oid,int state) throws DataAccessException{
        Boolean flag = orderDao.updateOrderStateById(oid, state);
        return flag;
    }

    @Override
    public List<Order> findAllOrder() throws DataAccessException{
        List<Order> orders = orderDao.selectAllOrder();
        return orders;
    }

    @Override
    public Order findOrderById(String oid) throws DataAccessException{
        Order order = orderDao.selectOrderByOid(oid);
        return order;
    }

    @Override
    public Boolean delectOrder(String oid) {
        Boolean flag = orderDao.delectOrderByOid(oid);
        return flag;
    }

    @Override
    public List<Order> findOrderByUid(String uid) {
        List<Order> orderList = orderDao.selectOrderByUid(uid);
        return orderList;
    }
}
