package com.wolfpeng.controller;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.wolfpeng.client.HttpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by penghao on 2017/4/25.
 * Copyright ? 2017Äê Alibaba. All rights reserved.
 */

@Controller("HomeIndex")
@RequestMapping("/home")
public class Index {

    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request) {
        request.setAttribute("date", "handle index request");
        return "index";
    }

    //@RequestMapping(value = "/wx.motherchildren.com")
    //public String motherchildren(HttpServletRequest request) {
    //    logger.debug("handle motherchildren request");
    //    try {
    //        ServletInputStream inputStream = request.getInputStream();
    //        HttpMessage message = new HttpMessage(inputStream);
    //        message.receive();
    //        request.setAttribute("date", message.getOriginData());
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //    return "index";
    //
    //}
}