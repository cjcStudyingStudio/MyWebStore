package com.cjcStudying.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserControler {

    /**
     * @param1  op: login
     * @param2 username: ${cookie.username.value}
     * @param3 password: ${cookie.password.value}
     * @param4 verifyCode: 13123
     * @param5 remember_me: on
     * @return ???
     */
    @RequestMapping("/UserServlet")
    public String login(){
        return "";
    }
}
