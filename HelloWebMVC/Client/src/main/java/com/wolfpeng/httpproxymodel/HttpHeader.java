package com.wolfpeng.httpproxymodel;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by penghao on 2017/5/4.
 * Copyright ? 2017Äê Alibaba. All rights reserved.
 */
public class HttpHeader implements Serializable {
    private static final long serialVersionUID = -2122961842618745850L;

    public enum RequestFeild {
        ACCEPT("Accept"),
        ACCEPT_CHARSET("Accept-Charset"),
        ACCEPT_ENCODING("Accept-Encoding"),
        ACCEPT_LANGUAGE("Accept-Language"),
        ACCEPT_RANGE("Accept-Ranges"),
        AUTHORIZATION("Authorization"),
        CACHE_CONTROL("Cache-Control"),
        CONNECTION("Connection"),
        COOKIE("Cookie"),
        CONTENT_LENGTH("Content-Length"),
        CONTENT_TYPE("Content-Type"),
        DATE("Date"),
        EXPECT("Expect"),
        FROM("From"),
        HOST("Host"),
        IF_MATCH("If-Match"),
        IF_MODIFIED_SINCE("If-Modified-Since"),
        IF_NONE_MATCH("If-None-Match"),
        IF_RANGE("If-Range"),
        IF_UNMODIFIED_SINCE("If-Unmodified-Since"),
        IF_MAX_FORWARD("Max-Forwards"),
        PRAGAM("Pragma"),
        PROXY_AUTHORIZATION("Proxy-Authorization"),
        RANGE("Range"),
        REFERER("Referer"),
        TE("TE"),
        UPGRADE("Upgrade"),
        USER_AGENT("User-Agent"),
        VIA("Via"),
        WARNING("Warning");

        private String value;
        RequestFeild(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum ResponseFeild {

        AGE("Age"),
        ALLOW("Allow"),
        CONTENT_ENCODING("Content-Encoding"),
        CONTENT_LANGUAGE("Content-Language"),
        CONTENT_LOCATION("Content-Location"),
        CONTENT_MD5("Content-MD5"),
        CONTENT_RANGE("Content-Range"),
        ETAG("Etag"),
        EXPIRES("Expires"),
        LAST_MODIFIED("Last-Modified"),
        LOCATION("Location"),
        PROXY_AUTHENTICATE("Proxy-Authenticate"),
        REFRESH("refresh"),
        RETRY_AFTER("Retry-After"),
        SERVER("Server"),
        SET_COOKIE("Set-Cookie"),
        TRAILER("Trailer"),
        TRANSFER_ENCODING("Transfer-Encoding"),
        VARY("Vary"),
        WWW_AUTHENTICATE("WWW-Authenticate");

        private String value;
        ResponseFeild(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }


    public void init(String headerString) {
        header_params = new HashMap<String, String>();
        get_params = new HashMap<String, String>();
        for (String param: headerString.split("\\r\\n")) {
            String[] kv = param.split(": ");
            if (kv.length>1) {
                header_params.put(kv[0], kv[1]);
            } else {
                header_params.put("first", kv[0]);
                praserFirst(kv[0]);
            }
        }
        headerLength = headerString.length();
    }

    public String method, path;
    HashMap<String, String> get_params;
    HashMap<String, String> header_params;

    int headerLength = 0;

    private void praserFirst(String first) {
        for (String param: first.split(" ")) {
            if (method == null) {
                method = param;
            } else  {
                String[] ps = param.split("\\?");
                if (ps.length > 1) {
                    path = ps[0];
                    for (String p: ps[1].split("&")) {
                        String[] kv = param.split("=");
                        if (kv.length>1) {
                            get_params.put(kv[0], kv[1]);
                        }
                    }
                }
            }
        }
    }

    public String getGetProperty(String property) {
        return get_params.get(property);
    }

    public void setGetProperty(String property, String value) {
        get_params.put(property, value);
    }

    public String getHeaderProperty(String property) {
        return header_params.get(property);
    }

    public void setHeaderProperty(String property, String value) {
        header_params.put(property, value);
    }
}
