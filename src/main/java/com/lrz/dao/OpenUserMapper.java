package com.lrz.dao;

import com.lrz.core.Mapper;
import com.lrz.model.OpenUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface OpenUserMapper extends Mapper<OpenUser> {
    void updateSessionByOpenId(@Param("sessionKey") String sessionKey, @Param("wxSession") String wxSession, @Param("openId") String openId);
}