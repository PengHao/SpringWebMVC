package com.wolfpeng.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.wolfpeng.client.Test;
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
    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        logger.debug("handle index request");
        Test t = new Test();
        t.test();
        request.setAttribute("date", t.test());
        return "index";
    }
}