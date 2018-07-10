package com.lrz.controller.admin;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.core.ServiceException;
import com.lrz.model.User;
import com.lrz.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.utils.HelperUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.UUID;

/**
* Created by CodeGenerator on 2018/07/07.
*/
@RestController
@RequestMapping("/admin/user")
public class UserController extends AdminBaseController{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Result add(User user) {
        String userName = user.getUserName();
        User checkUser = userService.findByUserName(userName);
        if(checkUser != null) {
            throw new ServiceException("用户名已经注册：" + userName);
        }else {
            String encodePassword = HelperUtil.encodePassword(user.getUserPassword());
            user.setUserPassword(encodePassword);
            user.setCreatedAt(HelperUtil.getTimeStamp());
            if(StringUtils.isEmpty(user.getUnionId())) {
                user.setUnionId(UUID.randomUUID().toString());
            }
        }
        userService.save(user);
        return ResultGenerator.genSuccessResult("账号注册成功：" + userName);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // userService.deleteById(id);
        User user = userService.findById(id);
        byte isDelete = 1;
        user.setIsDelete(isDelete);
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        String orderBy = "id ASC";
        PageHelper.startPage(page, size, orderBy);
        Condition condition = new Condition(User.class);
        condition.createCriteria().andEqualTo("isDelete", "0");
        // condition.and().andEqualTo("fisuse" ,"1");
        List<User> list = userService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * @return 返回实体的结构
     */
    @GetMapping("/entity")
    public Result entity() {
        User userEntity = new User();
        userEntity.setUnionId("0");
        return ResultGenerator.genSuccessResult(userEntity);
    }

}
