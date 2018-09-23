package com.lrz.service.impl;

import com.lrz.dao.TbkItemInfoMapper;
import com.lrz.model.TbkItemInfo;
import com.lrz.service.TbkItemInfoService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by CodeGenerator on 2018/09/23.
 */
@Service
@Transactional
public class TbkItemInfoServiceImpl extends AbstractService<TbkItemInfo> implements TbkItemInfoService {
    @Autowired
    private TbkItemInfoMapper tbkItemInfoMapper;

}
