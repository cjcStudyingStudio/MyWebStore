package com.cjcStudying.controler;

import com.cjcStudying.domain.Category;
import com.cjcStudying.domain.Product;
import com.cjcStudying.domain.SearchCondition;
import com.cjcStudying.service.CategoryService;
import com.cjcStudying.service.ProductService;
import com.cjcStudying.service.ShoppingCartService;
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

    @Autowired
    private ShoppingCartService shoppingCartService;

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
            request.getRequestDispatcher(request.getContextPath()+"/products.jsp").forward(request, response);
        }
    }

    /**
     * op: delItem
     * uid: 1217310874
     * itemid: 1945054959
     */
    @RequestMapping("/delItem")
    public String delItem(@RequestParam("op")String op,
                          @RequestParam("uid")String uid,
                          @RequestParam("itemid")String itemid,
                          HttpServletRequest request){
        Boolean flag = shoppingCartService.deleteItemByUidAndItemid(uid,itemid);
        if(flag){
            request.setAttribute("addShoppingCartResult","从购物车移除成功");
        }else {
            request.setAttribute("addShoppingCartResult","发生位置错误，请稍后再试！");
        }
        return "redirect:"+request.getContextPath()+"shoppingCart/findShoppingCart?op=findShoppingCart&uid="+uid;
    }

    //实现分页

//    @RequestMapping(value = "pageinfo", method = RequestMethod.GET)
//    public PageInfo<Product> getPageInfo(int pageNum, int pageSize) {
//        /*
//        1.通过调用PageHelper的静态方法开始获取分页数据
//        pageNum: 当前第几页,
//        pageSize:每页多少条数
//        * */
//        PageHelper.startPage(pageNum, pageSize);
//        //2.获取所有的数据
//        List<Product> list = productService.getAll();
//        //3.获取当前分页对象
//        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
//        return pageInfo;
//    }

}
