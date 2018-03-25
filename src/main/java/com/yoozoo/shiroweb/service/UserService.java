package com.yoozoo.shiroweb.service;

import com.yoozoo.shiroweb.model.form.User;

/**
 * Created by Hao on 2018/3/25.
 */
public interface UserService {
    public User findByName(String username);
}
