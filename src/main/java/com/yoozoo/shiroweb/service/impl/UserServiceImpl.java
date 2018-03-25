package com.yoozoo.shiroweb.service.impl;

import com.yoozoo.shiroweb.mapper.UserMapper;
import com.yoozoo.shiroweb.model.form.User;
import com.yoozoo.shiroweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User findByName(String username) {
        return userMapper.findByName(username);
    }
}
