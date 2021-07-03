package com.cjcStudying.controler;

import com.cjcStudying.domain.Category;
import com.cjcStudying.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryControler {

    @Autowired
    CategoryService categoryService;

    /**
     * op: findCategory
     */
    @RequestMapping("/findCategory")
    public Category findCategory(@RequestParam("op")String op){
        Category category = null;
        if(op.equals("findCategory")){

        }
        return category;
    }

    /**
     * op: addCategory
     * checkbox: on
     * cname: 21312
     */
    @RequestMapping("/addCategory")
    public ModelAndView addCategory(@RequestParam("op")String op,
                                    Category category,
                                    ModelAndView modelAndView,
                                    HttpServletRequest request){
        modelAndView.setViewName("redirect:"+request.getContextPath()+"/admin/category/addCategory.jsp");
        if(op.equals("addCategory")){
            Boolean flag = categoryService.addCategory(category);
            if(flag){

                modelAndView.addObject("addCategoryResult","添加分类成功！");
            }else {
                modelAndView.addObject("addCategoryResult","添加分类失败！");
            }
        }
        return modelAndView;
    }

    /**
     * op: findAllCategory
     * num: 1
     */
    @RequestMapping(value = "/findAllCategory",produces={"text/html;charset=UTF-8"})
    public String findAllCategory(@RequestParam("op")String op,
                                  @RequestParam("num")String num,
                                  HttpSession session,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws UnsupportedEncodingException {
        if(op.equals("findAllCategory")){
            List<Category> categoryList = categoryService.findAllCategory();
            session.setAttribute("categoryList",categoryList);
        }
        return request.getContextPath()+"/admin/category/categoryList.jsp";
    }


    /**
     * op: deleteMulti
     */
    @RequestMapping("/deleteMulti")
    public void deleteMulti(@RequestParam("op")String op,
                                        ModelAndView modelAndView,
                                        HttpServletRequest request){
        if(op.equals("deleteMulti")){
//           categoryService.deleteCategory()
        }
    }
}
