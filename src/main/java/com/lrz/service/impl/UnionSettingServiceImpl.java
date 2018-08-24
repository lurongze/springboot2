package com.lrz.service.impl;

import com.lrz.dao.UnionSettingMapper;
import com.lrz.model.UnionSetting;
import com.lrz.service.UnionSettingService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by CodeGenerator on 2018/08/24.
 */
@Service
@Transactional
public class UnionSettingServiceImpl extends AbstractService<UnionSetting> implements UnionSettingService {
    @Autowired
    private UnionSettingMapper unionSettingMapper;

}
