package com.wzy.role.web.controller;
import com.wzy.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 调到主页
     * @return
     */
    @RequestMapping(path = "/")
    public ModelAndView main() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
