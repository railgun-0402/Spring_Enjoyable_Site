package com.su.enjoy.controller;

import com.su.enjoy.domain.dto.user.UserEntity;
import com.su.enjoy.service.SampleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class top {
    private final SampleService sampleService;

    public top(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/test")
    @ResponseBody
    public UserEntity get() {
        return sampleService.get("zenn");
    }
}
