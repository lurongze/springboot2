package com.lrz.model;

public class OpenUser {
    private String sessionKey;

    private String openid;

    private String unionid;

    private String info;

    private String wxSession;

    public String getWxSession() {
        return wxSession;
    }

    public void setWxSession(String wxSession) {
        this.wxSession = wxSession;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}