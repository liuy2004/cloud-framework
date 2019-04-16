package com.sech.framework.core.utils;

import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 前台Web常用工具类
 *
 * @author sech.io
 */
public class WebUtils {

    /**
     * 对String-Integer转换，如果转换异常则返回默认值
     *
     * @param intId
     * @param defaultIntId 返回默认值
     * @return Integer
     */
    public static Integer parseStrToInteger(String intId, Integer defaultIntId) {
        if (StringUtils.isEmpty(intId)) {
            return defaultIntId;
        }
        try {
            return Integer.parseInt(intId.trim());
        } catch (Exception e) {
            return defaultIntId;
        }
    }

    /**
     * 对String-Long转换，如果转换异常则返回默认值
     *
     * @param intId
     * @param defaultIntId 返回默认值
     * @return Integer
     */
    public static Long parseStrToLong(String intId, Long defaultIntId) {
        if (StringUtils.isEmpty(intId)) {
            return defaultIntId;
        }
        try {
            return Long.parseLong(intId.trim());
        } catch (Exception e) {
            return defaultIntId;
        }
    }

    /**
     * @param intId
     * @return
     */
    public static Double parseStrToDouble(String intId, Double defaultDoubleId) {
        if (StringUtils.isEmpty(intId)) {
            return new Double(0);
        }
        try {
            return Double.parseDouble(intId.trim());
        } catch (Exception e) {
            return new Double(0);
        }
    }

    public static String buildURLEncoder(String param) {
        if (StringHelper.isEmpty(param)) {
            return "";
        }
        try {
            return URLEncoder.encode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String buildURLDecoder(String param) {
        try {
            return java.net.URLDecoder.decode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 判断是否是微信浏览器发出的请求
     *
     * @param userAgent
     */
    public static boolean isWxRequest(String userAgent) {
        return userAgent.indexOf("micromessenger") > -1;
    }

}
