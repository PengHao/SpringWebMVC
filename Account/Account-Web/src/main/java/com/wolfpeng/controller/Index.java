package com.wolfpeng.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolfpeng.session.controll.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by penghao on 2017/4/25.
 * Copyright ? 2017Äê Alibaba. All rights reserved.
 */

@Controller("HomeIndex")
@RequestMapping("/home")
public class Index {
    //http://localhost:8080/home/
    @RequestMapping(value = "/")
    public String index(HttpServletRequest request) {
        request.setAttribute("date", "handle index request");
        return "index";
    }

    UserService userService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passwd");
        userService.login(userName, passWord);
        Cookie cookie = new Cookie("session_token", "session_token");
        response.addCookie(cookie);
        return "index";
    }
}