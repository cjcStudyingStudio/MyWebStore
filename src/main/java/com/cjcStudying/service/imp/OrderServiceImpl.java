package com.cjcStudying.service.imp;

import com.cjcStudying.dao.OrderDao;
import com.cjcStudying.domain.Order;
import com.cjcStudying.domain.OrderItem;
import com.cjcStudying.service.OrderService;
import com.cjcStudying.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    ShoppingCartService shoppingCartService;

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

    @Transactional
    @Override
    public Boolean placeOrderAndItems(Order order, String[] pid) {
        Boolean result = true;
        Boolean flag1 = false;
        Boolean flag2 = false;
        Boolean flag3 = false;
        if(pid!=null&&order!=null){
            //Oid 一个 item 多个  一对多
            flag1 = orderDao.insertOrder(order);
            result = flag1&result;
            for (String p:pid
                 ) {

                OrderItem orderItem = new OrderItem();
                orderItem.setOid(order.getOid());
                orderItem.setPid(p);

                flag2 = orderDao.insertItem(orderItem);
                result = flag2&result;

                String sid = shoppingCartService.findShoppingCartSidByUid(order.getUid());
                flag3 = shoppingCartService.deleteShoppingCartItemByPidAndSid(p,sid);
                result = flag3&result;
            }

        }else {
            return false;
        }
        return result;
    }
}
