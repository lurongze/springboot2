package com.lrz.controller.admin;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.RolePermission;
import com.lrz.model.UserRole;
import com.lrz.service.RolePermissionService;
import com.lrz.service.UserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2018/08/03.
*/
@RestController
@RequestMapping("/admin/user/role")
public class UserRoleController extends AdminBaseController{

    private final UserRoleService userRoleService;
    private final RolePermissionService rolePermissionService;
    @Autowired
    public UserRoleController(UserRoleService userRoleService, RolePermissionService rolePermissionService) {
        this.userRoleService = userRoleService;
        this.rolePermissionService = rolePermissionService;
    }


    @PostMapping("/add")
    public Result add(UserRole userRole) {
        userRoleService.save(userRole);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam(defaultValue = "0") Integer id) {
        UserRole userRole = userRoleService.findById(id);
        byte isDelete = 1;
        userRole.setIsDelete(isDelete);
        userRoleService.update(userRole);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserRole userRole, @RequestParam(required = false) String permissionList) {
        String[] permissionArray = permissionList.split("\\|");
        List<String> values = Arrays.asList(permissionArray);
        rolePermissionService.updatePermission(userRole.getId(), values);
        userRoleService.update(userRole);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        UserRole userRole = userRoleService.findById(id);
        Condition condition = new Condition(RolePermission.class);
        condition.createCriteria().andEqualTo("roleId", id);
        List<RolePermission> permissionList = rolePermissionService.findByCondition(condition);
        Map<String, Object> res = new HashMap<>(2);
        res.put("userRole", userRole);
        res.put("permissionList", permissionList);
        return ResultGenerator.genSuccessResult(res);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        String orderBy = "sort_order ASC,id ASC";
        PageHelper.startPage(page, size, orderBy);
        Condition condition = new Condition(UserRole.class);
        condition.createCriteria().andEqualTo("isDelete", "0");
        if (!checkAdminBoolean()) {
            System.out.println(1);
        }
        List<UserRole> list = userRoleService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
    * @return 返回实体的结构
    */
    @GetMapping("/entity")
    public Result entity() {
        UserRole userRoleEntity = new UserRole();
        userRoleEntity.setUnionId("0");
        return ResultGenerator.genSuccessResult(userRoleEntity);
    }
}
