package com.yoozoo.shiroweb.service.impl;

import com.yoozoo.shiroweb.mapper.UserMapper;
import com.yoozoo.shiroweb.model.form.User;
import com.yoozoo.shiroweb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public List<String> findPermissionByUserId(String userId) {
        return userMapper.findPermissionByUserId(userId);
    }
}
