package com.cjcStudying.controler;

import com.cjcStudying.domain.Product;
import com.cjcStudying.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
