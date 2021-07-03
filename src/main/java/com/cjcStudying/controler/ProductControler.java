package com.cjcStudying.controler;

import com.cjcStudying.domain.Product;
import com.cjcStudying.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    /**
     * cid
     * pNum 321
     * pname 天下第一
     * eStorePrice 2131
     * markPrice 12322
     * imgurl
     * desc 天下第一
     */
    @RequestMapping("/addProduct")
    public ModelAndView addCategory(Product product,
                                    ModelAndView modelAndView,
                                    MultipartFile imgurl,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        modelAndView.setViewName("redirect:"+request.getContextPath()+"/admin/product/addProduct.jsp");
//
//        System.out.println("RealName = "+ NameUtils.encodingName(imgurl.getOriginalFilename()));
//        String contentType1 = imgurl.getContentType();
//        System.out.println("ContentType = "+ contentType1);
//        System.out.println("后缀"+contentType1.substring(contentType1.indexOf("/")+1));
//        System.out.println(product);
//        Boolean flag = productService.addProduct(product);
//        if(flag){
//                response.setContentType("text/html;charset=utf-8");
//                request.setCharacterEncoding("utf-8");
//                response.setCharacterEncoding("utf-8");
//                modelAndView.addObject("addProductResult","添加商品成功！");
//            }else {
//                modelAndView.addObject("addProductResult","添加商品失败！");
//            }

        //保存数据库的路径
        String sqlPath = null;
        //定义文件保存的本地路径
        String localPath="E:\\MyCode\\Servlet\\MyWebStore\\Picture\\";
        //定义 文件名
        String filename=null;
        if(!product.getImgurl().isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=product.getImgurl().getContentType();
            //获得文件后缀名
            String suffixName=contentType.substring(contentType.indexOf("/")+1);
            //得到 文件名
            filename=uuid+"."+suffixName;
            //文件保存路径
            File file = new File(localPath + filename);
            if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
            try {
                product.getImgurl().transferTo(new File(localPath+filename));
                System.out.println(true);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(false);
            }

        }
        //把图片的相对路径保存至数据库
        sqlPath = "/Picture/"+filename;
//        System.out.println(sqlPath);
        product.setImgUrl(sqlPath);
        Boolean flag = productService.addProduct(product);
        if(flag){
                modelAndView.addObject("addProductResult","添加商品成功！");
            }else {
                modelAndView.addObject("addProductResult","添加商品失败！");
            }
        return modelAndView;
    }
}
