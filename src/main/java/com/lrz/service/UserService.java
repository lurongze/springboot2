package com.lrz.service;
import com.lrz.model.OpenUser;
import com.lrz.model.User;
import com.lrz.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/12.
 */
public interface UserService extends Service<User> {
    void saveOpenUser(OpenUser openUser);
    User findByUserName(String userName);
    List<User> getList(String unionId);
}
