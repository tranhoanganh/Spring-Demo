package com.anhth.spring.service;

import com.anhth.spring.repository.UserRepo;
import com.anhth.spring.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserEntity findUser(int id) {
        return userRepo.findUserEntityById(id);
    }

    @Override
    public List<UserEntity> findbyUsername(String name) {
        String token = UUID.randomUUID().toString();
        return userRepo.findByUsername(name);
    }
}
