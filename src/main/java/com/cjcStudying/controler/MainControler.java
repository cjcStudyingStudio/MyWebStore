package com.cjcStudying.controler;

import com.cjcStudying.domain.Category;
import com.cjcStudying.domain.Product;
import com.cjcStudying.domain.SearchCondition;
import com.cjcStudying.service.CategoryService;
import com.cjcStudying.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class MainControler {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * op: index searchProduct
     * @return 返回商品信息
     */

    @RequestMapping("/mainProduct")
    public void mainProduct(HttpServletRequest request,
                            HttpServletResponse response,
                            HttpSession session){
//        productService.findTopProducts();
        List<Product> products = productService.findAllProduct();
        List<Category> categoryList = categoryService.findAllCategory();
        request.setAttribute("hotProducts", products);
        request.setAttribute("topProducts", products);
        session.setAttribute("categories", categoryList);
        try {
                request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * op: findProductsByName
     * pname: 天下第一
     * Search:
     */
    @RequestMapping("/findProductsByName")
    public void findProductsByName(@RequestParam("op")String op,
                                   SearchCondition searchCondition,
                                   HttpServletRequest request,
                                   HttpSession session,
                                   HttpServletResponse response) throws ServletException, IOException {
        if(op.equals("findProductsByName")) {
            List<Product> productList = productService.findProductByPname(searchCondition);
            request.setAttribute("productList",productList);
            request.getRequestDispatcher(request.getContextPath()+"/searchProducts.jsp").forward(request, response);

        }
    }

    /**
     * op: findProductByPid
     * pid: 73b5fc3b0e1f46fc883f9dae611b26b2
     */
    @RequestMapping("/findProductByPid")
    public void findProductByPid(@RequestParam("op")String op,
                                 @RequestParam("pid")String pid,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException {
        if(op.equals("findProductByPid")) {
            Product product = productService.findProductByPid(pid);
            request.setAttribute("product",product);
            request.getRequestDispatcher(request.getContextPath()+"/productdetail.jsp").forward(request, response);

        }
    }

    /**
     * op: findProductByCid
     * cid: 1
     */
    @RequestMapping("/findProductByCid")
    public void findProductByCid(@RequestParam("op")String op,
                                 SearchCondition searchCondition,
                                 HttpSession session,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException {
        if(op.equals("findProductByCid")) {
            List<Product> productList = productService.findProductByCid(searchCondition);
//            List<Category> categoryList = categoryService.findAllCategory();
            request.setAttribute("productList",productList);
//            session.setAttribute("categories", categoryList);
            request.getRequestDispatcher(request.getContextPath()+"/searchProducts.jsp").forward(request, response);
        }
    }


}
