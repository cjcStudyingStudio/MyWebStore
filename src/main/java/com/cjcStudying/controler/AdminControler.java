package com.cjcStudying.controler;

import com.cjcStudying.domain.Admin;
import com.cjcStudying.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
}
