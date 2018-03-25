package com.yoozoo.shiroweb.mapper;

import com.yoozoo.shiroweb.model.form.User;

/**
 * Created by Hao on 2018/3/25.
 */

public interface UserMapper {
    public User findByName(String username);
}
