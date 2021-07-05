package com.cjcStudying.controler;

import com.cjcStudying.domain.ShoppingCart;
import com.cjcStudying.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartControler {

    @Autowired
    private ShoppingCartService shoppingCartService;
    /**
     * op: findCart
     *
     *
     */
    @RequestMapping("/findShoppingCart")
    public String findShoppingCart(@RequestParam("op")String op,
                                 HttpServletRequest request){
        if(op.equals("findCart")){
            ShoppingCart shoppingCart = shoppingCartService.findShoppingCart();
            request.setAttribute("shoppingCart",shoppingCart);
        }
        return "forward:"+request.getContextPath()+"/user/shoppingcart.jsp";
    }

    /**
     * shoppingCart/addToShoppingCart?
     * op=addCartFromIndex
     * pid=" + pid +
     * "&uid=" + uid;
     * sid 在创立用户时创立
     */
    @RequestMapping("/addToShoppingCart")
    public String addToShoppingCart(@RequestParam("op")String op,
                                    @RequestParam("pid")String pid,
                                    @RequestParam("uid")String uid,
                                   HttpServletRequest request){
        String sid = shoppingCartService.findShoppingCartSidByUid(uid);
        Boolean flag = shoppingCartService.addShoppingItem(sid,pid);
        if(flag){
            request.setAttribute("addShoppingCartResult","添加购物车成功");
        }else {
            request.setAttribute("addShoppingCartResult","添加购物车成功");
        }
        if(op.equals("addCartFromIndex")){

        }
        return "redirect:"+request.getContextPath()+"/index.jsp";
    }
}
