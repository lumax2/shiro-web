package com.yoozoo.shiroweb.service;

import com.yoozoo.shiroweb.model.form.User;

import java.util.List;

/**
 * Created by Hao on 2018/3/25.
 */
public interface UserService {

    public User findByName(String username);

    public List<String> findPermissionByUserId(String userId);
}
