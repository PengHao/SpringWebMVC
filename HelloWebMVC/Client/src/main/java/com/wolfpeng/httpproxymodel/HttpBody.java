package com.wolfpeng.httpproxymodel;

import java.io.Serializable;


/**
 * Created by penghao on 2017/5/4.
 * Copyright ? 2017Äê Alibaba. All rights reserved.
 */
public class HttpBody implements Serializable {
    private static final long serialVersionUID = -1203443310121800854L;

    byte[] binaryData;

    public void setBinaryData(byte[] data) {
        binaryData = data;
    }

    public byte[] getBinaryData () {
        return this.binaryData;
    }

}
