package com.wolfpeng.client;

import com.wolfpeng.httpproxymodel.HttpResponse;

/**
 * Created by penghao on 2017/5/4.
 * Copyright ? 2017Äê Alibaba. All rights reserved.
 */
public interface HttpProxyInterface {
    HttpResponse receiveRequestData(byte[] requestData);




}
