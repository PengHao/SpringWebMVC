package com.wolfpeng.httpproxymodel;

import java.io.Serializable;

/**
 *
 * @author penghao
 * @date 2017/5/4
 * Copyright ? 2017Äê Alibaba. All rights reserved.
 */
public class HttpRequest implements Serializable {

    private static final long serialVersionUID = 4194460765505783264L;
    static String endOfHeader = "\r\n\r\n";
    static String CRLF = "\r\n";
    HttpHeader header;
    HttpBody body;

    public void init(byte[] data) {
        String dataString = new String(data);
        if (dataString.contains(endOfHeader)) {
            String[] subStrings = dataString.split(endOfHeader);
            String headerString = subStrings[0];
            header = new HttpHeader();
            header.init(headerString);

            Integer headerLength = headerString.length() + 4;
            byte[] bodyByte = new byte[data.length - headerLength];
            for (int i = 0; i < bodyByte.length; ++i) {
                bodyByte[i] = data[headerLength + i];
            }
            body = new HttpBody();
            body.setBinaryData(bodyByte);
        }
    }

    public String getBodyString() {
        Boolean isChunked = false;
        if (isChunked) {
            String bodyString = new String(body.getBinaryData());
            String[] subStrings = bodyString.split(CRLF);
            Integer chunkedLength = 0;
            for (int i = 0; i < subStrings.length; ++i) {
                if (i%2 == 0) {
                    String chunkedLengthString = subStrings[i];
                    chunkedLength = Integer.parseInt(chunkedLengthString, 16);
                    i += 1;
                    if (chunkedLength == subStrings[i].length()) {

                    }
                }
            }
        }
        return "";
    }
}
