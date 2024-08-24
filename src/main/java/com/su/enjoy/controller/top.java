package com.su.enjoy.controller;

import com.su.enjoy.domain.dto.user.UserEntity;
import com.su.enjoy.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class top {
    private final SampleService sampleService;

    public top(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String get(Model model) {
        UserEntity userEntity = this.sampleService.get("zenn");
        model.addAttribute("issue", userEntity);
        return "index2";
    }
}
