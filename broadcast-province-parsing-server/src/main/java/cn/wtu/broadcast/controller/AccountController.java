package cn.wtu.broadcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	
    @RequestMapping(value = "/goLogin")
    public String goLogin() {
        return "index";
    }
}