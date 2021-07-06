package com.cjcStudying.controler;

import com.cjcStudying.domain.ShoppingCart;
import com.cjcStudying.service.ShoppingCartService;
import com.cjcStudying.utls.EncodingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartControler {

    @Autowired
    private ShoppingCartService shoppingCartService;
    /**
     * op: findShoppingCart
     * uid: 1217310874
     */
    @RequestMapping("/findShoppingCart")
    public void findShoppingCart(@RequestParam("op")String op,
                                 @RequestParam("uid")String uid,
                                 HttpServletRequest request,
                                 HttpServletResponse response){

            ShoppingCart shoppingCart = shoppingCartService.findShoppingCart(uid);
//            System.out.println(shoppingCart);
            request.setAttribute("shoppingCart",shoppingCart);
            try {
                if(op.equals("findShoppingCartByCart")){
                    request.getRequestDispatcher(request.getContextPath() + "/user/placeOrder.jsp").forward(request, response);
                }
                if(op.equals("findShoppingCart")) {
                    request.getRequestDispatcher(request.getContextPath() + "/user/shoppingcart.jsp").forward(request, response);
                }
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

//        return "forward:"+request.getContextPath()+"/user/shoppingcart.jsp";
    }

    /**
     * shoppingCart/addToShoppingCart?
     * op=addCartFromIndex addCartFromProductdetail addCartFromSearchProducts
     *      addCartFromProducts
     * pid=" + pid +
     * "&uid=" + uid;
     * sid 在创立用户时创立
     */
    @RequestMapping(value = "/addToShoppingCart",produces={"text/html;charset=UTF-8"})
    public String addToShoppingCart(@RequestParam("op")String op,
                                    @RequestParam("pid")String pid,
                                    @RequestParam("uid")String uid,
                                    String cid,
                                    String pname,
                                   HttpServletRequest request) throws UnsupportedEncodingException {
        String sid = shoppingCartService.findShoppingCartSidByUid(uid);
        Boolean flag = shoppingCartService.addShoppingItem(sid,pid);
        if(flag){
            request.setAttribute("addShoppingCartResult","添加购物车成功");
        }else {
            request.setAttribute("addShoppingCartResult","添加购物车成功");
        }
        if(op.equals("addCartFromProductdetail")){
            return "redirect:"+request.getContextPath()+"/productdetail.jsp";
        }
        if(op.equals("addCartFromSearchProducts")){
            String encode = EncodingUtils.encode(pname);
            return "redirect:"+request.getContextPath()+"/findProductsByName?op=findProductsByName&pname="+encode;
        }
        if(op.equals("addCartFromProducts")){
            return "redirect:"+request.getContextPath()+"/findProductByCid?op=findProductByCid&cid="+cid;
        }
        return "redirect:"+request.getContextPath()+"/index.jsp";
    }


}
