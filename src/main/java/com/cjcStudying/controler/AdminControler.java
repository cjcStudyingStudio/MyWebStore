package com.cjcStudying.controler;

import com.cjcStudying.domain.Admin;
import com.cjcStudying.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControler {

    @Autowired
    private AdminService adminService;

    /**
     * op: login
     * username: laowang
     * password: 123
     */
    @RequestMapping("/login")
    public String login(@RequestParam("op")String op,
                      @RequestParam("username")String username,
                      @RequestParam("password")String password,
                      HttpSession session){
        if(op.equals("login")){
            Admin admin = adminService.login(username, password);
            if(admin!=null){
                session.setAttribute("admin",admin);
                return "redirect:main.jsp";
            }else {
                //登录失败后操作
            }
        }
        return "index.jsp";
    }

    /**
     * op: logout
     */
    @RequestMapping("/logout")
    public String logout(@RequestParam("op")String op,
                         HttpSession session){
        if(op.equals("logout")){
            session.invalidate();
        }
        return "redirect:index.jsp";
    }

    /**
     * op: addAdmin
     * username: laowang
     * password: 123
     * password1: 123
     */
    @RequestMapping("/addAdmin")
    public void addAdmin(@RequestParam("op")String op,
                         @RequestParam("password1")String password1,
                         Admin admin,
                         HttpServletResponse response,
                         HttpServletRequest request){
        if(op.equals("addAdmin")){
            try {
                response.setContentType("text/html;charset=utf-8");
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                if(admin.getPassword().equals(password1)){
                    Boolean flag = adminService.register(admin);
                        response.getWriter().println("注册成功！");
                }else {
                    response.getWriter().println("注册失败！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param op
     * @param num
     * @param session,
     * @param request
     * @return Session page  return page(adminList);
     */
    @RequestMapping("/findAllAdmin")
    public String findAllAdmin(@RequestParam("op")String op,
                               @RequestParam("num")String num,
                               HttpSession session,
                               HttpServletRequest request){
        if(op.equals("findAllAdmin")){
            //page(adminList)
            List<Admin> adminList = adminService.findAllAdmin();
            session.setAttribute("page",adminList);
        }
        return request.getContextPath()+"/admin/admin/adminList.jsp";
    }


}
