package com.buaa.backkom.cloud.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class RequestUtil {

    private static final String CHARSET = "utf-8";

    public static HttpServletRequest currentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static String id() {
        return decodeHeadValue(currentRequest().getHeader("id"));
    }

    public static String role() {
        return decodeHeadValue(currentRequest().getHeader("role"));
    }

    private static String decodeHeadValue(String headValue) {
        String decode = null;
        try {
            decode = URLDecoder.decode(headValue, CHARSET);
        } catch (UnsupportedEncodingException e) {

        }
        return decode;
    }

}
