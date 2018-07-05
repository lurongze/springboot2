package com.lrz.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Base64;

/**
 * Created by gz000172 on 2018/6/24.
 */
public class HelperUtil {

    /**
     * 加密密码 或者 token
     * @param userPassword 加密的字符串
     * @return 加密后的字符串，多加了几次MD5加密减低暴力破解的风险
     */
    public static String encodePassword(String userPassword) {
        return HashCrypt.string2MD5(userPassword + "lrz" + HashCrypt.string2MD5(userPassword + "rz" + HashCrypt.string2MD5(userPassword + "z"))).toUpperCase();
    }


    /**
     * 获取IP 地址
     * @param request 请求实例
     * @return IP
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress="";
        }
        // ipAddress = this.getRequest().getRemoteAddr();
        return ipAddress;
    }

    /**
     * @return 当前时间戳
     */
    public static Integer getTimeStamp() {
        Double time = Math.floor(System.currentTimeMillis()/1000);
        return time.intValue();
    }

    /**
     * BASE64加密
     * @param data 加密数据
     * @return 加密后的数据
     */
    public static String Base64Encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    /**
     * BASE64解密
     * @param data 解密数据
     * @return 解密后的数据
     */
    public static String Base64Decode(String data) {
        byte[] decodeInfo = Base64.getDecoder().decode(data);
        try{
            return new String(decodeInfo, "UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }
}
