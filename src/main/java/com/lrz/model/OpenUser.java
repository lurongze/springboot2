package com.lrz.model;

import javax.persistence.*;

@Table(name = "open_user")
public class OpenUser {
    @Id
    @Column(name = "session_key")
    private String sessionKey;

    @Column(name = "appid")
    private String appid;

    @Column(name = "openid")
    private String openid;

    @Column(name = "wx_session")
    private String wxSession;

    @Column(name = "unionid")
    private String unionid;

    @Column(name = "info")
    private String info;

    /**
     * @return session_key
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * @param sessionKey
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * @return appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * @return wx_session
     */
    public String getWxSession() {
        return wxSession;
    }

    /**
     * @param wxSession
     */
    public void setWxSession(String wxSession) {
        this.wxSession = wxSession;
    }

    /**
     * @return unionid
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * @param unionid
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * @return info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }
}