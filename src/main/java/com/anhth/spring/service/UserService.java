package com.anhth.spring.service;

import com.anhth.spring.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity findUser(int id);
    List<UserEntity> findbyUsername(String name);
}
