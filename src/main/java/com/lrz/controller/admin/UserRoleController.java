package com.lrz.controller.admin;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.UserRole;
import com.lrz.service.UserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
* Created by CodeGenerator on 2018/08/03.
*/
@RestController
@RequestMapping("/admin/user/role")
public class UserRoleController extends AdminBaseController{

    private final UserRoleService userRoleService;
    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }


    @PostMapping
    public Result add(UserRole userRole) {

        userRoleService.save(userRole);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // userRoleService.deleteById(id);
        UserRole userRole = userRoleService.findById(id);
        byte isDelete = 1;
        userRole.setIsDelete(isDelete);
        userRoleService.update(userRole);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(UserRole userRole) {
        userRoleService.update(userRole);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        UserRole userRole = userRoleService.findById(id);
        return ResultGenerator.genSuccessResult(userRole);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        String orderBy = "sort_order ASC,id ASC";
        PageHelper.startPage(page, size, orderBy);
        // List<UserRole> list = userRoleService.findAll();
        Condition condition = new Condition(UserRole.class);
        condition.createCriteria().andEqualTo("isDelete", "0");
        if (!checkAdminBoolean()) {
            condition.and().andEqualTo("unionId", this.userInfo.getUnionId());
        }
        // condition.and().andEqualTo("fisuse" ,"1");
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
