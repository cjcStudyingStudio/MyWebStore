package com.cjcStudying.controler;

import com.cjcStudying.domain.Category;
import com.cjcStudying.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("/findAllCategory")
    public ModelAndView findAllCategory(@RequestParam("op")String op,
                                        @RequestParam("num")String num,
                                        ModelAndView modelAndView,
                                        HttpServletRequest request){
        if(op.equals("findAllCategory")){
            List<Category> categoryList = categoryService.findAllCategory();
                modelAndView.addObject("categoryList",categoryList);
                modelAndView.setViewName(request.getContextPath()+"/admin/category/categoryList.jsp");
        }
        return modelAndView;
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
