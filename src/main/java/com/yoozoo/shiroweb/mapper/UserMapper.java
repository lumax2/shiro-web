package com.yoozoo.shiroweb.mapper;

import com.yoozoo.shiroweb.model.form.User;

import java.util.List;

/**
 * Created by Hao on 2018/3/25.
 */

public interface UserMapper {

    public User findByName(String username);

    public List<String> findPermissionByUserId(String userId);
}
