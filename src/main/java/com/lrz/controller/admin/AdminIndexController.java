package com.lrz.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.core.ServiceException;
import com.lrz.model.RolePermission;
import com.lrz.model.UnionSetting;
import com.lrz.model.User;
import com.lrz.service.RolePermissionService;
import com.lrz.service.UnionSettingService;
import com.lrz.service.UserService;
import com.lrz.utils.HelperUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * Created by gz000172 on 2018/6/5.
 */
@RestController
@RequestMapping("/admin/index")
public class AdminIndexController extends AdminBaseController{
    private final UserService userService;
    private final RolePermissionService rolePermissionService;
    private final UnionSettingService unionSettingService;
    @Autowired
    public AdminIndexController(UserService userService, RolePermissionService rolePermissionService,UnionSettingService unionSettingService) {
        this.userService = userService;
        this.rolePermissionService = rolePermissionService;
        this.unionSettingService = unionSettingService;
    }

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "error") String type) {
        if("error".equals(type)) {
            throw new ServiceException("type类型错误");
        }
        return "admin-index";
    }

    /**
     * 注册用户名
     * @param userName 用户名
     * @param userPassword 密码
     * @return result
     */
    @PostMapping("/register")
    public Result register(@RequestParam String userName, @RequestParam String userPassword, @RequestParam(required = false) String unionId) {
        User checkUser = userService.findByUserName(userName);
        if(checkUser != null) {
            throw new ServiceException("用户名已经注册：" + userName);
        }else {
            User user = new User();
            String encodePassword = HelperUtil.encodePassword(userPassword);
            user.setUserName(userName);
            user.setUserPassword(encodePassword);
            user.setCreatedAt(HelperUtil.getTimeStamp());
            user.setUserEmail("");
            user.setUserAddress("");
            if(StringUtils.isEmpty(unionId)) {
                unionId = UUID.randomUUID().toString();
            }
            user.setUnionId(unionId);
            userService.save(user);
            return ResultGenerator.genSuccessResult("账号注册成功：" + userName);
        }
    }

    /**
     * 用户登录
     * @param userName 用户名
     * @param userPassword 密码
     * @return 登录token
     */
    @PostMapping("/login")
    public Result login(@RequestParam String userName, @RequestParam String userPassword, HttpServletRequest httpServletRequest) {
        User user = userService.findByUserName(userName);
        if(user != null) {
            String encodePassword = HelperUtil.encodePassword(userPassword);
            if(encodePassword.equals(user.getUserPassword())) {
                // 把userInfo 的信息弄成json结构，sign是防止数据修改
                JSONObject userInfo = new JSONObject();
                userInfo.put("id", user.getId());
                userInfo.put("name", user.getUserName());
                Integer time = HelperUtil.getTimeStamp();
                userInfo.put("loginTime", time);
                String IP = HelperUtil.getIpAddress(httpServletRequest);
                userInfo.put("sign", HelperUtil.encodePassword( user.getUserName() + "*|*" + user.getId() + "*|*" + IP + "*|*" + time));
                String token = HelperUtil.Base64Encode(userInfo.toJSONString());
                // 登录成功了，更新一下token值
                user.setToken(token);
                userService.update(user);
                Map<String, Object> res = new HashMap<>();
                res.put("token", token);
                res.put("userName", user.getUserName());
                res.put("unionId", user.getUnionId());
                res.put("unionSetting", getUnionSetting(user.getUnionId()));
                if ("lurongze".equals(user.getUserName())) {
                    res.put("permissionList", "systemAdmin");
                } else {
                    res.put("permissionList", getUserPermission(user.getRoleId()));
                }
                return ResultGenerator.genSuccessResult(res);
            }else {
                throw new ServiceException("用户名或密码错误");
            }
        }else {
            throw new ServiceException("用户不存在");
        }
    }

    public ArrayList<String> getUserPermission(Integer roleId) {
        Condition condition = new Condition(RolePermission.class);
        condition.createCriteria().andEqualTo("roleId", roleId);
        List<RolePermission> res = rolePermissionService.findByCondition(condition);
        ArrayList<String> permissionList = new ArrayList<>();
        for(RolePermission item:res) {
            permissionList.add(item.getPermission());
        }
        return permissionList;
    }

    public List<UnionSetting> getUnionSetting(String unionId) {
        Condition condition = new Condition(UnionSetting.class);
        condition.createCriteria().andEqualTo("unionId", unionId);
        return unionSettingService.findByCondition(condition);
    }

    @PostMapping("/uploadImage")
    public Result uploadImage(MultipartFile file) {
        try {
            // String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            String uploadDir = "F:/workspace/java/index/src/upload/";
            System.out.println("uploadDir:" + uploadDir);
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            if (StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String filename = uploadDir + UUID.randomUUID().toString() + suffix;
                File serverFile = new File(filename);
                file.transferTo(serverFile);
                return ResultGenerator.genSuccessResult(filename);
            } else {
                return ResultGenerator.genFailResult("文件名为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("上传失败");
        }
    }

}
