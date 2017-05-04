package com.wolfpeng.client;

import com.wolfpeng.httpproxymodel.HttpBody;
import com.wolfpeng.httpproxymodel.HttpRequest;
import com.wolfpeng.httpproxymodel.HttpResponse;
import org.springframework.stereotype.Service;

/**
 * Created by penghao on 2017/5/4.
 * Copyright ? 2017Äê Alibaba. All rights reserved.
 */

@Service("testService")
public class MCProxy extends Object implements HttpProxyInterface {

    public HttpResponse receiveRequestData(byte[] requestData) {
        HttpRequest request = new HttpRequest();
        request.init(requestData);

        HttpResponse response = new HttpResponse();
        HttpBody body = new HttpBody();
        body.setBinaryData(requestData);
        response.body = body;
        return response;
    }
}
