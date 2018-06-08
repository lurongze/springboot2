package com.lrz.wechat;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.gson.JsonObject;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.open.api.impl.WxOpenServiceImpl;

import java.util.Map;

/**
 * Created by gz000172 on 2018/6/7.
 */
public class BaseService extends WxOpenServiceImpl {

    public String getAccessToken() {
        return "5555";
    }

    public String HttpGet(String uri, Map params) {
        try {
            return this.get(uri, Joiner.on("&").withKeyValueSeparator("=").join(params));
        }catch (WxErrorException e){
            return null;
        }
    }

    public String HttpPost(String uri, JSONObject params) {
        try {
            return this.post(uri, params.toString());
        }catch (WxErrorException e){
            return null;
        }
    }

}
