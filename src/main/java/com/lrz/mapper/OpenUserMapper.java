package com.lrz.mapper;

import com.lrz.model.OpenUser;

public interface OpenUserMapper {
    int deleteByPrimaryKey(String sessionKey);

    int insert(OpenUser record);

    int insertSelective(OpenUser record);

    OpenUser selectByPrimaryKey(String sessionKey);

    int updateByPrimaryKeySelective(OpenUser record);

    int updateByPrimaryKey(OpenUser record);

    OpenUser selectByOpenId(String openId);

    int updateByOpenId(OpenUser record);
}