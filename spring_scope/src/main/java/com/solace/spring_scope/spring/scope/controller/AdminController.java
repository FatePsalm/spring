package com.solace.spring_scope.spring.scope.controller;

import com.solace.spring_scope.spring.scope.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("codeTest")
    @ResponseBody
    public void codeTest(){
        System.out.println(String.valueOf(adminService));
    }

}
