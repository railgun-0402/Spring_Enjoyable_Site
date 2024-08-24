package com.su.enjoy.controller;

import com.su.enjoy.ResultObject;
import com.su.enjoy.SampleForm;
import com.su.enjoy.domain.dto.user.UserEntity;
import com.su.enjoy.mapper.UserRepository;
import com.su.enjoy.service.SampleService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @PostMapping("/sample")
    @CrossOrigin
    public ResultObject post(@RequestBody SampleForm form) {
        int id = form.getId();
        ResultObject resultObject = new ResultObject();
        resultObject.setName("zenn");
        resultObject.setLank(id);
        return resultObject;
    }
}
