package com.lrz.service.impl;

import com.lrz.dao.TbkItemMapper;
import com.lrz.model.TbkItem;
import com.lrz.service.TbkItemService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by CodeGenerator on 2018/09/19.
 */
@Service
@Transactional
public class TbkItemServiceImpl extends AbstractService<TbkItem> implements TbkItemService {
    @Autowired
    private TbkItemMapper tbkItemMapper;

}
