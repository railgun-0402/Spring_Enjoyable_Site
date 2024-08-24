package com.su.enjoy.domain.controller;

import com.su.enjoy.ResultObject;
import com.su.enjoy.SampleForm;
import com.su.enjoy.domain.dto.user.UserEntity;
import com.su.enjoy.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.su.enjoy.domain.model.user.User;

@RestController
public class SampleController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sample")
    @CrossOrigin
    public ResultObject post(@RequestBody SampleForm form) {
        int id = form.getId();
        ResultObject resultObject = new ResultObject();
        resultObject.setName("zenn");
        resultObject.setLank(id);
        return resultObject;
    }

    @GetMapping("/test")
    public User get() {
        UserEntity userEntity = userRepository.findByName("zenn");
        return userEntity.toUser();
    }
}
