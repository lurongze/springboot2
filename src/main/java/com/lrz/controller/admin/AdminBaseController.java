package com.lrz.controller.admin;

import com.lrz.core.ServiceException;
import com.lrz.model.User;
import com.lrz.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gz000172 on 2018/6/5.
 */
public class AdminBaseController {
    public final String systemAdminUserName = "lurongze";
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    // 用户id
    protected Integer userId;
    protected User userInfo;
    @Autowired
    private UserService userService;

    /**
     * 每个方法之前执行的方法
     */
    @ModelAttribute
    void beforeAction(HttpServletRequest httpServletRequest) {
        // 拦截器解析判断的时候赋值给request userId 了，所以这里可以直接拿到
        this.userId = Integer.valueOf(httpServletRequest.getAttribute("userId").toString());
        this.userInfo = userService.findById(this.userId);
        if (this.userInfo == null) {
            throw new ServiceException("用户不存在");
        }
        String authorization = httpServletRequest.getHeader("authorization");
        if (this.userInfo != null && !this.userInfo.getToken().equals(authorization)) {
            logger.info("beforeAction:", "token 和 用户不匹配");
            throw new ServiceException("token 和 用户不匹配");
        }
        logger.info("beforeAction:this.userInfo:", this.userInfo);
        if (this.userInfo != null && !systemAdminUserName.equals(this.userInfo.getUserName())) { // 非管理员
            String unionId = httpServletRequest.getHeader("union-id");
            checkUnion(unionId);
        }
        checkPermission(this.userInfo.getRoleId(), httpServletRequest.getRequestURI());
    }

    /**
     * 判断组织ID是否和登录人的一致，在需要的时候再验证
     * @param unionId 组织ID
     */
    public void checkUnion(String unionId) {
        if (StringUtils.isEmpty(unionId) || !unionId.equals(this.userInfo.getUnionId())) {
            // 组织id 不一致
            throw new ServiceException("无权限：201807271139-47");
        }
    }

    public void checkAdmin() {
        if (!systemAdminUserName.equals(this.userInfo.getUserName())) {
            throw new ServiceException("无权限：201807271139-53");
        }
    }
    // 检查权限
    public void checkPermission(Integer roleId, String permission) {
        permission = permission.replace("/admin", "");
        if (!checkAdminBoolean() && !userService.checkPermission(roleId, permission)) { // 非管理员并且没有权限的
            throw new ServiceException("无权限：管理员未为你配置相应的权限");
        }
    }

    public Boolean checkAdminBoolean() {
        return systemAdminUserName.equals(this.userInfo.getUserName());
    }

}
