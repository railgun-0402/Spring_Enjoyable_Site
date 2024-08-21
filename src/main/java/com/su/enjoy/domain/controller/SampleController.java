package com.su.enjoy.domain.controller;

import com.su.enjoy.ResultObject;
import com.su.enjoy.SampleForm;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

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
