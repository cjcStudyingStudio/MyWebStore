package com.cjcStudying.controler;

import com.cjcStudying.domain.User;
import com.cjcStudying.domain.User2;
import com.cjcStudying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserControler {

    @Autowired
    private UserService userService;
    /**
     * @param1  op: login
     * @param2 username: ${cookie.username.value}
     * @param3 password: ${cookie.password.value}
     * @param4 verifyCode: 13123
     * @param5 remember_me: on
     * @return ???
     */
    @RequestMapping("/login")
    public String login(@RequestParam("op") String op,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        @RequestParam("remember_me") String remember_me,
                        HttpServletResponse response){
//    public String login( String op,
//                         String username,
//                        String password,
//                         String verifyCode,
//                        String remember_me,
//                        HttpServletResponse response){
        if(op.equals("login")) {
            User user = userService.login(username, password);
            if (user != null) {
                Cookie cookie = new Cookie("username", username);
                Cookie cookie1 = new Cookie("password", password);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                return "redirect:/index.jsp";
            }
        }
        return "/user/login.jsp";
    }

    /**
     * op: register
     * username: alibaba
     * nickname: 小啊
     * email: 456798@qq.com
     * password: 123
     * birthday: 1995-08-10
     */
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));}


    @RequestMapping("/register")
    public String register(User user,
                           @RequestParam("op")String op,
                           HttpServletResponse response,
                           HttpServletRequest request) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        if(op.equals("register")) {
            Boolean register = userService.register(user);
            if (register) {
                return "redirect:/user/login.jsp";
            }
        }
        return "/user/register.jsp";
    }

    @RequestMapping("/test")
    public void test(User2 user2){
        System.out.println(user2.toString());
    }

}
