package com.lrz.service.impl;

import com.lrz.dao.OpenUserMapper;
import com.lrz.model.OpenUser;
import com.lrz.service.OpenUserService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/12.
 */
@Service
@Transactional
public class OpenUserServiceImpl extends AbstractService<OpenUser> implements OpenUserService {
    @Resource
    private OpenUserMapper openUserMapper;

}
