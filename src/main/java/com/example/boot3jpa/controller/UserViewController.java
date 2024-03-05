package com.example.boot3jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/login")
    public String login(){
        return "login"; // /login 경로로 접근하면 login() 메서드가 login.html 을 반환 한다.
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }


}
