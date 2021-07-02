package com.cjcStudying.controler;

import com.cjcStudying.domain.Order;
import com.cjcStudying.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderControler {
    @Autowired
    OrderService orderService;

    /**
     * op: findAllOrder
     * num: 1
     */
    @RequestMapping("/findAllOrder")
    public String findAllOrder(@RequestParam("op")String op,
                               @RequestParam("num")String num,
                               HttpSession session,
                               HttpServletRequest request){
        if(op.equals("findAllOrder")){
            List<Order> orderList = orderService.findAllOrder();
            session.setAttribute("orderList",orderList);
        }
        return request.getContextPath()+"/admin/order/orderList.jsp";
    }
}
