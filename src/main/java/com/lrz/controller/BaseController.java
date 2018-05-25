package com.lrz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gz000172 on 2018/5/14.
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getSession(HttpServletRequest request) {
        return request.getHeader("authorization");
    }
}
