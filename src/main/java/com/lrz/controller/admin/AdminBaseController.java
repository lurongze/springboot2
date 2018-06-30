package com.lrz.controller.admin;

import com.lrz.core.ServiceException;
import com.lrz.model.User;
import com.lrz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by gz000172 on 2018/6/5.
 */
public class AdminBaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    // 用户id
    protected Integer userId;
    protected User userInfo;
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    UserService userService;

    /**
     * 每个方法之前执行的方法
     */
    @ModelAttribute
    void beforeActions() {
        this.userId = Integer.valueOf(httpServletRequest.getAttribute("userId").toString());
        this.userInfo = userService.findById(this.userId);
        System.out.println("beforeAction:this.userId:" + this.userId);
    }

    /**
     * 判断组织ID是否和登录人的一致
     * @param unionId 组织ID
     */
    public void checkUnion(String unionId) {
        if (!unionId.equals(this.userInfo.getUnionId())) {
            throw new ServiceException("组织ID不匹配");
        }
    }
}
