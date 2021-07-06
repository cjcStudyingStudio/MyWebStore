package com.cjcStudying.controler;

import com.cjcStudying.domain.Product;
import com.cjcStudying.domain.SearchCondition;
import com.cjcStudying.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
                                    HttpServletRequest request) throws IOException {
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

    /**
     * op: findAllProduct
     * num: 1
     */
    @RequestMapping("/findAllProduct")
    public String findAllProduct(@RequestParam("op")String op,
                                 @RequestParam("num")Integer num,
                                 HttpServletRequest request) throws IOException {
        PageHelper.startPage(num,6);
        List<Product> productList = productService.findAllProduct();
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        System.out.println(pageInfo);
//        pageInfo.getList()
//        总共页数
//        pageInfo.getPages()
//        当前页数
//        pageInfo.getPageNum()
//        总共条数
//        pageInfo.getEndRow()
//        前一页
//        pageInfo.getPrePage();
//        下一页
//        pageInfo.getNextPage();
//        pageInfo.getPages();
        pageInfo.getPageNum();
        request.setAttribute("pageInfo",pageInfo);
        return "forward:"+request.getContextPath()+"/admin/product/productList.jsp";
    }

    /**
     * op: deleteOne
     * pid: 0100a498a8974247856351544a137cc2
     */
    @RequestMapping("/deleteOne")
    public ModelAndView deleteOne(@RequestParam("op")String op,
                                  @RequestParam("pid")String pid,
                                   ModelAndView modelAndView,
                                   HttpServletRequest request){
        modelAndView.setViewName("redirect:"+request.getContextPath()+"/admin/product/productList.jsp");
        if(op.equals("deleteOne")){
            Boolean flag = productService.deleteProductByPid(pid);
            //同时需要删除本地图片为完成！
            if(flag){
                modelAndView.addObject("result","商品删除成功");
            }else {
                modelAndView.addObject("result","商品删除失败");
            }
            List<Product> productList = productService.findAllProduct();
            request.setAttribute("productList",productList);
        }
        return modelAndView;
    }

    /**
     * num: 1
     * op: multiConditionSearch
     * pid: 321412412   第一搜索条件
     * cid: 1376582235  第三搜索条件
     * pname: 天下第一   第二搜索条件
     * minprice: 4214    第四搜索条件
     * maxprice: 5534    第四搜索条件
     * search: 查询
     * @return  /admin/product/productSearchList.jsp productList
     */
    @RequestMapping("/multiConditionSearch")
    public String multiConditionSearch(@RequestParam("op")String op,
                                       String num,
                                       SearchCondition searchCondition,
                                       HttpServletRequest request) throws IOException {
        List<Product> productList = new ArrayList<Product>();
        if(op.equals("multiConditionSearch")) {
            if (searchCondition.getPid() != null && !searchCondition.getPid().isEmpty()) {
                Product product = productService.findProductByPid(searchCondition.getPid());
                productList.add(product);
            } else if (searchCondition.getPname() != null && !searchCondition.getPname().isEmpty()) {
                if (searchCondition.getCid() != null) {
                    if (searchCondition.getMinprice() != null) {
                        if (searchCondition.getMaxprice() != null) {
                            productList = productService.findProductByPnameAndCidAndMinpAndMaxp(searchCondition);
                        } else {
                            productList = productService.findProductByPnameAndCidAndMinp(searchCondition);
                        }
                    }else if(searchCondition.getMaxprice() != null) {
                        productList = productService.findProductByPnameAndCidAndMaxp(searchCondition);
                    } else {
                        productList = productService.findProductByPnameAndCid(searchCondition);
                    }
                } else if(searchCondition.getMinprice() != null){
                    if (searchCondition.getMaxprice() != null) {
                        productList = productService.findProductByPnameAndMinpAndMaxp(searchCondition);
                    } else {
                        productList = productService.findProductByPnameAndMinp(searchCondition);
                    }

                }else if(searchCondition.getMaxprice() != null){
                    productList = productService.findProductByPnameAndMaxp(searchCondition);
                } else {
                    productList = productService.findProductByPname(searchCondition);
                }
            } else if (searchCondition.getCid() != null) {
                if (searchCondition.getMinprice() != null) {
                    if (searchCondition.getMaxprice() != null) {
                        productList = productService.findProductByCidAndMinpAndMaxp(searchCondition);
                    } else {
                        productList = productService.findProductByCidAndMinp(searchCondition);
                    }
                } else if(searchCondition.getMaxprice() != null){
                    productList = productService.findProductByCidAndMaxp(searchCondition);
                }else {
                    productList = productService.findProductByCid(searchCondition);
                }
            }
        }
        //只靠价格查询暂时未开发
        request.setAttribute("productList", productList);
        return "forward:"+request.getContextPath()+"/admin/product/productSearchList.jsp";
    }

    /**
     * op: findCategoryByUpdate
     * pid: 1acf966a83304625a3164996f50f022c
     */
    @RequestMapping("/findCategoryByUpdate")
    public ModelAndView findCategoryByUpdate(@RequestParam("op")String op,
                                  @RequestParam("pid")String pid,
                                  ModelAndView modelAndView,
                                  HttpServletRequest request){
        modelAndView.setViewName("forward:"+request.getContextPath()+"/admin/product/productList.jsp");
        if(op.equals("deleteOne")){
            Boolean flag = productService.deleteProductByPid(pid);
            //同时需要删除本地图片为完成！
            if(flag){
                modelAndView.addObject("deleteProductResult","商品删除成功");
            }else {
                modelAndView.addObject("deleteProductResult","商品删除失败");
            }
            List<Product> productList = productService.findAllProduct();
            request.setAttribute("productList",productList);
        }
        return modelAndView;
    }

    @RequestMapping("/findProductByPid")
    public String findProductByPid(@RequestParam("pid")String pid,
                                 HttpSession session,
                                 HttpServletRequest request){
        Product product = productService.findProductByPid(pid);
        System.out.println(product);
        session.setAttribute("product",product);
        return "forward:"+request.getContextPath()+"/admin/product/updateProduct.jsp";
    }

    /**
     * op: updateProduct
     * imgurl:  暂不开发
     * cid: 1
     * pid: e62b4f5ecb774436a65d720bb31a3501
     * pNum: 22
     * pname: 天下第一的书
     * eStorePrice: 111.0
     * markPrice: 222.0
     * desc: 天下第一11111天下第一11111天下第一11111天下第一11111
     */
    @RequestMapping("/updateProduct")
    public ModelAndView updateProduct(@RequestParam("op")String op,
                                   Product product,
                                   ModelAndView modelAndView,
                                   HttpServletRequest request){
        modelAndView.setViewName("redirect:"+request.getContextPath()+"/admin/product/productList.jsp");
        if(op.equals("updateProduct")){
            Boolean flag = productService.updateProduct(product);
            if(flag){
                modelAndView.addObject("result","修改成功");
            }else {
                modelAndView.addObject("result","修改失败");
            }
        }
        return modelAndView;
    }
}
