package com.cjcStudying.controler;

import com.cjcStudying.domain.User;
import com.cjcStudying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
    @RequestMapping("/UserServlet")
//    public String login(@RequestParam("op") String op,
//                        @RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        @RequestParam("verifyCode") String verifyCode,
//                        @RequestParam("remember_me") String remember_me,
//                        HttpServletResponse response){
    public String login( String op,
                         String username,
                        String password,
                         String verifyCode,
                        String remember_me,
                        HttpServletResponse response){
        User user = userService.login(username, password);
        if(op.equals("login")&&user!=null){
            Cookie cookie = new Cookie("username", username);
            Cookie cookie1 = new Cookie("password", password);
            response.addCookie(cookie);
            response.addCookie(cookie1);
            return "redirect:/index.jsp";
        }
        return "/user/login.jsp";
    }
}
