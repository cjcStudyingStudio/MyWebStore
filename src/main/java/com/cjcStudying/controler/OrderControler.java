package com.cjcStudying.controler;

import com.cjcStudying.domain.Order;
import com.cjcStudying.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    /**
     * op: delOrder
     * oid: QWEQRTT4581
     */
    @RequestMapping("/delOrder")
    public void delOrder(@RequestParam("op")String op,
                         @RequestParam("oid")String oid,
                            HttpServletResponse response,
                            HttpServletRequest request){
        if(op.equals("delOrder")){
            try {
                response.setContentType("text/html;charset=utf-8");
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                Boolean flag = orderService.delectOrder(oid);
                if(flag){
                    response.getWriter().println("删除成功！");
                }else {
                    response.getWriter().println("删除失败！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * op: orderDetail
     * oid: QWEQRTT458
     */
    @RequestMapping("/orderDetail")
    public String orderDetail(@RequestParam("op")String op,
                               @RequestParam("oid")String oid,
                               HttpSession session,
                               HttpServletRequest request){
        if(op.equals("orderDetail")){
            Order order = orderService.findOrderById(oid);
            session.setAttribute("order",order);
        }
        return request.getContextPath()+"/admin/order/orderDetails.jsp";
    }

    /**
     * op: myoid
     * uid: 1
     */
    @RequestMapping("/myOrder")
    public String myOrder(@RequestParam("op")String op,
                          @RequestParam("uid")String uid,
                          HttpServletRequest request){
        if(op.equals("myoid")){
            List<Order> orderList = orderService.findOrderByUid(uid);
            request.setAttribute("orders",orderList);
        }
        return "forward:"+request.getContextPath()+"/user/myOrders.jsp";
    }

    /**
     * op: cancelOrder
     * oid: 1232458
     * state: 0
     */
    @RequestMapping("/cancelOrder")
    public void cancelOrder(@RequestParam("op")String op,
                            @RequestParam("oid")String oid,
                              @RequestParam("state")Integer state,
                          HttpServletResponse response){
        if(op.equals("cancelOrder")){
            Boolean flag = orderService.updateOrderState(oid, state);
            try {
                if(flag){
                    response.getWriter().println("订单已取消！");
                }else {
                    response.getWriter().println("订单未取消，请稍后再试！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
