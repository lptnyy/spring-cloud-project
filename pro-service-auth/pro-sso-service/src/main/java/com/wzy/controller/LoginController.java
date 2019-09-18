package com.wzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     */
    @GetMapping("/require")
    public ModelAndView require() {
        return new ModelAndView("login");
    }
}
