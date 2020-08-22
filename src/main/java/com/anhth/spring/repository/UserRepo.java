package com.anhth.spring.repository;

import com.anhth.spring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserEntityById(int ids);

    @Query("select c from UserEntity c where c.username like %?1%")
    List<UserEntity> findByUsername(String name);

    List<UserEntity> findAllByUsernameLike(String name);

}
