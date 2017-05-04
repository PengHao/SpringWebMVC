package com.wolfpeng.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.wolfpeng.client.HttpProxyInterface;
import com.wolfpeng.httpproxymodel.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by penghao on 2017/4/25.
 * Copyright ? 2017Äê Alibaba. All rights reserved.
 */

@Controller
@RequestMapping("/home")
public class Index {
    @Resource
    HttpProxyInterface httpProxyInterface;
    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        logger.debug("handle index request");
        String t = "handle index request";
        HttpResponse response = httpProxyInterface.receiveRequestData(t.getBytes());
        String responseString = new String(response.body.getBinaryData());
        request.setAttribute("date", responseString);
        return "index";
    }
}