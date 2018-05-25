package com.lrz.service;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.lrz.mapper.OpenUserMapper;
import com.lrz.model.OpenUser;
import com.lrz.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

/**
 * Created by gz000172 on 2018/5/20.
 */
@Service
public class MiniappService {
    @Autowired
    OpenUserMapper openUserMapper;
    @Transactional
    public String addOpenId(WxMaJscode2SessionResult session) {
        OpenUser openUser = openUserMapper.selectByOpenId(session.getOpenid());
        String wxSession = session.getSessionKey();
        String sessionKey = Utils.md5(wxSession + session.getOpenid()).toUpperCase();
        if(Utils.isEmpty(openUser)) {
            OpenUser newOpenUser = new OpenUser();
            newOpenUser.setOpenid(session.getOpenid());
            newOpenUser.setSessionKey(sessionKey);
            newOpenUser.setWxSession(wxSession);
            openUserMapper.insert(newOpenUser);
        }else {
            openUser.setSessionKey(sessionKey);
            openUser.setWxSession(wxSession);
            openUserMapper.updateByOpenId(openUser);
        }
        return sessionKey;
    }
    public Boolean checkSession(String sessionKey) {
        OpenUser openUser = openUserMapper.selectByPrimaryKey(sessionKey);
        return Utils.isNotEmpty(openUser);
    }
    public OpenUser getOpenUserBySession(String sessionKey) {
        return openUserMapper.selectByPrimaryKey(sessionKey);
    }
}
