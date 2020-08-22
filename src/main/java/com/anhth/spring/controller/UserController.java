package com.anhth.spring.controller;

import com.anhth.spring.dto.BaseRequest;
import com.anhth.spring.dto.ResponseDTO;
import com.anhth.spring.dto.UserDTO;
import com.anhth.spring.entity.UserEntity;
import com.anhth.spring.service.UserService;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private int status = 0;
    private String msg = "success";

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getUserById(@PathVariable("id") int id) {
        ResponseDTO res = new ResponseDTO();
        res.setStatus(1);
        res.setMessage("Success");
        res.setData(userService.findUser(id));
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseDTO getUserByUsername(@Param("username") String username) {
        ResponseDTO res = new ResponseDTO();
        res.setMessage(msg);
        List<UserEntity> list = userService.findbyUsername(username);
//        Map<String, List<UserEntity>> data = new HashMap<>();
//        data.put("users", list);
//        res.setData(data);
        res.setDatas(list);
        return res;
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public ResponseDTO updateUser(@RequestHeader Map<String, String> allHeaders, @RequestBody BaseRequest request) {
        ResponseDTO res = new ResponseDTO(1, "success");
        res.setData(request);
        return res;
    }

}

