package com.cjcStudying.controler;

import com.cjcStudying.domain.Product;
import com.cjcStudying.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductControler {

    @Autowired
    ProductService productService;

    /**
     * op: findProductsByName
     * pname: shoes
     * Search:
     */
    @RequestMapping("/findProductByPName")
    public void findProduct(@RequestParam("op")String op,
                            @RequestParam("pname")String pname){
        if(op.equals("op")) {
            Product product = productService.findProduct(pname);
            if(product!=null){

            }
        }
    }

    /**
     *
     * @param ajax findProductsHintByName
     * @param key keyword
     * @Returen 返回查到的商品
     */
    @RequestMapping("/ajaxFindProductsHintByName")
    public void ajaxFindProductsHintByName(@RequestParam("ajax")String ajax,
                                           @RequestParam("key")String key,
                                           HttpServletResponse response){
        if(ajax.equals("op")) {
            Product product = productService.findProduct(key.trim());
            if(product!=null){
                try {
                    response.getWriter().println(product);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * @return 返回商品信息
     */

    @RequestMapping("/mainProduct")
    public void mainProduct(HttpServletRequest request,
                                HttpServletResponse response){
//        productService.findTopProducts();
        List<Product> products = productService.findAllProduct();
        request.setAttribute("hotProducts", products);
        request.setAttribute("topProducts", products);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param op
     * @param response
     */
    @RequestMapping("/findProductsByName")
    public void findProductsByName(@RequestParam("op")String op,
                                   @RequestParam("num")String num,
                                   Product product,
                                   HttpServletRequest request,
                                   HttpServletResponse response){
        if(op.equals("op")) {
            //首页进来num为null num变为1
            if (null == num || num.isEmpty() || "0".equals(num)) num = "1";
            try {
                request.getRequestDispatcher("/searchProducts.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
